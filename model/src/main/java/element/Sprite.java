package element;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Ahmed on 13/06/2016.
 */
public class Sprite extends StringWriter implements ISprite {
    private Image image;

    /**
     *Take Sprites
     * @param c
     * @param image
     */
    public Sprite(final String c, final String image){
        this.write(c);
        try {
            this.image= ImageIO.read(new File("Sprite/" + image));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Sprite(final String c){
        this(c, "ground.jpg");
    }

    /**
     * Get sprite
     * @return Sprite
     */
    public Image getImage() {
        return this.image;
    }
}
