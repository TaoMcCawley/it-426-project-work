package adventurers;

import behaviors.IBehavior;
import tools.ITool;

public class Adventurer implements IBehavior
{
    private String name;
    private AdventurerType type;

    //store a family of algorithms
    private IBehavior behavior;

    public Adventurer(String name, AdventurerType type,
                      IBehavior behavior)
    {
        this.name = name;
        this.type = type;
        this.behavior = behavior;
    }

    public String getName()
    {
        return name;
    }

    public AdventurerType getType()
    {
        return type;
    }

    @Override
    public void takeAction()
    {
        behavior.takeAction();
    }

    @Override
    public String toString()
    {
        return "Adventurer{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
