package AsteroidsGame;

public class UFO {

	/**
	 * Starting number of ships for
	 * each game.
	 */
	static final int UFO_PASSES = 3;
	/**
	 * various objects.
	 */
	static final int UFO_POINTS = 250;
	/**
	 * Flying saucer data.
	 */
	int ufoPassesLeft;
	static final int NEW_UFO_POINTS = 2750;
	/**
	 * Counter for number of flying saucer passes.
	 */
	int ufoCounter;
	int newUfoScore;
	AsteroidsSprite ufo;

	public void initUfo() {
		double angle, speed;

		// Randomly set flying saucer at left or right edge of the screen.

		ufo.active = true;
		ufo.x = -AsteroidsSprite.width / 2;
		ufo.y = Math.random() * 2 * AsteroidsSprite.height - AsteroidsSprite.height;
		angle = Math.random() * Math.PI / 4 - Math.PI / 2;
		speed = MAX_ROCK_SPEED / 2 + Math.random() * (MAX_ROCK_SPEED / 2);
		ufo.deltaX = speed * -Math.sin(angle);
		ufo.deltaY = speed *  Math.cos(angle);
		if (Math.random() < 0.5) {
			ufo.x = AsteroidsSprite.width / 2;
			ufo.deltaX = -ufo.deltaX;
		}
		if (ufo.y > 0)
			ufo.deltaY = ufo.deltaY;
		ufo.render();
		saucerPlaying = true;
		if (sound)
			saucerSound.loop();
		ufoCounter = (int) Math.abs(AsteroidsSprite.width / ufo.deltaX);
	}

	public void updateUfo() {
		int i, d;
		boolean wrapped;

		// Move the flying saucer and check for collision with a photon. Stop it
		// when its counter has expired.

		if (ufo.active) {
			if (--ufoCounter <= 0) {
				if (--ufoPassesLeft > 0)
					initUfo();
				else
					stopUfo();
			}
			if (ufo.active) {
				ufo.advance();
				ufo.render();
				for (i = 0; i < MAX_SHOTS; i++)
					if (photons[i].active && ufo.isColliding(photons[i])) {
						if (sound)
							crashSound.play();
						explode(ufo);
						stopUfo();
						score += UFO_POINTS;
					}

				// On occassion, fire a missle at the ship if the saucer is not too
				// close to it.

				d = (int) Math.max(Math.abs(ufo.x - ship.x), Math.abs(ufo.y - ship.y));
				if (ship.active && hyperCounter <= 0 &&
						ufo.active && !missle.active &&
						d > MAX_ROCK_SPEED * FPS / 2 &&
						Math.random() < MISSLE_PROBABILITY)
					initMissle();
			}
		}
	}

	public void stopUfo() {
		ufo.active = false;
		ufoCounter = 0;
		ufoPassesLeft = 0;
		if (loaded)
			saucerSound.stop();
		saucerPlaying = false;
	}

}