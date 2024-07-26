package com.ohrim.entities.objects;

import com.ohrim.Coordinates;
import com.ohrim.constants.EmojiConstants;

public class Tree extends StaticObject {


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
