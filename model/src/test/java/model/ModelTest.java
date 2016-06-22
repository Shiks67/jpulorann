/**
 *
 */
package model;

import element.mobile.Hero;
import element.mobile.Monster1;
import element.mobile.Monster2;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class ModelTest.
 *
 * @author Jean-Aymeric Diet
 */
public class ModelTest {
	@Test
	public void loadMap() throws Exception {

	}

	@Test
	public void loadHighscores() throws Exception {
		Assert.assertEquals(9999,model.getDBplayerScore(0));
		Assert.assertEquals("Soos",model.getDBplayerName(0));
	}

	@Test
	public void testisDead() throws Exception {
		model.getHero().setX(5);
		model.getHero().setY(5);
		model.getMonster1().setX(5);
		model.getMonster1().setY(5);
		Assert.assertEquals(true,model.isDead());
	}

	@Test
	public void testFireball() throws Exception {
		model.fireBall();
		model.getMonster1().setX(5);
		model.getMonster1().setY(5);
		model.getShoot().setX(5);
		model.getShoot().setY(5);
		model.checkFireball();
		Assert.assertEquals(1,model.death1);
	}
	@Test
	public void monster1() throws Exception {

	}

	private Model model;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.model = new Model();
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.Model#getMap()}.
	 */
	//@Test
	public void testGetMessage() {
		Assert.assertEquals("", this.model.getMap());
	}

	/**
	 * Test method for {@link model.Model#loadMap(java.lang.String)}.
	 */
	@Test
	public void testGetMessageString() {
		/**
		 * map edited, that's why it fail
		 */
		this.model.loadMap("MAP1");
		Assert.assertEquals("BHHHHHHHHHHHHHHHHHHB\n" +
				"V    V             V\n" +
				"V    V             V\n" +
				"V    V     P       V\n" +
				"V  P BHHHHHB       V\n" +
				"V P P1     K  L  KCV\n" +
				"V  P BHHHHHB       V\n" +
				"V    V     P       V\n" +
				"V    V             V\n" +
				"V    V             V\n" +
				"V    V             V\n" +
				"BHHHHHHHHHHHHHHHHHHB", model.map);
		this.model.loadMap("MAP2");
		Assert.assertEquals("        BHHB        \n" +
				"        VP V        \n" +
				"BHHHHHB V  BHHHHHHB \n" +
				"V4    BHB L  B   2V \n" +
				"V       K BBHBHBBHB \n" +
				"V     BHBHBB V VV V \n" +
				"VP    V V  BHBHBBHB \n" +
				"V P   V V  BHBHBBHB \n" +
				"VP    V V  V V VV V \n" +
				"V PBHHBHB  BHBHBBHBB\n" +
				"V               3 CV\n" +
				"BHHHHHHHHHHHHHHHHHHB", model.map);
		this.model.loadMap("MAP3");
		Assert.assertEquals("BHHHHHHHB    BHHHHHB\n" +
				"VP      V    V1   3V\n" +
				"V BHHHB V    V  B  V\n" +
				"V V     V    V  P  V\n" +
				"B V BHHHBHHHHB  P  V\n" +
				"C V V   V  L V BPB V\n" +
				"B V B B B    V  P  V\n" +
				"V V   V      V  P  V\n" +
				"V BHHHHHBHHHHB  P  V\n" +
				"V       K       B  V\n" +
				"V       BHHHHB2   4V\n" +
				"BHHHHHHHB    BHHHHHB", model.map);
		this.model.loadMap("MAP4");
		Assert.assertEquals("BHHHHHHHHHHHHHHHHHB \n" +
				"V                 BB\n" +
				"V BHHHHHHHHHHHHHB  V\n" +
				"V P          2  BB V\n" +
				"V BHHHHHHHHHHHB  V V\n" +
				"V V4           B V V\n" +
				"VKV            B V V\n" +
				"V BHHHHHHHHHHHB  V V\n" +
				"V P   1         BB V\n" +
				"V BHHHHHHHHHHHHHBL B\n" +
				"BB                 C\n" +
				" BHHHHHHHHHHHHHHHHHB", model.map);
		this.model.loadMap("MAP5");
		Assert.assertEquals("BHHHHHHHHHHHBHHHHB  \n" +
				"VP P        V    BB \n" +
				"V  B  B3 B  V     V \n" +
				"V  V4 P  P1 V   B V \n" +
				"V  V  P  P  V   V V \n" +
				"V  V  P  P  V   V V \n" +
				"V  V  B  B  V   V V \n" +
				"V  V        V   V V \n" +
				"V  BHHHHHHHHB   V V \n" +
				"V  K        L BHB V \n" +
				"BB               CBB\n" +
				" BHHHHHHHHHHHHHHHHHB", model.map);
		this.model.loadMap("MAP6");
		Assert.assertEquals("BHHBHHHHHHHHHHHHBHHB\n" +
				"V1 B            B 2V\n" +
				"V  B            B  V\n" +
				"BBBB      C     BBBB\n" +
				"V                  V\n" +
				"V       P L P      V\n" +
				"V                  V\n" +
				"V         K        V\n" +
				"BBBB            BBBB\n" +
				"V  B            B  V\n" +
				"V4 B            B 3V\n" +
				"BHHBHHHHHHHHHHHHBHHB",model.map);
	}

}
