import java.util.Scanner;

public class Invoice
{   
	private String number;     //Numero do item
	private String descrition; //Descricao do item
	private int quantityItem;  //Quantidade de itens
	private double priceItem;     //Preco por item
	
	//Construtor da classe Invoice
	public Invoice(String num, String des, int qtt, double price)
	{
		number = num;
		descrition = des;
		quantityItem = qtt;
		
		if(price < 0)
			priceItem = 0.0;
		else
			priceItem = price;
	}

	//Métodos set
	public void setNumber(String num) { number = num; }
	public void setDescrition(String des) { descrition = des; }
	public void setQuantityItem(int qtt) { quantityItem = qtt; }
	public void setPriceItem(double price) { priceItem = price; }
	
	//Métodos get
	public String getNumber() { return number; }
	public String getDescrition() { return descrition; }
	public int getQuantityItem() { return quantityItem; }
	public double getPriceItem() { return priceItem; }

	//Calcula o valor fa fatura
	public double getInvoiceAmount()
	{
		if(quantityItem*priceItem < 0)
			return(0);
		else
			return(quantityItem*priceItem);
	}
	
}