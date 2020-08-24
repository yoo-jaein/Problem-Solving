// 2020-08-24 Yoo Jaein
// [BOJ] 1026 보물
// 구현
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	int N = Integer.parseInt(br.readLine());
    	String[] s = br.readLine().split(" ");
    	
    	int[] A = new int[N];
    	for(int i=0; i<N; i++)
    		A[i] = Integer.parseInt(s[i]);
    	
    	s = br.readLine().split(" ");
    	int[] B = new int[N];
    	for(int i=0; i<N; i++)
    		B[i] = Integer.parseInt(s[i]);
    	
    	int answer = 0;
    	
    	Arrays.sort(A);
    	Arrays.sort(B);
		for(int i=0; i<N; i++) 
			answer += A[i] * B[N-i-1];

    	System.out.println(answer);
    		
    	br.close();
    	return;
    }
}
