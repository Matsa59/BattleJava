/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.battle.model;

import java.util.LinkedList;

/**
 *
 * @author Alexandre
 */
public class Player
{
    private LinkedList<Card> cards;
    private String name;

    /**
     * Default constructor : create a new player with name
     *
     * @param name
     */
    public Player(String name)
    {
        this.cards = new LinkedList<>();
        this.name = name;
    }

    /**
     * Add a card to player
     * This method is used to syncrhonized player and card
     *
     * @param card
     */
    public void addCard(Card card)
    {
        if (!this.cards.contains(card)) {
            this.cards.add(card);
        }

        if (card.getPlayer() != this) {
            card.setPlayer(this);
        }
    }

    /**
     * remove a card from player's card
     * This method is used to syncrhonized player and card
     */
    public void removeCard(Card card)
    {
        if (this.cards.remove(card)) {
            card.setPlayer(null);
        }
    }

    /**
     * return the next card to play
     *
     * @return
     */
    public Card getNextCard()
    {
        return this.cards.removeFirst();
    }

    /**
     * Player can play if he have more than 1 card
     * Return true if number of cards number > 0, false otherwise
     *
     * @return
     */
    public boolean canPlay()
    {
        return this.cards.size() > 0;
    }

    /**
     * Get the name of the current player
     *
     * @return
     */
    public String getName()
    {
        return this.name;
    }
}
