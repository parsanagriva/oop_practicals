import java.io.*;
import java.util.Date;
import java.util.Scanner;

class FileManager {

    void printProperties(File f) {
        System.out.println("--- File Properties ---");
        System.out.println("Name          : " + f.getName());
        System.out.println("Absolute Path : " + f.getAbsolutePath());
        System.out.println("Size (bytes)  : " + f.length());
        System.out.println("Readable      : " + f.canRead());
        System.out.println("Writable      : " + f.canWrite());
        System.out.println("Last Modified : " + new Date(f.lastModified()));
        System.out.println("-----------------------");
    }

    void copyFile(String src, String dest) throws IOException {
        File source = new File(src);
        if (!source.exists()) throw new FileNotFoundException("Source file not found: " + src);

        File destination = new File(dest);
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        }
        System.out.println("File copied successfully: " + src + " -> " + dest);
        printProperties(destination);
    }

    void deleteFile(String path) {
        File f = new File(path);
        if (f.exists() && f.delete()) {
            System.out.println("File deleted: " + path);
        } else {
            System.out.println("Delete failed or file not found: " + path);
        }
    }

    void renameFile(String oldPath, String newPath) {
        File oldFile = new File(oldPath);
        File newFile = new File(newPath);
        if (!oldFile.exists()) {
            System.out.println("File not found: " + oldPath);
            return;
        }
        if (oldFile.renameTo(newFile)) {
            System.out.println("Renamed: " + oldPath + " -> " + newPath);
            printProperties(newFile);
        } else {
            System.out.println("Rename failed.");
        }
    }

    void showProperties(String path) {
        File f = new File(path);
        if (!f.exists()) {
            System.out.println("File not found: " + path);
            return;
        }
        printProperties(f);
    }
}

public class p17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileManager fm = new FileManager();

        int choice;
        do {
            System.out.println("\n--- File Manager Menu ---");
            System.out.println("1. Copy File");
            System.out.println("2. Delete File");
            System.out.println("3. Rename File");
            System.out.println("4. Show File Properties");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Source file path: ");
                        String src = sc.nextLine();
                        System.out.print("Destination file path: ");
                        String dest = sc.nextLine();
                        fm.copyFile(src, dest);
                        break;

                    case 2:
                        System.out.print("File path to delete: ");
                        String delPath = sc.nextLine();
                        fm.deleteFile(delPath);
                        break;

                    case 3:
                        System.out.print("Current file path: ");
                        String oldPath = sc.nextLine();
                        System.out.print("New file path: ");
                        String newPath = sc.nextLine();
                        fm.renameFile(oldPath, newPath);
                        break;

                    case 4:
                        System.out.print("File path: ");
                        String propPath = sc.nextLine();
                        fm.showProperties(propPath);
                        break;

                    case 5:
                        System.out.println("Exiting.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
            }

        } while (choice != 5);

        sc.close();
    }
}
