import java.io.File;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        for (; ; ) {
            System.out.println("Введите путь к папке");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            if  (!name.matches("^[A-Za-z]:\\/[\\w/]+")){
                System.out.println("Неверный путь");
                continue;
            }
            File file = new File(name);
            double gigabyte = FileUtils.calculateFolderSize(name) / Math.pow(1024, 3);
            String read = String.format("Размер папки '%s' составляет : %.2f Гб", file.getAbsolutePath(), gigabyte );
            System.out.println(read);
        }
    }
}
