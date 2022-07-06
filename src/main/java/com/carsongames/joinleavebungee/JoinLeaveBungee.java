package com.carsongames.joinleavebungee;

import net.md_5.bungee.api.Callback;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.*;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public final class JoinLeaveBungee extends Plugin {
    String configjoin = " ";
    String configjoin_first = " ";
    String uuid;
    int Ready = 1;



    @Override
    public void onEnable() {
        getCommandsandEvents();
        getLogger().info("JoinLeave has started!");


    }

    @Override
    public void onDisable() {
        getLogger().info("JoinLeave has stopped!");

    }

    public void getCommandsandEvents() {

        getProxy().getPluginManager().registerListener(this, new PlayerJoin());
        getProxy().getPluginManager().registerListener(this, new PlayerLeave());
        getProxy().getPluginManager().registerListener(this, new ProxyJoin());


    }

    public class PlayerJoin implements Listener {

        @EventHandler
        public void onPlayerJoin(ServerConnectedEvent e) {
            String Target = e.getServer().getInfo().getName();
            ProxiedPlayer Player = e.getPlayer();

            ProxyServer.getInstance().broadcast(ChatColor.GOLD + Player.getName() + " has connected to " + Target);

        }
    }

    public class ProxyJoin implements Listener {

        @EventHandler
        public void onProxyJoin(PostLoginEvent e) {

            String Player = e.getPlayer().getName();

                    ProxyServer.getInstance().broadcast(ChatColor.GREEN + Player + " joined the network");

        }
    }

    public class PlayerLeave implements Listener {

        @EventHandler
        public void onPlayerLeave(PlayerDisconnectEvent e) {

            String Player = e.getPlayer().getName();


            ProxyServer.getInstance().broadcast(ChatColor.RED + Player + " has left the network");
        }




    }

    public class ServerSwitch implements Listener {

        @EventHandler
        public void onPlayerJoin(ServerConnectedEvent e) {
            String Target = e.getServer().getInfo().getName();
            String Player = e.getPlayer().getName();

        }

    }



}



