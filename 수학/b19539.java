// 2020-08-25 Yoo Jaein
// [BOG] 19539 사과나무
// 수학
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[N];
    	int a = 0;
    	int b = 0;
    	
    	String[] s = br.readLine().split(" ");
    	for(int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(s[i]);
    		a += arr[i];
    		b += arr[i]/2; // +2 할 수 있는 횟수 카운트
    	}
    	
    	if(a%3!=0) { // 높이의 합이 3의 배수가 아니면 불가능
    		System.out.println("NO");
    	} else {
    		a = a/3; // +1 & +2 물을 주는 횟수
    		if(b>=a) // +2 할 수 있는 횟수가 전체 횟수보다 크거나 같아야 한다
    			System.out.println("YES");
    		else
    			System.out.println("NO");    		
    	}
    	
    	
    	br.close();
    	return;
    }
}
