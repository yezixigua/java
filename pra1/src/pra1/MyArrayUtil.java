package pra1;

public class MyArrayUtil {
	public static void main(String args[]) {
		System.out.println("hello");
		
//		double[] arr = new double[] {10.0, 20.0, 30.0, 40.0};
//		printArray(arr);
		
		printMulTable();
	}
	
	
	public static void printArray(double arr[]) {
		if(arr == null){
			System.out.println("null");
			return;
		}
		
		String ret = "[";
		for(int index = 0; index < arr.length; index++) {
			ret = ret + arr[index];
			
			if(index != arr.length - 1) {
				ret = ret + ", ";
			}
		}
		ret = ret + "]";
		System.out.println(ret);
		return;
		
	
	}  
	
	
	public static void printMulTable() {
		
		
		for(int i = 1; i < 10; i++){
			
			for(int j = i; j < 10; j++){
				System.out.print(i + " * " + j + " = " + i * j + "; ");
			}
			System.out.println();
		}
		
		   
	}
	
}











