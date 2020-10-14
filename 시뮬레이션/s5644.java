// 2020-10-14 Yoo Jaein
// [SWEA] 5644 무선 충전
// 시뮬레이션

import java.io.*;
import java.util.*;

public class Main {
	static int M, A;
	static int[][] map;
	static int[][] ap;
	static int ans;
	
	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void check(Pair a, Pair b) {
		// p가 BC의 충전 범위에 있는지 체크
		ArrayList<Integer> list_a = new ArrayList<>();
		ArrayList<Integer> list_b = new ArrayList<>();
		
		// BC의 위치(x, y)와 p의 거리가 C 이하이면 접속 가능
		// list에 넣는다
		for(int i=0; i<A; i++) {
			if(Math.abs(ap[i][0]-a.x)+Math.abs(ap[i][1]-a.y) <= ap[i][2])
				list_a.add(i);
		}
		
		for(int i=0; i<A; i++) {
			if(Math.abs(ap[i][0]-b.x)+Math.abs(ap[i][1]-b.y) <= ap[i][2])
				list_b.add(i);
		}
		
		int size_a = list_a.size();
		int size_b = list_b.size();
		
		if(size_a==0 && size_b==0) return;
		
		int max = 0;
		//System.out.println("size: "+size_a +" "+size_b);
		// list에 값이 들어있으면 무조건 모든 케이스를 다 돌려서 최대값 찾기
		for(int i=0; i<size_a; i++) {
			for(int j=0; j<size_b; j++) {
				if(list_a.get(i)==list_b.get(j)) {
					// A와 B가 같은 BC에 연결
					max = Math.max(max, ap[list_a.get(i)][3]);
				} else {
					// A와 B가 다른 BC에 연결
					max = Math.max(max, ap[list_a.get(i)][3]+ap[list_b.get(j)][3]);
				}
			}
		}
		
		
		// A/B 하나만 연결했을 때도 고려
		for(int i=0; i<size_a; i++)
			max = Math.max(max, ap[list_a.get(i)][3]);
		
		for(int i=0; i<size_b; i++)
			max = Math.max(max, ap[list_b.get(i)][3]);
		
		// ans에 최대값 더하기
		ans += max;
		//System.out.println(ans+" "+max);
	}
	
	public static Pair move(Pair p, int n) {
		// n을 이용하여 p를 이동시킴
		// 움직임 주의!
		if(n==0) return p;
		else if(n==1) return new Pair(p.x, p.y-1);
		else if(n==2) return new Pair(p.x+1, p.y);
		else if(n==3) return new Pair(p.x, p.y+1);
		else return new Pair(p.x-1, p.y);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		A = sc.nextInt();
		
		Pair prev_a = new Pair(1, 1); 
		Pair prev_b = new Pair(10, 10);
		
		int[] info_A = new int[M];
		int[] info_B = new int[M];
		
		for(int i=0; i<M; i++) {
			info_A[i] = sc.nextInt();
		}
		
		for(int i=0; i<M; i++) {
			info_B[i] = sc.nextInt();
		}
		
		ap = new int[A][4];
		for(int i=0; i<A; i++) {
			for(int j=0; j<4; j++) {
				ap[i][j] = sc.nextInt();
			}
		}
		
		// m=0일때 BC연결 체크
		check(prev_a, prev_b);
		//System.out.println(ans);
		// m=1부터 m<=M까지 완전탐색
		for(int m=0; m<M; m++) {
			Pair a = move(prev_a,info_A[m]);
			Pair b = move(prev_b,info_B[m]);
			
			check(a, b);
			//System.out.println(ans);
			//System.out.println(a.x+" "+a.y);
			//System.out.println(b.x+" "+b.y);
			
			prev_a = a;
			prev_b = b;
		}
		
		System.out.println("#"+"test_case"+" "+ans);
		
		sc.close();
		
		br.close();
    	return;
    }
}