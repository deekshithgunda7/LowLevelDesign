package FileSearch;

import java.util.*;

public class Search {
    private FileSystem directory;
    private List<Filter> filters;
    private String condition;

    public Search(FileSystem directory, Map<String, Object> filters, String condition) {
        this.directory = directory;
        this.filters = new ArrayList<>();
        this.condition = condition;

        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String filterType = entry.getKey();
            Object filterValue = entry.getValue();
            switch (filterType) {
                case "NameFilter":
                    this.filters.add(new NameFilter((String) filterValue));
                    break;
                case "SizeFilter":
                    Object[] sizeProperties = (Object[]) filterValue;
                    this.filters.add(new SizeFilter((Integer) sizeProperties[0], (String) sizeProperties[1]));
                    break;
                case "ExtensionFilter":
                    this.filters.add(new ExtensionFilter((String) filterValue));
                    break;
            }
        }
    }

    public boolean checkConditions(File file) {
        if (condition == null) {
            return filters.get(0).match(file);
        } else if (condition.equals("AND")) {
            for (Filter filter : filters) {
                if (!filter.match(file)) {
                    return false;
                }
            }
            return true;
        } else if (condition.equals("OR")) {
            for (Filter filter : filters) {
                if (filter.match(file)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<String> findFiles() {
        List<String> result = new ArrayList<>();
        Queue<FileSystem> queue = new LinkedList<>();
        queue.add(directory);

        while (!queue.isEmpty()) {
            FileSystem current = queue.poll();
            for (File file : current.getFiles()) {
                if (checkConditions(file)) {
                    result.add(file.getName());
                }
            }
            for (FileSystem subDirectory : current.getSubDirectories()) {
                queue.add(subDirectory);
            }
        }
        return result;
    }
}