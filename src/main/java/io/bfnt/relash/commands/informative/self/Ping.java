package io.bfnt.relash.commands.informative.self;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

import java.time.temporal.ChronoUnit;

/**
 * Created by Ryan's PC on 08/03/2017.
 */
public class Ping extends RelashCommand {

    public void ping(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final String p1 = "🕚 Pinging...";
        final String p2 = "🕛 Ping: %dms";

        try {

            channel.sendMessage(makeEmbed(" ", p1).build()).queue(pong -> pong.editMessage(makeEmbed(" ", String.format(p2, trigger.getCreationTime().until(pong.getCreationTime(), ChronoUnit.MILLIS))).build()).queue());

        } catch (PermissionException exception){

            channel.sendMessage(p1).queue(pong -> pong.editMessage(p2.replace("%time%", trigger.getCreationTime().until(pong.getCreationTime(), ChronoUnit.MILLIS)+ "")).queue());
        }
    }
}