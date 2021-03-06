package net.shibacraft.simplechunkteleport.api.banner;

import net.shibacraft.simplechunkteleport.SimpleChunkTeleport;
import net.shibacraft.simplechunkteleport.api.loader.Loader;
import net.shibacraft.simplechunkteleport.api.logger.CoreLogger;

public class Banner implements Loader {

    private final SimpleChunkTeleport plugin;

    public Banner(SimpleChunkTeleport plugin) {
        this.plugin = plugin;
    }

    @Override
    public void load() {
        CoreLogger.log("&5Plugin: &e" + plugin.getName());
        CoreLogger.log("&fAuthor: &e" + plugin.getDescription().getAuthors().get(0));
        CoreLogger.log("&fVersion: &e" + plugin.getDescription().getVersion());
    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

    }

}
