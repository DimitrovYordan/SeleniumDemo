
public class Objects {

	public static void main(String[] args) {
		
		// String is Object represent niz of characters
		// запазва само 1 място в паметта и 2те променливи сочат към това място
		//String text = "Welcome text";
		String text2 = "Welcome text";
		
		// за всяка променлива запазва ново място в паметта
		String text3 = new String("Welcome");
		String text4 = new String("Welcome");

		String text = "Welcome text";		
		String[] splittedString = text.split(" ");
		for (int i = 0; i < text.length(); i++) {
			System.out.println(text.charAt(i));
		}
		
		for (int i = text.length()-1; i >= 0 ; i--) {
			System.out.println(text.charAt(i));
		}

	}

}
