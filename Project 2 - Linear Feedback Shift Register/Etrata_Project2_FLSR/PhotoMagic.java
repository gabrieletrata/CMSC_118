import java.awt.Color;
/**
 * The PhotoMagic class encrypts/decrypts an image.
 * 
 * @author (Gabriel Etrata) 
 * @version (v1.0)
 */
public class PhotoMagic
{
    /**
     * Main method for PhotoMagic class.
     * 
     * @param args
     * 
     */
    public static void main (String[] args){
        String inputFile = "DSC_0714compressed.jpg";
        String seed = "01101000010100010000";
        int tap = 3;
        Picture pic = new Picture(inputFile);
        LFSR lfsr = new LFSR(seed, tap);
        Picture shuffledPic = transform(pic, lfsr);
        pic.show();
    }
    
    /**
     * Transforms the picture.
     * 
     * @param picture the image being encrypted/decrypted
     * @param lfsr the LFSR being used to encrypt/decrypt the image
     * 
     * @return picture the encrypted/decrypted image
     */
    public static Picture transform(Picture picture, LFSR lfsr){
        int w = picture.width();
        int h = picture.height();
        for(int i = 0; i < w; i++){
            for(int j = 0; j < h; j++){
                Color c = picture.get(i,j);
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                int genRed = lfsr.generate(8);
                int genGreen = lfsr.generate(8);
                int genBlue= lfsr.generate(8);
                Color genColor = new Color(genRed, genGreen, genBlue);
                picture.set(i, j, genColor);
            }
        }
        return picture;
    }
    
}