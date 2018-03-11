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
1) Your program should be able to handly ANY two dimensional character 
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

The comments are there just to explain what each line means. Don't put 
them in your data file.  This format will help you create your jagged 
arrays because it tells you the sizes of each one of them.

3) Do not use recursion.


Fun fact! This was a real interview question.*/



public class Main {
   
	public static void main(String[] args) {
		char[][] my2DArray = {{'a','b','h'},{'c','d','i'},{'e','f','g'}};
		int arrayCount = my2DArray.length;
		int maxArrayLength =0;
		for (int i = 0; i <= arrayCount-1; i++) {
			if (my2DArray[i].length > maxArrayLength) {
				maxArrayLength = my2DArray[i].length;
			}
		}
		//System.out.println("Count of Arrays: "+ arrayCount);
		//System.out.println("Max Array Length: "+ maxArrayLength);
		
		for (int i = 0; i <= arrayCount-1; i++) {
			for (int j = 0; j <= my2DArray[i].length -1; j++) {
				System.out.print(my2DArray[j][i]);
			}
			System.out.println("");
		}		

	}

}

/*// TODO: sort arrays by length, to ensure longest array is "first" combination
// component

okay, I see the issue here: sorting on the value of a key-value pair in Java is 
difficult. My first thought was to make a <k><v> <my2DArray.index><array.length>

from there I thought I could just sort by the array length, to get the order of 
arrays for my for loop

but what if I make my key an array? where the first value is the arry len,
		second my2DArray.index? Can I sort it then?
and the value <my2DArray.index>

AHH... TREEMAP .. looks like i can sort by key there ... but doesn't support an
array sort

*/
