package objects;

import game.GameConfig;

public class Tile {
	
	private Entity entity = null;
	
	public Tile(Entity entity) {
		this.entity = entity;
	}
	
	public boolean isWalkable() {
		if (entity == null) return true;
		return entity.isWalkable();
	}
	
	public boolean isEmpty() {
		return this.entity == null;
	}
	
	public String getSymbol() {
		return this.isEmpty() ? GameConfig.Symbols.NONE : entity.getSymbol();
	}
	
	public Entity getEntity() {
		return this.entity;
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
}
