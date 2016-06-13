package model;

import contract.IModel;

import java.sql.SQLException;
import java.util.Observable;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

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
		return this.map;
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
