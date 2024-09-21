package edu.hitsz.application;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.templatePattern.Game;

public class FireThread implements Runnable{
    private static final int FIRE_REINFORCE_DURATION = 3000;
    private final HeroAircraft hero;
    public FireThread(HeroAircraft hero){
        this.hero = hero;
    }

    /**
     * This thread uses the synchronized clock of the main thread
     * */
    @Override
    public void run(){
        try{
            if(Game.heroFireReinforceFlag && Math.abs(Game.time - Game.FIRE_REINFORCE_TIME) < FIRE_REINFORCE_DURATION) {
                hero.setShootNum(5);
            }
            else {
                hero.setShootNum(2);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
