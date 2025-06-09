import java.util.Scanner;

public class Date
{   
	private int day;   //Dia 
	private int month; //Mes
	private int year;  //Ano
	
	//Construtor da classe Date
	public Date(int d, int m, int y)
	{
		//Inicializa month
		if((m < 1) || m > 12)
			month = 1;
		else
			month = m;
		
		
		//Inicializa year
		if(y < 0)
			year = 0;
		else
			year = y;
		
		
		//Inicializa day
		if((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12))
		{
			if((d < 1) || (d > 31))
				day = 1;
			else
				day = d;
		}
		
		if((month == 4) || (month == 6) || (month == 9) || (month == 11))
		{
			if((d < 1) || (d > 30))
				day = 1;
			else
				day = d;
		}
		
		if(month == 2)
		{
			//Verifica se o ano e bissexto
			if((year % 4) == 0)
			{
				if((d < 1) || (d > 29))
					day = 1;
				else
					day = d;
			}
			else
			{
				if((d < 1) || (d > 28))
					day = 1;
				else
					day = d;			
			}
		}
		
	}

	//Metodos set
	public void setDay(int d) { day = d; }
	public void setMonth(int m) { month = m; }
	public void setYear(int y) { year = y; }
	
	//Metodos get
	public int getDay() { return day; }
	public int getMonth() { return month; }
	public int getYear() { return year; }
	
	//Metodo para exibir a dara
	public void displayData()
	{
		System.out.printf("%02d/%02d/%04d", day, month, year);
	}
}