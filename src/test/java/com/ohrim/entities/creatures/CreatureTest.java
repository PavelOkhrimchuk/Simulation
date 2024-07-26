package com.ohrim.entities.creatures;

import com.ohrim.Coordinates;
import com.ohrim.Map;
import com.ohrim.Simulation;
import com.ohrim.entities.Grass;
import com.ohrim.entities.objects.Rock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreatureTest {

    private Simulation simulation;
    private Map map;
    private TestCreature testCreature;

    @BeforeEach
    void setUp() {
        simulation = new Simulation();
        map = new Map(5, 5);
        simulation.setMap(map);

        Coordinates start = new Coordinates(0, 0);
        Grass grass = new Grass(new Coordinates(2, 2));
        map.placeEntity(grass, new Coordinates(2, 2));
        testCreature = new TestCreature(simulation, grass);
        testCreature.setCoordinates(start);
        map.placeEntity(testCreature, start);
    }

    @Test
    void testMakeMoveTowardsTarget() {

        testCreature.makeMove();


        Coordinates newCoordinates = testCreature.getCoordinates();
        assertNotEquals(new Coordinates(0, 0), newCoordinates, "Creature should have moved");
    }

    @Test
    void testMakeMoveWithObstacle() {

        map.placeEntity(new Rock(new Coordinates(1, 0)), new Coordinates(1, 0));
        map.placeEntity(new Rock(new Coordinates(0, 1)), new Coordinates(0, 1));


        testCreature.makeMove();


        Coordinates newCoordinates = testCreature.getCoordinates();
        assertTrue(Arrays.asList(new Coordinates(1, 1), new Coordinates(2, 0), new Coordinates(0, 2)).contains(newCoordinates), "Creature should have moved around obstacles");
    }



}