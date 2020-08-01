// 2020-08-01 Yoo Jaein
// [BOJ] 10448 유레카 이론
// Brute Force

import java.io.*;

public class Main {
    
	static int[] eureka = new int[45]; // n(n+1)/2 <= 1000, n(n+1) <= 2000, n의 최대값 44
	
	public static boolean solution(int K) {
		boolean answer = false;
		
		// 정확히 3개의 삼각수의 합으로 표현되는가
		outer:
		for (int a = 1; a < 45; a++) {
            for (int b = 1; b < 45; b++) {
                for (int c = 1; c < 45; c++) {
					
					if((eureka[a]+eureka[b]+eureka[c])==K) {
						answer = true;
						break outer;
					}
						
				}
			}
			
		}
		
        
        return answer;
    }
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	int T = Integer.parseInt(br.readLine());
		int[] arrays = new int[T];
		for(int i=0; i<T; i++) {
			arrays[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1; i<45; i++) {
			eureka[i] = i*(i+1)/2;
		}
		
		
		
		for(int i=0; i<T; i++) {
			if(solution(arrays[i]))
				System.out.println(1);
			else
				System.out.println(0);
		}
		
    	return;
    }
}
