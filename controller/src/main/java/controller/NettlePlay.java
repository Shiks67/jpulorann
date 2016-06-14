package controller;

import element.mobile.Hero;
import model.INettleWorld;

import java.io.IOException;

/**
 * Created by Asus on 14/06/2016.
 */
public class NettlePlay {

    private final INettleWorld nettleWorld;
    private int playMode;

    public NettlePlay(final INettleWorld nettleWorld) {
        this.nettleWorld = nettleWorld;
        this.nettleWorld.addMobile(new Hero(), 15, 15);
    }

    /*public void orderPerform(final UserOrder userOrder) throws IOException {
        switch (userOrder) {
            case UP:
                this.getNettleWorld().getHero().moveUp();
                break;
            case RIGHT:
                this.getNettleWorld().getHero().moveRight();
                break;
            case DOWN:
                this.getNettleWorld().getHero().moveDown();
                break;
            case LEFT:
                this.getNettleWorld().getHero().moveLeft();
                break;
            case NOP:
            default:
                break;
        }
    }*/
}
