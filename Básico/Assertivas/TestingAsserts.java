import javax.swing.JOptionPane;

public class TestingAsserts
{
	public static void main(String[] args)
	{
		if( args.length == 0)
			JOptionPane.showMessageDialog(null, "Entrada Invalida", "Erro", JOptionPane.ERROR_MESSAGE);
		else
		{
			for( String number : args )
			{
				assert( number.equals("0") ) : "0 Diitado";
				System.out.println(number);
			}
		}
	}
}