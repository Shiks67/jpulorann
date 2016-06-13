package element.motionless;

import element.Permeability;
import element.Sprite;

/**
 * Created by Ahmed on 13/06/2016.
 */
class Bone extends MotionlessElement {

    public Bone(){
        super(new Sprite("B", "bone.png"), Permeability.BLOCKING, 'C');
    }
}
