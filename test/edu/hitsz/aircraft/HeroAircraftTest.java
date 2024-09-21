package edu.hitsz.aircraft;

import edu.hitsz.prop.AbstractProp;
import edu.hitsz.factory.FireFactory;
import edu.hitsz.prop.PropFactory;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class HeroAircraftTest {

    private HeroAircraft heroAircraft;
    private AbstractProp fireProp;
    private PropFactory factory;
    @BeforeEach
    void setUp(){
        System.out.println("**---Executed before each test method in this class---**");
        heroAircraft = HeroAircraft.getHeroAircraft();
        factory = new FireFactory();
        fireProp = factory.createProp(10,20);
    }
    @AfterEach
    void tearDown(){
        System.out.println("**---Executed after each test method in this class---**");
        heroAircraft = null;
    }
    @Test
    @DisplayName("Test crash method")
    void crash() {
        System.out.println("**---Test crash method executed---**");
        assertFalse(heroAircraft.crash(fireProp));
    }
    @Test
    @DisplayName("Test increaseHp method")
    void increaseHp() {
        System.out.println("**---Test increaseHp method executed---**");
        heroAircraft.increaseHp(30);
        assertEquals(10000,heroAircraft.getHp());
    }
}