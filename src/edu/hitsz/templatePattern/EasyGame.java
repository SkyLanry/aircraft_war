package edu.hitsz.templatePattern;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.EnemyFactory;
import edu.hitsz.factory.EliteFactory;
import edu.hitsz.factory.MobFactory;

import java.util.List;

public class EasyGame extends Game {
    private EnemyFactory enemyFactory;
    private AbstractAircraft enemy;
    private int enemyMaxNumber = 3;
    @Override
    public List<AbstractAircraft> enemyProduce(List<AbstractAircraft> enemies){
        if (enemies.size() < enemyMaxNumber) {
            if (Math.random() > 0.8) {
                enemyFactory = new EliteFactory();
                enemies.add(enemyFactory.createEnemy());
            } else {
                enemyFactory = new MobFactory();
                enemies.add(enemyFactory.createEnemy());
            }

        }
        return enemies;

    }

}
