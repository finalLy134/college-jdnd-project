package objects.agents;

import interfaces.GameContext;
import objects.entities.Player;
import utils.Vector2;

public class ScanPlayer extends Player {

	private Vector2 currentDirection = new Vector2(0, 1);
	
	public ScanPlayer(String name, int x, int y) {
		super(name, x, y);
	}

	@Override
	public Vector2 move(GameContext context) {
		if (!context.canMove(this, currentDirection)) {
            currentDirection = Vector2.getRandomDirection();
        }
		return currentDirection;
	}

}