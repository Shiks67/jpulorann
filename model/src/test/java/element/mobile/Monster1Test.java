package element.mobile;

import junit.framework.TestCase;

/**
 * Created by Sylvain on 21/06/2016.
 */
public class Monster1Test extends TestCase {
    private Monster1 monster;
    public void setUp() throws Exception {

        super.setUp();
        monster = new Monster1(1,1);
    }

    public void tearDown() throws Exception {

    }

    public void testGetX() throws Exception {
    assertEquals(1,monster.getX());
    }

    public void testSetX() throws Exception {
        monster.setX(2);
        assertEquals(2,monster.getX());
    }

    public void testGetY() throws Exception {
    assertEquals(1,monster.getY());
    }

    public void testSetY() throws Exception {
        monster.setY(2);
        assertEquals(2,monster.getY());
    }

    public void testMoveUp() throws Exception {
        monster.moveUp();
        assertEquals(0,monster.getY());
    }

    public void testMoveLEFT() throws Exception {
        monster.moveLEFT();
        assertEquals(0,monster.getX());
    }

    public void testMoveDOWN() throws Exception {
        monster.moveDOWN();
        assertEquals(2,monster.getY());
    }

    public void testMoveRIGHT() throws Exception {
        monster.moveRIGHT();
        assertEquals(2,monster.getX());
    }

}