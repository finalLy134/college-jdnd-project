package objects.entities.weapons;

import enums.WeaponType;
import game.GameConfig;
import objects.entities.WeaponPickup;

public class FireballWeaponPickup extends WeaponPickup {

	public FireballWeaponPickup(int x, int y) {
		super(GameConfig.Symbols.FIREBALL, WeaponType.FIREBALL, x, y);
	}

}
