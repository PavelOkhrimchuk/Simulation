package com.ohrim.actions;

import com.ohrim.Coordinates;
import com.ohrim.Map;
import com.ohrim.entities.creatures.Creature;

public class MoveAction extends Action{


    public void executeCreatureMoves(Map map) {
        for (int row = 0; row < map.getHeight(); row++) {
            for (int col = 0; col < map.getWidth(); col++) {
                Coordinates coordinates = new Coordinates(row, col);
                if (!map.isCellEmpty(coordinates) && map.getEntity(coordinates) instanceof Creature) {
                    ((Creature) map.getEntity(coordinates)).makeMove();
                }
            }
        }
    }

}

