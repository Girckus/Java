package strategy.unit.vehicle;

import strategy.behavior.shooting.TankGunShoot;
import strategy.unit.GameUnit;

public class Tank extends GameUnit
{
	public Tank()
	{
		this.setShootingBehavior(new TankGunShoot());
	}

	public void display()
	{
		System.out.println("Displaying Tank");
	}
}
