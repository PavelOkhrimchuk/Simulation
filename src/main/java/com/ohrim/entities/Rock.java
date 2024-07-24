package com.ohrim.entities;

import com.ohrim.Coordinates;
import com.ohrim.constants.EmojiConstants;

public class Rock extends Entity{

    public Rock(Coordinates coordinates) {
        this.coordinates = coordinates;

    }

    public Rock() {
        this.coordinates = new Coordinates();
    }

    @Override
    public String toString() {
        return EmojiConstants.ROCK;
    }
}
