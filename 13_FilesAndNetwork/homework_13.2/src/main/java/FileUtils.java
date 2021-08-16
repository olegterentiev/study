import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        File source = new File(sourceDirectory);
        File destination = new File(destinationDirectory);
        try {
            Files.copy(source,destination);
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
