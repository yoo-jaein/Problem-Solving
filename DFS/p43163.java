import java.util.*;
class Solution {

    int min = 9999;

    public int solution(String begin, String target, String[] words) {

        boolean match = false;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(target)) {
                match = true;
            }
        }

        if(!match) {
            return 0;
        }

        dfs(begin, target, words, 0);

        int answer = min;
        return answer;
    }

    public void dfs(String begin, String target, String[] words, int n) {
        if(begin.equals(target)) {

            if(min > n) {
                min = n;
            }

            return ;
        }

        String[] tmp = new String[words.length - 1];
        int r = 100;

        for(int i = 0; i < words.length; i++) {
            int count = 0;
            for(int j = 0; j < begin.length(); j++) {
                if(words[i].charAt(j) != begin.charAt(j)) {
                    count++;
                }
            }

            if(count == 1) {
                int idx = 0;
                for(int j = 0; j < i; j++) {
                    tmp[idx] = new String(words[j]);
                    idx++;
                }
                for(int j = i+1; j < words.length; j++) {
                    tmp[idx] = new String(words[j]);
                    idx++;
                }

                dfs(words[i], target, tmp, n+1);
            }
        }
    }
}