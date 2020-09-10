// 2020-09-10 Yoo Jaein
// [PRG] 42861 섬 연결하기
// Kruskal: Union-Find

import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	
	// 1. 초기화 과정
	// 자신의 부모는 자기 자신으로 초기화한다.
	public static void init(int n) {
		for(int i=0; i<n; i++)
			parent[i] = i;
	}
	
	// 2. 파인드 과정
	// 루트 노드를 찾음으로써 어떤 집합에 포함되었는지 알아낸다.
	public static int find(int x) {
		if(x==parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	
	// 3. 유니온 과정
	// 두 집합을 합친다. 이 때 일반적으로 작은 값 쪽으로 합친다.
	public static void merge(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x!=y) {
			if(x<y) {
				parent[y] = x;
			} else
				parent[x] = y;
		}
	}
	
	// 같은 집합에 포함되는지 확인한다.
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) return true;
		else return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int result = 0;
		Arrays.sort(costs, new Comparator<int[]> () {
			@Override
			public int compare(int[] c1, int[] c2) {
				return c1[2]-c2[2];
			}
		});
		
		parent = new int[n];
		init(n);
		
		for(int i=0; i<costs.length; i++) {
			int x = costs[i][0];
			int y = costs[i][1];
			x = find(x);
			y = find(y);
			if(x!=y) {
				result += costs[i][2];
				merge(x,y);
			}
		}
		
		
		System.out.println(result);
		
		br.close();
    	return;
    }
}
