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
		char[][] my2DArray = {{'a','b','h'},{'c','d'},{'e','f','g'}};
		int arrayCount = my2DArray.length;
		int maxArrayLength =0;
		for (int i = 0; i <= arrayCount-1; i++) {
			if (my2DArray[i].length > maxArrayLength) {
				maxArrayLength = my2DArray[i].length;
			}
		}
		//System.out.println("Count of Arrays: "+ arrayCount);
		//System.out.println("Max Array Length: "+ maxArrayLength);
		
		for (int r = 0; r <= arrayCount-1; r++) {
			for (int k = 0; k <= maxArrayLength-1; k++) {
				if (k <= my2DArray[k].length) { //need to store and check len
					System.out.print(my2DArray[k][r]);
				}
			}
			System.out.println("");
		}		

	}

}

/// YOU NEED TO BUILD A TREE AND WALK IT...