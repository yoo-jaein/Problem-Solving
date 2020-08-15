// 2020-08-16 Yoo Jaein
// [BOJ] 10817 세 수
// 구현

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	String[] s = br.readLine().split(" ");
    	int[] arr = new int[3];
    	
    	for(int i=0; i<3; i++)
    		arr[i] = Integer.parseInt(s[i]);
    	
    	Arrays.sort(arr);
    	System.out.println(arr[1]);
		br.close();
    	return;
    }
}
