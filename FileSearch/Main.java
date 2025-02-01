package FileSearch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File f1 = new File("abc", "txt", 10);
        File f2 = new File("cde", "txt", 20);
        File f3 = new File("def", "pdf", 30);
        File f4 = new File("ghi", "py", 5);
        File f5 = new File("uvw", "java", 10);

        FileSystem root = new FileSystem("/", true);
        root.addFile(f1);
        root.addFile(f2);
        root.addFile(f3);
        root.addFile(f4);
        root.addFile(f5);

        Map<String, Object> filters = new HashMap<>();
        filters.put("ExtensionFilter", "java");
        filters.put("SizeFilter", new Object[]{10, ">="});

        Search search = new Search(root, filters, "OR");
        List<String> result = search.findFiles();

        for (String fileName : result) {
            System.out.println(fileName);
        }
    }
}
