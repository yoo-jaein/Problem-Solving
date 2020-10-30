// 2020-10-30 Yoo Jaein
// [BOJ] 2947 나무 조각
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static boolean check(int[] arr) {
		// arr의 순서가 1, 2, 3, 4, 5인지 확인하는 함수
		for(int i=0; i<5; i++) {
			if(i+1!=arr[i]) 
				return false;
		}
		return true;
	}
	
	public static void swap(int[] arr, int a, int b) {
		// arr[a]와 arr[b]의 위치를 서로 바꾸고 결과를 출력하는 함수
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
		
		for(int i=0; i<5; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[5];
		for(int i=0; i<5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			if(arr[0]>arr[1]) swap(arr, 0, 1);
			if(arr[1]>arr[2]) swap(arr, 1, 2);
			if(arr[2]>arr[3]) swap(arr, 2, 3);
			if(arr[3]>arr[4]) swap(arr, 3, 4);
			
			if(check(arr)) break;
		}
		
		br.close();
		return;
	}
}