package io.bfnt.relash.util;

import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class Logger extends ListenerAdapter {

    @Override
    public void onGuildJoin(GuildJoinEvent event) {

        System.out.println("~> Joined " + event.getGuild().getName() + ": +" + event.getGuild().getMembers().size() + " users.");
    }

    @Override
    public void onGuildLeave(GuildLeaveEvent event) {

        System.out.println("~> Left " + event.getGuild().getName() + ": -" + event.getGuild().getMembers().size() + " users.");
    }
}