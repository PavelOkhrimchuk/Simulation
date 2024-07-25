package com.ohrim.entities.creatures;

import com.ohrim.BreadthFirstSearch;
import com.ohrim.Coordinates;
import com.ohrim.constants.EmojiConstants;
import com.ohrim.entities.Entity;
import com.ohrim.entities.Grass;
import com.ohrim.entities.Ground;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.ohrim.AppRunner.simulation;

@Getter
@Setter
public class Herbivore extends Creature {
    private BreadthFirstSearch breadthFirstSearch;

    public static void consumeGrass (List<Coordinates> pathToGrass) {
        Coordinates grassCoordinates = pathToGrass.get(0);
        Entity[][] field = simulation.getMap().getField();
        field[grassCoordinates.getX()][grassCoordinates.getY()] = new Ground(grassCoordinates);
    }



    @Override
    public void makeMove() {
        breadthFirstSearch = new BreadthFirstSearch();
        List<Coordinates> pathToGrass = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), new Grass());

        if(pathToGrass.size() == 1) {
            consumeGrass(pathToGrass);
        }
        else {
            moveTowardsGrass(pathToGrass);
        }


    }

    private void moveTowardsGrass(List<Coordinates> pathToGrass) {
        Entity[][] map = simulation.getMap().getField();
        map[coordinates.getX()][coordinates.getY()] = new Ground(new Coordinates(coordinates.getX(), coordinates.getY()));

        Coordinates coordinatesToMove = pathToGrass.get(0);

        if (map[coordinatesToMove.getX()][coordinatesToMove.getY()] instanceof Creature) {
            coordinatesToMove = coordinates;
        }

        this.setCoordinates(coordinatesToMove);
        simulation.getMap().addEntity(this);
    }

    @Override
    public String toString() {
        return EmojiConstants.HERBIVORE;
    }


}
