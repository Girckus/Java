package strategy.behavior.shooting;

import strategy.behavior.ShootingBehavior;

public class MachineGunShoot implements ShootingBehavior
{

	@Override
	public void shoot()
	{
		System.out.println("Shooting with a machine gun");
	}

}
