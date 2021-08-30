import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Download {

    public static void downloadFile(String path) throws IOException {
        String[] fragments = path.split("/");
        String nameFile = fragments[fragments.length - 1];
//        if (nameFile.endsWith(".jpg")) {
            System.out.println(nameFile);
            URL url = new URL(path);
            File file = new File("images", nameFile);

            if (!file.exists()) {
                file.createNewFile();
                InputStream in = new BufferedInputStream(url.openStream());
                OutputStream out = new FileOutputStream("images/" + fragments[fragments.length - 1]);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
                in.close();
                out.close();
            }
//        }
    }

    public static String parserFile(String file) {

        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(file));
            lines.forEach(line -> builder.append(line).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();

    }
}
