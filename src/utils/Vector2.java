package utils;

public class Vector2 {
	private int x, y;
	
	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.format("(%d, %d)", this.x, this.y);
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Vector2)) return false;
		Vector2 other = (Vector2) o;
		return other.x == this.x && other.y == this.y;
	}
	
	public static Vector2 getRandomDirection() {
		int r = (int) (Math.random() * 4);

	    switch (r) {
	        case 0: return new Vector2(-1, 0); // up
	        case 1: return new Vector2(1, 0);  // down
	        case 2: return new Vector2(0, -1); // left
	        case 3: return new Vector2(0, 1);  // right
	        default: return null;
	    }
	}
	
	public static Vector2 getDirectionFromInput(char input) {
		switch (input) {
		case 'w':
		case 'W':
			return new Vector2(-1, 0); // up
		case 'a':
		case 'A':
			return new Vector2(0, -1); // left
		case 's':
		case 'S':
			return new Vector2(+1, 0); // down
		case 'd':
		case 'D':
			return new Vector2(0, +1); // right
		default:
			return null;
		}
	}
	
	public static int distance(Vector2 a, Vector2 b) {
		int aX = a.getX(), aY = a.getY();
		int bX = b.getX(), bY = b.getY();
		
		return (int) Math.sqrt(Math.pow((aX - bX), 2) + Math.pow((aY - bY), 2));
	}
	
	public static Vector2 getDirectionToTarget(Vector2 current, Vector2 target) {
	    if (target == null || current == null) return getRandomDirection();

	    int dx = target.getX() - current.getX();
	    int dy = target.getY() - current.getY();

	    if (dx == 0 && dy == 0) return new Vector2(0, 0);

	    if (Math.abs(dx) >= Math.abs(dy)) {
	        return new Vector2(Integer.signum(dx), 0);
	    } else {
	        return new Vector2(0, Integer.signum(dy));
	    }
	}
}
