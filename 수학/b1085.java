// 2020-08-15 Yoo Jaein
// [BOJ] 1085 직사각형에서 탈출
// 수학

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	String[] s = br.readLine().split(" ");
    	int x = Integer.parseInt(s[0]);
    	int y = Integer.parseInt(s[1]);
    	int w = Integer.parseInt(s[2]);
    	int h = Integer.parseInt(s[3]);
    	
    	// 사각형의 경계선까지 거리
    	int[] dist = new int[4];
    	dist[0] = h-y;
    	dist[1] = x;
    	dist[2] = w-x;
    	dist[3] = y;
    	
    	Arrays.sort(dist);
    	System.out.println(dist[0]);
    	
		br.close();
    	return;
    }
}
