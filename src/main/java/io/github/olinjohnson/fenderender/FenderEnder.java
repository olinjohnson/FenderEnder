package io.github.olinjohnson.fenderender;

import org.bukkit.plugin.java.JavaPlugin;

public final class FenderEnder extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("FenderEnder enabled!");
        getServer().getPluginManager().registerEvents(new EnderDragonController(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("FenderEnder shutting down!");
    }
}
