package club.koupah.amongusmuter.utility;

import club.koupah.amongusmuter.AUMuter;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class Utility {

	//If mute == false then unmute
	public static void handleMute(boolean mute) {
		VoiceChannel amongUs = getVC();
		
		//If VC exists
		if (amongUs != null) {
			amongUs.getMembers().forEach(member -> {
				member.mute(mute).queue();
			});
		}
	}
	
	public static VoiceChannel getVC() {
		for (VoiceChannel vc : AUMuter.jda.getGuildById("134165540133535744").getVoiceChannels()) { //Guild id is the FatSephy Guild
			for (Member member : vc.getMembers()) {
				System.out.println(member.getEffectiveName());
				if (member.getEffectiveName().toLowerCase().contains("fatsephy")) { //Look for the voice channel with FatSephy in it
					return vc;
				}
			}
		}
		return null;
	}
}
