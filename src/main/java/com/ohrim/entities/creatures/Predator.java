package com.ohrim.entities.creatures;

import com.ohrim.Coordinates;
import com.ohrim.Simulation;
import com.ohrim.constants.EmojiConstants;
import com.ohrim.entities.Entity;

public class Predator extends Creature {

    int attack = 5;

    public Predator(Simulation simulation) {
        super(simulation);
    }

    @Override
    protected Entity findTarget() {
        return new Herbivore(simulation);
    }

    @Override
    protected void interactWithTarget(Coordinates targetCoordinates) {
        Herbivore herbivore = (Herbivore) simulation.getMap().getEntity(targetCoordinates);
        int herbivoreHp = herbivore.getHp();
        herbivore.setHp(herbivoreHp - attack);

        if (herbivore.getHp() <= 0) {
            simulation.getMap().removeEntity(targetCoordinates);
        }
    }

    @Override
    public String toString() {
        return EmojiConstants.PREDATOR;
    }
}
