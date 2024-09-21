package edu.hitsz.observerPattern;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.EliteEnemy;
import edu.hitsz.aircraft.MobEnemy;
import edu.hitsz.templatePattern.Game;

import java.util.List;

public class EnemyObserver implements Observer{
    private List<AbstractAircraft> enemies;
    public EnemyObserver(List<AbstractAircraft> enemies){
        this.enemies = enemies;
    }

    @Override
    public void respond(){
        for(AbstractAircraft enemy:enemies){
            if(enemy instanceof EliteEnemy || enemy instanceof MobEnemy){
                enemy.vanish();
                Game.score += enemy.getScore();

            }
            else{
                enemy.decreaseHp(100);
            }
        }
    }

}
