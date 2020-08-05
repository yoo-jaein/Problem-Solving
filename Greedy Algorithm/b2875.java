// 2020-08-05 Yoo Jaein
// [BOJ] 2875 대회 or 인턴
// Greedy Algorithm

import java.io.*;

public class Main {

	public static int solution(int N, int M, int K) {
		// 여+남-인턴십 인원으로 팀 꾸리기  
        
		int team = 0; // 최대 팀 수 team
		
		for(int i=0; i<=K; i++) {
			for(int j=0; j<=K; j++) {
				if(i+j!=K)
					continue;
				
				int woman = N-i;
		        int man = M-j;
		        
		        int tmp = 0;
				while(woman-2>=0 && man-1>=0) {
					woman-=2;
					man--;
					tmp++;
				}
				if(team<=tmp)
					team = tmp;
			}
		}
		
        return team;
    }
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	String[] s = br.readLine().split(" ");
    	int N = Integer.parseInt(s[0]);
    	int M = Integer.parseInt(s[1]);
    	int K = Integer.parseInt(s[2]);
    	
    	System.out.println(solution(N, M, K));
    	
    	return;
    	
    }
}
