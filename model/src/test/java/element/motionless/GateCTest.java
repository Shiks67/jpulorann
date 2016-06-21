package element.motionless;

import junit.framework.TestCase;

/**
 * Created by Sylvain on 21/06/2016.
 */
public class GateCTest extends TestCase {
    private GateC gate;
    public void setUp() throws Exception {
        super.setUp();
        gate = new GateC(1,1);
    }

    public void tearDown() throws Exception {

    }

    public void testGetX() throws Exception {
        assertEquals(1,gate.getX());
    }

    public void testSetX() throws Exception {
        gate.setX(2);
        assertEquals(2,gate.getX());
    }

    public void testGetY() throws Exception {
        assertEquals(1,gate.getY());
    }

    public void testSetY() throws Exception {
        gate.setY(2);
        assertEquals(2,gate.getY());
    }

}