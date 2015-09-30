/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.battle.controller;

/**
 *
 * @author Alexandre
 */
public class DefaultController
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        GameController game = new GameController();
        game.createPlayer("Quentin");
        game.createPlayer("Alexandre");
        game.createPlayer("lalala");
        game.createPlayer("tototo");

        game.Start();
    }

}
