package com.ohrim;

import com.ohrim.entities.Entity;
import com.ohrim.entities.Grass;
import com.ohrim.entities.Rock;

import java.util.*;

public class BreadthFirstSearch {
    private final Simulation simulation = AppRunner.simulation;
    private final List<Coordinates> queuedCoordinates = new ArrayList<>();
    private final List<Coordinates> exploredCoordinates = new ArrayList<>();
    private final HashMap<Coordinates, Coordinates> childParentMap = new HashMap<>();
    private Entity[][] field;
    private Entity targetEntity;

    public List<Coordinates> findClosestObjectCoordinates(Coordinates currentCoordinates, Entity targetEntity) {
        this.field = simulation.getMap().getField();
        this.targetEntity = targetEntity;

        queuedCoordinates.add(currentCoordinates);

        Optional<Coordinates> targetCoordinates = exploreQueuedCoordinates();

        while (!targetCoordinates.isPresent()) {
            targetCoordinates = exploreQueuedCoordinates();
        }

        return findPathToTarget(targetCoordinates.get());
    }

    private Optional<Coordinates> exploreQueuedCoordinates() {
        for (int i = 0; i < queuedCoordinates.size(); i++) {
            Coordinates coordinates = queuedCoordinates.get(i);
            Entity entity = field[coordinates.getX()][coordinates.getY()];
            if (entity.getClass().equals(targetEntity.getClass())) {
                return Optional.of(coordinates);
            }
            exploredCoordinates.add(coordinates);
        }

        queuedCoordinates.removeAll(exploredCoordinates);
        enqueueNeighbors();

        return Optional.empty();

    }


    private void enqueueNeighbors() {
        for (Coordinates coordinates : exploredCoordinates) {
            enqueueNeighbors(coordinates);
        }
    }

    private void enqueueNeighbors(Coordinates coordinates) {

        int startX = Math.max(coordinates.getX() - 1, 0);
        int endX = Math.min(coordinates.getX() + 1, field.length - 1);
        int startY = Math.max(coordinates.getY() - 1, 0);
        int endY = Math.min(coordinates.getY() + 1, field[0].length - 1);


        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                Coordinates neighbor = new Coordinates(x, y);
                Entity entity = field[neighbor.getX()][neighbor.getY()];

                if (!queuedCoordinates.contains(neighbor)
                        && !exploredCoordinates.contains(neighbor)
                        && !(entity instanceof Rock || entity instanceof Grass)) {
                    childParentMap.put(neighbor, coordinates);
                    queuedCoordinates.add(neighbor);
                }
            }
        }


    }


    private List<Coordinates> findPathToTarget(Coordinates targetCoordinates) {

        List<Coordinates> path = new ArrayList<>();

        while (childParentMap.containsKey(targetCoordinates)) {
            path.add(targetCoordinates);
            targetCoordinates = childParentMap.get(targetCoordinates);
        }

        Collections.reverse(path);
        return path;

    }


}
