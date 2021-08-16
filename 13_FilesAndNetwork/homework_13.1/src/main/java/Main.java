import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        for (; ; ) {
            System.out.println("Введите путь к папке");
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();
            if (!path.matches("^[A-Za-z]:\\/[\\w/]+")) {
                System.out.println("Неверный путь");
                continue;
            }
            File file = new File(path);
            String[] sizeFormat = {"Байт", "Килобайт", "Мегабайт", "Гигабайт", "Терабайт"};

            double size = FileUtils.calculateFolderSize(path);
            int log = (int) (Math.log(size) / Math.log(1024));
            String out = sizeFormat[log];
            double newSize = size / Math.pow(1024, log);
            String output = String.format("Размер папки '%s' составляет : %.2f %s", file.getAbsolutePath(), newSize, out);
            System.out.println("Расчёт размера директории с помощью рекурсии");
            System.out.println(output);

            System.out.println("---------------------------------------------------");

            double size2 = FileUtils.calculateFolderSizeWalkFileTree(path).doubleValue();
            int log2 = (int) (Math.log(size2) / Math.log(1024));
            String out2 = sizeFormat[log2];
            double newSize2 = size2 / Math.pow(1024, log2);
            String output2 = String.format("Размер папки '%s' составляет : %.2f %s", file.getAbsolutePath(), newSize2, out2);
            System.out.println("Расчёт размера директории с помощью Files.walkFileTree()");
            System.out.println(output2);

            System.out.println("---------------------------------------------------");

            double size3 = FileUtils.calculateFolderSizeCollection(path);
            int log3 = (int) (Math.log(size3) / Math.log(1024));
            String out3 = sizeFormat[log3];
            double newSize3 = size3 / Math.pow(1024, log3);
            String output3 = String.format("Размер папки '%s' составляет : %.2f %s", file.getAbsolutePath(), newSize3, out3);
            System.out.println("Расчёт размера директории с помощью цикла и коллекции");
            System.out.println(output3);
        }
    }
}
