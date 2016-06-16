package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	String getMessage();

	/**
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	void loadMessage(String key);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	String getDBplayerName(int i);
	int getDBplayerScore(int i);

	int getHeight();
	int getWidth();


	/**			!!!		EVERYTHING NOT COMMENTED HERE IS COMMENTED IN MODEL			!!!		**/

	/**
	 * Gets the map content.
	 *
	 * @return the content
	 */
	void getMapInTab();

	char[][] getMap();
	int getScore();
	
	void loadHighscores();
	/**
	 * Load the map.
	 *
	 * @param key
	 *          the key
	 */
	void loadMap(String key);

	boolean isDead();

	void moveUP();
	void moveLEFT();
	void moveRIGHT();
	void moveDOWN();
	void lauchMissile();

	void setLastMove(String lastMove);
	String getLastMove();

	void fireAnimation();
	void monster1();
}
