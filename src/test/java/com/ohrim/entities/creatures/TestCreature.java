package com.ohrim.entities.creatures;

import com.ohrim.Coordinates;
import com.ohrim.Simulation;
import com.ohrim.entities.Entity;

public class TestCreature extends Creature{

    private Entity target;

    public TestCreature(Simulation simulation, Entity target) {
        super(simulation);
        this.target = target;
    }

    @Override
    protected Entity findTarget() {
        return target;
    }

    @Override
    protected void interactWithTarget(Coordinates targetCoordinates) {
        // Simple interaction for testing
    }
}
