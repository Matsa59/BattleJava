/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.battle.model;

/**
 *
 * @author Alexandre
 */
public class Card
{
    private Color color;
    private Symbol symbol;
    private int number;
    private String name;
    private Player player;

    /**
     * Default constructor : Create a new card
     *
     * @param number
     * @param color
     * @param symbol
     */
    public Card(int number, Color color, Symbol symbol)
    {
        this.color = color;
        this.symbol = symbol;
        this.number = number;

        switch (number)
        {
            case 11:
                this.name = "Vallet";
                break;
            case 12:
                this.name = "Lady";
                break;
            case 13:
                this.name = "King";
                break;
            case 14:
                this.name = "AS";
                break;
            default:
                this.name = Integer.toString(number);
                break;
        }
    }

    /**
     * return the player who have this card
     */
    public Player getPlayer()
    {
        return this.player;
    }

    /**
     * Change the player who have this card
     * This method is used to syncrhonized player and card
     *
     * @param player
     */
    public void setPlayer(Player player)
    {
        Player tempo = this.player;
        this.player = player;

        if (tempo != null) {
            tempo.removeCard(this);
        }

        if (this.player != null) {
            this.player.addCard(this);
        }
    }

    /**
     * Return number
     *
     * @return
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * Override the toString method
     *
     * @return
     */
    @Override
    public String toString()
    {
        return this.name + " " + this.symbol + " (" + this.color + ")";
    }
}
