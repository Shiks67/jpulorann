package element.motionless;

/**
 * Created by Asus on 14/06/2016.
 */
public abstract class MotionlessElements {
    public static final MotionlessElement	BONE									= new Bone();
    public static final MotionlessElement	CRYSTAL								= new Crystal();
    public static final MotionlessElement	GATEC									= new GateC();
    public static final MotionlessElement	GATEO							= new GateO();
    public static final MotionlessElement	HBONE									= new HBone();
    public static final MotionlessElement	VBONE									= new VBone();
    public static final MotionlessElement	PURSE									= new Purse();

    private static MotionlessElement			motionlessElements[]	= { BONE, CRYSTAL, GATEC, GATEO, HBONE, VBONE, PURSE};

    /*public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getFileSymbol() == fileSymbol) {
                return motionlessElement;
            }
        }
        return LAND;
    }*/
}