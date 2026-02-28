package game;

public class GameConfig {

	public class Game {
		public static final int MAX_PLAYERS = 6;
		public static final int DELAY_BETWEEN_TURNS = 200;
	}
	
	public class Board {
		public static final int ROWS = 10;
		public static final int COLUMNS = 10;
	}
	
	public class Symbols {
		public static final String NONE = "·";
		public static final String PLAYER = "♜";
		public static final String TREE = "♣";
		public static final String SWORD = "⚔";
		public static final String MAGIC_RING = "◯";
		public static final String FIREBALL = "☄";
	}
}
