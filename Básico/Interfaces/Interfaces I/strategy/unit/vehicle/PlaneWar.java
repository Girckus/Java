package strategy.unit.vehicle;

import strategy.behavior.shooting.MachineGunShoot;
import strategy.unit.GameUnit;

public class PlaneWar extends GameUnit
{

	public PlaneWar()
	{
		this.setShootingBehavior(new MachineGunShoot());
	}

	@Override
	public void display()
	{
		System.out.println("Displaying PlaneWar");
	}

}
