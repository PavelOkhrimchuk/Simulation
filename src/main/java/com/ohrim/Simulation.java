package com.ohrim;

import com.ohrim.actions.MapInitializer;
import com.ohrim.actions.MoveAction;
import com.ohrim.entities.Grass;
import com.ohrim.entities.creatures.Herbivore;
import com.ohrim.entities.creatures.Predator;
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
        checkSimulationOver();
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

    private void checkSimulationOver() {
        boolean hasHerbivores = map.getCells().values().stream().anyMatch(entity -> entity instanceof Herbivore);
        boolean hasGrass = map.getCells().values().stream().anyMatch(entity -> entity instanceof Grass);
        boolean hasPredators = map.getCells().values().stream().anyMatch(entity -> entity instanceof Predator);

        // Simulation is over if:
        // 1. No herbivores left, meaning predators have eaten all herbivores or there were no herbivores at the start
        // 2. No grass left, meaning herbivores have eaten all grass
        // 3. No predators and no herbivores left, meaning either scenario can cause the end
        if (!hasHerbivores || !hasGrass || (!hasHerbivores && !hasPredators)) {
            pauseSimulation();
        }
    }






}
