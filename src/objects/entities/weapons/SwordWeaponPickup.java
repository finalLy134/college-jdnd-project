package objects.entities.weapons;

import enums.WeaponType;
import game.GameConfig;
import objects.entities.WeaponPickup;

public class SwordWeaponPickup extends WeaponPickup {

	public SwordWeaponPickup(int x, int y) {
		super(GameConfig.Symbols.SWORD, WeaponType.SWORD, x, y);
	}

}
