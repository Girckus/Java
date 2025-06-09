package strategy.behavior.shooting;

import strategy.behavior.ShootingBehavior;

public class TankGunShoot implements ShootingBehavior
{

	@Override
	public void shoot()
	{
		System.out.println("Shooting with a gun tank");
	}

}
