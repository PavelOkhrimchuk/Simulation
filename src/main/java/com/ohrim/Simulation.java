package com.ohrim;

import com.ohrim.actions.MapInitializer;
import com.ohrim.actions.MoveAction;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class Simulation {





    private final Renderer renderer = new Renderer();
    private final MapInitializer mapInitializer;
    private final MoveAction moveAction = new MoveAction();

    private Map map;
    private boolean isGameStopped = false;

    public Simulation() {
        this.mapInitializer = new MapInitializer(this);
    }

    public void nextTurn() {
        moveAction.executeCreatureMoves(map);
        renderer.render(map);
        System.out.println(" ");
    }

    public void startSimulation() throws InterruptedException {
        map = mapInitializer.initializeMap();

        while (!isGameStopped) {
            nextTurn();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void pauseSimulation() {
        isGameStopped = true;
    }






}
