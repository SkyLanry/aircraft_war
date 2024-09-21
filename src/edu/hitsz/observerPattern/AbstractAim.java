package edu.hitsz.observerPattern;

import java.util.ArrayList;

public abstract class AbstractAim {
    protected ArrayList observers = new ArrayList();
    public void attach(Observer observer){
        observers.add(observer);
    }
    public void unbind(Observer observer){
        observers.remove(observer);
    }

    public abstract void notice();
}
