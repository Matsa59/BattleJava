package fr.epsi.battle.controller;

import fr.epsi.battle.model.Card;
import fr.epsi.battle.model.Player;
import java.util.LinkedList;

/**
 *
 * @author Alexandre
 */
public class RoundController
{
    private LinkedList<Player> players;
    private LinkedList<Card> cards;
    private Card cardWin = null;

    /**
     * Default constructor
     *
     * @param players
     */
    public RoundController(LinkedList<Player> players)
    {
        this.players = players;
        this.cards = new LinkedList<>();
    }

    /**
     * Start the round
     * We add a +1 for finish the game (if winCard = 3 just card number > 4 can win)
     */
    public void startRound()
    {
        for(Player player : players) {
            Card card = player.getNextCard();
            System.out.println(player.getName() + " : " + card.toString());
            this.cards.add(card);

            if (this.cardWin == null) {
                this.cardWin = card;
            } else if (card.getNumber() > cardWin.getNumber() + 1){
                this.cardWin = card;
            }
        }

        this.endRound();
    }

    /**
     * The end of the round
     */
    private void endRound()
    {


        for (Card card : cards) {
            card.setPlayer(this.cardWin.getPlayer());
        }


        for(Player player : players) {
            if (!player.canPlay()) {
                this.players.remove(player);
                System.out.println("Player " + player.getName() + " loose.");
            }
        }

        System.out.println(this.cardWin.getPlayer().getName() + " won the round. \n\n");
    }
}
