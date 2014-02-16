package com.github.procheattv.TutorialPlugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TutorialCommandExecutor implements CommandExecutor 
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) 
	{
		if(cmd.getName().equalsIgnoreCase("heile"))
		{
			if(sender instanceof Player)
			{
				Player p = (Player) sender;
				try
				{
					p.setHealth(Double.parseDouble(args[0])*2.0D);
					p.sendMessage(ChatColor.GREEN + "Du wurdest geheilt!");
				}
				catch(Exception e)
				{
					p.sendMessage(ChatColor.RED + "Du musst eine Zahl eingeben. Beispiel: /heile 10 und nicht /heile zehn!");
					return false;
				}	
				return true;
			}
			else
			{
				sender.sendMessage(ChatColor.RED + "Du musst ein Spieler sein");
				return false;
			}
		}
		if(cmd.getName().equalsIgnoreCase("mehrherz"))
		{
			if(sender instanceof Player)
			{
				Player p = (Player) sender;
				try
				{
					p.setMaxHealth(Double.parseDouble(args[0])*2.0D);
					p.sendMessage(ChatColor.BLUE + "Deine Herzen wurden auf " + args[0] + " Herzen hinaufgesetzt!");
				}	
				catch(Exception e)
				{
					p.sendMessage(ChatColor.RED + "Du musst eine Zahl eingeben. Beispiel: /mehrherz 100 und nicht /mehrherz hundert!");
					return false;
				}
				return true;
			}
			else
			{
				sender.sendMessage(ChatColor.RED + "Du musst ein Spieler sein");
				return false;
			}
		}
		if(cmd.getName().equalsIgnoreCase("tpplayer"))
		{
			if(sender instanceof Player)
			{
				Player p = (Player) sender;
				try
				{
					if(Bukkit.getServer().getPlayer(args[0]) != null)
					{
						Player tpp = Bukkit.getServer().getPlayer(args[0]);
						p.teleport(tpp);
						p.sendMessage(ChatColor.BLUE + p.getDisplayName() + " erfolgreich zu " + args[0] + " teleportiert!");
						tpp.sendMessage(ChatColor.GREEN + p.getDisplayName() + " hat sich erfolgreich zu dir teleportiert!");
					}
					else
					{
						double xpos = Double.parseDouble(args[0]);
						double ypos = Double.parseDouble(args[1]);
						double zpos = Double.parseDouble(args[2]);
						
						if(!(xpos > 29999999 || ypos > 29999999 || zpos > 29999999 || xpos < -29999999 || ypos < -29999999 || zpos < -29999999))
						{
							p.teleport(new Location(p.getWorld(), xpos, ypos, zpos));
							p.sendMessage(ChatColor.BLUE + p.getDisplayName() + " erfolgreich zu " + args[0] + ", " + args[1] + ", " + args[2] + " teleportiert!");
						}
						else
						{
							p.sendMessage(ChatColor.RED + "Koordinaten zu gro§! Maximum der Welt erreicht.");
						}
					}
				}	
				catch(Exception e)
				{
					p.sendMessage(ChatColor.RED + "Interner Fehler: Passe auf, dass der Spieler existiert oder die Koordinaten in einem Zahlenformat eingegeben wurden!");
					return false;
				}
				return true;
			}
			else
			{
				sender.sendMessage(ChatColor.RED + "Du musst ein Spieler sein");
				return false;
			}
		}
		return false;
	}

}
