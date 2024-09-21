package edu.hitsz.prop;

import edu.hitsz.aircraft.AbstractAircraft;

public interface PropFactory {
    public abstract AbstractProp createProp(int X, int Y);
}
