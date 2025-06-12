import org.testng.annotations.Test;

public class Parent_Class_2 extends Parent_Class {

	@Test
	public void testRun() {
		
		int num = 3;
		Parent_Class_3 pc3 = new Parent_Class_3(num);
		doThis();
		
		System.out.println(pc3.Increment());
		System.out.println(pc3.Decrement());
		
		//Parent_Class_4 pc4 = new Parent_Class_4(num);
		System.out.println(pc3.MultiplyByTwo());
	}

}
