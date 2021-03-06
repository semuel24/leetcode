package sort.colors;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * click to show follow up.
 * 
 * Follow up: A rather straight forward solution is a two-pass algorithm using
 * counting sort. First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 */
public class Solution {
	
	public static void main(String [] args) {
		Solution s = new Solution();
		int [] A = {0};
		s.sortColors(A);
		System.out.println("printing:");
		for(int i : A) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	
	public void sortColors(int[] A) {
		int redBar = 0;//elements before this index are red
		int blueBar = A.length - 1;//elements after this index are blue
		
		for(int cursor = 0; cursor<=blueBar; cursor++) {
			if(A[cursor] == 0) {//meet red
				A[redBar] = 0;
				if(cursor>redBar) {
					A[cursor] = 1;
				}
				redBar++;
			} else if(A[cursor] == 2) {//meet blue
				//swap
				A[cursor] = A[blueBar]; 
				A[blueBar] = 2;
				blueBar --;
				cursor--;
			} else {//==1
				
			}
		}
	}
}