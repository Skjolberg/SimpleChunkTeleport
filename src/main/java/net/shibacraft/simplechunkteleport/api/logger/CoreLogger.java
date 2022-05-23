package net.shibacraft.simplechunkteleport.api.logger;

import net.shibacraft.simplechunkteleport.api.chat.TextColor;
import org.bukkit.Bukkit;

public class CoreLogger {

    public static final String LOGGER_NAME = "&d&lSimpleChunkTeleport";

    public static void info(String message) {
        Bukkit.getLogger().info(TextColor.color(LOGGER_NAME + "&8 | &r" + message));
        Bukkit.getConsoleSender().sendMessage("");
    }

    public static void warn(String message) {
        Bukkit.getLogger().warning(TextColor.color(LOGGER_NAME + "&8 | &e" + message));
    }

    public static void severe(String message) {
        Bukkit.getLogger().severe(TextColor.color(LOGGER_NAME + "&8 | &c" + message));
    }

}
