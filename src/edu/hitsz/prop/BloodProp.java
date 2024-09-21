package edu.hitsz.prop;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

/**
 * 加血道具，敌机掉落
 */

public class BloodProp extends AbstractProp {

    public BloodProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }
    @Override
    public void forward() {
        super.forward();

        // 判定 x 轴出界
        if (locationX <= 0 || locationX >= Main.WINDOW_WIDTH) {
            vanish();
        }

        // 判定 y 轴出界
        if (speedY > 0 && locationY >= Main.WINDOW_HEIGHT ) {
            // 向下飞行出界
            vanish();
        }else if (locationY <= 0){
            // 向上飞行出界
            vanish();
        }
    }
    @Override
    public void function(HeroAircraft heroAircraft, List<AbstractAircraft> enemies, List<BaseBullet> enemyBullets){
        System.out.println("Bloodprop work");
        heroAircraft.increaseHp(30);
    }
}
