package AsteroidsGame;

public class Photon {

	static final int MAX_SHOTS = 8;
	/**
	 * Photon data.
	 */
	int photonIndex;
	/**
	 * Index to next available photon sprite.
	 */
	long photonTime;
	AsteroidsSprite[] photons = new AsteroidsSprite[MAX_SHOTS];

	public void updatePhotons() {
		int i;

		// Move any active photons. Stop it when its counter has expired.

		for (i = 0; i < MAX_SHOTS; i++)
			if (photons[i].active) {
				if (!photons[i].advance())
					photons[i].render();
				else
					photons[i].active = false;
			}
	}

	public void initPhotons() {
		int i;

		for (i = 0; i < MAX_SHOTS; i++)
			photons[i].active = false;
		photonIndex = 0;
	}

}