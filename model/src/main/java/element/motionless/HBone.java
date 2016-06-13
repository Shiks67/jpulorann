package element.motionless;

import element.Permeability;
import element.Sprite;

/**
 * Created by Ahmed on 13/06/2016.
 */
class HBone extends MotionlessElement{

    public HBone(){
        super(new Sprite("H", "horizontal_bone.png"), Permeability.BLOCKING, 'C');
    }

}
