package element.mobile;

import junit.framework.TestCase;

/**
 * Created by Sylvain on 21/06/2016.
 */
public class ShootTest extends TestCase {
    private Shoot shoot;
    public void setUp() throws Exception {
        super.setUp();
        shoot = new Shoot(1,1);
    }

    public void tearDown() throws Exception {

    }

    public void testGetX() throws Exception {
        assertEquals(1,shoot.getX());
    }

    public void testSetX() throws Exception {
        shoot.setX(2);
        assertEquals(2,shoot.getX());
    }

    public void testGetY() throws Exception {
        assertEquals(1,shoot.getY());
    }

    public void testSetY() throws Exception {
        shoot.setY(2);
        assertEquals(2,shoot.getY());
    }

    public void testMoveUP() throws Exception {
        shoot.moveUP();
        assertEquals(0,shoot.getY());
    }

    public void testMoveLEFT() throws Exception {
        shoot.moveLEFT();
        assertEquals(0,shoot.getX());
    }

    public void testMoveDOWN() throws Exception {
        shoot.moveDOWN();
        assertEquals(2,shoot.getY());
    }

    public void testMoveRIGHT() throws Exception {
        shoot.moveRIGHT();
        assertEquals(2,shoot.getX());
    }

}