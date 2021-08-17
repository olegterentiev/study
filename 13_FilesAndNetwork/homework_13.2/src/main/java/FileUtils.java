import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils {
    public static void copyFolderWalkFileTree(String sourceDirectory, String destinationDirectory) throws IOException {
        Path source = Paths.get(sourceDirectory);
        Path destination = Paths.get(destinationDirectory);
        Files.walkFileTree(source, new SimpleFileVisitor<>() {
            public FileVisitResult visitFile(Path src, BasicFileAttributes fileAttributes) {
                Path des = destination.resolve(source.relativize(src));
                try {
                    Files.copy(src, des, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Скопирован файл из    " + src + "    в    " + des);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return FileVisitResult.CONTINUE;
            }
            public FileVisitResult preVisitDirectory(Path src, BasicFileAttributes fileAttributes) {
                Path des = destination.resolve(source.relativize(src));
                try {
                    Files.copy(src, des, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Скопирована папка из    " + src + "    в    " + des);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        File source = new File(sourceDirectory);
        File destination = new File(destinationDirectory);
        if (source.isDirectory()) {
            File[] s = source.listFiles();
            if(s.length == 0){
                System.out.println("Скопирована пустая папка    " + sourceDirectory + "    в    " + destinationDirectory);
            }
            if (!destination.exists()) {
                destination.mkdir();
            }
            String files[] = source.list();
            for (String file : files) {
                File srcFile = new File(source, file);
                File destFile = new File(destination, file);
                copyFolder(srcFile.getAbsolutePath(), destFile.getAbsolutePath());
            }
        } else {
            InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(destinationDirectory);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
            System.out.println("Файл скопирован из    " + sourceDirectory + "    в    " + destinationDirectory);
        }
    }
}
