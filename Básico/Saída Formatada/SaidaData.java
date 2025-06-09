import java.util.Calendar;

public class SaidaData
{
	public static void main(String[] args)
	{
		Calendar data = Calendar.getInstance();
		System.out.printf("%1$tz %1$tD %1$tr\n", data);
		System.out.printf("%1$tz %1$tB %1$tm %1$tY %1$tT\n", data);
		System.out.printf("%1$tF day-of-the-month:%1$td\n", data);
		System.out.printf("%tF day-of-the-year:%d\n", data, data.get(data.DAY_OF_YEAR));
		System.out.printf("%1$ta %1$tb %1$td %1$tT %1$tz\n", data);
	}
}