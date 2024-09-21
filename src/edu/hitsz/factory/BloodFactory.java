package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.prop.AbstractProp;
import edu.hitsz.prop.BloodProp;
import edu.hitsz.prop.PropFactory;

public class BloodFactory implements PropFactory {
    public AbstractProp createProp(int X, int Y){
        return new BloodProp(X,Y,0,5);
    }
}
