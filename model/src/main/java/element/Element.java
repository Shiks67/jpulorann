package element;

import java.awt.*;

/**
 * Created by Ahmed on 13/06/2016.
 */
public class Element implements ISprite {
    private ISprite				sprite;
    private Permeability	permeability;

    public ISprite getSprite(){
        return this.sprite;
    }

    public Image getImage() {
        return this.getSprite().getImage();
    }
}
