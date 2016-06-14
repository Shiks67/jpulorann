package element.motionless;

import element.Element;
import element.ISprite;
import element.Permeability;

/**
 * Created by Ahmed on 13/06/2016.
 */
public class MotionlessElement extends Element implements IDoActionOnHeroes {
    private final char fileSymbol;

    public MotionlessElement(final ISprite sprite, final Permeability permeability, final char fileSymbol) {
        super(sprite, permeability);
        this.fileSymbol = fileSymbol;
    }

    public char getFileSymbol() {
        return this.fileSymbol;
    }


    @Override
    public ActionOnHeroes getActionOnHeroes() {
        return ActionOnHeroes.NOP;
    }
}
