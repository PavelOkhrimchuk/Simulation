package com.ohrim.entities;

import com.ohrim.Coordinates;
import com.ohrim.StaticObject;
import com.ohrim.constants.EmojiConstants;

public class Rock extends StaticObject {

    public Rock(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Rock() {
        coordinates = new Coordinates();
    }

    @Override
    public String toString() {
        return EmojiConstants.ROCK;
    }
}
