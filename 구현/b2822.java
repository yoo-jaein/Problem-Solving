// 2020-08-01 Yoo Jaein
// [BOJ] 2822 점수 계산
// 구현

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	int sum = 0;
    			
    	int[] arr = new int[8];
    	int[] arr2 = new int[8];
    	for(int i=0; i<8; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    		arr2[i] = arr[i];
    	}
		
    	Arrays.sort(arr2);
    	for(int i=3; i<8; i++) {
    		sum += arr2[i];
    	}
		
    	System.out.println(sum);
    	for(int i=0; i<8; i++) {
    		for(int j=3; j<8; j++) {
    			if(arr[i]==arr2[j]) {
    				System.out.print(i+1+" ");
    				break;
    			}
    		}
    	}
    	
    	return;
    }
}
