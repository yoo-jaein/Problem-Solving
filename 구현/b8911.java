// 2020-10-06 Yoo Jaein
// [BOJ] 8911 거북이
// 구현

import java.io.*;
public class Main {
	
	// x-y 좌표 생각
	// 위로 한 칸, 왼쪽으로 한 칸, 아래로 한 칸, 오른쪽으로 한 칸
	static int dx[] = {0, -1, 0, 1};
	static int dy[] = {1, 0, -1, 0};
	static int dir;
	
	static int x, y;
	static int max_x, min_x;
	static int max_y, min_y;
	
	public static void move(char ch) {
		if(ch=='F') {
			x += dx[dir];
			y += dy[dir];
		} else {
			x -= dx[dir];
			y -= dy[dir];
		}
	}
	
	public static void rotate(char ch) {
		if(ch=='L')
			dir = (dir+1)%4;
		else
			dir = (dir+3)%4;
	}
	
	public static void compare() {
		max_x = Math.max(max_x, x);
		min_x = Math.min(min_x, x);
		max_y = Math.max(max_y, y);
		min_y = Math.min(min_y, y);
	}
	
	public static void initValue() {
		x = y = 0;
		max_x = max_y = 0;
		min_x = min_y = 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String commands = br.readLine();
			initValue();
			
			for(int j=0; j<commands.length(); j++) {
				char control = commands.charAt(j);
				
				// F: 한 눈금 앞으로
				// B: 한 눈금 뒤로
				// L: 왼쪽으로 90도 회전
				// R: 오른쪽으로 90도 회전
				
				if(control=='F' || control=='B')
					move(control);
				else
					rotate(control);
				
				compare();
			}
			
			// 거북이가 지나간 영역을 모두 포함하는 가장 작은 직사각형
			int area = (max_x-min_x) * (max_y-min_y);
			System.out.println(area);
		}
		br.close();
    	return;
    }
}