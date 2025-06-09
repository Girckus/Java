package strategy.unit.pearson;

import strategy.behavior.defense.RunDefense;
import strategy.behavior.shooting.NoShoot;

public class Engineer extends GamePearson
{
	public Engineer()
	{
		this.setShootingBehavior(new NoShoot());
		this.setDefenseBehavior(new RunDefense());
	}

	@Override
	public void display()
	{
		System.out.println("Displaying Engineer");

	}

}
