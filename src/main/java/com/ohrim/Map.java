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
        this(5, 5);
    }





    public void addEntity(Entity entity) {
        Coordinates coordinates = entity.getCoordinates();
        field[coordinates.getX()][coordinates.getY()] = entity;

    }

    public void updateField() {
        for (Entity[] entities : field) {
            for (Entity entity : entities) {
                field[entity.getCoordinates().getX()][entity.getCoordinates().getY()] = entity;
            }
        }
    }



}
