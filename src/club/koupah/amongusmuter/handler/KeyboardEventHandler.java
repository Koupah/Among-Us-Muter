package club.koupah.amongusmuter.handler;

import club.koupah.amongusmuter.AUMuter;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class KeyboardEventHandler extends GlobalKeyAdapter {

	boolean mute = false;

	int muteKey = 187; // Use this to find a key if you want to change it
						// http://cherrytree.at/misc/vk.htm

	@Override
	public void keyPressed(GlobalKeyEvent event) {

		AUMuter.handleMute(mute = !mute); // Handle the keypress & mute
	}

	// Required function as we extend GlobalKeyAdapter
	@Override
	public void keyReleased(GlobalKeyEvent event) {
	}

}
