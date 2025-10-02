package algorithm.exercises;

public class ReduceWithMinimalOperations {

	public static void main(String[] args) {

		int n = 15;
		int[] operations = new int[n + 1];
		operations[0] = 0;
		operations[1] = 0;
		for (int i = 2; i < operations.length; i++) {
			operations[i] = 0;
		}
		int minOperations = calculate(n, operations);
		System.out.println("minOperations="+minOperations);
	}

	private static int calculate(int n, int[] operations) {
		int op = 0;
		if (n % 2 == 0) {
			int nextValue = n/2;
			System.out.println(String.format("%d value is even, next %d ", n, nextValue));
			op = calculateNext(operations, nextValue);
		} else {
			int nextValue1 = (n+1)/2;
			int nextValue2 = (n-1)/2;
			System.out.println(String.format("%d value is odd, increment 1 operation next %d or %d ", n, nextValue1, nextValue2));
			int result1 = calculateNext(operations, nextValue1);
			int result2 = calculateNext(operations, nextValue2);
			if(result1 > result2){
				System.out.println(String.format("%d value is odd, next %d ", n, nextValue2));
				op = result2;
			} else {
				System.out.println(String.format("%d value is odd, next %d ", n, nextValue1));
				op = result1;
			}
			op++;
			
		}
		operations[n] = 1+op;
		//System.out.println(String.format("for value %d operation is %d", n, operations[n]));
		return 1+op;
	}

	private static int calculateNext(int[] operations, int nextValue) {
		int op = 0;
		if(nextValue > 1 && operations[nextValue] == 0){
			op = calculate(nextValue, operations);
			
		} else {
			op = operations[nextValue];
			
		}
		return op;
	}

}
