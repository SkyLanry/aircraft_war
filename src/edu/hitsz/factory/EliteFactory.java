package edu.hitsz.factory;

import edu.hitsz.GUI.BeginMenu;
import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.EliteEnemy;
import edu.hitsz.aircraft.EnemyFactory;
import edu.hitsz.templatePattern.Game;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;

public class EliteFactory implements EnemyFactory {
    private EliteEnemy eliteEnemy;
    private double multiplier = 1.00;
    public AbstractAircraft createEnemy() {
        if(BeginMenu.gameDegree == "easy"){
            eliteEnemy = new EliteEnemy(  (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.ELITE_ENEMY_IMAGE.getWidth())),
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                    0,
                    8,
                    60);
        } else if (BeginMenu.gameDegree == "normal") {
            if(Game.score % 1000 <= 100 && Game.score >100) {
                boolean hasAdd = false;
                if (Game.score / 1000 == (multiplier - 1) / 0.03) {
                    hasAdd = true;
                }
                if(!hasAdd){
                    multiplier += 0.03;
                }
            }
            eliteEnemy = new EliteEnemy(  (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.ELITE_ENEMY_IMAGE.getWidth())),
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                    0,
                    10,
                    (int)(90*multiplier));
        }else {
            if(Game.score % 1000 <= 100 && Game.score >100) {
                boolean hasAdd = false;
                if (Game.score / 1000 == (multiplier - 1) / 0.05) {
                    hasAdd = true;
                }
                if(!hasAdd){
                    multiplier += 0.05;
                }
            }
            eliteEnemy = new EliteEnemy(  (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.ELITE_ENEMY_IMAGE.getWidth())),
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                    Math.random()-0.5 > 0 ? -1:1,
                    10,
                    (int)(120*multiplier));
        }
        return  eliteEnemy;
    }
}
