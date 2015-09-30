/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.battle.controller;

import fr.epsi.battle.model.Card;
import fr.epsi.battle.model.Color;
import fr.epsi.battle.model.Player;
import fr.epsi.battle.model.Symbol;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Alexandre
 */
public class GameController
{
    private LinkedList<Player> players;
    private LinkedList<Card> cards;

    /**
     * Default constructor
     */
    public GameController()
    {
        this.players = new LinkedList<>();
        this.cards = new LinkedList<>();

        for (int i = 2; i < 15; i++) {
            this.cards.add(new Card(i, Color.RED, Symbol.HEART));
            this.cards.add(new Card(i, Color.RED, Symbol.TILE));
            this.cards.add(new Card(i, Color.BLACK, Symbol.PIKE));
            this.cards.add(new Card(i, Color.BLACK, Symbol.CLOVER));
        }
    }

    /**
     * Add a player to the game
     *
     * @param name
     */
    public void createPlayer(String name)
    {
        this.players.add(new Player(name));
    }

    /**
     * Start the game and distribute cards
     */
    public void Start()
    {
        if (this.players.size() < 2) {
            System.out.println("Game must have more than 1 player.");
            return;
        }

        int index = 0;
        Random rn = new Random();

        while (this.cards.size() > 0) {
            Card card = this.cards.get(rn.nextInt(this.cards.size()));
            this.players.get(index).addCard(card);
            this.cards.remove(card);

            index = (index + 1) % this.players.size();
        }

        while (this.players.size() > 1) {
            RoundController roundController = new RoundController(this.players);
            roundController.startRound();
        }
    }
}
