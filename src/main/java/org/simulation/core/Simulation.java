package org.simulation.core;

import org.simulation.action.*;
import org.simulation.render.Renderer;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final Renderer renderer;
    private final SpawnConfig spawnConfig;
    private final SimulationConfig config;
    private final Board board;

    private final List<InitAction> initActions = new ArrayList<>();

    public Simulation() {
        this.config = SimulationConfigPrompt.promptUser();
        this.spawnConfig = new SpawnConfig(15,15,15,10,10);
        this.board = new Board(config.getWidth(), config.getHeight());
        this.renderer = new Renderer();
    }

    public void run(){

        setupInitActions();

        for (InitAction action : initActions){
            action.execute();
        }

        renderer.render(board);

    }

    private void setupInitActions() {
        initActions.add(new SpawnPredators(board, config));
        initActions.add(new SpawnHerbivores(board, config));
        initActions.add(new SpawnGrass(board, config));
        initActions.add(new SpawnTree(board, config));
        initActions.add(new SpawnRock(board, config));
    }




    public void addInitAction(InitAction action){
        initActions.add(action);
    }

    public SimulationConfig getConfig() {
        return config;
    }

    public Board getBoard() {
        return board;
    }
}
