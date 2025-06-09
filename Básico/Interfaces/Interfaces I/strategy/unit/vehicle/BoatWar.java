package strategy.unit.vehicle;

import strategy.behavior.shooting.MachineGunShoot;
import strategy.unit.GameUnit;

public class BoatWar extends GameUnit
{

	public BoatWar()
	{
		this.setShootingBehavior(new MachineGunShoot());
	}

	public void display()
	{
		System.out.println("Displaying BoatWar");
	}

}
