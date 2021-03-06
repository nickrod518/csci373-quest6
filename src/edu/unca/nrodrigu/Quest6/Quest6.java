package edu.unca.nrodrigu.Quest6;

import org.bukkit.plugin.java.JavaPlugin;

public class Quest6 extends JavaPlugin {
	/*
	 * This is called when your plug-in is enabled
	 */
	@Override
	public void onEnable() {
		// save the configuration file
		saveDefaultConfig();

		// set the command executor for sample
		this.getCommand("cake").setExecutor(new Quest6CommandExecutor(this));
		this.getCommand("pit").setExecutor(new Quest6CommandExecutor(this));
		this.getCommand("midas").setExecutor(new Quest6CommandExecutor(this));
		this.getCommand("zdefend").setExecutor(new Quest6CommandExecutor(this));
	}

	/*
	 * This is called when your plug-in shuts down
	 */
	@Override
	public void onDisable() {

	}
	
}