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

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public MotionlessElement getElements(int x, int y) {
        return null;
    }

    @Override
    public Hero getHero() {
        return null;
    }

    @Override
    public void addMobile(Mobile mobile, int x, int y) {

    }

    @Override
    public void addMobile(Hero hero, int x, int y) {

    }

    @Override
    public void setMobileHasChanged() {

    }

    @Override
    public Element[][] getElements() {
        return new Element[0][];
    }

    @Override
    public ArrayList<Mobile> getMobiles() {
        return null;
    }
}
