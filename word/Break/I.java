package word.Break;

import java.util.HashSet;
import java.util.Set;

public class I {

	public static void main(String [] args) {
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("code");
		dict.add("leet");
		I i = new I();
		i.wordBreak(s, dict);
	}
	
	//dp[i+1] represents that s[i] can be segmented into words from dict    
	public boolean wordBreak(String s, Set<String> dict) {

		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i=0; i<= s.length(); i++) {
			if(!dp[i]) {
				continue;
			}
			for(String _w : dict) {
				int _length = _w.length();
				int _end = _length + i;
				if(_end > s.length()) {//too long
					continue;
				}
				if(s.substring(i, _end).equalsIgnoreCase(_w)) {//find a word
					dp[_end] = true;
				}
			}
		}
		
		return dp[s.length()];
	}
}
