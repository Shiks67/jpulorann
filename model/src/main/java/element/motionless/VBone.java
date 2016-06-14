package element.motionless;

import element.Permeability;
import element.Sprite;

/**
 * Created by Ahmed on 13/06/2016.
 */
class VBone extends MotionlessElement{

    public VBone(){
        super(new Sprite("H", "vertical_bone.png"), Permeability.BLOCKING, 'C');
    }

}
