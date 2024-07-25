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

    public Map initializeMap() {
        map = new Map();

        HashMap<Integer, Integer> pool = createEntityDistribution(map);

        for (int i = 0; i < pool.size(); i++) {
            int amountOfEntity = pool.get(i);

            for (int j = 0; j < amountOfEntity; j++) {
                Entity entity;
                if (i == 0) {
                    entity = new Grass();
                } else if (i == 1) {
                    entity = new Herbivore();
                } else if (i == 2) {
                    entity = new Predator();
                } else if (i == 3) {
                    entity = new Tree();
                } else if (i == 4) {
                    entity = new Rock();
                } else {
                    continue;
                }

                setRandomCoordinates(entity);
                map.placeEntity(entity, entity.getCoordinates());
            }
        }

        // Заполняем оставшиеся ячейки землей
        for (int row = 0; row < map.getWidth(); row++) {
            for (int col = 0; col < map.getHeight(); col++) {
                Coordinates coordinates = new Coordinates(row, col);
                if (map.isCellEmpty(coordinates)) {
                    Ground ground = new Ground(coordinates);
                    map.placeEntity(ground, coordinates);
                }
            }
        }

        return map;
    }

    private HashMap<Integer, Integer> createEntityDistribution(Map map) {
        HashMap<Integer, Integer> pool = new HashMap<>();
        int x = map.getWidth();
        int y = map.getHeight();
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

    private <T extends Entity> void setRandomCoordinates(T entity) {
        int xMax = map.getWidth();
        int yMax = map.getHeight();

        Random random = new Random();
        int randomX = random.nextInt(xMax);
        int randomY = random.nextInt(yMax);
        Coordinates coordinates = new Coordinates(randomX, randomY);
        entity.setCoordinates(coordinates);
    }

}
