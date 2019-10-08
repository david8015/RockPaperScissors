package com.GA.RockPaperScissors;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class PlayerTest {

    @Test
    public void getPlayerName() {
        Player player = new Player();

        player.setName("superman");
        String input = "superman";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals(player, player.getPlayerName(player));

        Assert.assertSame(player, player.getPlayerName(player));
//        all it's doing is comparing the references of the objects
    }

    @Test
    public void getUserMainChoice() {
        Player player = new Player();

        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals(2, player.getUserMainChoice());
    }

    @Test
    public void getUserMove() {

    }

    @Test
    public void generateComputerChoice() {
    }
}
