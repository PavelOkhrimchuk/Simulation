package com.ohrim.actions;

import com.ohrim.Coordinates;
import com.ohrim.Map;
import com.ohrim.Simulation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapInitializerTest {

    private Simulation simulation;
    private MapInitializer mapInitializer;

    @BeforeEach
    void setUp() {
        simulation = new Simulation();
        mapInitializer = new MapInitializer(simulation);
    }

    @Test
    void testInitializeMapNotNull() {
        // When
        Map map = mapInitializer.initializeMap();

        // Then
        assertNotNull(map, "Initialized map should not be null");
    }

    @Test
    void testMapHasEntities() {

        Map map = mapInitializer.initializeMap();


        boolean hasEntities = false;
        for (int row = 0; row < map.getHeight(); row++) {
            for (int col = 0; col < map.getWidth(); col++) {
                if (!map.isCellEmpty(new Coordinates(row, col))) {
                    hasEntities = true;
                    break;
                }
            }
            if (hasEntities) break;
        }

        assertTrue(hasEntities, "Initialized map should have entities placed on it");
    }

}