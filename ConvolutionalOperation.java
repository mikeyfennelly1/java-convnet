import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

enum EdgeDetectionKernels {

}

enum RGBColor {
    RED, GREEN, BLUE
}

public class ConvolutionalOperation {
    private static String pathToImage = "./images/cat.jpg";
    private static Map<RGBColor, Integer> ShiftBits = new HashMap<RGBColor, Integer>() {{
        put(RGBColor.RED, 16);
        put(RGBColor.GREEN, 8);
        put(RGBColor.BLUE, 0);
    }};

    public static void main(String[] args) throws IOException {
        Matrix redValues = getRGBColorMatrix(RGBColor.RED);
        System.out.println("0");
    }

    private static Matrix getRGBColorMatrix(RGBColor color) throws IOException {
        BufferedImage img = ImageIO.read(new File(pathToImage));
        int width = img.getWidth();
        int height = img.getHeight();

        int[][] resultMatrix = new int[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int colorVal = (img.getRGB(x, y) >> ShiftBits.get(color)) & 0xFF;
                resultMatrix[y][x] = colorVal;
            }
        }
        return new Matrix(resultMatrix);
    }
}
