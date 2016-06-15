package model;

import element.Element;
import element.mobile.Hero;
import element.mobile.Mobile;
import element.motionless.MotionlessElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Ahmed on 14/06/2016.
 */
public class NettleWorld extends Observable implements INettleWorld {
    public MotionlessElement elements[][];
    public final ArrayList<Mobile> mobiles;
    private int width;
    private int height;
    private Hero hero;

    private NettleWorld(){
        this.mobiles = new ArrayList<Mobile>();
    }

    public NettleWorld(final String fileName) throws IOException{
        this();
        //this.loadFile(fileName);
    }

    private void setHero(final Hero hero) {
        this.hero = hero;
        this.setChanged();
    }


    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public MotionlessElement getElements(final int x, final int y) {
        if((x<0 || (y<0) || (x>=this.getWidth() || (y>=this.getHeight())))){
            return null;
        }
        return this.elements[x][y];
    }

    public Hero getHero() {
        return this.hero;
    }

    public void addMobile(final Mobile mobile, final int x, final int y) {
        this.mobiles.add(mobile);
        mobile.setNettleWorld(this, x, y);
        this.setChanged();
        this.notifyObservers();
    }

    public void addMobile(final Hero hero, final int x, final int y) {
        this.setHero(hero);
        this.addMobile((Mobile) hero, x, y);
    }

    public void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    public void notifyObservers() {
        super.notifyObservers();
    }

    public Element[][] getElements() {
        return this.elements;
    }

    public ArrayList<Mobile> getMobiles() {
        return this.mobiles;
    }
}
