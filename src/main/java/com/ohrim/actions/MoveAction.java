package com.ohrim.actions;

import com.ohrim.Map;
import com.ohrim.Renderer;
import com.ohrim.entities.Entity;
import com.ohrim.entities.creatures.Creature;

import static com.ohrim.AppRunner.simulation;

public class MoveAction extends Action{


    public void  executeCreatureMoves(Map mapObject) {
        Entity[][] map = mapObject.getField();

        for (Entity[] entities : map) {
            for (Entity entity : entities) {
                if (entity instanceof Creature creature) {
                    creature.makeMove();
                }
            }
        }

        mapObject.updateField();
    }

    public void renderMap(Map map) {
        Renderer renderer = simulation.getRenderer();
        renderer.render(map);
    }

}

