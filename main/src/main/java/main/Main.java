package main;

import controller.Controller;
import model.Model;
import view.View;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *          the arguments
	 */
	public static void main(final String[] args) {
		final Model model = new Model();
		final View view = new View(model);
		final Controller controller = new Controller(view, model);
		view.setController(controller);
		controller.control();
	}
}