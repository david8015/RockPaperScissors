package com.GA.RockPaperScissors;

public interface PlayerInterface {
//    double calculateWinPercentage(double wins, double totalGames);

    Player getPlayerName(Player player);

    int getUserMainChoice();

    Player generateComputerChoice(Player player);

    Player getUserMove(Player player);
}
