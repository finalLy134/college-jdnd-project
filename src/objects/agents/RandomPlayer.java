package objects.agents;

import interfaces.GameContext;
import objects.entities.Player;
import utils.Vector2;

public class RandomPlayer extends Player {

	public RandomPlayer(String name, int x, int y) {
		super(name, x, y);
	}

	@Override
	public Vector2 move(GameContext context) {
	    return Vector2.getRandomDirection();
	}

}
