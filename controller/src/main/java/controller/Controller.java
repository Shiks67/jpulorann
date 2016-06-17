package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMap("Press the key '1', '2', '3' '4' or '5', to load the level of your choice.\nPress 't' to load a test level.");
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */

	/** the loading the map in function of the map_name on the database*/
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case MAP1:
				this.model.loadMap("MAP1");
				break;
			case MAP2:
				this.model.loadMap("MAP2");
				break;
			case MAP3:
				this.model.loadMap("MAP3");
				break;
			case MAP4:
				this.model.loadMap("MAP4");
				break;
			case MAP5:
				this.model.loadMap("MAP5");
				break;
			case test:
				this.model.loadMap("MAP6");
				break;
			case UP:
				this.model.moveUP();
				this.model.setLastMove("UP");
				break;
			case LEFT:
				this.model.moveLEFT();
				this.model.setLastMove("LEFT");
				break;
			case RIGHT:
				this.model.moveRIGHT();
				this.model.setLastMove("RIGHT");
				break;
			case DOWN:
				this.model.moveDOWN();
				this.model.setLastMove("DOWN");
				break;
			case SHOOT:
				this.model.fireBall();
				break;
			default:
				break;
		}
	}

	public char[][] displayMap() {
		char[][] map = model.getMap();

		for (int i = 0; i < model.getHeight(); i++)
		{
			for (int j = 0; j < model.getWidth(); j++)
			{
				System.out.print(map[i][j]);
			}

			System.out.println();
		}

		return map;
	}
}
