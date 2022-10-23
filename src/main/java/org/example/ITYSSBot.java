package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Member;
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
            case "enable":
                enablePelting(event);
                break;
            case "disable":
                disablePelting(event);
            case "pelt":

            default:
                event.reply("I can't handle that command right now :(").setEphemeral(true).queue();
        }
    }

    /**
     *  Enrolls the user in pelting "algorithms"
     *  Users are not pelted by default, I'm not that mean!
     *
     *  @param event
     */
    public void enablePelting(SlashCommandInteractionEvent event) {
        Member unfortunateSoul = event.getMember();
        //add member to pelting repository
        //If member doesn't exist in repository, enable
        //If member does exist, enable again, then check if they are in any voice servers
    }

    /**
     * Unenrolls the user from pelting "algorithms"
     *
     * @param event
     */
    public void disablePelting(SlashCommandInteractionEvent event) {
        Member unfortunateSoul = event.getMember();
        //If user has an account, disable them from triggers and pelting
        //If no account, print error message

    }

    public void pelt() {

    }
}
