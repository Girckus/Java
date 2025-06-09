import java.util.Date;

public class FormattedOutput2 {

	public static void main(String[] args) {
		Date hoje = new Date();
		
		System.out.println(String.format("R %tR\n", hoje));
		System.out.println(String.format("I %tI\n", hoje));
		System.out.println(String.format("k %tk\n", hoje));
		System.out.println(String.format("l %tl\n", hoje));
		System.out.println(String.format("M %tM\n", hoje));
		System.out.println(String.format("S %tS\n", hoje));
		System.out.println(String.format("L %tL\n", hoje));
		System.out.println(String.format("N %tN\n", hoje));
		System.out.println(String.format("p %tp\n", hoje));
		System.out.println(String.format("z %tz\n", hoje));
		System.out.println(String.format("Z %tZ\n", hoje));
		System.out.println(String.format("s %ts\n", hoje));
		System.out.println(String.format("Q %tQ\n", hoje));
		System.out.println(String.format("B %tB\n", hoje));
		System.out.println(String.format("b %tb\n", hoje));
		System.out.println(String.format("h %th\n", hoje));
		System.out.println(String.format("A %tA\n", hoje));
		System.out.println(String.format("a %ta\n", hoje));
		System.out.println(String.format("C %tC\n", hoje));
		System.out.println(String.format("Y %tY\n", hoje));
		System.out.println(String.format("y %ty\n", hoje));
		System.out.println(String.format("j %tj\n", hoje));
		System.out.println(String.format("m %tm\n", hoje));
		System.out.println(String.format("d %td\n", hoje));
		System.out.println(String.format("e %te\n", hoje));
		System.out.println(String.format("R %tR\n", hoje));
		System.out.println(String.format("T %tT\n", hoje));
		System.out.println(String.format("r %tr\n", hoje));
		System.out.println(String.format("D %tD\n", hoje));
		System.out.println(String.format("F %tF\n", hoje));
		System.out.println(String.format("c %tc\n", hoje));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(String.format("%4$s %3$s %2$s %1$s %4$s %3$s %2$s %1$s","a", "b", "c", "d"));
		System.out.println(String.format("%s %s %<s %<s", "a", "b", "c", "d"));
		System.out.println(String.format("%s %s %s %s", "a", "b", "c", "d"));
		System.out.println(String.format("%2$s %s %<s %s", "a", "b", "c", "d"));
	}

}