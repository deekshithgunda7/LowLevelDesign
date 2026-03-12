import java.util.*;

class TreeType {

    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void display(int x, int y) {
        System.out.println("Drawing tree of type " + name + " at (" + x + ", " + y + ")");
    }
}

class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;
        if (!treeTypes.containsKey(key)) {
            treeTypes.put(key, new TreeType(name, color, texture));
        }
        return treeTypes.get(key);
    }
}

class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void display() {
        type.display(x, y);
    }
}

class Forest {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void display() {
        for (Tree tree : trees) {
            tree.display();
        }
    }
}

class TreeTypeExample {
    public static void main(String[] args) {
        Forest forest = new Forest();
               // Planting 1 million trees
        for(int i = 0; i < 1000000; i++) {
            forest.plantTree(i, i, "Oak", "Green", "Rough");
        }
        
        System.out.println("Planted 1 million trees.");
       
    }
}

// create doxumentation for the above code
/**
 * This code demonstrates the Flyweight design pattern using a tree example. 
 * The TreeType class represents the intrinsic state of a tree, which includes its name, color, and texture. 
 * The TreeFactory class is responsible for creating and managing TreeType instances, ensuring that only one instance of each unique TreeType is created. 
 * The Tree class represents the extrinsic state of a tree, which includes its position (x and y coordinates) and a reference to its TreeType. 
 * The Forest class manages a collection of trees and provides methods to plant trees and display them. 
 * In the main method, we plant 1 million trees in the forest, demonstrating how the Flyweight pattern helps to save memory by sharing TreeType instances among multiple Tree objects.
 */