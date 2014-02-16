package com.github.procheattv.TutorialPlugin;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.procheattv.TutorialPlugin.Commands.TutorialCommandExecutor;
import com.github.procheattv.TutorialPlugin.Listener.TutorialLoginListener;

public class TutorialPlugin extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		getLogger().info(ChatColor.GREEN + "Plugin erfolgreich aktiviert!");
		this.getCommand("heile").setExecutor(new TutorialCommandExecutor());
		this.getCommand("mehrherz").setExecutor(new TutorialCommandExecutor());
		this.getCommand("tpplayer").setExecutor(new TutorialCommandExecutor());
		this.getServer().getPluginManager().registerEvents(new TutorialLoginListener(this), this);
	}
	
	@Override
	public void onDisable()
	{
		getLogger().info("Plugin deaktiviert!");
	}
}
