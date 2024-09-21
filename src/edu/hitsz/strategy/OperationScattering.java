package edu.hitsz.strategy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class OperationScattering implements ShootStrategy {
    @Override
    public List<BaseBullet> doOperation(AbstractAircraft aircraft){
        List<BaseBullet> res = new LinkedList<>();
        int direction = aircraft.getDirection();
        int power = aircraft.getPower();
        int x = aircraft.getLocationX();
        int y = aircraft.getLocationY() + direction*2;
        int speedX = 0;
        int speedY = aircraft.getSpeedY() + direction*5;
        int shootNum = 5;
        BaseBullet bullet;
        for(int i=0; i<shootNum; i++){
            if(aircraft instanceof HeroAircraft) {
                speedX = i-2;
                bullet = new HeroBullet(x + (i * 2 - shootNum + 1) * 10, y, speedX, speedY, power);
                res.add(bullet);
                /**if (i == 0) {
                    speedX = speedX - 3;
                    bullet = new HeroBullet(x + (i * 2 - shootNum + 1) * 10, y, speedX, speedY, power);
                    speedX = 0;
                    res.add(bullet);
                } else if (i == 1) {
                    bullet = new HeroBullet(x + (i * 2 - shootNum + 1) * 10, y, 0, speedY, power);
                    res.add(bullet);
                } else {
                    speedX = speedX + 3;
                    bullet = new HeroBullet(x + (i * 2 - shootNum + 1) * 10, y, speedX, speedY, power);
                    speedX = 0;
                    res.add(bullet);
                }**/
            }
            else {
                speedX = i-2;
                bullet = new EnemyBullet(x + (i * 2 - shootNum + 1) * 10, y, speedX, speedY, power);
                res.add(bullet);
                /**if (i == 0) {
                    speedX = speedX + 3;
                    bullet = new EnemyBullet(x + (i * 2 - shootNum + 1) * 10, y, speedX, speedY, power);
                    speedX = 0;
                    res.add(bullet);
                } else if (i == 1) {
                    bullet = new EnemyBullet(x + (i * 2 - shootNum + 1) * 10, y, 0, speedY, power);
                    res.add(bullet);
                } else {
                    speedX = speedX - 3;
                    bullet = new EnemyBullet(x + (i * 2 - shootNum + 1) * 10, y, speedX, speedY, power);
                    speedX = 0;
                    res.add(bullet);
                }**/
            }
        }
        return res;
    }
}
