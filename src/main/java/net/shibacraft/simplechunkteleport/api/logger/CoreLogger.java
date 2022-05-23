package net.shibacraft.simplechunkteleport.api.logger;

import net.shibacraft.simplechunkteleport.SimpleChunkTeleport;
import net.shibacraft.simplechunkteleport.api.chat.TextColor;
import org.bukkit.Bukkit;

public class CoreLogger {

    public static final String LOGGER_NAME = "&d&lSimpleChunkTeleport";
    private static final SimpleChunkTeleport simpleChunkTeleport = SimpleChunkTeleport.getPlugin();

    public static void warn(String message) {
        simpleChunkTeleport.getLogger().warning(LOGGER_NAME + " | " + message);
    }

    public static void severe(String message) {
        simpleChunkTeleport.getLogger().severe(LOGGER_NAME + " | " + message);
    }

    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage(TextColor.color(LOGGER_NAME + "&8 | &r" + message));
    }

}
