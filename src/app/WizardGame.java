package app;

import game.GameManager;
import objects.agents.*;
import objects.entities.Player;

public class WizardGame {
	
	public static void main(String[] args) {
		Player p1 = new HumanPlayer("1", 0, 0);
		Player p2 = new RandomPlayer("2", 3, 5);
		Player p3 = new ScanPlayer("3", 2, 1);
		Player p4 = new SmartRandomPlayer("4", 9, 9);
		
		GameManager gameManager = new GameManager("level-1.txt", p1, p2, p3, p4);
		gameManager.start();
	}
	
}
