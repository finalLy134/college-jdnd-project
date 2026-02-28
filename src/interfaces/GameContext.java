package interfaces;

import enums.EntityType;
import objects.Entity;
import objects.entities.Player;
import utils.Vector2;

public interface GameContext {
	boolean canMove(Player player, Vector2 direction);
	Vector2 closestEntityByType(Vector2 position, EntityType type);
	Entity getEntityAt(Vector2 position);
	
	void onPlayerKill(Player killer, Player killed);
}
