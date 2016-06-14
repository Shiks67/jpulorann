package model;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;

import javax.imageio.ImageIO;

import static sun.swing.SwingUtilities2.drawChars;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {
    /** The array of objects **/
    private char[][] pngArray = new char[12][21];

    /** The message. */
    private String message;

    /** The map */
    private String map;

    /**
     * Instantiates a new model.
     */
    public Model() {
        this.map = "";
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

    /**public char[][] getMapInTab() {
        String[] tabmap = this.map.split("\n");
        for (int i =0; i < tabmap.length; i++)
        {
            for (int j = 0; j < tabmap[i].length(); j++)
            {
                switch (tabmap[i].charAt(j)){
                    case 'B' :
                        putPngName(i,j,'B');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case 'H' :
                        putPngName(i,j,'H');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case 'V' :
                        putPngName(i,j,'V');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case 'P' :
                        putPngName(i,j,'P');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case 'L' :
                        putPngName(i,j,'L');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case 'C' :
                        putPngName(i,j,'C');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case 'K' :
                        putPngName(i,j,'K');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case '1' :
                        putPngName(i,j,'1');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case '2' :
                        putPngName(i,j,'2');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case '3' :
                        putPngName(i,j,'3');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case '4' :
                        putPngName(i,j,'4');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    default :
                        putPngName(i,j,' ');
                        System.out.print(this.pngArray[i][j]);
                        break;

                }
            }
            System.out.println();
        }
        return this.pngArray;
    }**/

    public String getMap() {
        String[] tabmap = this.map.split("\n");     /** beginning of the parser **/
        for (int i =0; i < tabmap.length; i++)
        {
            for (int j = 0; j < tabmap[i].length(); j++)
            {
                switch (tabmap[i].charAt(j)){
                    case 'B' :
                        putPngName(i,j,'B');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case 'H' :
                        putPngName(i,j,'H');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case 'V' :
                        putPngName(i,j,'V');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case 'P' :
                        putPngName(i,j,'P');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case 'L' :
                        putPngName(i,j,'L');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case 'C' :
                        putPngName(i,j,'C');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case 'K' :
                        putPngName(i,j,'K');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case '1' :
                        putPngName(i,j,'1');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case '2' :
                        putPngName(i,j,'2');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case '3' :
                        putPngName(i,j,'3');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    case '4' :
                        putPngName(i,j,'4');
                        System.out.print(this.pngArray[i][j]);
                        break;
                    default :
                        putPngName(i,j,' ');
                        System.out.print(this.pngArray[i][j]);
                        break;

                }
            }
            System.out.println();
        }
        return "";
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
}
