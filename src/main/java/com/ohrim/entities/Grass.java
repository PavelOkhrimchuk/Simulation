package com.ohrim.entities;

import com.ohrim.Coordinates;
import com.ohrim.constants.EmojiConstants;

public class Grass extends Entity{
    public Grass(Coordinates coordinates) {
        this.coordinates = coordinates;

    }

    public Grass() {
        this.coordinates = new Coordinates();
    }

    @Override
    public String toString() {
        return EmojiConstants.GRASS;
    }
}
