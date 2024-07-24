package com.ohrim.entities;

import com.ohrim.Coordinates;
import com.ohrim.constants.EmojiConstants;

public class Tree extends Entity{


    public Tree(Coordinates coordinates) {
        this.coordinates = coordinates;

    }

    public Tree() {
        this.coordinates = new Coordinates();
    }

    @Override
    public String toString() {
        return EmojiConstants.TREE;
    }
}
