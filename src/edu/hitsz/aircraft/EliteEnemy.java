package edu.hitsz.aircraft;

import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.factory.BloodFactory;
import edu.hitsz.factory.BombFactory;
import edu.hitsz.factory.FireFactory;
import edu.hitsz.prop.*;
import edu.hitsz.strategy.OperationDirectShooting;

import java.util.LinkedList;
import java.util.List;

/**
 * 精英敌机
 * 可发射子弹
 *
 *
 */
public class EliteEnemy extends AbstractAircraft {

    /**攻击方式 */

    /**
     * 子弹一次发射数量
     */
    private int shootNum = 1;

    /**
     * 子弹伤害
     */
    private int power = 30;

    /**
     * 子弹射击方向 (向上发射：1，向下发射：-1)
     */
    private int direction = 1;

    public int score = 30;

    public EliteEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    @Override
    public void forward() {
        super.forward();
        // 判定 y 轴向下飞行出界
        if (locationY >= Main.WINDOW_HEIGHT ) {
            vanish();
        }
    }
    @Override
    public List<BaseBullet> shoot() {
        Context context = new Context(new OperationDirectShooting());
        return context.executeStrategy(this);
    }
    public List<AbstractProp> product(int x, int y){
        List<AbstractProp> one = new LinkedList<>();
        PropFactory propFactory;
        AbstractProp prop;
        double temp = Math.random();
        if(temp <0.4 ){
            propFactory = new BloodFactory();
            prop = propFactory.createProp(x, y);
            one.add(prop);
        }
        else if(temp > 0.4&&temp <0.7){
            propFactory = new FireFactory();
            prop = propFactory.createProp(x, y);
            one.add(prop);
        }
        else if(temp >0.7&&temp < 1.0){
            propFactory = new BombFactory();
            prop = propFactory.createProp(x, y);
            one.add(prop);
        }
        return one;
    }
    @Override
    public int getShootNum(){return shootNum;}
    @Override
    public int getDirection(){return direction;}
    @Override
    public int getPower(){return power;}
    @Override
    public int getScore(){return this.score;}
}
