package io.bfnt.relash.util;

import io.bfnt.relash.commands.informative.other.Ginfo;
import io.bfnt.relash.commands.informative.self.*;
import io.bfnt.relash.commands.random.animal.Bird;
import io.bfnt.relash.commands.random.animal.Cat;
import io.bfnt.relash.commands.random.animal.Dog;
import io.bfnt.relash.commands.random.generators.Explore;
import io.bfnt.relash.commands.random.generators.Name;
import io.bfnt.relash.commands.random.number.Dice;
import io.bfnt.relash.commands.random.number.Flip;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class CommandHandler extends ListenerAdapter {

    private final String[] prefixes = {"<~", "<@287566190421868544>", "<@!287566190421868544>"};

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        Boolean valid = false;
        String content = event.getMessage().getRawContent();
        String triggerPrefix = "";

        for(String prefix : prefixes){

            if(content.startsWith(prefix)){

                triggerPrefix = prefix;
                valid = true;
                break;
            }
        }
        if(!valid) return;
        Message message = event.getMessage();
        message.addReaction("⚙").queue();

        System.out.println(content);
        switch(content.replaceFirst(triggerPrefix, "").trim()){

            case "bird": new Bird().bird(message); break;
            case "cat": new Cat().cat(message); break;
            case "dice": new Dice().dice(message); break;
            case "dog": new Dog().dog(message); break;
            case "flip": new Flip().flip(message); break;
            case "help": new Help().help(message); break;
            case "ginfo": new Ginfo().ginfo(message); break;
            case "info": new Info().info(message); break;
            case "ping": new Ping().ping(message); break;
            case "website": new Website().website(message); break;
            case "invite": new InviteMe().invite(message); break;
            case "explore": new Explore().explore(message); break;
            case "name": new Name().name(message); break;
        }
    }
}