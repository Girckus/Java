package strategy.behavior.shooting;

import strategy.behavior.ShootingBehavior;

public class NoShoot implements ShootingBehavior
{
	public void shoot()
	{
		System.out.println("I cant shoot");
	}
}
