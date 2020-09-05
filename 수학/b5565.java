// 2020-09-05 Yoo Jaein
// [BOJ] 5565 영수증
// 수학

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int price = 0;
		
		for(int i=0; i<9; i++) {
			price += Integer.parseInt(br.readLine());
		}
		
		System.out.println(total-price);
		
    	return;
    }
}
