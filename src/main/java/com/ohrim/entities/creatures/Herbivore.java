package com.ohrim.entities.creatures;

import com.ohrim.BreadthFirstSearch;
import com.ohrim.Coordinates;
import com.ohrim.constants.EmojiConstants;
import com.ohrim.entities.Grass;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.ohrim.AppRunner.simulation;

@Getter
@Setter
public class Herbivore extends Creature {
    private BreadthFirstSearch breadthFirstSearch;



    @Override
    public void makeMove() {
        breadthFirstSearch = new BreadthFirstSearch();
        List<Coordinates> pathToGrass = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), new Grass());

        if (pathToGrass.size() == 1) {
            consumeGrass(pathToGrass);
        } else {
            moveTowardsGrass(pathToGrass);
        }
    }

    private void consumeGrass(List<Coordinates> pathToGrass) {
        Coordinates coordinatesOfGrass = pathToGrass.get(0);
        simulation.getMap().removeEntity(coordinatesOfGrass);
    }

    private void moveTowardsGrass(List<Coordinates> pathToGrass) {
        Coordinates currentCoordinates = this.getCoordinates();
        Coordinates newCoordinates = pathToGrass.get(0);

        if (simulation.getMap().getEntity(newCoordinates) instanceof Creature) {
            newCoordinates = currentCoordinates;
        }

        simulation.getMap().moveEntity(currentCoordinates, newCoordinates);
        this.setCoordinates(newCoordinates);
    }

    @Override
    public String toString() {
        return EmojiConstants.HERBIVORE;
    }


}
