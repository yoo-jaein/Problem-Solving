// 2020-09-16 Yoo Jaein
// [PRG] 42862 체육복
// Greedy Algorithm

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] lost = {1,3};
		int[] reserve = {2,4};
		int answer = 0;
		int n = 5;
		
		answer = n-lost.length;
		
		for(int i=0; i<reserve.length; i++) {
            for(int j=0; j<lost.length; j++) {
                if(reserve[i]==lost[j]) {
                	reserve[i] = -1;
                	lost[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        
		for(int i=0; i<reserve.length; i++) {
			for(int j=0; j<lost.length; j++) {
				if(lost[j]!=-1) {
					if(reserve[i]+1==lost[j] || reserve[i]-1==lost[j]) {
						reserve[i] = -1;
						lost[j] = -1;
						answer++;
						break;
					}
				}
			}
		}
		
		System.out.println(answer);
		br.close();
		return;
    }
}
