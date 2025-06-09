package strategy;

import strategy.unit.pearson.Civilian;
import strategy.unit.pearson.Engineer;
import strategy.unit.pearson.GangMember;
import strategy.unit.pearson.Medic;
import strategy.unit.pearson.Soldier;
import strategy.unit.vehicle.BoatWar;
import strategy.unit.vehicle.HelicopterWar;
import strategy.unit.vehicle.PlaneWar;
import strategy.unit.vehicle.Tank;

public class TestStrategy
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("------------------------------------");
		Tank tank = new Tank();
		tank.performActions();
		System.out.println("------------------------------------");
		BoatWar boat = new BoatWar();
		boat.performActions();
		System.out.println("------------------------------------");
		HelicopterWar helicopter = new HelicopterWar();
		helicopter.performActions();
		System.out.println("------------------------------------");
		PlaneWar plane = new PlaneWar();
		plane.performActions();
		System.out.println("------------------------------------");
		Soldier soldier = new Soldier();
		soldier.performActions();
		System.out.println("------------------------------------");
		Civilian civil = new Civilian();
		civil.performActions();
		System.out.println("------------------------------------");
		Engineer engineer = new Engineer();
		engineer.performActions();
		System.out.println("------------------------------------");
		Medic medic = new Medic();
		medic.performActions();
		System.out.println("------------------------------------");
		GangMember gang = new GangMember();
		gang.performActions();
	}

}
