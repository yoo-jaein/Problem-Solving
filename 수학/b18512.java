// 2020-08-25 Yoo Jaein
// [BOJ] 18512 점프 점프
// 수학
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	String[] s = br.readLine().split(" ");
    	int x = Integer.parseInt(s[0]);
    	int y = Integer.parseInt(s[1]);
    	int p1 = Integer.parseInt(s[2]);
    	int p2 = Integer.parseInt(s[3]);
    	
    	// 학생 A가 뛰는 횟수 n, 학생 B가 뛰는 횟수 m은 모두 >=0
    	// p1+(x*n) == p2+(y+m) 을 만족하면 만날 수 있다.
    	// 1000번까지 계산해보고 결과를 출력한다.
    	
    	for(int n=0; n<=1000; n++) {
    		for(int m=0; m<=1000; m++) {
    			if(p1+(x*n)==p2+(y*m)) {
    				System.out.println(p1+(x*n));
    				return;
    			}
    		}
    	}
    	
    	System.out.println("-1");
    	
    	br.close();
    	return;
    }
}
