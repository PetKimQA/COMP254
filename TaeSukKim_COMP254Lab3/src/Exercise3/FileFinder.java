package Exercise3;

import java.io.File;
import java.util.Scanner;

public class FileFinder {
    // Recursively searches under 'path' for files named 'filename'

    // flag for file found or not
    private static boolean foundAny = false;
    public static void find(String path, String filename) {
        File root = new File(path);
        if (!root.exists()) {
            System.out.printf("Path '%s' does not exist.%n", path);
            return;
        }
        // If it's a file and matches, print it
        if (root.isFile()) {
            if (root.getName().equals(filename)) {
                System.out.println("Found: " + root.getAbsolutePath());
                foundAny = true;
            }
            return;
        }
        // If it's a directory, list contents and recurse
        File[] entries = root.listFiles();
        if (entries != null) {
            for (File entry : entries) {
                find(entry.getAbsolutePath(), filename);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter directory path to search: ");
        String startPath = in.nextLine();
        System.out.print("Enter filename to find: ");
        String target = in.nextLine();

        System.out.printf("Searching for '%s' under '%s'...%n", target, startPath);
        find(startPath, target);

        // If we never found any matches, print the fail message
        if (!foundAny) {
            System.out.printf("No files named '%s' were found under '%s'.%n",
                    target, startPath);
        }
        in.close();
    }
}
