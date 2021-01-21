// 2021-01-21 Yoo Jaein
// [BOJ] 1546 평균
// 수학

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		double[] input = new double[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input); // 오름차순 정렬
		
		double avg = 0;
		double max = input[n-1];
		for(int i=0; i<n; i++) {
			input[i] = input[i] / max * 100;
			avg += input[i];
		}
		
		System.out.println(avg / n);
		
		br.close();
		return;
	}
}