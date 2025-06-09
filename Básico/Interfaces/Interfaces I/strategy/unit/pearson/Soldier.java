package strategy.unit.pearson;

import strategy.behavior.defense.HideDefense;
import strategy.behavior.shooting.NormalShoot;

public class Soldier extends GamePearson
{
	public Soldier()
	{
		this.setShootingBehavior(new NormalShoot());
		this.setDefenseBehavior(new HideDefense());
	}

	@Override
	public void display()
	{
		System.out.println("Displaying Soldier");
	}
}
