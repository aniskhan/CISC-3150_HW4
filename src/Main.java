import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/*
Write a program that given a two dimensional array of characters prints 
out the combination of every letter with every other letter. For eg, if 
you had:

{{a, b},{c, d},{e, f}}

Your output would be:
ace
acf
ade
adf
bce
bcf
bde
bdf

NOTE: 
1) Your program should be able to handle ANY two dimensional character 
array.

2) Get the 2D array at runtime. Either from the user or a file. To make 
your life easy, your file can have the following format:

3	//how many rows your arr[][] will have.
4	//length of your arr[0]
a b c d	//values of arr[0]
2	//length of your arr[1]
e f	//values of arr[1]
3	//length of your arr[2]
g h i	//values of arr[2]

The comments are there just to explain what each line means. Don"t put 
them in your data file.  This format will help you create your jagged 
arrays because it tells you the sizes of each one of them.

3) Do not use recursion.


Fun fact! This was a real interview question.*/

/*

NOTES

If I know the total number of combinations possible, I also know the number of
times each char(typed as String) will appear in the full set of combinations

Example {{"a"},{"b","c"},{"d"},{"e","f","g"}};

has 2 array with len 1
has 1 array with len 2
has 1 array with len 3

Total combinations = 1^2 * 2^1 * 3^1 = 6

In full combo set I will see "a"/"d" (each) 6x, "b"/"c" 3x, "e"/"f"/"g" 2x

aaaaaa
bcbcbc
dddddd
efgefg

This can now be manipulated to print to spec.


*/

public class Main {
   
	public static void main(String[] args) {

		String[][] my2DArray = {{"a"},{"b","c"},{"d"},{"e","f","g"}};
		Integer arrayCount = my2DArray.length;
		Integer subArrayLengths[] = new Integer [arrayCount];
		Integer counterArray[] = new Integer [arrayCount];
		Arrays.fill(counterArray, 0);
		//store subArray lengths
		for (int i = 0; i <= arrayCount-1; i++) {
			subArrayLengths[i] = (my2DArray[i].length);
		}
		//System.out.println(Arrays.toString(subArrayLengths));
		
		Map<Integer, Integer> subArrayLenFreq = new HashMap<Integer, Integer>();
		for (Integer idx = 0; idx <= subArrayLengths.length-1; idx++) {
			 Integer key = subArrayLengths[idx];
			 Integer value = subArrayLenFreq.get(key);
			 if (value == null) {
			     value = subArrayLenFreq.put(key, 1);
			 }else {
				 subArrayLenFreq.put(key, (value+1));
			 }
		}
		int ctPossCombos = 1;
		for (Map.Entry<Integer, Integer> entry : subArrayLenFreq.entrySet()) {
			Integer k = entry.getKey();
			Integer v = entry.getValue();
			ctPossCombos = ctPossCombos * (int)Math.pow(k, v);
			//System.out.println(k.toString() + ":" + v.toString());
		}
		System.out.println(ctPossCombos + " combinations:");
		
		int counter = 1;
		String combHolder[][]= new String [arrayCount][ctPossCombos];
		for (int r = 0; r <= arrayCount-1; r++) {
			String s = "";
			while (counter <= ctPossCombos/subArrayLengths[r]) {
				for(int k = 0; k <= subArrayLengths[r]-1; k++ ) {
					s = s + my2DArray[r][k];
					//System.out.print(my2DArray[r][k]);
					//System.out.print(combHolder[r][counter-1]);
					if (k == subArrayLengths[r]-1) {
						counter++;
					}
				}
			}
			counter=1;
			combHolder[r] = s.split("(?!^)");
			//System.out.println(s);
		}
		//pretty print
		for(int k = 0; k <= ctPossCombos-1; k++) {
			for(int r = 0; r <= arrayCount-1; r++) {
				System.out.print(combHolder[r][k]);
			}
			System.out.println();
		}
	}
}		






