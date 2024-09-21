package edu.hitsz.factory;

import edu.hitsz.GUI.BeginMenu;
import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.BossEnemy;
import edu.hitsz.aircraft.EnemyFactory;
import edu.hitsz.templatePattern.Game;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.application.MusicThread;

public class BossFactory implements EnemyFactory {
    private BossEnemy bossEnemy;
    private double multiplier = 1.00;
    public AbstractAircraft createEnemy() {
        MusicThread.bgm = false;
        MusicThread.bossBgm = true;
        new MusicThread("src/videos/bgm_boss.wav").start();
        if(BeginMenu.gameDegree == "normal") {
            bossEnemy =  new BossEnemy((int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.BOSS_ENEMY_IMAGE.getWidth())),
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05 + 100),
                    2,
                    0,
                    600);
        } else if (BeginMenu.gameDegree == "hard") {
            if(Game.score % 1000 <= 100 && Game.score >100) {
                boolean hasAdd = false;
                if (Game.score/1000 == (multiplier-1)/0.05) {
                    hasAdd = true;
                }
                if(!hasAdd){
                    multiplier += 0.05;
                }
            }
            bossEnemy =  new BossEnemy((int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.BOSS_ENEMY_IMAGE.getWidth())),
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05 + 100),
                    2,
                    0,
                    (int)(600*multiplier));
        }
        return bossEnemy;
    }
}
