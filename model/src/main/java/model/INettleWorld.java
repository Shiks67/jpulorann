package model;

import element.Element;
import element.mobile.Hero;
import element.mobile.Mobile;
import element.motionless.MotionlessElement;

import java.util.ArrayList;
import java.util.Observer;

/**
 * Created by Asus on 14/06/2016.
 */
public interface INettleWorld {
    public int getWidth();

    public int getHeight();

    public MotionlessElement getElements(int x, int y);

    public Hero getHero();

    public void addMobile(Mobile mobile, int x, int y);

    public void addMobile(Hero hero, int x, int y);

    public void setMobileHasChanged();

    public Element[][] getElements();

    public ArrayList<Mobile> getMobiles();

    public void addObserver(Observer o);
}
