package com.github.procheattv.TutorialPlugin;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public class TutorialPlugin extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		getLogger().info(ChatColor.GREEN + "Plugin erfolgreich aktiviert!");
	}
	
	@Override
	public void onDisable()
	{
		getLogger().info("Plugin deaktiviert!");
	}
}
