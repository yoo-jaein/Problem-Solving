// 2020-08-05 Yoo Jaein
// [BOJ] 8979 올림픽
// 구현

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	    		
    	String[] s = br.readLine().split(" ");
    	int N = Integer.parseInt(s[0]);
    	int K = Integer.parseInt(s[1]);
    	
    	int[][] arr = new int[N][4];
    	
    	for(int i=0; i<N; i++) {
    		s = br.readLine().split(" ");
    		for(int j=0; j<4; j++)
    			arr[i][j] = Integer.parseInt(s[j]);
    	}
    	
    	
    	for(int i=0; i<N; i++) {
    		if(arr[i][0]==K) {
    			K=i;
    			break;
    		}
    	}
    	
    	
    	int rank = 0;

    	for(int i=0; i<N; i++) {
			if(arr[i][1]>arr[K][1]) {
    			rank++;
			}
			else if((arr[i][1]==arr[K][1]) && (arr[i][2]>arr[K][2])) {
				rank++;
			}
			else if(arr[i][1]==arr[K][1] && arr[i][2]==arr[K][2] && arr[i][3]>arr[K][3]) {
				rank++;
			}
    	}
    
    	System.out.println(rank+1);
    	return;
    }
}
