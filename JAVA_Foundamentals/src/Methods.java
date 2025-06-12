
public class Methods {

	public static void main(String[] args) {
		
		Methods m = new Methods();
		m.printLine();
		SecondMethods m2 = new SecondMethods();
		String text = m2.printLine();
		System.out.println(text);
		System.out.println(printStaticLine());
		
	}
	
	public void printLine()
	{
		System.out.println("Hello world!");
	}
	
	public static String printStaticLine() {
		return "Static text";
	}

}
