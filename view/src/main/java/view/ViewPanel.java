package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	char[][] map;

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		viewFrame.setBackground(Color.BLACK);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		//this.map = this.viewFrame.getModel().getMap();
		this.viewFrame.getModel().getMapInTab();
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());

		this.map = this.viewFrame.getModel().getMap();

		for(int i = 0; i < this.map.length; i++)
		{
			for (int j = 0; j < this.map[i].length; j++)
			{
				switch (this.map[i][j]){
					case 'B':
						//System.out.print(this.map[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
						break;
					case 'H':
						//System.out.print(this.map[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/horizontal_bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
						break;
					case 'V':
						//System.out.print(this.map[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/vertical_bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
						break;
					case 'P':
						//System.out.print(this.map[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/purse.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
						break;
					case 'L' :
						//System.out.print(this.map[i][j]);
						graphics.drawImage((new ImageIcon("sprite/lorann.gif")).getImage(),32*j,32*i,this);
						break;
					case 'C' :
						//System.out.print(this.map[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/gate_closed.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
						break;
					case 'K' :
						//System.out.print(this.map[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/crystal_ball.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
						break;
					case '1' :
						//System.out.print(this.map[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/monster_1.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
						break;
					case '2' :
						//System.out.print(this.map[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/monster_2.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
						break;
					case '3' :
						//System.out.print(this.map[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/monster_3.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
						break;
					case '4' :
						//System.out.print(this.map[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/monster_4.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
						break;
					default:
						//System.out.print(" ");
						try {
							Image img = ImageIO.read(new File("sprite/noimage.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {

							e.printStackTrace();

						}
						break;
				}
			}
			//System.out.println();

		}
	}


}
