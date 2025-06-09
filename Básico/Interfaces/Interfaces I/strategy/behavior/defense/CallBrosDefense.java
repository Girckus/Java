package strategy.behavior.defense;

import strategy.behavior.DefenseBehavior;

public class CallBrosDefense implements DefenseBehavior
{

	@Override
	public void defense()
	{
		System.out.println("If you atack me I'll call my gang bros");
	}

}
