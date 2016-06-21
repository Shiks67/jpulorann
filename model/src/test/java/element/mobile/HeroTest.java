package element.mobile;

import junit.framework.TestCase;

/**
 * Created by Sylvain on 21/06/2016.
 */
public class HeroTest extends TestCase {
    private Hero hero;
    public void setUp() throws Exception {
        super.setUp();
        hero = new Hero(1,1);
    }

    public void tearDown() throws Exception {

    }

    public void testGetX() throws Exception {
    assertEquals(1,hero.getX());
    }

    public void testSetX() throws Exception {
        hero.setX(2);
        assertEquals(2,hero.getX());
    }

    public void testGetY() throws Exception {
        assertEquals(1,hero.getY());
    }

    public void testSetY() throws Exception {
        hero.setY(2);
        assertEquals(2,hero.getY());
    }

    public void testMoveUp() throws Exception {
        hero.moveUp();
        assertEquals(0,hero.getY());
    }

    public void testMoveLEFT() throws Exception {
        hero.moveLEFT();
        assertEquals(0,hero.getX());
    }

    public void testMoveDOWN() throws Exception {
        hero.moveDOWN();
        assertEquals(2,hero.getY());
    }

    public void testMoveRIGHT() throws Exception {
        hero.moveRIGHT();
        assertEquals(2,hero.getX());
    }


}