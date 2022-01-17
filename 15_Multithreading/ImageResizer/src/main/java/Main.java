import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;

public class Main {

    private  static int newWidth = 300;
    private static int cores = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) {

        String srcFolder = "C://image_resizer/src";
        String dstFolder = "C://image_resizer/dst";

        File srcDir = new File(srcFolder);
        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();

        for (int i = 0 ; i < cores; i++ ){
            assert files != null;
            int size = (files.length/cores)*i;

            File[] file = new File[files.length / cores];
            System.arraycopy(files, size,file,0,file.length);
            ImageResizer resizer = new ImageResizer(newWidth,dstFolder,file,start);
            resizer.start();
        }
    }
}
