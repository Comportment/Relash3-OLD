package io.bfnt.relash;

import io.bfnt.relash.music.MusicHandler;
import io.bfnt.relash.secret.Config;
import io.bfnt.relash.util.CommandHandler;
import io.bfnt.relash.util.Logger;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public final class Main extends Config {

    private static JDA jda;

    public static void main(String[] args){

        System.out.println("Booting Relash...");
        login();

        while (true){

            String input = new Scanner(System.in).nextLine();

            if(input.startsWith("<~")){

                switch(input.replaceFirst("<~", "").trim()){

                    case "boot": login(); break;
                    case "exit": System.exit(0); break;
                    case "shutdown": shutdown(); break;
                    case "reboot": reboot(); break;
                }
            }
        }
    }

    private static void login(){

        System.out.println("~> Logging in.");

        while (true) {

            try {

                jda = new JDABuilder(AccountType.BOT)
                        .setToken(getToken())
                        .setAudioEnabled(false)
                        .setGame(Game.of("<~ help"))
                        .addListener(new CommandHandler(), new Logger(), new MusicHandler())
                        .buildBlocking();

                System.out.println("~> Successfully logged in!");
                return;

            } catch (LoginException | InterruptedException | RateLimitedException exception) {

                System.err.println("~> Failed to login... Retrying.");
            }
        }
    }

    private static void shutdown(){

        System.out.println("~> Shutting down...");
        jda.shutdown(false);
        System.out.println("~> Shut down.");
    }

    private static void reboot(){

        shutdown();
        login();
    }
}