import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    private  static int newWidth = 300;
    private static int cores = Runtime.getRuntime().availableProcessors();
    public static final int MAX_T = cores;
    public static void main(String[] args) {

        String srcFolder = "C://image_resizer/src";
        String dstFolder = "C://image_resizer/dst";

        File srcDir = new File(srcFolder);
        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        for (int i = 0 ; i < cores; i++ ){
            assert files != null;
            int size = (files.length/cores)*i;

            File[] file = new File[files.length / cores];
            System.arraycopy(files, size,file,0,file.length);
            ImageResizer resizer = new ImageResizer(newWidth,dstFolder,file,start);
            pool.execute(resizer);
            if(i == cores - 1){                                                                      // получение последней итерации цикла
                if(!(files.length%cores == 0)){                                                      // проверка на остаток
                    int startPoint = files.length - files.length%cores;                              // переменная старта копирования
                    File[] lastFile = new File[files.length%cores];                                  // создание массива остатка
                    System.arraycopy(files,startPoint,lastFile,0,lastFile.length);           // процесс копирования
                    ImageResizer lastResizer = new ImageResizer(newWidth,dstFolder,lastFile,start);  // создание экземпляра
                    pool.execute(lastResizer);                                                       // занесение в пул потоков
                }
            }
        }
        pool.shutdown();
    }
}
