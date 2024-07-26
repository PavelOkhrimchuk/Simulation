package com.ohrim;


import com.ohrim.entities.Grass;
import com.ohrim.entities.objects.Rock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest  {


    private Map map;

    @BeforeEach
    void setUp() {
        map = new Map(5, 5);
    }

    @Test
    void testPlaceEntity() {

        Coordinates coordinates = new Coordinates(0, 0);
        Grass grass = new Grass(coordinates);

        map.placeEntity(grass, coordinates);

        assertEquals(grass, map.getEntity(coordinates), "Entity should be placed at the given coordinates");
    }

    @Test
    void testIsCellEmpty() {
        // given
        Coordinates coordinates = new Coordinates(0, 0);
        Grass grass = new Grass(coordinates);
        map.placeEntity(grass, coordinates);

        // when & then
        assertFalse(map.isCellEmpty(coordinates), "Cell should not be empty when an entity is placed");
        assertTrue(map.isCellEmpty(new Coordinates(1, 1)), "Cell should be empty if no entity is placed");
    }

    @Test
    void testRemoveEntity() {
        Coordinates coordinates = new Coordinates(0,0);
        Grass grass = new Grass(coordinates);
        map.placeEntity(grass,coordinates);

        map.removeEntity(coordinates);

        assertNull(map.getEntity(coordinates), "Entity should be removed from the given coordinates");
        assertTrue(map.isCellEmpty(coordinates), "Cell should be empty after entity is removed");
    }

    @Test
    void checkMoveEntity() {
        Coordinates from = new Coordinates(0,0);
        Coordinates to = new Coordinates(1,1);
        Rock rock  = new Rock();
        map.placeEntity(rock,from);


        map.moveEntity(from,to);

        assertNull(map.getEntity(from), "Entity should be removed from the original coordinates");
        assertEquals(rock, map.getEntity(to), "Entity should be moved to the new coordinates");


    }




}