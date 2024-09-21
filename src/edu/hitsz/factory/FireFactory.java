package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.prop.AbstractProp;
import edu.hitsz.prop.FireProp;
import edu.hitsz.prop.PropFactory;

public class FireFactory implements PropFactory {
    public AbstractProp createProp(int X, int Y){
        return new FireProp(X,Y,0,5);
    }
}
