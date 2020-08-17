// 2020-08-17 Yoo Jaein
// [BOJ] 1920 수 찾기
// Binary Search

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] nArr;
	
	public static boolean binarySearch(int n) {
		int leftIndex = 0;
		int rightIndex = N-1;
		
		while(leftIndex<=rightIndex) {
			int midIndex = (leftIndex+rightIndex)/2;
			int mid = nArr[midIndex];
			
			if(n<mid) rightIndex = midIndex-1;
			else if(n>mid) leftIndex = midIndex+1;
			else return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	N = Integer.parseInt(br.readLine());
    	nArr = new int[N];
    	
    	String[] s = br.readLine().split(" ");
    	for(int i=0; i<N; i++)
    		nArr[i] = Integer.parseInt(s[i]);
    	Arrays.sort(nArr);
    	
    	M = Integer.parseInt(br.readLine());
    	String[] s2 = br.readLine().split(" ");
    	
    	for(int i=0; i<M; i++) {
    		if(binarySearch(Integer.parseInt(s2[i])))
    			System.out.println("1");
    		else
    			System.out.println("0");
    	}
    	
    	br.close();
    	return;
    }
}
