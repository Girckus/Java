package strategy.behavior.shooting;

import strategy.behavior.ShootingBehavior;

public class ThrowKnifes implements ShootingBehavior
{

	@Override
	public void shoot()
	{
		System.out.println("Throwing Knives");
	}

}
