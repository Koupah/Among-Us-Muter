package club.koupah.amongusmuter.handler;

import club.koupah.amongusmuter.utility.Utility;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class KeyboardEventHandler extends GlobalKeyAdapter {

	boolean mute = false;

	@Override
	public void keyPressed(GlobalKeyEvent event)  {
		if (event.getVirtualKeyCode() == 187) { // 187 is '='
			mute = !mute; //First press = mute, second = unmute
			Utility.handleMute(mute); //Handle the keypress & mute
		}

	}
	
	//Required function as we extend GlobalKeyAdapter
	@Override
	public void keyReleased(GlobalKeyEvent event) {}

}
