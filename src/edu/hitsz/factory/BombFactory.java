package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.prop.AbstractProp;
import edu.hitsz.prop.BombProp;
import edu.hitsz.prop.PropFactory;

public class BombFactory implements PropFactory {
    public AbstractProp createProp(int X, int Y){
        return new BombProp(X,Y,0,5);
    }
}
