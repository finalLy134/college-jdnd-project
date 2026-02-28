package interfaces;

import objects.entities.Player;

public interface Interactable {
	void onInteract(GameContext context, Player player);
}
