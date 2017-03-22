package io.bfnt.relash.commands.informative.self;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class Help extends RelashCommand {

    public void help(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final String commands = "`Informative:`\n❗ <~ help - Sends you help.\n📈 <~ info - Gives you info about Relash.\n📝 <~ ginfo - Gives you info about the current guild.\n⏱ <~ ping - Pings Relash's connection.\n🖥 <~ website - Gives a link to my website.\n`Random:` \n🐦 <~ bird - Returns a random bird.\n🐱 <~ cat - Returns a random cat.\n🤣 <~ dice - Rolls a 6-sided die.\n🐶 <~ dog - Returns a random dog.\n🔘 <~ flip - Flips a coin.\n🔎 <~ explore - Invites you to a random guild.\n👤 <~name - Gives you a random person.";

        if(!channel.getType().equals(ChannelType.PRIVATE)){

            try {

                channel.sendMessage(makeEmbed(" ", checkPM).build()).queue();

            } catch (PermissionException exception){

                channel.sendMessage(checkPM).queue();
            }
        }

        try {

            trigger.getAuthor().openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(makeEmbed("❗❗ Relash Help ❗❗", "", "Commands: " + commands).build()).queue());

        } catch (PermissionException exception) {

            trigger.getAuthor().openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage("❗❗ Relash Help ❗❗\n" + commands).queue());
        }
    }
}