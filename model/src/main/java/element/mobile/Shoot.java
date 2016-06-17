package element.mobile;

/**
 * Created by Asus on 16/06/2016.
 */
public class Shoot {
    private int x;
    private int y;
    public Shoot(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {

        return this.x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {

        return this.y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public void moveUP() {this.setY(this.getY() - 1);}

    public void moveLEFT() {
        this.setX(this.getX() - 1);
    }

    public void moveDOWN() {
        this.setY(this.getY() + 1);
    }

    public void moveRIGHT() {
        this.setX(this.getX() + 1);
    }

}
