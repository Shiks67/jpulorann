package model;

import contract.IModel;
import element.mobile.Hero;

import java.sql.SQLException;
import java.util.Observable;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {
    /** The array of objects **/
    private int height = 12;
    private int width = 21;
    public Hero hero ;
    public int Score;
    private char[][] pngArray = new char[this.getHeight()][this.getWidth()];

    /** The message. */
    private String message;

    /** The map */
    private String map;

    /** getters **/
    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }


    /**
     * Instantiates a new model.
     */
    public Model() {

        this.map = "";
        this.hero = new Hero(0,0);
    }

    /*
     * (non-Javadoc)
     *
     * @see contract.IModel#getMessage()
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets the message.
     *
     * @param message
     *          the new message
     */
    private void setMessage(final String message) {
        this.message = message;
        this.setChanged();
        this.notifyObservers();
    }

    /*
     * (non-Javadoc)
     *
     * @see contract.IModel#getMessage(java.lang.String)
     */
    public void loadMessage(final String key) {
        try {
            final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
            this.setMessage(daoHelloWorld.find(key).getMessage());
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see contract.IModel#getObservable()
     */
    public Observable getObservable() {
        return this;
    }


    /** i added the map functions in general here*/

    public void putPngName(int i, int j, char pngName) {
        pngArray[i][j]= pngName;
    }

    public void getMapInTab() {
        String[] tabmap = this.map.split("\n");
        for (int i =0; i < tabmap.length; i++)      /** beginning of the parser **/
        {
            for (int j = 0; j < tabmap[i].length(); j++)
            {
                switch (tabmap[i].charAt(j)){
                    case 'B' :
                        putPngName(i,j,'B');
                        break;
                    case 'H' :
                        putPngName(i,j,'H');
                        break;
                    case 'V' :
                        putPngName(i,j,'V');
                        break;
                    case 'P' :
                        putPngName(i,j,'P');
                        break;
                    case 'L' :
                        putPngName(i,j,'L');
                        hero.setX(j);
                        hero.setY(i);
                        break;
                    case 'C' :
                        putPngName(i,j,'C');
                        break;
                    case 'K' :
                        putPngName(i,j,'K');
                        break;
                    case '1' :
                        putPngName(i,j,'1');
                        break;
                    case '2' :
                        putPngName(i,j,'2');
                        break;
                    case '3' :
                        putPngName(i,j,'3');
                        break;
                    case '4' :
                        putPngName(i,j,'4');
                        break;
                    default :
                        putPngName(i,j,' ');
                        break;

                }
            }
           // System.out.println();
        }

    }

    public Hero getHero() {
        return this.hero;
    }


    public char[][] getMap() {
        return this.pngArray;
    }

    private void setMap(final String map) {
        this.map = map;
        this.setChanged();
        this.notifyObservers();
    }
    public void loadMap(String key) {
        try {
            final DAOLoadMap daoLoadMap = new DAOLoadMap(DBConnection.getInstance().getConnection());
            this.setMap(daoLoadMap.find(key).getMap());
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isPurse(final int x, final int y){
        return (this.pngArray[x][y] == 'P');
    }

   private boolean isMovePossible(final int x, final int y){
        return (this.pngArray[x][y] != 'V' && this.pngArray[x][y] != 'H'
        && this.pngArray[x][y] != 'B' && this.pngArray[x][y] != 'C'
        && this.pngArray[x][y] != '1' && this.pngArray[x][y] != '2'
        && this.pngArray[x][y] != '3' && this.pngArray[x][y] != '4');
    }

    public void moveRIGHT() {
        if(this.isPurse(this.getHero().getY(), this.getHero().getX()+1)){
            Score += 100;
        }if(this.isMovePossible(this.getHero().getY(), this.getHero().getX()+1)){
            this.pngArray[this.getHero().getY()][this.getHero().getX()] = ' ';
            this.getHero().moveRIGHT();
            this.pngArray[this.getHero().getY()][this.getHero().getX()] = 'L';
        }
    }
    public void moveUP() {
        if(this.isPurse(this.getHero().getY() -1, this.getHero().getX())){
            Score += 100;
        }if(this.isMovePossible(this.getHero().getY() -1, this.getHero().getX())) {
            this.pngArray[this.getHero().getY()][this.getHero().getX()] = ' ';
            this.getHero().moveUp();
            this.pngArray[this.getHero().getY()][this.getHero().getX()] = 'L';
        }

    }
    public void moveDOWN() {
        if(this.isPurse(this.getHero().getY() +1, this.getHero().getX())){
            Score += 100;
        }if (this.isMovePossible(this.getHero().getY() +1, this.getHero().getX())) {
            this.pngArray[this.getHero().getY()][this.getHero().getX()] = ' ';
            this.getHero().moveDOWN();
            this.pngArray[this.getHero().getY()][this.getHero().getX()] = 'L';
        }
    }
    public void moveLEFT() {
        if(this.isPurse(this.getHero().getY(), this.getHero().getX() - 1)){
            Score += 100;
        }if(isMovePossible(this.getHero().getY(), this.getHero().getX() - 1)){
            this.pngArray[this.getHero().getY()][this.getHero().getX()] = ' ';
            this.getHero().moveLEFT();
            this.pngArray[this.getHero().getY()][this.getHero().getX()] = 'L';
        }
    }
}
