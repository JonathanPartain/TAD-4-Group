import java.awt.*;

public class Explosions {

	static final int MAX_SCRAP = 40;

	/**
	 * Explosion data.
	 */
	int[] explosionCounter = new int[MAX_SCRAP];
	AsteroidsSprite[] explosions = new AsteroidsSprite[MAX_SCRAP];
	/**
	 * Time counters for explosions.
	 */
	int explosionIndex;

	public void initExplosions() {
		int i;

		for (i = 0; i < MAX_SCRAP; i++) {
			explosions[i].shape = new Polygon();
			explosions[i].active = false;
			explosionCounter[i] = 0;
		}
		explosionIndex = 0;
	}

	public void updateExplosions() {
		int i;

		// Move any active explosion debris. Stop explosion when its counter has
		// expired.

		for (i = 0; i < MAX_SCRAP; i++)
			if (explosions[i].active) {
				explosions[i].advance();
				explosions[i].render();
				if (--explosionCounter[i] < 0)
					explosions[i].active = false;
			}

	}

}