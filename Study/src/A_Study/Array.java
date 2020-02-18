package A_Study;

public class Array {
	public static void main(String[] args) {
		
		/*
		 * int[] array = new int[50]; for (int i = 0; i < array.length; i++) { array[i]
		 * = 2 * i + 1; System.out.println(array[i]); } System.out.println(array);
		 * 
		 * int a = 1; for (int i = 1; i < 100; i++){ a =
		 * ++a;//++在前，先自增在备份，结果是100；++在后，先备份，再自增，结果是1。每次赋值都是备份的值 }
		 * System.out.println(a);
		 */
		int[] a = {1,2};
        int[] b = {3,4};
        int[] c = a;
        a = b;
        b = c;
        for (int v : a){
            System.out.println(v);
        }
        for (int v : b){
            System.out.println(v);
        }
	}
}
