package com.ohrim;

import com.ohrim.entities.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter

public class Map {
    private int width;
    private int height;
    private HashMap<Coordinates, Entity> cells;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new HashMap<>();
    }

    public Map() {
        this(5, 5);
    }

    public void placeEntity(Entity entity, Coordinates coordinates) {
        entity.setCoordinates(coordinates);
        cells.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return cells.get(coordinates);
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return !cells.containsKey(coordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        cells.remove(coordinates);
    }

    public void moveEntity(Coordinates from, Coordinates to) {
        Entity entity = getEntity(from);
        removeEntity(from);
        placeEntity(entity, to);
    }



}
