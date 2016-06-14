package element.motionless;

import element.Permeability;
import element.Sprite;

/**
 * Created by Ahmed on 13/06/2016.
 */
class Purse extends MotionlessElement{

    public Purse(){
        super(new Sprite("P","purse.png"), Permeability.PENETRABLE, 'C');
    }
}
