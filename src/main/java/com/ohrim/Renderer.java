package com.ohrim;

import com.ohrim.entities.Entity;

public class Renderer {
    public void render(Map mapObj) {
        Entity[][] map = mapObj.getField();
        for (Entity[] entityRow : map) {
            for (Entity entity : entityRow) {
                System.out.print(entity.toString() + " ");
            }
            System.out.println();
        }


    }
}
