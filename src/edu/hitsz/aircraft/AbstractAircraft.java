package edu.hitsz.aircraft;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.basic.AbstractFlyingObject;
import edu.hitsz.prop.AbstractProp;
import edu.hitsz.strategy.ShootStrategy;

import java.util.List;

/**
 * 所有种类飞机的抽象父类：
 * 敌机（BOSS, ELITE, MOB），英雄飞机
 *
 * @author hitsz
 */
public abstract class AbstractAircraft extends AbstractFlyingObject {
    /**
     * 生命值
     */
    protected int maxHp;
    protected int hp;
    protected int shootNum;
    protected int direction;
    protected int power;
    protected int score;

    public AbstractAircraft(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY);
        this.hp = hp;
        this.maxHp = hp;
    }

    public void decreaseHp(int decrease){
        hp -= decrease;
        if(hp <= 0){
            hp=0;
            vanish();
        }
    }

    public int getHp() {
        return hp;
    }


    /**
     * 飞机射击方法，可射击对象必须实现
     * @return
     *  可射击对象需实现，返回子弹
     *  非可射击对象空实现，返回null
     */
    public abstract List<BaseBullet> shoot();

    public abstract List<AbstractProp> product(int x, int y);

    public int getShootNum(){return shootNum;}
    public int getDirection(){return direction;}
    public int getPower(){return power;}
    public int getScore(){return score;}
    class Context{
        private ShootStrategy strategy;
        public Context(ShootStrategy strategy){
            this.strategy = strategy;
        }
        public void setStrategy(ShootStrategy strategy){
            this.strategy = strategy;
        }
        public List<BaseBullet> executeStrategy(AbstractAircraft aircraft){
            return strategy.doOperation(aircraft);
        }

    }

}


