package io.bfnt.relash.commands.random.animal;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class Bird extends RelashCommand {

    public void bird(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final String image = getAnimal("birds");

        try {

            channel.sendMessage(makeEmbed("🐦", "").setImage(image).build()).queue();

        } catch (PermissionException exception){

            channel.sendMessage(image).queue();
        }
    }
}