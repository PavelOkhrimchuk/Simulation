package com.ohrim;

import com.ohrim.entities.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Map {
    private int width;
    private int height;

    private Entity[][] field;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.field = new Entity[width][height];

    }

    public Map() {
        this(30, 30);
    }

    public void addEntity(Entity entity) {
        Coordinates coordinates = entity.getCoordinates();
        if (isWithinBounds(coordinates) && field[coordinates.getX()][coordinates.getY()] == null) {
            field[coordinates.getX()][coordinates.getY()] = entity;
        } else {
            System.out.println("Invalid position or cell already occupied");
        }
    }

    public void updateField() {
        for (Entity[] entities : field) {
            for (Entity entity : entities) {
                field[entity.getCoordinates().getX()][entity.getCoordinates().getY()] = entity;
            }
        }
    }

    private boolean isWithinBounds(Coordinates coordinates) {
        return coordinates.getX() >= 0 && coordinates.getX() < width
                && coordinates.getY() >= 0 && coordinates.getY() < height;
    }


}
