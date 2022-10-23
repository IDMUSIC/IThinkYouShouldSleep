package org.example;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;

import java.math.BigInteger;

public class ITYSSUser {

    private User user;

    private Guild server;
    private boolean participating;
    private BigInteger tokens;

    public ITYSSUser() {
        user = null;
        participating = false;
        tokens = BigInteger.valueOf(-1);
    }



}
