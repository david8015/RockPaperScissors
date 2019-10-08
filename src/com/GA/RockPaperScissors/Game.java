package com.GA.RockPaperScissors;

import java.util.List;

public class Game implements GameInterface {
    private int gameNumber;
    private Player playerOne;
    private Player playerTwo;
    private String winner;

    public Game() {
    }

    public Game(int gameNumber, Player playerOne, Player playerTwo, String winner) {
        this.gameNumber = gameNumber;
        this.playerTwo = playerTwo;
        this.winner = winner;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }


    public Game checkWinner(Player player1, Player player2, Game game) {

        if (player1.getMove().equalsIgnoreCase(player2.getMove())){
            game.winner = "tie";
        }

        else if((player1.getMove().equalsIgnoreCase("rock") && player2.getMove().equalsIgnoreCase("scissors"))
                || (player1.getMove().equalsIgnoreCase("paper") && player2.getMove().equalsIgnoreCase("rock"))
                || (player1.getMove().equalsIgnoreCase("scissors")) && player2.getMove().equalsIgnoreCase("paper")){
            game.winner = player1.getName();
        }

        else {
            game.winner = player2.getName();
        }

        if (game.winner.equals("tie")){
            System.out.println(player1.getName() + " chose " + player1.getMove() + "\n" +
                    player2.getName() + " chose " + player2.getMove() + "\n" +
                    "the game resulted in a " + game.winner);

        }

        else {
            System.out.println(player1.getName() + " chose " + player1.getMove() + "\n" +
                    player2.getName() + " chose " + player2.getMove() + "\n" +
                    "the winner is " + game.winner);
        }
        return game;
    }

    @Override
    public void printGameHistory(List<Game> gameList) {
        //check if any games have been played
        if (gameList.isEmpty()) {
            System.out.println("No games played yet");
        } else {
            gameList.forEach(game -> {
                System.out.println("game number " + game.getGameNumber() + "\n" + game.getPlayerOne().getName() +
                        " chose " + game.getPlayerOne().getMove() + "\n" + game.getPlayerTwo().getName() + " chose " +
                        game.getPlayerTwo().getMove() + "\n" + "result: " + game.getWinner() + "\n"
                );
            });
        }
    }
}
