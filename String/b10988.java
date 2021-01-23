// 2021-01-24 Yoo Jaein
// [BOJ] 10988 팰린드롬인지 확인하기
// String

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine(); // 앞으로 읽을 때
		
		StringBuilder sb = new StringBuilder(input).reverse(); // 거꾸로 읽을 때
		String output = sb.toString();
		
		if(input.equals(output)) System.out.println("1");
		else System.out.println("0");
		
		br.close();
		return;
	}
}