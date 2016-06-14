package model;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;

import javax.imageio.ImageIO;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {
    /** the image **/
    Image image;
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

    public String getMap() {
        String[] tabmap = this.map.split("\n");     /** beginning of the parser **/
        for (String i : tabmap)
        {
            //System.out.println(i);
            for (int j = 0; j < 20; j++)
            {
                System.out.print(i.charAt(j));
                switch (i.charAt(j)){
                    case 'B' :
                        /**String image ="bone.png";
                        try {
                            this.image = ImageIO.read(new File("sprite/" + image));
                        } catch (final IOException e) {
                            e.printStackTrace();
                        }
                        return this.image;**/


                        /** don't forget to delete Image image from class if above has to be deleted **/



                    case 'H' :

                        break;
                    case 'V' :

                        break;
                    case 'P' :

                    break;
                    case 'L' :

                        break;
                    case 'C' :

                        break;
                    case '1' :

                        break;
                    case '2' :

                        break;
                    case '3' :

                        break;
                    case '4' :

                        break;
                    default :
                        break;

                }
            }
            System.out.println();
        }
        return null;
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
