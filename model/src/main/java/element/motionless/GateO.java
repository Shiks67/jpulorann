package element.motionless;

import element.Permeability;
import element.Sprite;

/**
 * Created by Ahmed on 13/06/2016.
 */
class GateO extends MotionlessElement{

    public GateO(){
        super(new Sprite("O","gate_open.png"), Permeability.PENETRABLE, 'C');
    }
}
