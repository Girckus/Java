import java.util.Scanner;

public class VendasTotais
{
	private int[][] vendas;
	
	public VendasTotais()
	{
		Scanner input = new Scanner( System.in );
	
		vendas = new int[4][];
		
		for( int i = 0; i < 4; i++)
		{
			vendas[i] = new int[5];
			
			for( int j = 0; j < 5; j++ )
			{
				System.out.printf("vendedor %d Produto %d: ", i, j);
				vendas[i][j] = input.nextInt();
				System.out.println();
			}
		}
	}
	
	public void print()
	{
		int[] somaVendedor = new int[4];
		int[] somaProduto = new int[5];
		
		somaVetor( somaVendedor, 0 );
		somaVetor( somaProduto, 1 );
		
		System.out.println("\t  Vendedor1   Vendedor2   Vendedor3   Vendedor4   Total");
		for( int i = 0; i < 5; i++)
		{
			System.out.printf("Produto%d", (i+1) );
			for( int j = 0; j < 4; j++ )
			{
				if( j == 0)
					System.out.printf("%7d", vendas[j][i] );
				else
					System.out.printf("%12d", vendas[j][i] );
			}
			System.out.printf("%11d", somaProduto[i] );
			System.out.println();
		}
		System.out.print("Total   ");
		for( int j = 0; j < 4; j++ )
		{
			if( j == 0)
				System.out.printf("%7d", somaVendedor[j] );
			else
				System.out.printf("%12d", somaVendedor[j] );
		}	
	}
	
	//op = 0 --> Soma todas as colunas
	//op = 1 --> Soma todas as linhas
	public void somaVetor( int[] vetor, int op )
	{
		int soma = 0;
		
		if( op == 0 )
		{
			for( int i = 0; i < 4; i++ )
			{
				soma = 0;
				for( int j = 0; j < 5; j++ )
					soma += vendas[i][j];
				vetor[i] = soma;
			}
		}
		if( op == 1 )
		{
			for( int i = 0; i < 5; i++ )
			{
				soma = 0;
				for( int j = 0; j < 4; j++ )
					soma += vendas[j][i];
				vetor[i] = soma;
			}
		}
	}
	
	public static void main(String[] args)
	{
		VendasTotais vendas = new VendasTotais();
		
		vendas.print();
	}
}