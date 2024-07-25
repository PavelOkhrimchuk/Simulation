package com.ohrim.entities.creatures;

import com.ohrim.BreadthFirstSearch;
import com.ohrim.Coordinates;
import com.ohrim.constants.EmojiConstants;
import com.ohrim.entities.Entity;
import com.ohrim.entities.Ground;

import java.util.List;

import static com.ohrim.AppRunner.simulation;

public class Predator extends Creature {

    int attack = 2;
    BreadthFirstSearch breadthFirstSearch;

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

        Entity[][] map = simulation.getMap().getField();
        map[coordinates.getX()][coordinates.getY()] = new Ground(new Coordinates(coordinates.getX(), coordinates.getY()));

        Coordinates coordinatesToMove = pathToHerbivore.get(0);

        if (map[coordinatesToMove.getX()][coordinatesToMove.getY()] instanceof Creature) {
            coordinatesToMove = coordinates;
        }

        this.setCoordinates(coordinatesToMove);
        simulation.getMap().addEntity(this);
    }

    private void attackHerbivore(List<Coordinates> pathToHerbivore) {
        Coordinates coordinatesOfHerbivore = pathToHerbivore.get(0);
        Entity[][] map = simulation.getMap().getField();
        Herbivore herbivore = (Herbivore) map[coordinatesOfHerbivore.getX()][coordinatesOfHerbivore.getY()];
        int herbivoreHp = herbivore.getHp();
        herbivore.setHp(herbivoreHp - attack);

        if (herbivore.getHp() <= 0) {
            map[coordinatesOfHerbivore.getX()][coordinatesOfHerbivore.getY()] = new Ground(coordinatesOfHerbivore);
        }


    }


    @Override
    public String toString() {
        return EmojiConstants.PREDATOR;
    }
}
