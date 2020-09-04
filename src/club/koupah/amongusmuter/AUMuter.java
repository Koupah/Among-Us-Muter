package club.koupah.amongusmuter;

import club.koupah.amongusmuter.handler.KeyboardEventHandler;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class AUMuter {
	
	public static JDA jda;
	
	static GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true); //Keyboard hook (From SystemHook)
	
	static String token = "NzUxMjQzMjM3NjI0MjUwNDI4.X1GPyQ.V1HpYVlAJidz5kIdPEF09GrK72s";
	
	static boolean inEclipse = false;
	
	
	// Main method
	public static void main(String[] args) throws Exception {
		
		keyboardHook.addKeyListener(new KeyboardEventHandler());
		
		jda = new JDABuilder(token)
				.setActivity(Activity.listening("Dacker whining")).build();
		jda.getPresence().setStatus(OnlineStatus.ONLINE);

	}
	


}
