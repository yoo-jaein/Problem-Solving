// 2020-10-14 Yoo Jaein
// [SWEA] 2382 미생물 격리
// 시뮬레이션

import java.io.*;
import java.util.*;

public class Main {
	static int ans;
	static int n, m, k;
	static int[][] group;
	
	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static Pair move(Pair p, int dir) {
		if(dir==1) return new Pair(p.x-1, p.y);
		else if(dir==2) return new Pair(p.x+1, p.y);
		else if(dir==3) return new Pair(p.x, p.y-1);
		else return new Pair(p.x, p.y+1);
	}
	
	public static void merge(ArrayList<Integer> list) {
		// 두 개 이상의 군집이 한 셀에 모이는 경우 군집을 합친다
		int sum = 0;
		int max = 0;
		int dir = 0;
		
		// 군집의 위치
		int x = group[list.get(0)][0];
		int y = group[list.get(0)][1];
		
		// 미생물 수가 가장 많은 군집의 방향으로 간다
		for(int i=0; i<k; i++) {
			// 합칠 대상이 아니면 건너뛴다
			if(!list.contains(i)) continue;
			
			if(max<group[i][2]) {
				max = group[i][2];
				dir = group[i][3];
			}
			
			// 군집의 미생물 수는 모인 군집의 미생물 수 합
			sum += group[i][2];
			
			// 군집 제거
			group[i][2] = 0;
			group[i][3] = 0;
		}
		group[list.get(0)][0] = x;
		group[list.get(0)][1] = y;
		group[list.get(0)][2] = sum;
		group[list.get(0)][3] = dir;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // n*n 맵
		m = sc.nextInt(); // m시간 후 남은 미생물 수의 총합
		k = sc.nextInt(); // k개의 미생물 군집
		
		group = new int[k][4];
		for(int i=0; i<k; i++) {
			group[i][0] = sc.nextInt(); // row
			group[i][1] = sc.nextInt(); // col
			group[i][2] = sc.nextInt(); // size
			group[i][3] = sc.nextInt(); // dir (상:1, 하:2, 좌:3, 우:4)
		}
		
		for(int time=0; time<m; time++) {
			// 각 미생물 군집을 이동시킨다
			for(int i=0; i<k; i++) {
				// 사라진 군집은 건너뛰기 (시간단축)
				if(group[i][2]==0) continue;
				
				Pair p = move(new Pair(group[i][0], group[i][1]), group[i][3]);
				group[i][0] = p.x;
				group[i][1] = p.y;
				
				// 약품이 칠해진 셀로 이동했을 경우
				if(p.x==0 || p.y==0 || p.x==n-1 || p.y==n-1) {
					// 짝수일때 반으로 나눔
					if(group[i][2]%2==0) group[i][2]/=2;
					// 홀수일때 살아남은 미생물 수 = 원래 미생물 수를 2로 나눈 후 소수점 이하를 버림한 값
					else group[i][2] = group[i][2]/2;
					
					// 이동 방향을 반대로 바꿈
					if(group[i][3]==1) group[i][3] = 2;
					else if(group[i][3]==2) group[i][3] = 1;
					else if(group[i][3]==3) group[i][3] = 4;
					else group[i][3] = 3;
				}
			}
			
			for(int i=0; i<k; i++) {
				if(group[i][2]==0) continue;
				
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				for(int j=0; j<k; j++) {
					if(i==j) continue;
					
					if(group[i][0]==group[j][0] && group[i][1]==group[j][1])
						list.add(j);
				}
				
				// 두개 이상의 군집이 만날 때
				if(list.size()>1) {
					merge(list); // 합친다
				}
				
			}
			
		}
		
		// 남아 있는 미생물 수 세기
		for(int i=0; i<k; i++) {
			ans += group[i][2];
			//System.out.println(group[i][2]);
		}
		
		System.out.println("#"+"test_case"+" "+ans);
		ans = 0;
		
		sc.close();
		
		br.close();
    	return;
    }
}