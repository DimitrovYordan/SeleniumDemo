
public class Parent_Class_3 extends Parent_Class_4{

	int num;
	public Parent_Class_3(int num) {
		super(num);
		this.num = num;
	}

	public int Increment() {
		
		num = num + 1;
		return num;
	}
	
	public int Decrement() {
		
		num = num - 1;
		return num;
	}
}
