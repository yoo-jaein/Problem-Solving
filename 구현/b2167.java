// 2020-09-05 Yoo Jaein
// [BOJ] 2167 2차원 배열의 합
// 구현

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] arr = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			String[] st = br.readLine().split(" ");
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st[j-1]);
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int k=0; k<K; k++) {
			String[] st = br.readLine().split(" ");
			int i = Integer.parseInt(st[0]);
			int j = Integer.parseInt(st[1]);
			int x = Integer.parseInt(st[2]);
			int y = Integer.parseInt(st[3]);
			
			int sum = 0;
			for(int a=i; a<=x; a++) {
				for(int b=j; b<=y; b++) {
					sum += arr[a][b];
				}
			}
			System.out.println(sum);
		}
	br.close();
    	return;
    }
}
