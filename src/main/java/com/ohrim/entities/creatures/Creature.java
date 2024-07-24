package com.ohrim.entities.creatures;

import com.ohrim.entities.Entity;

public abstract class Creature extends Entity {

    int hp = 5;
    int speed = 1;
    public abstract void makeMove();

}
