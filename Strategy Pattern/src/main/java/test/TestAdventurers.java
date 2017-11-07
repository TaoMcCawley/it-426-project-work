package test;

import adventurers.Adventurer;
import adventurers.AdventurerType;
import adventurers.GearedAdventurer;
import behaviors.AggressiveBehavior;
import behaviors.NobleBehavior;
import behaviors.TimidBehavior;
import tools.ArchaeologicalTool;
import tools.TrowelTool;

public class TestAdventurers
{
    public static void main(String[] args)
    {
        //squire
        Adventurer squire = new Adventurer("Jeff", AdventurerType.SQUIRE,
                                           new TimidBehavior());
        squire.takeAction();

        //we can dynamically alter the behavior of our Adventurer class
        squire = new Adventurer("Lydia", AdventurerType.SQUIRE,
                                new NobleBehavior());
        squire.takeAction();

        GearedAdventurer knight = new GearedAdventurer("Robyn",
                AdventurerType.KNIGHT, new TimidBehavior(), new TrowelTool());

        //act timid with a trowel!
        knight.takeAction();
        knight.useTool();

        knight = new GearedAdventurer("Brianne", AdventurerType.KNIGHT,
                new AggressiveBehavior(), new ArchaeologicalTool());

        //act aggressive with an archaeological tool!
        knight.takeAction();
        knight.useTool();
    }
}
