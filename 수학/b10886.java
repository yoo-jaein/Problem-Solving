// 2020-09-05 Yoo Jaein
// [BOJ] 10886 0 = not cute / 1 = cute
// 수학

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int y = 0;
		int n = 0;
		
		for(int i=0; i<N; i++) {
			if(br.readLine().equals("0")) // not cute
				n++;
			else
				y++;
		}
		
		System.out.println(n>y?"Junhee is not cute!":"Junhee is cute!");
		
    	return;
    }
}
