// 2020-10-31 Yoo Jaein
// [BOJ] 1620 나는야 포켓몬 마스터 이다솜
// Data Structure: HashMap

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// list를 쓸 경우 시간초과!
		Map<String, String> map = new HashMap<>();
		
		for(int i=1; i<=n; i++) {
			String name = br.readLine();
			// 이름과 번호를 모두 넣어준다.
			map.put(name, Integer.toString(i));
			map.put(Integer.toString(i), name);
		}
		
		for(int i=0; i<m; i++) {
			System.out.println(map.get(br.readLine()));
		}
		
		br.close();
		return;
	}
}