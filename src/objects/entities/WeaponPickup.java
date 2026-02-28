package objects.entities;

import enums.EntityType;
import enums.WeaponType;
import interfaces.GameContext;
import interfaces.Interactable;
import objects.Entity;

public class WeaponPickup extends Entity implements Interactable {

	private final WeaponType weaponType;
	
	public WeaponPickup(String symbol, WeaponType weaponType, int x, int y) {
		super(EntityType.WEAPON_PICKUP, symbol, x, y, true);
		this.weaponType = weaponType;
	}

	@Override
	public void onInteract(GameContext context, Player player) {
		player.pushWeapon(this.weaponType);
	}
	
	public WeaponType getWeaponType() {
		return this.weaponType;
	}

}
