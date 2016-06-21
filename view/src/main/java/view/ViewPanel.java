package view;

import model.Model;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
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

	/**
	 * 2d array when we copy the one from the model
	 */
	public char[][] map;
	/**
	 * r used to display highscores log
	 */
	private int r = 0;
	int GO = 0;
	int Win = 0;

	public static int m = 0;


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
		this.viewFrame.getModel().getMapInTab();	/** fulfill the 2d array with what we got in the DB in the model **/
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
		graphics.setColor(Color.BLACK);		/** background color is now black **/
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		graphics.setFont(new Font("default", Font.BOLD, 16));	/** now want you write is bold **/

		this.map = this.viewFrame.getModel().getMap();		/** we copy the 2D array from the model to use it to display images **/

		/**
		 * Instantiate the monsters with their timer
		 */
		this.viewFrame.getModel().monster1();
		this.viewFrame.getModel().monster2();
		this.viewFrame.getModel().monster3();
		this.viewFrame.getModel().monster4();
		this.viewFrame.getModel().setO(this.viewFrame.getModel().getO() +1);


		for(int i = 0; i < this.map.length; i++)			/** beginning of the parser **/
		{
			for (int j = 0; j < this.map[i].length; j++)
			{
				switch (this.map[i][j]){
					case 'B':
						try {
							Image img = ImageIO.read(new File("sprite/bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);	/** displays an image **/
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 'H':
						try {
							Image img = ImageIO.read(new File("sprite/horizontal_bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 'V':
						try {
							Image img = ImageIO.read(new File("sprite/vertical_bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 'P':
						try {
							Image img = ImageIO.read(new File("sprite/purse.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 'L' :
						graphics.drawImage((new ImageIcon("sprite/lorann.gif")).getImage(),32*j,32*i,this);
						break;
					case 'C' :
						try {
							Image img = ImageIO.read(new File("sprite/gate_closed.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 'O':
						try {
							Image img = ImageIO.read(new File("sprite/gate_open.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 'K' :
						try {
							Image img = ImageIO.read(new File("sprite/crystal_ball.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case '1' :
						try {
							Image img = ImageIO.read(new File("sprite/monster_1.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case '2' :
						try {
							Image img = ImageIO.read(new File("sprite/monster_2.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case '3' :
						try {
							Image img = ImageIO.read(new File("sprite/monster_3.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case '4' :
						try {
							Image img = ImageIO.read(new File("sprite/monster_4.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 'M' :

						graphics.drawImage((new ImageIcon("sprite/shoot.gif")).getImage(),32*j,32*i,this);
						break;
					default:
						try {
							Image img = ImageIO.read(new File("sprite/noimage.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

				}
			}
		}			/** end of the parser **/
		if (this.r < 1) {		/** display highscore log only when you start the game **/
			this.viewFrame.getModel().loadHighscores();
			for(int c = 1;c < 8; c++){
				if(c==1) {
					graphics.setColor(Color.RED);
					graphics.drawString("Highscores :",256,64+32*c);
				}
				else {
					graphics.setColor(Color.WHITE);
					for (int i = 0 ; i < 6;) {
						graphics.drawString(this.viewFrame.getModel().getDBplayerName(i) + " :  " + this.viewFrame.getModel().getDBplayerScore(i), 256, (128+ (32 * i)));
						i++;
					}
				}
			}

		}
		this.r++;

		if (this.r > 2) {
			graphics.setColor(Color.YELLOW);		/** color change to write stuff **/
			graphics.drawString("SCORE : " + this.viewFrame.getModel().getScore(),4,this.getHeight()-10);	/** display actual score **/
			graphics.drawString("LEVEL : " + this.viewFrame.getModel().getMapnumber(),200,this.getHeight()-10);
			graphics.setColor(Color.BLACK);		/** everything next is black again just in case **/
		}

		/**
		 * Fireball
		 */
		this.viewFrame.getModel().checkFireball();
		this.viewFrame.getModel().fireAnimation();
		this.viewFrame.getModel().checkFireball();

		/**
		 * If Lorann is dead
		 */
		if(this.viewFrame.getModel().isDead() && GO == 0){
			GO = 1;
			this.viewFrame.printMap("GAME OVER");
			this.endGame();
		}
		/**
		 * if Lorann is on the gate
		 */
		if(this.viewFrame.getModel().getOnGate() == 1 && Win == 0){
			Win= 1;
			this.viewFrame.printMap("CONGRATULATIONS !\n You finished the game !");
			this.endGame();
		}
		try {
			Image img = ImageIO.read(new File("sprite/exia.png"));
			graphics.drawImage(img, this.getWidth()-72, this.getHeight()-35, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * What we do at the end of the game :
	 * ask for player name and put it with the score in the DB
	 */
	public void endGame() {
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		String nom = jop.showInputDialog(null, "Your name", JOptionPane.QUESTION_MESSAGE);

		int score = this.viewFrame.getModel().getScore();
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jpublankproject?autoReconnect=true&useSSL=false", "root", "");
			String sql = "{call putHighscoreInDB(?,?)}";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(2, nom);
			statement.setInt(1, score);
			statement.execute();
		 	jop2.showMessageDialog(null, "Score saved", null, JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		 	jop2.showMessageDialog(null, "Score not saved", null, JOptionPane.INFORMATION_MESSAGE);
		}

		System.exit(0);		/** exit game **/
	}
}
