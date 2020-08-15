// 2020-08-16 Yoo Jaein
// [BOJ] 10815 숫자 카드
// Binary Search

import java.io.*;
import java.util.*;

public class Main {
	static int[] cards;
	static int N, M;
	
	public static boolean binarySearch(int num) {
		int leftIndex = 0;
		int rightIndex = N-1;
		
		while(leftIndex<=rightIndex) {
			int midIndex = (leftIndex+rightIndex)/2;
			int mid = cards[midIndex];
			
			if(num<mid) rightIndex = midIndex-1;
			else if(num>mid) leftIndex = midIndex+1;
			else return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	N = Integer.parseInt(br.readLine());
    	String[] s1 = br.readLine().split(" ");
    	
    	cards = new int[N];
    	for(int i=0; i<N; i++)
    		cards[i] = Integer.parseInt(s1[i]);
    	
    	Arrays.sort(cards);
    	
    	M = Integer.parseInt(br.readLine());
    	String[] s2 = br.readLine().split(" ");
    	
    	for(int i=0; i<M; i++) {
    		int num = Integer.parseInt(s2[i]);
    		
    		if(binarySearch(num)) // if(Arrays.binarySearch(cards, num) >= 0)과 같음
    			System.out.print("1 ");
    		else
    			System.out.print("0 ");
    		
    	}
    	
		br.close();
    	return;
    }
}
