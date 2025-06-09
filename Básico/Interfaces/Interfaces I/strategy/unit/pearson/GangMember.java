package strategy.unit.pearson;

import strategy.behavior.defense.CallBrosDefense;
import strategy.behavior.shooting.ThrowKnifes;

public class GangMember extends GamePearson
{

	public GangMember()
	{
		this.setShootingBehavior(new ThrowKnifes());
		this.setDefenseBehavior(new CallBrosDefense());
	}

	@Override
	public void display()
	{
		System.out.println("Displaying Gang Member");
	}

}
