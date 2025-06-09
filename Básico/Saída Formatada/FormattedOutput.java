public class FormattedOutput {

	public static void main(String[] args) {
		System.out.println(String.format("%b %b %b", true, false, null));
        System.out.println(String.format("%B %B %B", true, false, null));
        System.out.println(String.format("%h", new String("blohblah")));
        System.out.println(String.format("%H", new String("blohblah")));
        System.out.println(String.format("%s", new String("blohblah")));
        System.out.println(String.format("%S", new String("blohblah")));
        System.out.println(String.format("%-10s", new String("zzz")));
        System.out.println(String.format("%10s", new String("zzz")));
        System.out.println(String.format("%.2s", new String("zzz")));

        System.out.println(String.format("%c", 'r'));
        // System.out.println(String.format("%C", 'r'));

        System.out.println(String.format("%d", 1000));
        System.out.println(String.format("%+d", 1000));
        System.out.println(String.format("%+d", -1000));
        System.out.println(String.format("% 4d", 1000));
        System.out.println(String.format("% 4d", -1000));
        System.out.println(String.format("%05d", 1000));
        System.out.println(String.format("%05d", -1000));
        System.out.println(String.format("%,4d", 1000));
        System.out.println(String.format("%,4d", -1000));
        System.out.println(String.format("%(4d", 1000));
        System.out.println(String.format("%(4d", -1000));
        System.out.println();
        System.out.println(String.format("%o", 1000));
        System.out.println(String.format("%05o", 1000));
        System.out.println(String.format("%05o", -1000));
        System.out.println(String.format("%#o", 1000));
        System.out.println(String.format("%#o", -1000));
        System.out.println();
        System.out.println(String.format("%x", 1000));
        System.out.println(String.format("%05X", 1000));
        System.out.println(String.format("%05x", -1000));
        System.out.println(String.format("%#x", 1000));
        System.out.println(String.format("%#X", -1000));

        System.out.println(String.format("%e", 100.03));
        System.out.println(String.format("%E", 765623789657891234.91782634789));
        System.out.println(String.format("%-20e", 765623789657891234.91782634789));
        System.out.println(String.format("%#20E", 765623789657891234.91782634789));
        System.out.println(String.format("%+20e", 765623789657891234.91782634789));
        System.out.println(String.format("% 20E", 765623789657891234.91782634789));
        System.out.println(String.format("%020e", 765623789657891234.91782634789));
        System.out.println(String.format("%(20E", 765623789657891234.91782634789));
        System.out.println(String.format("%(20e", -765623789657891234.91782634789));
        System.out.println();
        System.out.println(String.format("%g", 100.03));
        System.out.println(String.format("%g", 765623789657891234.91782634789));
        System.out.println(String.format("%G", -765623789657891234.91782634789));
        System.out.println(String.format("%-20g", 765623789657891234.91782634789));
        System.out.println(String.format("%,20G", 1000.1));
        System.out.println(String.format("%+20g", 765623789657891234.91782634789));
        System.out.println(String.format("% 20G", 765623789657891234.91782634789));
        System.out.println(String.format("%020g", 765623789657891234.91782634789));
        System.out.println(String.format("%(20G", 765623789657891234.91782634789));
        System.out.println(String.format("%(20g", -765623789657891234.91782634789));
        System.out.println();
        System.out.println(String.format("%f", 100.03));
        System.out.println(String.format("%2$f %1$f", 100.01, 100.02));
        System.out.println(String.format("%2$f %3$f %1$f", 100.01, 100.02, 100.03));
        System.out.println(String.format("%f", 7656237871234.9174789));
        System.out.println(String.format("%f", -7656237871234.9174789));
        System.out.println(String.format("%5.2f", 7656237871234.9174789));
        System.out.println(String.format("%5.1f", -7656237871234.9174789));
        System.out.println(String.format("%-30.7f", 7656237871234.9174789));
        System.out.println(String.format("%,30f", 7656237871234.9174789));
        System.out.println(String.format("%+30.7f", 7656237871234.9174789));
        System.out.println(String.format("% 30f", 7656237871234.9174789));
        System.out.println(String.format("%030.5f", 7656237871234.9174789));
        System.out.println(String.format("%(30.6f", 7656237871234.9174789));
        System.out.println(String.format("%(30f", -7656237871234.9174789));
        System.out.println();
        System.out.println(String.format("%a", 100.03));
        System.out.println(String.format("%a", 765623789657891234.91782634789));
        System.out.println(String.format("%A", -765623789657891234.91782634789));
        System.out.println(String.format("%-20a", 765623789657891234.91782634789));
        System.out.println(String.format("%+20a", 765623789657891234.91782634789));
        System.out.println(String.format("% 20A", 765623789657891234.91782634789));
        System.out.println(String.format("%020a", 765623789657891234.91782634789));
	}

}
