package objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import game.GameConfig;
import objects.entities.Tree;
import objects.entities.weapons.FireballWeaponPickup;
import objects.entities.weapons.MagicRingWeaponPickup;
import objects.entities.weapons.SwordWeaponPickup;
import utils.Vector2;

public class Board {

	public final int rows = GameConfig.Board.ROWS;
	public final int columns = GameConfig.Board.COLUMNS;

	private final Tile[][] board = new Tile[rows][columns];

	public Board() {
		this.reset();
	}

	public Board(String fileName) {
		this.load(fileName);
	}

	public Tile tileAt(int row, int col) {
		return this.board[row][col];
	}
	
	public Tile tileAt(Vector2 pos) {
		return this.board[pos.getX()][pos.getY()];
	}

	public void reset() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				this.board[i][j] = new Tile(null);
			}
		}
	}

	public void load(String mapPath) {
	    File file = new File("resources/" + mapPath);

	    try (Scanner reader = new Scanner(file)) {
	        int i = 0;

	        while (reader.hasNextLine() && i < rows) {
	            String line = reader.nextLine();

	            for (int j = 0; j < columns && j < line.length(); j++) {
	                char symbol = line.charAt(j);
	                this.board[i][j] = new Tile(
                		createEntity(symbol, i, j)
            		);
	            }

	            i++;
	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}

	public void print() {
		clear();
		System.out.println();
		for (int i = 0; i < rows; i++) {
			System.out.print("  ");

			for (int j = 0; j < columns; j++) {
				Tile tile = this.board[i][j];
				String symbol = tile.getSymbol();

				System.out.print(symbol);

				if (j < columns - 1) {
					System.out.print(" ");
				}
			}

			System.out.print(" ");
			System.out.println();
		}
	}

	public void clear() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	private Entity createEntity(char symbol, int i, int j) {
		switch (symbol) {
		case 'T':
			return new Tree(i, j);
		case 'S':
			return new SwordWeaponPickup(i, j);
		case 'F':
			return new FireballWeaponPickup(i, j);
		case 'M':
			return new MagicRingWeaponPickup(i, j);
		}
		
		return null;
	}
}
