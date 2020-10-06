// 2020-10-06 Yoo Jaein
// [BOJ] 1672 DNA 해독
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static int index(char ch) {
		if(ch=='A') return 0;
		else if(ch=='G') return 1;
		else if(ch=='C') return 2;
		else return 3;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] arr = {{'A', 'C', 'A', 'G'}, {'C', 'G', 'T', 'A'}, {'A', 'T', 'C', 'G'}, {'G', 'A', 'G', 'T'}};
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		if(n==1) {
			System.out.println(str);
			return;
		}
		
		char ch = str.charAt(str.length()-1);
		for(int i=str.length()-2; i>=0; i--) {
			ch = arr[index(ch)][index(str.charAt(i))];
		}
		
		System.out.println(ch);
		
		br.close();
    	return;
    }
}