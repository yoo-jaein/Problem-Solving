// 2020-07-30 Yoo Jaein
// [BOJ] 7568 덩치
// Brute Force

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class Person {
	int weight;
	int height;
	
	public Person(int x, int y) {
		this.weight = x;
		this.height = y;
	}
}

public class Main {
	public static void solution(int N, Person[] p) {
		int[] answer = new int[N];
		
		for(int i=0; i<N; i++)
			answer[i]++;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if((p[i].height > p[j].height)&&(p[i].weight > p[j].weight)) {
					answer[j]++;
				}
			}
		}
				
		for(int i=0; i<N; i++)
			System.out.print(answer[i]+" ");
		
        return;
    }
    
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	
    	int N = scan.nextInt();
    	Person[] p = new Person[N];
    	
    	for(int i=0; i<N; i++) {
    		int w = scan.nextInt();
    		int h = scan.nextInt();
    		p[i] = new Person(w,h);
    	}
    		
    	solution(N, p);
    }
}