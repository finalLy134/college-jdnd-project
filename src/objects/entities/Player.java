package objects.entities;

import java.util.Stack;

import enums.EntityType;
import enums.WeaponType;
import interfaces.GameContext;
import interfaces.Interactable;
import objects.Entity;
import utils.Vector2;

public abstract class Player extends Entity implements Interactable {
	
	private String name;
	private final Stack<WeaponType> weapons;
	private boolean dead = false;
	
	public Player(String name, int x, int y) {
		super(EntityType.PLAYER, name, x, y, true);
		this.name = name;
		this.weapons = new Stack<>();
	}
	
	public abstract Vector2 move(GameContext context);
	
	@Override
	public void onInteract(GameContext context, Player other) {
		WeaponType ourWeapon = this.popWeapon();
		WeaponType otherWeapon = other.popWeapon();
		
		System.out.println(getName() + ": " + ourWeapon + " vs. " + other.getName() + ": " + otherWeapon);
		
		if (playerWonAttack(ourWeapon, otherWeapon))
			context.onPlayerKill(this, other);
		else
			context.onPlayerKill(other, this);
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isDead() {
		return this.dead;
	}
	
	public void setIsDead(boolean dead) {
		this.dead = dead;
	}
	
	public void pushWeapon(WeaponType weaponType) {
		this.weapons.push(weaponType);
	}
	
	public WeaponType popWeapon() {
	    if (this.weapons.isEmpty())
	        return WeaponType.NONE;
	    
		return this.weapons.pop();
	}
	
	public boolean playerWonAttack(WeaponType ourWeapon, WeaponType otherWeapon) {
	    if (ourWeapon == WeaponType.NONE)
	        return false;

	    if (otherWeapon == WeaponType.NONE)
	        return true;

	    if (ourWeapon == otherWeapon)
	        return false;

	    return (ourWeapon == WeaponType.FIREBALL && otherWeapon == WeaponType.SWORD)
	        || (ourWeapon == WeaponType.SWORD && otherWeapon == WeaponType.MAGIC_RING)
	        || (ourWeapon == WeaponType.MAGIC_RING && otherWeapon == WeaponType.FIREBALL);
	}

}
