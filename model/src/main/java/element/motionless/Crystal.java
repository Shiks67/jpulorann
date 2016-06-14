package element.motionless;

import element.Permeability;
import element.Sprite;

/**
 * Created by Asus on 13/06/2016.
 */
class Crystal extends MotionlessElement{

    public Crystal(){
        super(new Sprite("K", "crystal_ball.png"), Permeability.PENETRABLE, 'C');
    }

    public ActionOnHeroes getActionOnHeroes() {
        return ActionOnHeroes.CRYSTAL;
    }
}
