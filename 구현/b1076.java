// 2020-09-05 Yoo Jaein
// [BOJ] 1076 저항
// 구현

import java.io.*;
import java.util.*;

public class Main {
	enum Color {
		black, brown, red, orange, yellow, green, blue, violet, grey, white
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String color1 = br.readLine();
		String color2 = br.readLine();
		String mul = br.readLine();
		
		String tmp = "";
		for(Color c :Color.values()) {
			if(c.name().equals(color1))
				tmp+=String.valueOf(c.ordinal());
		}
		
		for(Color c :Color.values()) {
			if(c.name().equals(color2))
				tmp+=String.valueOf(c.ordinal());
		}
		
		// white white white의 경우 int 범위 초과
		long num = Integer.valueOf(tmp);
		for(Color c :Color.values()) {
			if(c.name().equals(mul)) {
				//c.ordinal() 만큼 10을 곱한다.
				for(int i=0; i<c.ordinal(); i++)
					num*=10;
			}
		}
		
		System.out.println(num);
    	return;
    }
}
