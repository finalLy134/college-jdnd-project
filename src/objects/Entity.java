package objects;

import enums.EntityType;
import utils.Vector2;

public class Entity {

	private final EntityType type;
	private final String symbol;
	private Vector2 position;
	private final boolean isWalkable;
	
	public Entity(EntityType type, String symbol, int x, int y, boolean isWalkable) {
		this.type = type;
		this.symbol = symbol;
		this.position = new Vector2(x, y);
		this.isWalkable = isWalkable;
	}
	
	public EntityType getType() {
		return this.type;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public Vector2 getPosition() {
		return this.position;
	}
	
	public boolean isWalkable() {
		return this.isWalkable;
	}
	
}
