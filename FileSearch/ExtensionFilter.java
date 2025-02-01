package FileSearch;

public class ExtensionFilter extends Filter {
    private String extension;

    public ExtensionFilter(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean match(File file) {
        return file.getExtension().equals(extension);
    }
}
