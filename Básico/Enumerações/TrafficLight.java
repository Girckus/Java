//Capítulo 08 Exercicio 8.11: Enumeracoes de sinal de farol de trafego

public enum TrafficLight
{
	RED(30),
	YELLOW(10),
	GREEN(20);
	
	private int time;
	
	TrafficLight(int time)
	{
		this.time = time;
	}
	
	public int getTime() { return time; }
	
	public String toString()
	{
		return ( String.format("%6s: %d seconds", name(), getTime()) );
	}
}