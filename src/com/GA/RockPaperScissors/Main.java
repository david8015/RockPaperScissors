package com.GA.RockPaperScissors;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void generateMenu() {
        System.out.println("~~~~~~~~~~~~~~~ WELCOME TO ROCK, PAPER, SCISSORS ~~~~~~~~\n");
        System.out.println("what would you like to do (1-4)? \n 1. play against computer  \n 2. 2 player game \n 3. view game history \n 4. Exit");
    }

    public static void main(String[] args) {
        List<Game> gameList = new ArrayList<>(); // create a list of games

        int count = 1; //increase the game count

        int s = 0;

        while (s != 4) {
            generateMenu(); //generate initial menu
            Game game = new Game(); //start a new game
            Player player1 = new Player(); //generate player1
            player1.setName("player1"); //set name as default

            Player player2 = new Player(); //generate player2
            player2.setName("player2"); //set name as default



            s = player1.getUserMainChoice(); //get user choice


            if (s == 1 || s == 2) {
                player1 = player1.getPlayerName(player1); //get player1 username
                player1 = player1.getUserMove(player1); // get player1 move

                if (s == 1) {
                    player2.setName("computer"); //set player 2 name to computer
                    player2 = player2.generateComputerChoice(player2); //get computer choice

                }

                if (s == 2) {
                    player2 = player2.getPlayerName(player2); //player2 username
                    player2 = player2.getUserMove(player2); //player2 move

                }

                game = game.checkWinner(player1, player2, game); //check winner

                game.setGameNumber(count); //set the count

                game.setPlayerOne(player1); //add player1 to game object
                game.setPlayerTwo(player2); //add player2 to game object

                gameList.add(game); //add game to list of games

                count++; //increase game count;

            }

//            print game history
            if (s == 3) {
                game.printGameHistory(gameList);

            }

            if (s == 4) {
                System.out.println("thanks for playing goodbye...");
            }
        }
    }
}