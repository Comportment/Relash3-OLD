package io.bfnt.relash.commands.random.generators;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Ryan's PC on 12/03/2017.
 */
public class Name extends RelashCommand {

    public void name(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        JSONObject jsonObject;
        String output = "";
        String title = "👤 Random person: ";

        try {

            JSONObject raw = (JSONObject) new JSONParser().parse(new Scanner(new URL("http://api.namefake.com/").openStream()).useDelimiter("\\n").next());
            output = String.format("🤔 **Name:** \n%s\n\n👀 **Features:**\nEyes: %s\nHair: %s\n\n📏 **Measurements:**\nWeight: %skg\nHeight: %scm", raw.get("name"), raw.get("eye"), raw.get("hair"), raw.get("weight"), raw.get("height"));

        } catch (ParseException|IOException e){

            output = "Error";
        }

        try {

            channel.sendMessage(makeEmbed(title, output).build()).queue();

        } catch (PermissionException e){

            channel.sendMessage(title + "\n" + output);
        }
    }
}