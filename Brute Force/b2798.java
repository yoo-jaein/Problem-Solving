// 2020-07-30 Yoo Jaein
// [BOJ] 2798 블랙잭
// Brute Force

import java.util.Scanner;

public class Main {
	public static void solution(int N, int M, int[] cards) {
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					if(cards[i]+cards[j]+cards[k] > M) {
						continue;
					}
					
					if(cards[i]+cards[j]+cards[k] > sum) {
						sum = cards[i]+cards[j]+cards[k];
					}
				}
			}
		}
        
		System.out.print(sum);
        
        return;
    }
    
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	
    	int N = scan.nextInt();
    	int M = scan.nextInt();
    	int[] cards = new int[N];
    	
    	for(int i=0; i<N; i++) {
    		cards[i] = scan.nextInt();
    	}
    	
    	solution(N, M, cards);
    }
}