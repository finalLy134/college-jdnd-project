package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import enums.EntityType;
import interfaces.GameContext;
import interfaces.Interactable;
import objects.Board;
import objects.Entity;
import objects.Tile;
import objects.entities.Player;
import utils.Vector2;

public class GameManager implements GameContext {

	private List<Entity> entityList = new ArrayList<>();
	private List<Player> playerList = new ArrayList<>(GameConfig.Game.MAX_PLAYERS);
	
	private final Board board;
	
	public GameManager(Entity...entities) {
		this.board = new Board();
		this.placeEntities(entities);
	}
	
	public GameManager(String mapPath, Entity...entities) {
		this.board = new Board(mapPath);
		this.placeEntities(entities);
	}
	
	private void placeEntities(Entity...entities) {
		for (Entity entity : entities) {
			Vector2 coords = entity.getPosition();
			int x = coords.getX();
			int y = coords.getY();
			
			this.board.tileAt(x, y).setEntity(entity);
			
			if (entity instanceof Player)
				playerList.add((Player) entity);
			
			entityList.add(entity);
		}
	}
	
	private Player getWinner() {
	    Player alive = null;

	    for (Player player : playerList) {
	        if (!player.isDead()) {
	            if (alive != null) {
	                return null;
	            }
	            alive = player;
	        }
	    }

	    return alive;
	}
	
	@Override
	public void onPlayerKill(Player killer, Player killed) {
	    killed.setIsDead(true);

	    Vector2 pos = killed.getPosition();
	    board.tileAt(pos).setEntity(null);
	}
	
	@Override
	public boolean canMove(Player player, Vector2 direction) {
	    Vector2 coords = player.getPosition();

	    int newRow = coords.getX() + direction.getX();
	    int newCol = coords.getY() + direction.getY();

	    boolean outOfBounds =
	            newRow < 0 ||
	            newRow >= this.board.rows ||
	            newCol < 0 ||
	            newCol >= this.board.columns;

	    if (outOfBounds)
	        return false;

	    Tile tile = this.board.tileAt(newRow, newCol);
	    return tile.isWalkable();
	}
	
	@Override
	public Vector2 closestEntityByType(Vector2 position, EntityType type) {
		for (int i = 0; i < GameConfig.Board.ROWS; i++) {
			for (int j = 0; j < GameConfig.Board.COLUMNS; j++) {
				Tile tile = this.board.tileAt(i, j);
				if (!tile.isEmpty()) {
					Entity entity = tile.getEntity();
					if (entity.getType().equals(type))
						return new Vector2(i, j);
				}
			}
		}
		return null;
	}
	
	@Override
	public Entity getEntityAt(Vector2 position) {
		return this.board.tileAt(position).getEntity();
	}
	
	private void movePlayer(Player player, Vector2 direction) {
	    Vector2 coords = player.getPosition();

	    int oldRow = coords.getX();
	    int oldCol = coords.getY();

	    int newRow = oldRow + direction.getX();
	    int newCol = oldCol + direction.getY();

	    this.board.tileAt(oldRow, oldCol).setEntity(null);
	    this.board.tileAt(newRow, newCol).setEntity(player);

	    coords.setX(newRow);
	    coords.setY(newCol);
	    
	    board.print();
	}
	
	private void tryInteract(Player player, Vector2 direction) {
	    Vector2 coords = player.getPosition();

	    int newRow = coords.getX() + direction.getX();
	    int newCol = coords.getY() + direction.getY();
	    
	    Tile tile = this.board.tileAt(newRow, newCol);
	    Entity tileEntity = tile.getEntity();
	    
	    if (tileEntity instanceof Interactable) {
	    	Interactable interactionEntity = (Interactable) tileEntity;
	    	interactionEntity.onInteract(this, player);
	    }
	}
	
	private void removePlayer(Player player) {
	    entityList.remove(player);
	    player.setIsDead(true);
	}
	
	private void pause(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		board.print();
		Player winner = getWinner();
		while (winner == null) {
			update();
			winner = getWinner();
		}
		System.out.println("Player " + winner.getName() + " won");
	}
	
	public void update() {
	    boolean changed = false;

	    Iterator<Player> iterator = playerList.iterator();

	    while (iterator.hasNext() && getWinner() == null) {
	        Player player = iterator.next();
	        
	        if (player.isDead()) {
	            removePlayer(player);
	            changed = true;
	            continue;
	        }

	        Vector2 dir = player.move(this);

	        if (dir != null && canMove(player, dir)) {
	            tryInteract(player, dir);
	            
	            if (!player.isDead())
	                movePlayer(player, dir);
	            
	            changed = true;
	            pause(GameConfig.Game.DELAY_BETWEEN_TURNS);
	        }
	    }

	    if (changed)
	        board.print();
	}
}
