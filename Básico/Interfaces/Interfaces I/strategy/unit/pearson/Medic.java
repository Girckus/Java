package strategy.unit.pearson;

import strategy.behavior.defense.HideDefense;
import strategy.behavior.shooting.NoShoot;

public class Medic extends GamePearson
{

	public Medic()
	{
		this.setShootingBehavior(new NoShoot());
		this.setDefenseBehavior(new HideDefense());
	}

	@Override
	public void display()
	{
		System.out.println("Displaying Medic");
	}

}
