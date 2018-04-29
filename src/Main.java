import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

MY APPROACH

If I know the total number of combinations possible, I also know the number of
times each char will appear in the full set of combinations

Example {{"a"},{"b","c"},{"d"},{"e","f","g"}};

has 2 array with len 1
has 1 array with len 2
has 1 array with len 3

Total combinations = 1 * 2 * 1 * 3 = 6

In full combo set I will see "a" 6x, "b"/"c" 3x, "e"/"f"/"g" 2x 
(totalCombos / array len)

aaaaaa
bbbccc
dddddd
efgefg

translates / transposes to: 
abde
abdf
abdg
acde
acdf
acdg


need an array counter....kinda like a clock:
clock needs to increment least significant index, roll over indexes with higher
significance (if they have potential to roll over)

0000
0001
0002
0100
0101
0102

*/

public class Main {
   
	public static void main(String[] args) {

		String[][] my2DArray = {{"a","b"},{"c","d","g"},{"e","f"},{"h"}};
		Integer subArrayCount = my2DArray.length;
		Integer subArrayLengths[] = new Integer [subArrayCount];
		Integer counterArray[] = new Integer [subArrayCount];
		Arrays.fill(counterArray, 0);
		int ctPossCombos = 1;
		StringBuilder sb;
		//store subArray lengths
		for (int i = 0; i <= subArrayCount-1; i++) {
			subArrayLengths[i] = (my2DArray[i].length);
			ctPossCombos = ctPossCombos * subArrayLengths[i] ;
		}
		System.out.println(ctPossCombos + " combinations:");
		
		for (int comboCounter = ctPossCombos; comboCounter > 0; --comboCounter){
			sb = new StringBuilder();
			for (int outerIdx = 0; outerIdx < subArrayCount; ++outerIdx){
				sb.append(my2DArray[outerIdx][counterArray[outerIdx]]);
			}
			System.out.println(sb);
			//System.out.println(Arrays.toString(counterArray));
			// generate next combo index
			for (int innerIdx = subArrayCount-1; innerIdx >=0; --innerIdx) {
				if(counterArray[innerIdx]+1 < subArrayLengths[innerIdx]) {
					++counterArray[innerIdx];
					break; //print new combo
				}
				//if inner index at this outer index is maxed, zero out
				counterArray[innerIdx]=0;
			}
			
		}	
		
	}
}		

