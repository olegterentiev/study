import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import static org.imgscalr.Scalr.OP_ANTIALIAS;

public class ImageResizer extends Thread {

    private int newWidth;
    private String dstFolder;
    private File[] files;
    private long start;

    public ImageResizer(int newWidth, String dstFolder, File[] files, long start) {
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.files = files;
        this.start = start;
    }

    public static BufferedImage resize(BufferedImage src, int targetWidth, int targetHeight, BufferedImageOp... ops){

        int type = src.getType() == 0? BufferedImage.TYPE_INT_ARGB : src.getType();
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, type);
        Graphics2D graphics = resizedImage.createGraphics();
        graphics.drawImage(src, 0, 0, targetWidth, targetHeight, null);
        graphics.dispose();
        return resizedImage;
    }

    @Override
    public void run() {

                try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }
                int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));

                BufferedImage newImage = ImageResizer.resize(image,newWidth,newHeight, OP_ANTIALIAS);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Duration : " + (System.currentTimeMillis() - start) + " ms");
    }
}
