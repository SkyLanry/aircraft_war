package edu.hitsz.aircraft;

import edu.hitsz.templatePattern.Game;
import edu.hitsz.application.MusicThread;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.factory.BloodFactory;
import edu.hitsz.factory.BombFactory;
import edu.hitsz.factory.FireFactory;
import edu.hitsz.prop.*;
import edu.hitsz.strategy.OperationScattering;

import java.util.LinkedList;
import java.util.List;

public class BossEnemy extends AbstractAircraft {

    /**攻击方式 */

    /**
     * 子弹一次发射数量
     */
    private int shootNum = 3;

    /**
     * 子弹伤害
     */
    private int power = 30;

    /**
     * 子弹射击方向 (向上发射：1，向下发射：-1)
     */
    private int direction = 1;
    /**
     * 击落得分
     */
    public int score = 100;

    public BossEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    @Override
    public List<BaseBullet> shoot() {
        Context context = new Context(new OperationScattering());
        return context.executeStrategy(this);
    }
    public List<AbstractProp> product(int x, int y){
        List<AbstractProp> one = new LinkedList<>();
        PropFactory propFactory;
        AbstractProp prop;
        for(int i = 0;i < 3;i++) {
            double temp = Math.random();
            if (temp < 0.4) {
                propFactory = new BloodFactory();
                prop = propFactory.createProp((int)(x+100*Math.random()), y);
                one.add(prop);
            } else if (temp >= 0.4 && temp < 0.7) {
                propFactory = new FireFactory();
                prop = propFactory.createProp((int)(x-100*Math.random()), y);
                one.add(prop);
            } else if (temp >= 0.7 && temp < 1.0) {
                propFactory = new BombFactory();
                prop = propFactory.createProp((int)(x+100*Math.random()), y);
                one.add(prop);
            }
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
    @Override
    public void vanish(){
        super.vanish();
        MusicThread.bgm = true;
        MusicThread.bossBgm = false;
        Game.musicThread = new MusicThread("src/videos/bgm.wav");
        Game.musicThread.start();
    }

}
