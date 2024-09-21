package edu.hitsz.templatePattern;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.EnemyFactory;
import edu.hitsz.factory.BossFactory;
import edu.hitsz.factory.EliteFactory;
import edu.hitsz.factory.MobFactory;

import java.util.List;

public class HardGame extends Game {
    private EnemyFactory enemyFactory;
    private AbstractAircraft bossEnemy;
    private int enemyMaxNumber = 7;
    private double eliteProbability = 0.8;
    private double multiplier = 1.00;

    @Override
    public List<AbstractAircraft> enemyProduce(List<AbstractAircraft> enemies){
        if(score % 1000 <= 100 && score >100){
            boolean hasAdd = false;
            if(score/1000 == (int)((multiplier-1)/0.05)){
                hasAdd = true;
            }
            if(!hasAdd){
                eliteProbability = eliteProbability - 0.01;
                multiplier += 0.05;
                System.out.println("提高难度！ 精英机概率：" + (1-eliteProbability) + ",敌机属性提升倍率：" + multiplier);
            }
        }
        if (score % 1000 <= 100 && score > 100) {
            boolean hasBoss = false;
            enemyFactory = new BossFactory();
            for (AbstractAircraft enemyAircraft : enemies) {
                if (enemyAircraft == bossEnemy) {
                    hasBoss = true;
                }
            }
            if (!hasBoss) {
                bossEnemy = enemyFactory.createEnemy();
                enemies.add(bossEnemy);
            }
        }
        if (enemies.size() < enemyMaxNumber) {
            if (Math.random() > eliteProbability) {
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
