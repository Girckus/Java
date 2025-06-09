package strategy.unit.pearson;

import strategy.behavior.defense.RunDefense;
import strategy.behavior.shooting.NoShoot;

public class Civilian extends GamePearson
{
	public Civilian()
	{
		this.setShootingBehavior(new NoShoot());
		this.setDefenseBehavior(new RunDefense());
	}

	@Override
	public void display()
	{
		System.out.println("Displaying Civilian");
	}

}
