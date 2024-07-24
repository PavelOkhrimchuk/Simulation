package com.ohrim.actions;

import com.ohrim.Coordinates;
import com.ohrim.Map;
import com.ohrim.entities.*;
import com.ohrim.entities.creatures.Herbivore;
import com.ohrim.entities.creatures.Predator;

import java.util.HashMap;
import java.util.Random;

public class MapInitializer extends Action {

    private Map map;

    @Override
    public void execute() {
        initializeMap();

    }

    public Map initializeMap() {
        map = new Map();
        HashMap<Integer, Integer> pool = createEntityDistribution(map);

        for (int i = 0; i < pool.size(); i++) {
            int amountOfEntity = pool.get(i);

            for (int j = 0; j < amountOfEntity; j++) {
                Entity entity = null;
                switch (i) {
                    case 0 -> entity = new Grass();
                    case 1 -> entity = new Herbivore();
                    case 2 -> entity = new Predator();
                    case 3 -> entity = new Tree();
                    case 4 -> entity = new Rock();
                }
                if (entity != null) {
                    setRandomCoordinates(entity);
                    map.addEntity(entity);
                }
            }
        }

        for (int i = 0; i < map.getField().length; i++) {
            for (int j = 0; j < map.getField()[i].length; j++) {
                if (map.getField()[i][j] == null) {
                    Ground ground = new Ground(new Coordinates(i, j));
                    map.addEntity(ground);
                }
            }
        }

        return map;

    }


    private HashMap<Integer, Integer> createEntityDistribution(Map map) {
        HashMap<Integer, Integer> pool = new HashMap<>();
        int x = map.getField().length;
        int y = map.getField()[0].length;
        int area = x * y;

        int amountOfGrass = area / 2;
        pool.put(0, amountOfGrass);

        int amountOfHerbivores = amountOfGrass / 10;
        pool.put(1, amountOfHerbivores);

        int amountOfPredators = amountOfHerbivores / 5;
        pool.put(2, amountOfPredators);

        int amountOfTrees = amountOfGrass / 10;
        pool.put(3, amountOfTrees);

        int amountOfRocks = amountOfGrass / 10;
        pool.put(4, amountOfRocks);

        return pool;

    }

    private <T extends Entity> void setRandomCoordinates(Entity entity) {
        int xMax = map.getField().length;
        int yMax = map.getField()[0].length;

        Random random = new Random();

        int randomX = random.nextInt(xMax);
        int randomY = random.nextInt(yMax);
        Coordinates coordinates = new Coordinates(randomX, randomY);
        entity.setCoordinates(coordinates);
    }


}
