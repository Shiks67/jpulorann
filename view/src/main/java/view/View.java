package view;

import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.SwingUtilities;

import com.sun.javafx.scene.traversal.Direction;
import contract.*;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {
	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_NUMPAD1:
			case KeyEvent.VK_1:
				return ControllerOrder.MAP1;
			case KeyEvent.VK_NUMPAD2:
			case KeyEvent.VK_2:
				return ControllerOrder.MAP2;
			case KeyEvent.VK_NUMPAD3:
			case KeyEvent.VK_3:
				return ControllerOrder.MAP3;
			case KeyEvent.VK_NUMPAD4:
			case KeyEvent.VK_4:
				return ControllerOrder.MAP4;
			case KeyEvent.VK_NUMPAD5:
			case KeyEvent.VK_5:
				return ControllerOrder.MAP5;
			case KeyEvent.VK_T:
				return ControllerOrder.test;
			case KeyEvent.VK_UP:
				return ControllerOrder.UP;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.DOWN;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.LEFT;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.RIGHT;
			case KeyEvent.VK_SPACE:
				return ControllerOrder.SHOOT;
			default:
				return ControllerOrder.nthng;
		}
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMap(final String map) {
		this.viewFrame.printMap(map);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
