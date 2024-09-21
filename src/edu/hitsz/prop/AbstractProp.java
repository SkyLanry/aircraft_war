package edu.hitsz.prop;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.Main;
import edu.hitsz.basic.AbstractFlyingObject;
import edu.hitsz.bullet.BaseBullet;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

/**
 * 所有种类道具的抽象父亲
 * 加血道具、火力道具、炸弹道具（BLOOD、FIRE、BOMB）
 *
 * @author 210110327
 */
public abstract class AbstractProp extends AbstractFlyingObject {

    public AbstractProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    public abstract void function(HeroAircraft heroAircraft, List<AbstractAircraft> enemies, List<BaseBullet> enemyBullets);
}
