package com.ohrim;

import com.ohrim.actions.MapInitializer;
import com.ohrim.actions.MoveAction;
import lombok.Getter;

@Getter
public class Simulation {


    private final Renderer renderer = new Renderer();

    private final MapInitializer mapInitializer = new MapInitializer();
    private final MoveAction moveAction = new MoveAction();
    private int moveCounter = 0;
    private Map map;


    public void nextTurn() {

    }
    public void startSimulation() {

    }

    public void pauseSimulation() {

    }


}
