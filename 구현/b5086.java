// 2021-01-24 Yoo Jaein
// [BOJ] 5086 배수와 약수
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == b && b == 0) {
				break;
			}
			
			if(a < b) {
				int ta = a;
				int i = 2;
				
				while(ta < b) {
					ta = a * i;
					i++;
				}
				
				if(ta == b) {
					System.out.println("factor");
				} else {
					System.out.println("neither");
				}
				
			} else if(a > b){
				int tb = b;
				int i = 2;
				
				while(tb < a) {
					tb = b * i;
					i++;
				}
				
				if(tb == a) {
					System.out.println("multiple");
				} else {
					System.out.println("neither");
				}
			}
			
		}
		
		br.close();
		return;
	}
}