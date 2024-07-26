package com.ohrim.entities.creatures;

import com.ohrim.BreadthFirstSearch;
import com.ohrim.Coordinates;
import com.ohrim.entities.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.ohrim.AppRunner.simulation;

@Getter
@Setter
public abstract class Creature extends Entity {
    protected BreadthFirstSearch breadthFirstSearch;

    int hp = 5;
    int speed = 1;
    public void makeMove() {
        breadthFirstSearch = new BreadthFirstSearch();
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
