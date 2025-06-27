import java.io.IOException;
import java.util.ArrayList;

public class testExcel {

	public static void main(String[] args) throws IOException {

		dataDriven dd = new dataDriven();
		ArrayList<String> list = dd.getData("Add Profile");
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
	}

}
