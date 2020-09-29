package club.koupah.amongusmuter;

import club.koupah.amongusmuter.handler.KeyboardEventHandler;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class AUMuter {

	public static JDA jda;

	static GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true); // Keyboard hook (From SystemHook)

	static String token = Secret.token; // Use your own token here

	static VoiceChannel amongUs;

	static String guildID = Secret.guildID;

	// Main method
	public static void main(String[] args) throws Exception {
		
		//Keyboard hook to listen for the mute key
		keyboardHook.addKeyListener(new KeyboardEventHandler());

		jda = new JDABuilder(token).build();

		jda.getPresence().setStatus(OnlineStatus.ONLINE);

	}

	
	// Could save an arraylist of muted people and only unmute them rather than
	// everyone in a VC, but I tried this and it seemed to struggle to unmute the
	// last one. Made no sense to me so I reverted back to this instead of testing
	public static void handleMute(boolean mute) {

		//Infinite loop until we find the VC, basically just make the voice channel man
		while ((amongUs = getVC()) == null)
			try {
				Thread.sleep(200); //Sleep so we don't spam discord right
			} catch (InterruptedException e) { //Exception shouldn't occur, who cares if it does
			}

		// for instead of foreach, java 7 tings
		for (Member member : amongUs.getMembers()) {
			System.out.println("muting " + member.getNickname());
			member.mute(mute).queue();
		}
	}

	public static VoiceChannel getVC() {
		// I don't do foreach() for Java 7 users
		for (VoiceChannel vc : AUMuter.jda.getGuildById(guildID).getVoiceChannels()) {

			// "Among Us" = "amongus", "[Emoji]Among Us[Emoji]" = "[Emoji]amongus[Emoji]"
			if (vc.getName().toLowerCase().replaceAll(" ", "").contains("amongus"))
				return vc;
			
		}
		return null;
	}

}
