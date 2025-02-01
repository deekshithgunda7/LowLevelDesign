package FileSearch;

public class NameFilter extends Filter {
    private String name;

    public NameFilter(String name) {
        this.name = name;
    }

    @Override
    public boolean match(File file) {
        return file.getName().equals(name);
    }
}

