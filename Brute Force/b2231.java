// 2020-07-30 Yoo Jaein
// [BOJ] 2231 분해합
// Brute Force

import java.util.Scanner;

public class Main {
	public static void solution(int N) {
		int answer = 0;
		
        for(int i=N; i>=0; i--) {
        	String str = Integer.toString(i);
        	
        	int sum = 0;
        	for(int j=0; j<str.length(); j++)
        		sum += Character.getNumericValue(str.charAt(j));
        	
        	if(sum+i!=N)
        		continue;
        	
        	answer = i;
        }
		
        System.out.print(answer);
        
        return;
    }
    
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	
    	int N = scan.nextInt();
    	
    	solution(N);
    }
}