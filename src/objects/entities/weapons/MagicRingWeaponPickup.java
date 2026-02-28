package objects.entities.weapons;

import enums.WeaponType;
import game.GameConfig;
import objects.entities.WeaponPickup;

public class MagicRingWeaponPickup extends WeaponPickup {

	public MagicRingWeaponPickup(int x, int y) {
		super(GameConfig.Symbols.MAGIC_RING, WeaponType.MAGIC_RING, x, y);
	}

}
