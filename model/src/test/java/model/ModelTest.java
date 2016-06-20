/**
 *
 */
package model;

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
		this.model = new Model() {
		};
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
		this.model.loadMap("MAP1");
		Assert.assertEquals("BHHHHHHHHHHHHHHHHHHB\nV    V             V\nV    V             V\nV    V     P       V\nV  P BHHHHHB       V\nV P P1     K  L  KCV\nV  P BHHHHHB       V\nV    V     P       V\nV    V             V\nV    V             V\nV    V             V\nBHHHHHHHHHHHHHHHHHHB", this.model.getMap());
		this.model.loadMap("MAP2");
		Assert.assertEquals("        BHHB        \n        VP V        \nBHHHHHB V  BHHHHHHB \nV4    BHB L  P   2V \nV       K  BHBHBBHB \nV     BHB  B V VV V \nVP    V V  BHBHBBHB \nV P   V V  BHBHBBHB \nVP    V V  V V VV V \nV PBHHBHB  BHBHBBHBB\nV               3 CV\nBHHHHHHHHHHHHHHHHHHB", this.model.getMap());
		this.model.loadMap("MAP3");
		Assert.assertEquals("BHHHHHHHB    BHHHHHB\nVP      V    V1   3V\nV BHHHB V    V  B  V\nV V     V    V  P  V\nB V BHHHBHHHHB  P  V\nC V V   V  L V BPB V\nB V B B B    V  P  V\nVKV   V      V  P  V\nV BHHHHHBHHHHB  P  V\nV       P       B  V\nV       BHHHHB2   4V\nBHHHHHHHB    BHHHHHB", this.model.getMap());
		this.model.loadMap("MAP4");
		Assert.assertEquals("BHHHHHHHHHHHHHHHHHB \nV                 BB\nV BHHHHHHHHHHHHHB  V\nV P          2  BB V\nV BHHHHHHHHHHHB  V V\nV V4           B V V\nVKV            B V V\nV BHHHHHHHHHHHB  V V\nV P   1         BB V\nV BHHHHHHHHHHHHHBL B\nBB                 C\n BHHHHHHHHHHHHHHHHHB", this.model.getMap());
		this.model.loadMap("MAP5");
		Assert.assertEquals("BHHHHHHHHHHHBHHHHB  \nVP P        V    BB \nV  B  B3 B  V     V \nV  V4 P  P1 V   B V \nV  V  P  P  V   V V \nV  V  P  P  V   V V \nV  V  B  B  V   V V \nV  V        V   V V \nV  BHHHHHHHHB   V V \nV  K        L BHB V \nBB               CBB\n BHHHHHHHHHHHHHHHHHB", this.model.getMap());
	}

}
