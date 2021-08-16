import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;

public class FileUtils {
    public static long calculateFolderSize(String path) {
        long result = 0;

        try {
            File folder = new File(path);
            for (File f : folder.listFiles())
                if (f.isDirectory()) {
                    String path2 = f.getAbsolutePath();
                    result += calculateFolderSize(path2);
                } else {
                    result += f.length();
                }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static AtomicLong calculateFolderSizeWalkFileTree(String path) throws IOException {
        AtomicLong size = new AtomicLong(0);
        Files.walkFileTree(
                Paths.get(path),
                new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                        size.addAndGet(attrs.size());
                        return FileVisitResult.CONTINUE;
                    }
                });
        return size;
    }

    public static long calculateFolderSizeCollection(String path){
        long size = 0;
        try{
        File folder = new File(path);
        ArrayList files = new ArrayList();
        Collections.addAll(files,folder.listFiles());
//        First in First out
        while(!files.isEmpty()){
            File f = (File) files.get(0);
            if(f.isDirectory()){
                Collections.addAll(files,f.listFiles());
            } else {
                size += f.length();
            }
            files.remove(f);

        }}catch (Exception ex){
            ex.printStackTrace();
        }
        return size;
    }
}
