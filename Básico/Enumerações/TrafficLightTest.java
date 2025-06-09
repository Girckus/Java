//Capítulo 08 Exercicio 8.11: Testando a classe enum TrafficLight

import java.util.EnumSet;

public class TrafficLightTest
{
	public static void main( String args[] )
	{
		for( TrafficLight farol : TrafficLight.values() )
			System.out.println(farol);
	}
}