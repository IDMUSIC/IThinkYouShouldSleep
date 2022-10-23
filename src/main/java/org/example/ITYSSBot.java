package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class ITYSSBot extends ListenerAdapter {

    private static String accessKey = "";

    private static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createLight(accessKey, EnumSet.noneOf(GatewayIntent.class)) // slash commands don't need any intents
                .addEventListeners(new ITYSSBot())
                .build();

        CommandListUpdateAction commands = jda.updateCommands();


    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        // Only accept commands from guilds
        if (event.getGuild() == null)
            return;
        switch (event.getName())
        {
            case "beter":
                //beter(event); // content is required so no null-check here
                break;
            default:
                event.reply("I can't handle that command right now :(").setEphemeral(true).queue();
        }
    }
}
