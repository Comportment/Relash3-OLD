package io.bfnt.relash.commands.informative.self;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 08/03/2017.
 */
public class Info extends RelashCommand {

    public void info(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final JDA jda = trigger.getJDA();
        final String rinfo = "📈 Relash Info 📈";
        int users = 0;
        for(Guild guild : jda.getGuilds()) {

            users += guild.getMembers().size();
        }
        final String info = String.format("🙇 Owner: RYArrowsmith#8070\n📚 Library: JDA (Java Discord API)\n🔧 API Version: 3.0.BETA2_148\n🤖 Bot Version: 3.0.6\n-=+=-\n👥 Guilds: %d\n🎧 Voice Channels: %d\n🖊 Text Channels: %d\n📓 Total Channels: %d\n👤 Users: %d\n-=+=-\n❗ Invite me: https://bfnt.io/self-invite\n❔ Support: https://bfnt.io/self-support\n💵 Donate: https://bfnt.io/self-donate\n🖥 Website: https://bfnt.io/self-website", jda.getGuilds().size(), jda.getVoiceChannels().size(), jda.getTextChannels().size(), jda.getTextChannels().size() + jda.getVoiceChannels().size(), users);

        try {

            channel.sendMessage(makeEmbed(" ", rinfo).addField("", info, true).setThumbnail(jda.getSelfUser().getEffectiveAvatarUrl()).build()).queue();

        } catch (PermissionException exception){

            channel.sendMessage(rinfo + "\n" + info).queue();
        }
    }
}