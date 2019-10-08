package com.GA.RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class Player implements PlayerInterface {
    private String name;
    private String move;

    public Player() {
    }

    public Player(String name, String move) {
        this.name = name;
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    @Override
    public Player getPlayerName(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getName() + " Enter your name: ");
        String name = scanner.next();

        player.setName(name);

        return player;

    }

    @Override
    public int getUserMainChoice() {
        int choice = 0;
        boolean validInput = false;

        Scanner scanner = new Scanner(System.in);

        while (!validInput) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice > 0 && choice < 5) {
                    validInput = true;
                } else {
                    System.out.println("number must be between 1 and 4");
                }
            } else {
                System.out.println("input must be a number");
                scanner.nextLine();
            }
        }
        return choice;
    }

    @Override
    public Player getUserMove(Player player) {
        System.out.println(player.getName() + " Type Rock, Paper or Scissors to play");

        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        String choice = "";

        while (!validInput) {
            if (scanner.hasNextLine()) {
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("rock") || choice.equalsIgnoreCase("paper") ||
                        choice.equalsIgnoreCase("scissors")) {
                    validInput = true;
                } else {
                    System.out.println("make a valid choice");
                }
            }
        }

        player.setMove(choice);
        return player;
    }

    @Override
    public Player generateComputerChoice(Player player) {
        String play = "";

//        generate random int 1-3
        Random ran = new Random();
        int random = ran.nextInt((3) + 1);

//         match random number to a choice
        switch (random) {
            case 1: {
                play = "Rock";
                break;
            }
            case 2: {
                play = "Paper";
                break;
            }
            default:
                play = "Scissors";
        }

        player.setMove(play);
        return player;
    }
}