package com.palmergames.bukkit.towny.war.siegewar.utils;

import com.palmergames.bukkit.towny.TownySettings;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.war.siegewar.locations.Siege;
import com.palmergames.util.TimeMgmt;

/**
 * @author Goosius
 */
public class SiegeWarTimeUtil {

	public static void activateSiegeImmunityTimer(Town town, Siege siege) {
        double siegeDuration = siege.getActualEndTime() - siege.getStartTime();
        double cooldownDuration = siegeDuration * TownySettings.getWarSiegeSiegeImmunityTimeModifier();
        town.setSiegeImmunityEndTime(System.currentTimeMillis() + (long)(cooldownDuration + 0.5));
    }

	public static void activateRevoltImmunityTimer(Town town) {
        long immunityDuration = (long)(TownySettings.getWarSiegeRevoltImmunityTimeHours() * TimeMgmt.ONE_HOUR_IN_MILLIS);
        town.setRevoltImmunityEndTime(System.currentTimeMillis() + immunityDuration);
    }
}
