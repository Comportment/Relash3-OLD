package io.bfnt.relash.commands.random.number;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

import java.security.SecureRandom;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class Dice extends RelashCommand {

    public void dice(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final String result = "🤣 Result: " + (new SecureRandom().nextInt(6) + 1);

        try {

            channel.sendMessage(makeEmbed(result, "").build()).queue();

        } catch (PermissionException exception){

            channel.sendMessage(result).queue();
        }
    }
}