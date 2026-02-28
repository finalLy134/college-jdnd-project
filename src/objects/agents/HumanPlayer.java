package objects.agents;

import java.util.Scanner;

import interfaces.GameContext;
import objects.entities.Player;
import utils.Vector2;

public class HumanPlayer extends Player {
	
	private static final Scanner reader = new Scanner(System.in);
	
	public HumanPlayer(String name, int x, int y) {
		super(name, x, y);
	}

	@Override
	public Vector2 move(GameContext context) {
		System.out.println("\n\n" + getName() + " (W/A/S/D): ");
		char dir = reader.next().charAt(0);
		return Vector2.getDirectionFromInput(dir);
	}

}
