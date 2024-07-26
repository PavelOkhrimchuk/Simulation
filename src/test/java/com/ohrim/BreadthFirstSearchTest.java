package com.ohrim;


import com.ohrim.entities.Grass;
import com.ohrim.entities.objects.Rock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BreadthFirstSearchTest{


    private Simulation simulation;
    private Map map;
    private BreadthFirstSearch bfs;

    @BeforeEach
    void setUp() {
        simulation = new Simulation();
        map = new Map(5, 5);
        simulation.setMap(map);
        bfs = new BreadthFirstSearch(simulation);
    }

    @Test
    void testFindClosestObjectCoordinates() {

        Coordinates start = new Coordinates(0, 0);
        Coordinates target = new Coordinates(2, 2);
        Grass grass = new Grass(target);
        map.placeEntity(grass, target);


        List<Coordinates> path = bfs.findClosestObjectCoordinates(start, new Grass());


        assertFalse(path.isEmpty(), "Path should not be empty when target is present");
        assertEquals(target, path.get(path.size() - 1), "Last coordinate in path should be the target's coordinates");
    }


    @Test
    void testFindClosestObjectWithObstacles() {

        Coordinates start = new Coordinates(0, 0);
        Coordinates target = new Coordinates(2, 2);
        Grass grass = new Grass(target);
        map.placeEntity(grass, target);


        List<Coordinates> obstacles = Arrays.asList(
                new Coordinates(1, 0),
                new Coordinates(0, 1)
        );

        obstacles.forEach(coords -> map.placeEntity(new Rock(coords), coords));


        List<Coordinates> path = bfs.findClosestObjectCoordinates(start, new Grass());


        assertFalse(path.isEmpty(), "Path should not be empty when target is present");
        assertEquals(target, path.get(path.size() - 1), "Last coordinate in path should be the target's coordinates");
        assertTrue(path.contains(new Coordinates(1, 1)), "Path should go around obstacles");
    }


    @Test
    void testPathDoesNotCrossObstacles() {

        Coordinates start = new Coordinates(0, 0);
        Coordinates target = new Coordinates(4, 4);
        Grass grass = new Grass(target);
        map.placeEntity(grass, target);

        List<Coordinates> obstacles = Arrays.asList(
                new Coordinates(1, 1),
                new Coordinates(2, 2),
                new Coordinates(3, 3)
        );

        obstacles.forEach(coords -> map.placeEntity(new Rock(coords), coords));


        List<Coordinates> path = bfs.findClosestObjectCoordinates(start, new Grass());

        assertFalse(path.isEmpty(), "Path should not be empty when target is present");
        assertEquals(target, path.get(path.size() - 1), "Last coordinate in path should be the target's coordinates");
        assertFalse(path.containsAll(obstacles), "Path should not contain any obstacles");
    }



}