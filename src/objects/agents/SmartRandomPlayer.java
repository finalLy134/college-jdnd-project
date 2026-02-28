package objects.agents;

import enums.EntityType;
import interfaces.GameContext;
import objects.entities.Player;
import utils.Vector2;

public class SmartRandomPlayer extends Player {

    private final int CHECK_RADIUS = 5;
    private Vector2 lockedTargetPos = null;

    public SmartRandomPlayer(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public Vector2 move(GameContext context) {
        Vector2 pos = this.getPosition();

        if (lockedTargetPos != null) {
            if (context.getEntityAt(lockedTargetPos) == null || pos.equals(lockedTargetPos)) {
                lockedTargetPos = null; 
            }
        }

        if (lockedTargetPos == null) {
            Vector2 closestPlayer = context.closestEntityByType(pos, EntityType.PLAYER);
            Vector2 closestWeapon = context.closestEntityByType(pos, EntityType.WEAPON_PICKUP);

            int pDist = (closestPlayer != null) ? Vector2.distance(pos, closestPlayer) : Integer.MAX_VALUE;
            int wDist = (closestWeapon != null) ? Vector2.distance(pos, closestWeapon) : Integer.MAX_VALUE;

            if (closestPlayer != null && pDist <= CHECK_RADIUS) {
                lockedTargetPos = closestPlayer;
            } else if (closestWeapon != null && wDist <= CHECK_RADIUS) {
                lockedTargetPos = closestWeapon;
            }
        }

        if (lockedTargetPos != null) {
            return Vector2.getDirectionToTarget(pos, lockedTargetPos);
        }

        return Vector2.getRandomDirection();
    }
}
