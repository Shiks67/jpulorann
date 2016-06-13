package element.motionless;

import element.Permeability;
import element.Sprite;

/**
 * Created by Asus on 13/06/2016.
 */
class GateC extends MotionlessElement{

    public GateC(){
      super(new Sprite("C", "gate_closed.png"), Permeability.BLOCKING, 'C');
    }
}
