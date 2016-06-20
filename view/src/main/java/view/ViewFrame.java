package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
class ViewFrame extends JFrame implements KeyListener {

	/** The model. */
	private IModel						model;

	/** The controller. */
	private IController				controller;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
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

	/**
	 * Builds the view frame.
	 *
	 * @param model
	 *          the model
	 */
	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
		this.setSize(649,440);
		this.setLocationRelativeTo(null);
		this.setTitle("LORANN v2.0");	/** changed title of the frame to something more fancy **/
	}

	/**
	 * Prints the message.
	 *
	 * @param map
	 *          the message
	 */
	public void printMap(final String map) {
		JOptionPane.showMessageDialog(null, map);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
		/**try {
			for(int i = 0; i < this.l.size(); i++)

			{
				if ((int) this.l.get(i) == keyEvent.getKeyCode()) {
					this.l.remove(i);
				}
			}
			this.l.add(keyEvent.getKeyCode());
			//NettleView.displayMessage("" + keyEvent.getKeyCode());
			if (this.l.size() == 1) {
				this.getNettlePlay().orderPerform(NettleView.keyCodeToUserOrder(keyEvent.getKeyCode()));
			} else if (this.l.size() == 2) {
				int i = 0;
				i = (int) this.l.get(0) * (int) this.l.get(1);
				this.getNettlePlay().orderPerform(NettleView.keyCodeToUserOrder(i));
				//NettleView.displayMessage("Deux touches sont utilisées en même temps !");
			}
			**/

			/*for(int i = 0; i < this.l.size(); i++)

			{
				if ((int) this.l.get(i) == keyEvent.getKeyCode()) {
					this.l.remove(i);
				}
			}*/

		/**} catch (final IOException e) {
			e.printStackTrace();
		}**/
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased( KeyEvent e) {
		//this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}
}
