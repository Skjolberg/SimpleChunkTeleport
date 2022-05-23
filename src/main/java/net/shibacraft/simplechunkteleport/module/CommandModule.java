package net.shibacraft.simplechunkteleport.module;

import net.shibacraft.simplechunkteleport.SimpleChunkTeleport;
import net.shibacraft.simplechunkteleport.api.loader.Loader;
import net.shibacraft.simplechunkteleport.commands.MainCommand;

public class CommandModule implements Loader {

    SimpleChunkTeleport plugin;

    public CommandModule(SimpleChunkTeleport plugin){
        this.plugin = plugin;
    }

    @Override
    public void load() {
        plugin.getCommand("SimpleChunkTeleport").setExecutor(new MainCommand(plugin));
        plugin.getCommand("SimpleChunkTeleport").setPermission("sct.use");
    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

    }
}
