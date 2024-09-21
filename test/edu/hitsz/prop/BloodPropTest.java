package edu.hitsz.prop;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.factory.BloodFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BloodPropTest {

    private AbstractProp bloodProp;
    private PropFactory factory;
    private HeroAircraft heroAircraft;
    private List<AbstractAircraft> enemyAircrafts;
    private List<BaseBullet> enemyBullets;
    @BeforeEach
    void setUp(){
        System.out.println("**---Executed before each test method in this class---**");
        heroAircraft = HeroAircraft.getHeroAircraft();
        factory = new BloodFactory();
        bloodProp = factory.createProp(-1,20);
    }
    @AfterEach
    void tearDown(){
        System.out.println("**---Executed after each test method in this class---**");
        bloodProp = null;
        factory = null;
        heroAircraft = null;
    }

    @Test
    @DisplayName("Test forward method")
    void forward() {
        System.out.println("**---Test forward method executed---**");
        assertFalse(bloodProp.notValid());
    }

    @Test
    @DisplayName("Test function method")
    void function() {
        System.out.println("**---Test function method executed---**");
        heroAircraft.decreaseHp(60);
        bloodProp.function(heroAircraft, enemyAircrafts, enemyBullets);
        assertEquals(9970,heroAircraft.getHp());
    }
}