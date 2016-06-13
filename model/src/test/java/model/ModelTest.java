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
	 * Test method for {@link model.Model#getMessage()}.
	 */
	@Test
	public void testGetMessage() {
		Assert.assertEquals("", this.model.getMessage());
	}

	/**
	 * Test method for {@link model.Model#loadMessage(java.lang.String)}.
	 */
	@Test
	public void testGetMessageString() {
		this.model.loadMessage("GB");
		Assert.assertEquals("Hello world", this.model.getMessage());
		this.model.loadMessage("FR");
		Assert.assertEquals("Bonjour le monde", this.model.getMessage());
		this.model.loadMessage("DE");
		Assert.assertEquals("Hallo Welt", this.model.getMessage());
		this.model.loadMessage("ID");
		Assert.assertEquals("Salamat pagi dunia", this.model.getMessage());
	}

}
