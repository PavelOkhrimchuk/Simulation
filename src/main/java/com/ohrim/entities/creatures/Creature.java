package com.ohrim.entities.creatures;

import com.ohrim.entities.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Creature extends Entity {

    int hp = 5;
    int speed = 1;
    public abstract void makeMove();

}
