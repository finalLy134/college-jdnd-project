package objects.entities;

import enums.EntityType;
import game.GameConfig;
import objects.Entity;

public class Tree extends Entity {

	public Tree(int x, int y) {
		super(EntityType.TREE, GameConfig.Symbols.TREE, x, y, false);
	}
	
}
