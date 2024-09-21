package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.HeroBullet;
import edu.hitsz.prop.AbstractProp;
import edu.hitsz.strategy.OperationDirectShooting;
import edu.hitsz.strategy.OperationScattering;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * 英雄飞机，游戏玩家操控
 * @author hitsz
 */
public class HeroAircraft extends AbstractAircraft {
    private volatile static HeroAircraft heroAircraft;

    private HeroAircraft (int locationX, int locationY, int speedX, int speedY, int hp){
        super(locationX, locationY, speedX, speedY, hp);
    }

    /**
     * 双重检查锁定式
     * @return
     */
    public static HeroAircraft getHeroAircraft(){
        if(heroAircraft == null){
            synchronized (HeroAircraft.class){
                if(heroAircraft == null){
                    heroAircraft = new HeroAircraft(Main.WINDOW_WIDTH / 2,
                            Main.WINDOW_HEIGHT - ImageManager.HERO_IMAGE.getHeight() ,
                            0, 0, 10000);
                }
            }
        }
        return heroAircraft;
    }

    /**攻击方式 */

    /**
     * 子弹一次发射数量
     */
    private int shootNum = 2;

    /**
     * 子弹伤害
     */
    private int power = 30;

    /**
     * 子弹射击方向 (向上发射：1，向下发射：-1)
     */
    private int direction = -1;




    @Override
    public void forward() {
        // 英雄机由鼠标控制，不通过forward函数移动
    }

    @Override
    /**
     * 通过射击产生子弹
     * @return 射击出的子弹List
     */
    public List<BaseBullet> shoot() {
        Context context = new Context(new OperationDirectShooting());
        if(shootNum == 2){
            return context.executeStrategy(this);
        }
        else{
            context.setStrategy(new OperationScattering());
            return context.executeStrategy(this);
        }
    }

    public void increaseHp(int increase){
        hp += increase;
        if(hp >= 10000){
            hp=10000;
        }
    }
    public List<AbstractProp> product(int x,int y){
        return new LinkedList<>();
    }
    @Override
    public int getShootNum(){return shootNum;}
    @Override
    public int getDirection(){return direction;}
    @Override
    public int getPower(){return power;}
    public void setShootNum(int i){shootNum = i;}
}
