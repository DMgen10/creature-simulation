package org.simulation.action;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpawnConfig {

    private final int predatorPercent;
    private final int herbivorePercent;
    private final int treePercent;
    private final int grassPercent;
    private final int rockPercent;

    public SpawnConfig(int predatorPercent, int herbivorePercent, int treePercent, int grassPercent, int rockPercent) {
        Map<String, Integer> input = new LinkedHashMap<>();
        input.put("predator", predatorPercent);
        input.put("herbivore", herbivorePercent);
        input.put("grass", grassPercent);
        input.put("tree", treePercent);
        input.put("rock", rockPercent);

        this.predatorPercent = predatorPercent;
        this.herbivorePercent = herbivorePercent;
        this.treePercent = treePercent;
        this.grassPercent = grassPercent;
        this.rockPercent = rockPercent;
    }


    private Map<String,Integer> calculationPercentage(Map<String,Integer> original){
        Map<String, Integer> result = new LinkedHashMap<>();

        int total = 0;
        for (String key : original.keySet()){
            total += original.get(key);
        }

        if (total <= 100){
            for (String key : original.keySet()){
                result.put(key, original.get(key));
            }
            return result;
        }

        int sum = 0;
        String lastKey = null;

        for (String key : original.keySet()){
            lastKey = key;
            double ratio = (double) original.get(key) / total;
            int adjusted = (int) Math.round(ratio * 100);
            result.put(key, adjusted);
            sum += adjusted;
        }

        int diff = 100 - sum;
        if (diff != 0 && lastKey != null) {
            result.put(lastKey, result.get(lastKey) + diff);
        }
        return result;
    }

    public int getPredatorPercent() {
        return predatorPercent;
    }

    public int getHerbivorePercent() {
        return herbivorePercent;
    }

    public int getTreePercent() {
        return treePercent;
    }

    public int getGrassPercent() {
        return grassPercent;
    }

    public int getRockPercent() {
        return rockPercent;
    }
}
