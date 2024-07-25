package com.ohrim.entities.creatures;

import com.ohrim.BreadthFirstSearch;
import com.ohrim.Coordinates;
import com.ohrim.constants.EmojiConstants;

import java.util.List;

import static com.ohrim.AppRunner.simulation;

public class Predator extends Creature {

    int attack = 5;
    private BreadthFirstSearch breadthFirstSearch;

    @Override
    public void makeMove() {
        breadthFirstSearch = new BreadthFirstSearch();
        List<Coordinates> pathToHerbivore = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), new Herbivore());

        if (pathToHerbivore.size() == 1) {
            attackHerbivore(pathToHerbivore);
        } else {
            moveTowardsHerbivore(pathToHerbivore);
        }
    }

    private void moveTowardsHerbivore(List<Coordinates> pathToHerbivore) {
        Coordinates currentCoordinates = this.getCoordinates();
        Coordinates newCoordinates = pathToHerbivore.get(0);

        if (simulation.getMap().getEntity(newCoordinates) instanceof Creature) {
            newCoordinates = currentCoordinates;
        }

        simulation.getMap().moveEntity(currentCoordinates, newCoordinates);
        this.setCoordinates(newCoordinates);
    }

    private void attackHerbivore(List<Coordinates> pathToHerbivore) {
        Coordinates coordinatesOfHerbivore = pathToHerbivore.get(0);
        Herbivore herbivore = (Herbivore) simulation.getMap().getEntity(coordinatesOfHerbivore);
        int herbivoreHp = herbivore.getHp();
        herbivore.setHp(herbivoreHp - attack);

        if (herbivore.getHp() <= 0) {
            simulation.getMap().removeEntity(coordinatesOfHerbivore);
        }
    }

    @Override
    public String toString() {
        return EmojiConstants.PREDATOR;
    }
}
