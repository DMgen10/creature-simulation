package org.simulation.core;

import java.util.Scanner;

public class SimulationConfigPrompt {

    private static final Scanner scanner = new Scanner(System.in);

    public static SimulationConfig promptUser(){

        int width = promptValidate("Enter map width:");
        int height = promptValidate("Enter map height:");
        int predatorHealth = promptValidate("Enter health predator:");
        int predatorSpeed = promptValidate("Enter speed predator:");
        int predatorAttack = promptValidate("Enter attack predator:");
        int herbivoreHealth = promptValidate("Enter health herbivore:");
        int herbivoreSpeed = promptValidate("Enter speed herbivore:");
        int grassNutrition = promptValidate("Enter nutrition grass:");

        return new SimulationConfig(width,
                                    height,
                                    predatorHealth,
                                    predatorSpeed,
                                    predatorAttack,
                                    herbivoreHealth,
                                    herbivoreSpeed,
                                    grassNutrition);
    }

    private static int promptValidate(String message){
        int value;

        while (true){
            System.out.println(message);
            String input = scanner.nextLine();

            try {
                value = Integer.parseInt(input.trim());

                if (value <= 0 ){
                    System.out.println("The number must be positive and greater than 0. Try again.\n");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter a positive integer. Example: 10\n");
            }
        }
    }
}
