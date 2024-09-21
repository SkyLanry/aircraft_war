package edu.hitsz.aircraft;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.factory.BossFactory;
import edu.hitsz.prop.AbstractProp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BossEnemyTest {
    private AbstractAircraft Boss;
    private BossFactory factory;


    @BeforeEach
    void setUp(){
        System.out.println("**---Executed before each test method in this class---**");
        factory = new BossFactory();
        Boss = factory.createEnemy();
    }
    @AfterEach
    void tearDown(){
        System.out.println("**---Executed after each test method in this class---**");
        factory = null;
        Boss = null;
    }
    @Test
    @DisplayName("Test shoot method")
    void shoot() {
        System.out.println("**---Test shoot method executed---**");
        List<BaseBullet> bullets = Boss.shoot();
        assertFalse(bullets.isEmpty());
    }

    @Test
    @DisplayName("Test product method")
    void product() {
        System.out.println("**---Test product method executed---**");
        List<AbstractProp> props = Boss.product(10,20);
        assertFalse(props.isEmpty());
    }
}

