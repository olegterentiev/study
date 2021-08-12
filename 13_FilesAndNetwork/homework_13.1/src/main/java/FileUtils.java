import java.io.File;

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
}
