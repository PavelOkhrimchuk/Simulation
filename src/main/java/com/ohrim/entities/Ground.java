package com.ohrim.entities;

import com.ohrim.Coordinates;
import com.ohrim.constants.EmojiConstants;

public class Ground extends Entity{

    public Ground(Coordinates coordinates) {
        this.coordinates = coordinates;

    }

    public Ground() {
        this.coordinates = new Coordinates();
    }

    @Override
    public String toString() {
       return EmojiConstants.GROUND;
    }
}
