// 2020-07-31 Yoo Jaein
// [BOJ] 2309 일곱 난쟁이
// Brute Force

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void solution(int[] heights) {
		int liar1 = 0;
		int liar2 = 0;
		
		int sum = 0;
		for(int i=0; i<9; i++) {
			sum += heights[i];
		}
		
		sum = sum-100;
		
		outer:
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(heights[i]+heights[j]==sum) {
					liar1 = heights[i];
					liar2 = heights[j];
					break outer;
				}
			}
		}
		
		Arrays.sort(heights);
		
		for(int i=0; i<9; i++)
			if(heights[i] != liar1 && heights[i] != liar2)
				System.out.println(heights[i]);
        
        return;
    }
    
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	
    	int[] heights = new int[9];
    	for(int i=0; i<9; i++) 
    		heights[i] = scan.nextInt();
    	
    	solution(heights);
    	
    	return;
    }
}
