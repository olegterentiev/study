import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите путь к папке которую нужно скопировать с помощью Files.walkFileTree()");
        Scanner scannerIn = new Scanner(System.in);
        String pathIn = scannerIn.nextLine();

        System.out.println("Введите путь к папке в которую нужно скопировать");
        Scanner scannerOut = new Scanner(System.in);
        String pathOut = scannerOut.nextLine();

        try {
            FileUtils.copyFolderWalkFileTree(pathIn, pathOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("------------------------------------------------------------");

        System.out.println("Введите путь к папке которую нужно скопировать с помощью рекурсии");
        Scanner scannerIn2 = new Scanner(System.in);
        String pathIn2 = scannerIn2.nextLine();

        System.out.println("Введите путь к папке в которую нужно скопировать");
        Scanner scannerOut2 = new Scanner(System.in);
        String pathOut2 = scannerOut2.nextLine();

        FileUtils.copyFolder(pathIn2, pathOut2);
    }
}
