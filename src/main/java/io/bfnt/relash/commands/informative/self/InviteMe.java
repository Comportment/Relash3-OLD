package io.bfnt.relash.commands.informative.self;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 11/03/2017.
 */
public class InviteMe extends RelashCommand {

    public void invite(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final String message = "❗ My invite link is: https://bfnt.io/self-invite";

        try {

            channel.sendMessage(makeEmbed(" ", message).build()).queue();

        } catch (PermissionException e){

            channel.sendMessage(message).queue();
        }
    }
}
