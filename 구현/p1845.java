// 2020-10-24 Yoo Jaein
// [PRG] 1845 폰켓몬
// 구현

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] nums = {3,3,3,2,2,2};
		int answer = 0;
		
		Set<Integer> s = new HashSet<Integer>();
		for(int i=0; i<nums.length; i++) {
			s.add(nums[i]);
		}
		if(s.size()>nums.length/2) answer = nums.length/2;
		else answer = s.size();
		
		System.out.println(answer);
		
		br.close();
    	return;
    }
}