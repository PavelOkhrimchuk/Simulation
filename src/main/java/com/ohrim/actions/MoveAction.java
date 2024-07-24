package com.ohrim.actions;

import com.ohrim.Map;
import com.ohrim.entities.Entity;
import com.ohrim.entities.creatures.Creature;

public class MoveAction extends Action{
    @Override
    public void execute() {

    }

    public void executeCreatureMoves(Map mapObject) {
        Entity[][] map = mapObject.getField();

        for (Entity[] entities : map) {
            for (Entity entity : entities) {
                if (entity instanceof Creature creature) {
                    creature.makeMove();
                }
            }
        }
    }

    public void renderMap(Map map) {

    }
}

