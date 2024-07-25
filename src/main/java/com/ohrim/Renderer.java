package com.ohrim;

import com.ohrim.constants.EmojiConstants;
import com.ohrim.entities.Entity;

public class Renderer {
    public void render(Map mapObj) {
        for (int row = 0; row < mapObj.getHeight(); row++) {
            for (int col = 0; col < mapObj.getWidth(); col++) {
                Coordinates coordinates = new Coordinates(row, col);
                if (!mapObj.isCellEmpty(coordinates)) {
                    Entity entity = mapObj.getEntity(coordinates);
                    System.out.print(entity.toString() + " ");
                } else {
                    System.out.print(EmojiConstants.GROUND);
                }
            }
            System.out.println();
        }


    }
}
