package strategy.unit.vehicle;

import strategy.behavior.shooting.MachineGunShoot;
import strategy.unit.GameUnit;

public class HelicopterWar extends GameUnit
{

	public HelicopterWar()
	{
		this.setShootingBehavior(new MachineGunShoot());
	}

	public void display()
	{
		System.out.println("Displaying HelicopterWar");
	}
}
