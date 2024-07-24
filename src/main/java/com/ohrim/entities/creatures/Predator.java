package com.ohrim.entities.creatures;

import com.ohrim.constants.EmojiConstants;

public class Predator extends Creature {
    int attack = 2;

    @Override
    public void makeMove() {

    }

    @Override
    public String toString() {
        return EmojiConstants.PREDATOR;
    }
}
