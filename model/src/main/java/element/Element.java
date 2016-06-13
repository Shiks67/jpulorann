package element;

import aedt.showboard.ISquare;

import java.awt.*;


/**
 * Created by Ahmed on 13/06/2016.
 */
public abstract class Element implements ISquare{
    private ISprite				sprite;
    private Permeability permeability;
    //private IMap map;

    /**
     * Put sprites on char
     * @param sprite
     * @param permeability
     */
    public Element(final ISprite sprite, final Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
    }

    public ISprite getSprite() {
        return this.sprite;
    }

    private void setSprite(final ISprite sprite) {
        this.sprite = sprite;
    }

    public Permeability getPermeability() {
        return this.permeability;
    }

    private void setPermeability(final Permeability permeability) {
        this.permeability = permeability;
    }

    public Image getImage() {
        return this.getSprite().getImage();
    }
}
