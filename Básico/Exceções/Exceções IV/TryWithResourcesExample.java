public class TryWithResourcesExample

	public static void main(String[] args) throws IOException 
	{
		try(FileInputStream     input         = new FileInputStream("file.txt");
			BufferedInputStream bufferedInput = new BufferedInputStream(input)
			)
		{
			int data = bufferedInput.read();
			while(data != -1){
				System.out.print((char) data);
			data = bufferedInput.read();
		}
	}
}