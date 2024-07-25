package com.ohrim;

import com.ohrim.entities.Entity;

import java.util.*;

public class BreadthFirstSearch {
    private final Simulation simulation = AppRunner.simulation;
    private final List<Coordinates> queuedCoordinates = new ArrayList<>();
    private final List<Coordinates> exploredCoordinates = new ArrayList<>();
    private final HashMap<Coordinates, Coordinates> childParentMap = new HashMap<>();
    private Entity[][] field;
    private Entity targetEntity;

    public List<Coordinates> findClosestObjectCoordinates(Coordinates currentCoordinates, Entity targetEntity) {

    }

    private Optional<Coordinates> exploreQueuedCoordinates() {


    }


    private void enqueueNeighbors() {
    }

    private void enqueueNeighbors(Coordinates coordinates) {

    }




    private List<Coordinates> findPathToTarget(Coordinates targetCoordinates) {

    }




}
