package AsteroidsGame.Assets;

import java.applet.AudioClip;

public class sounds {

	/**
	 * Sound clips.
	 */
	java.applet.AudioClip crashSound;
	java.applet.AudioClip explosionSound;
	java.applet.AudioClip fireSound;
	java.applet.AudioClip missleSound;
	java.applet.AudioClip saucerSound;
	java.applet.AudioClip thrustersSound;
	java.applet.AudioClip warpSound;

	public void loadSounds() {
		// Load all sound clips by playing and immediately stopping them. Update
		// counter and total for display.

		try {
			crashSound     = getAudioClip(new URL(getCodeBase(), "crash.au"));
			clipTotal++;
			explosionSound = getAudioClip(new URL(getCodeBase(), "explosion.au"));
			clipTotal++;
			fireSound      = getAudioClip(new URL(getCodeBase(), "fire.au"));
			clipTotal++;
			missleSound    = getAudioClip(new URL(getCodeBase(), "missle.au"));
			clipTotal++;
			saucerSound    = getAudioClip(new URL(getCodeBase(), "saucer.au"));
			clipTotal++;
			thrustersSound = getAudioClip(new URL(getCodeBase(), "thrusters.au"));
			clipTotal++;
			warpSound      = getAudioClip(new URL(getCodeBase(), "warp.au"));
			clipTotal++;
		}
		catch (MalformedURLException e) {}

		try {
			crashSound.play();     crashSound.stop();     clipsLoaded++;
			repaint(); Thread.currentThread().sleep(DELAY);
			explosionSound.play(); explosionSound.stop(); clipsLoaded++;
			repaint(); Thread.currentThread().sleep(DELAY);
			fireSound.play();      fireSound.stop();      clipsLoaded++;
			repaint(); Thread.currentThread().sleep(DELAY);
			missleSound.play();    missleSound.stop();    clipsLoaded++;
			repaint(); Thread.currentThread().sleep(DELAY);
			saucerSound.play();    saucerSound.stop();    clipsLoaded++;
			repaint(); Thread.currentThread().sleep(DELAY);
			thrustersSound.play(); thrustersSound.stop(); clipsLoaded++;
			repaint(); Thread.currentThread().sleep(DELAY);
			warpSound.play();      warpSound.stop();      clipsLoaded++;
			repaint(); Thread.currentThread().sleep(DELAY);
		}
		catch (InterruptedException e) {}

	}

}