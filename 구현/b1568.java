// 2020-09-05 Yoo Jaein
// [BOJ] 1568 새
// 구현

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int now = N; // 남아있는 새의 수
		int time = 0; // 초
		int sing = 1; // 지금 부르는 숫자
		
		while(now>0) {			
			if(now<sing)
				sing = 1;
			
			now -= sing;
			
			time++;
			sing++;
		}
		System.out.println(time);
		
		br.close();
    	return;
    }
}
