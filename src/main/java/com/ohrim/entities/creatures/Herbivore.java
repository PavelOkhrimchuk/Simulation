package com.ohrim.entities.creatures;

import com.ohrim.Coordinates;
import com.ohrim.Simulation;
import com.ohrim.constants.EmojiConstants;
import com.ohrim.entities.Entity;
import com.ohrim.entities.Grass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Herbivore extends Creature {

    public Herbivore(Simulation simulation) {
        super(simulation);
    }

    @Override
    protected Entity findTarget() {
        return new Grass();
    }

    @Override
    protected void interactWithTarget(Coordinates targetCoordinates) {
        simulation.getMap().removeEntity(targetCoordinates);
    }

    @Override
    public String toString() {
        return EmojiConstants.HERBIVORE;
    }


}
