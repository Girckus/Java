package strategy.unit;

import strategy.behavior.ShootingBehavior;

public abstract class GameUnit
{

	private ShootingBehavior shootingBehavior;

	public ShootingBehavior getShootingBehavior()
	{
		return shootingBehavior;
	}

	public void setShootingBehavior(ShootingBehavior shootingBehavior)
	{
		this.shootingBehavior = shootingBehavior;
	}

	public void shoot()
	{
		this.shootingBehavior.shoot();
	}

	public void run()
	{
		System.out.println("Running...");
	}

	public void performActions()
	{
		display();
		shoot();
		run();
	}

	public abstract void display();
}
