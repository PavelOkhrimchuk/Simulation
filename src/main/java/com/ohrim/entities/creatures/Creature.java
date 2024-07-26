package com.ohrim.entities.creatures;

import com.ohrim.BreadthFirstSearch;
import com.ohrim.Coordinates;
import com.ohrim.Simulation;
import com.ohrim.entities.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Creature extends Entity {
    protected BreadthFirstSearch breadthFirstSearch;
    protected Simulation simulation;

    int hp = 5;
    int speed = 1;

    public Creature(Simulation simulation) {
        this.simulation = simulation;
    }

    public void makeMove() {
        breadthFirstSearch = new BreadthFirstSearch(simulation);
        List<Coordinates> pathToTarget = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), findTarget());

        if (pathToTarget.size() == 1) {
            interactWithTarget(pathToTarget.get(0));
        } else {
            moveTowardsTarget(pathToTarget);
        }
    }

    protected abstract Entity findTarget();

    protected abstract void interactWithTarget(Coordinates targetCoordinates);

    protected void moveTowardsTarget(List<Coordinates> pathToTarget) {
        Coordinates currentCoordinates = this.getCoordinates();
        Coordinates newCoordinates = pathToTarget.get(0);

        if (simulation.getMap().getEntity(newCoordinates) instanceof Creature) {
            newCoordinates = currentCoordinates;
        }

        simulation.getMap().moveEntity(currentCoordinates, newCoordinates);
        this.setCoordinates(newCoordinates);
    }

}
