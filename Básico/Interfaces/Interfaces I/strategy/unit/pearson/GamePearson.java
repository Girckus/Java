package strategy.unit.pearson;

import strategy.behavior.DefenseBehavior;
import strategy.unit.GameUnit;

public abstract class GamePearson extends GameUnit
{
	private DefenseBehavior defenseBehavior;

	public DefenseBehavior getDefenseBehavior()
	{
		return defenseBehavior;
	}

	public void setDefenseBehavior(DefenseBehavior defenseBehavior)
	{
		this.defenseBehavior = defenseBehavior;
	}

	public void speak()
	{
		System.out.println("Blah blah blah");
	}

	public void defense()
	{
		this.defenseBehavior.defense();
	}

	public void performActions()
	{
		super.performActions();
		defense();
		speak();
	}
}
