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
                        //System.out.print(this.pngArray[i][j]);
                        break;
                    case 'H' :
                        putPngName(i,j,'H');
                        //System.out.print(this.pngArray[i][j]);
                        break;
                    case 'V' :
                        putPngName(i,j,'V');
                        //System.out.print(this.pngArray[i][j]);
                        break;
                    case 'P' :
                        putPngName(i,j,'P');
                        //System.out.print(this.pngArray[i][j]);
                        break;
                    case 'L' :
                        putPngName(i,j,'L');
                        hero.setX(j);
                        hero.setY(i);
                        //System.out.print(this.pngArray[i][j]);
                        break;
                    case 'C' :
                        putPngName(i,j,'C');
                        //System.out.print(this.pngArray[i][j]);
                        break;
                    case 'K' :
                        putPngName(i,j,'K');
                        //System.out.print(this.pngArray[i][j]);
                        break;
                    case '1' :
                        putPngName(i,j,'1');
                        //System.out.print(this.pngArray[i][j]);
                        break;
                    case '2' :
                        putPngName(i,j,'2');
                        //System.out.print(this.pngArray[i][j]);
                        break;
                    case '3' :
                        putPngName(i,j,'3');
                        //System.out.print(this.pngArray[i][j]);
                        break;
                    case '4' :
                        putPngName(i,j,'4');
                        //System.out.print(this.pngArray[i][j]);
                        break;
                    default :
                        putPngName(i,j,' ');
                        //System.out.print(this.pngArray[i][j]);
                        break;

                }
            }
            System.out.println();
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
    public void moveRIGHT() {

    }
    public void moveUP() {
        this.pngArray[this.getHero().getY()][this.getHero().getX()] = ' ';
        this.getHero().moveUp();
        this.pngArray[this.getHero().getY()][this.getHero().getX()] = 'L';
    }
    public void moveDOWN() {

    }
    public void moveLEFT() {

    }

}
