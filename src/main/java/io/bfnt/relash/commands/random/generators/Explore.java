package io.bfnt.relash.commands.random.generators;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.exceptions.PermissionException;

import java.security.SecureRandom;

/**
 * Created by Ryan's PC on 11/03/2017.
 */
public class Explore extends RelashCommand {

    public void explore(Message trigger){

        final MessageChannel pchannel = trigger.getChannel();
        final String searching = "🔎 Searching...";
        final String found = "🔍 Found: ";
        final String link = "%s\nhttps://discord.gg/%s";
        final JDA jda = trigger.getJDA();

        if(!pchannel.getType().equals(ChannelType.PRIVATE)){

            try {

                pchannel.sendMessage(makeEmbed(" ", checkPM).build()).queue();

            } catch (PermissionException e){

                pchannel.sendMessage(checkPM).queue();
            }
        }

        try {

            trigger.getAuthor().openPrivateChannel().queue(channel -> channel.sendMessage(makeEmbed(searching, "").build()).queue(search -> {

                Invite invite = null;

                while (invite == null){

                    invite = makeInvite(jda.getGuilds().get(new SecureRandom().nextInt(jda.getGuilds().size())));
                }

                search.editMessage(makeEmbed(found, String.format(link, invite.getGuild().getName(), invite.getCode())).build()).queue();
            }));

        } catch (PermissionException e){

            trigger.getAuthor().openPrivateChannel().queue(channel -> channel.sendMessage(searching).queue(search -> {

                Invite invite = null;

                while (invite == null){

                    invite = makeInvite(jda.getGuilds().get(new SecureRandom().nextInt(jda.getGuilds().size())));
                }

                search.editMessage(found + String.format(link, invite.getGuild(), invite.getCode())).queue();
            }));
        }
    }

    private Invite makeInvite(Guild guild){

        try {

            return guild.getPublicChannel().createInvite().complete();

        } catch (PermissionException e){

            return null;
        }
    }
}
