package edu.hitsz.prop;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.factory.FireFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirePropTest {
    private AbstractProp fireProp;
    private PropFactory factory;
    private HeroAircraft heroAircraft;
    @BeforeEach
    void setUp(){
        System.out.println("**---Executed before each test method in this class---**");
        heroAircraft = HeroAircraft.getHeroAircraft();
        factory = new FireFactory();
        fireProp = factory.createProp(-1,20);
    }
    @AfterEach
    void tearDown(){
        System.out.println("**---Executed after each test method in this class---**");
        fireProp = null;
        factory = null;
        heroAircraft = null;
    }

    @Test
    @DisplayName("Test forward method")
    void forward() {
        System.out.println("**---Test forward method executed---**");
        assertTrue(fireProp.notValid());
    }

    @Test
    @DisplayName("Test function method")
    void function() {
        System.out.println("**---Test function method executed---**");
    }
}