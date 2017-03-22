package io.bfnt.relash.util;

import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class RelashCommand {

    protected final String checkPM = "📫 Check your private messages! 📫";

    protected EmbedBuilder makeEmbed(String title, String description, String... fields){

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle(title, null);
        embed.setDescription(description);
        for(String field : fields){

            embed.addField(field.split(" ")[0], field.replaceFirst(field.split(" ")[0], ""), false);
        }
        embed.setColor( new Color(1,210,202));
        return embed;
    }

   protected String getAnimal(String animal){

        try {

            return new Scanner(new URL("http://shibe.online/api/" + animal + "/?count=1").openStream()).next().replaceAll("[\\[\\]\"]", "");

        } catch (IOException exception){

            return "https://cdn.discordapp.com/attachments/277836339687194625/288779713206419458/wump.png";
        }
    }
}