package com.ohrim.actions;

import com.ohrim.Coordinates;
import com.ohrim.Map;
import com.ohrim.Simulation;
import com.ohrim.entities.Grass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveActionTest {

    private Map map;
    private MoveAction moveAction;
    private Simulation simulation;

    @BeforeEach
    void setUp() {
        map = new Map(5, 5);
        moveAction = new MoveAction();
        simulation = new Simulation();
    }


    @Test
    void testNoMoveForNonCreatureEntities() {

        Coordinates start = new Coordinates(2, 2);
        Grass grass = new Grass(start);
        map.placeEntity(grass, start);


        moveAction.executeCreatureMoves(map);


        assertEquals(start, grass.getCoordinates(), "Non-creature entities should not move");
    }








}