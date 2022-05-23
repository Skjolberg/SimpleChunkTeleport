package net.shibacraft.simplechunkteleport.module;

import net.shibacraft.simplechunkteleport.SimpleChunkTeleport;
import net.shibacraft.simplechunkteleport.api.banner.Banner;
import net.shibacraft.simplechunkteleport.files.FileManager;
import net.shibacraft.simplechunkteleport.api.loader.Loader;

public class MainModule implements Loader {

    private final SimpleChunkTeleport plugin;

    public MainModule(SimpleChunkTeleport plugin) {
        this.plugin = plugin;
    }

    @Override
    public void load() {
        Banner banner = new Banner(plugin);
        banner.load();
        FileManager fileManager = new FileManager(plugin);
        fileManager.load();
        CommandModule commandModule = new CommandModule(plugin);
        commandModule.load();

    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

    }
}
