package com.ohrim;

import com.ohrim.actions.MapInitializer;
import com.ohrim.actions.MoveAction;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class Simulation {


    private final MapInitializer initAction = new MapInitializer();
    private final MoveAction turnAction = new MoveAction();
    private final Renderer renderer = new Renderer();
    private Map map;
    private boolean isGameStopped = false;

    public void nextTurn() {
        turnAction.executeCreatureMoves(map);
        turnAction.renderMap(map);
        System.out.println(" ");

    }

    public void startSimulation() throws InterruptedException {
        map = initAction.initializeMap();

        while (!isGameStopped) {
            nextTurn();
            TimeUnit.SECONDS.sleep(2);
        }
    }






}
