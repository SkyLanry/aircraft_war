package edu.hitsz.observerPattern;

public class AimBomb extends AbstractAim{
    @Override
    public void notice(){
        for(Object obs:observers){
            ((Observer)obs).respond();
        }
    }
}
