package view;

import model.Model;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

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
	}

	//public char[][] map = new char[12][21];

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
		//graphics.drawString(this.getViewFrame().getModel().getMap(), 10, 20);

		/**for(int i=0; i<this.viewFrame.getModel().getMap().length; i++)
		{
			for (int j = 0; j < this.viewFrame.getModel().getMap()[i].length; j++)
			{
				this.map[i][j] = this.viewFrame.getModel().getMap()[i][j];
			}
		}**/
		this.viewFrame.getModel().getMapInTab();


		char[][] map = this.viewFrame.getModel().getMap();
		/**for (int i = 0; i < 21; i++) {
			System.arraycopy(this.viewFrame.getModel().getMap()[i], 0, map[i], 0, this.viewFrame.getModel().getMap()[i].length);
		}**/

		for(int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[i].length; j++)
			{
				switch (map[i][j]){
					case 'B':
						System.out.print(map[i][j]);
						break;
					case 'H':
						System.out.print(map[i][j]);
						break;
					case 'V':
						System.out.print(map[i][j]);
						break;
					case 'P':
						System.out.print(map[i][j]);
						break;
					case 'L' :
						System.out.print(map[i][j]);
						break;
					case 'C' :
						System.out.print(map[i][j]);
						break;
					case 'K' :
						System.out.print(map[i][j]);
						break;
					case '1' :
						System.out.print(map[i][j]);
						break;
					case '2' :
						System.out.print(map[i][j]);
						break;
					case '3' :
						System.out.print(map[i][j]);
						break;
					case '4' :
						System.out.print(map[i][j]);
						break;
					default:
						System.out.print(" ");
						break;
				}
			}
			System.out.println();
		}
	}


}
