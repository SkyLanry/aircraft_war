package edu.hitsz.observerPattern;

import edu.hitsz.bullet.BaseBullet;

import java.util.List;

public class EnemyBulletObserver implements Observer{
    private List<BaseBullet> enemyBullets;
    public EnemyBulletObserver(List<BaseBullet> enemyBullets){
        this.enemyBullets = enemyBullets;
    }

    @Override
    public void respond(){
        enemyBullets.removeAll(enemyBullets);
    }

}
