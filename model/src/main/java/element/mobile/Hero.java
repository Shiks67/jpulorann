package element.mobile;

import element.Element;
import element.Sprite;

import java.awt.*;

/**
 * Created by Asus on 14/06/2016.
 */
public class Hero extends Element{
    private Point lastPosition;
    private Point position;

    public Hero(){
        super();
        this.lastPosition = new Point();
        this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
    }
    private void saveLastPosition(){
        if ((this.lastPosition.getX() != this.getPosition().getX()) || (this.lastPosition.getY() != this.getPosition().getY())) {
            this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);}
    }


    public void moveBack() {
        this.setX(this.lastPosition.x);
        this.setY(this.lastPosition.y);
    }

    public int getX() {
        return this.position.x;
    }

    protected void setX(final int x) {
        if ((x >= 0) && (x < this.getNettleWorld().getWidth())) {
            this.position.x = x;
            this.getNettleWorld().setMobileHasChanged();
        }
    }

    public int getY() {
        return this.position.y;
    }

    protected void setY(final int y) {
        if ((y >= 0) && (y < this.getNettleWorld().getHeight())) {
            this.position.y = y;
            this.getNettleWorld().setMobileHasChanged();
        }
    }

    public Point getPosition(){ return this.position;}

    public void moveUp() {
        this.setY(this.getY() - 1);
    }

    public void moveLeft() {
        this.setX(this.getX() - 1);
    }

    public void moveDown() {
        this.setY(this.getY() + 1);
    }

    public void moveRight() {
        this.setX(this.getX() + 1);
    }

}
