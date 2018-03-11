import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
    //prettyPrint Map | https://www.mkyong.com/java/how-to-sort-a-map-in-java/
    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
				+ " Value : " + entry.getValue());
        }
    }
    
	public static void main(String[] args) {
		char[][] my2DArray = {{'a', 'b'},{'c', 'd', 'g'},{'e', 'f'}};
		int arrayCount = my2DArray.length;
		Map<int[], Integer> UnsortedMapArrayLengths = new HashMap<>();

		for (int i = 0; i <= arrayCount-1; i++) {
			int[] myArrayDict = new int[2];
			myArrayDict[0]= my2DArray[i].length;
			myArrayDict[1]= i;
			UnsortedMapArrayLengths.put(myArrayDict, i);
		}
		printMap(UnsortedMapArrayLengths);
		
		Map<int[], Integer> SortedMapArrayLengths =
				new TreeMap<int[], Integer>(UnsortedMapArrayLengths);
		printMap(SortedMapArrayLengths);
		
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

AHH... TREEMAP .. looks like i can sort by key there

*/