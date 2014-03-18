package word.Break;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class II {
	
	public static void main(String [] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaab";
		String[] array = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		Set<String> dict = new HashSet<String>();
		for(String _w : array){
			dict.add(_w);
		}
		II ii = new II();
		ii.wordBreak(s, dict);
	}
	
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
       
		ArrayList<ArrayList<String>> words = new ArrayList<ArrayList<String>>();
		for(int i=0; i<=s.length(); i++) {
			words.add(new ArrayList<String>());
		}
		words.get(0).add("");
		
		boolean[] flags = new boolean[s.length()+1];
		flags[0] = true;
		
		for(int i=0; i<s.length(); i++) {
			if(!flags[i]) {
				continue;
			}
			for(String w : dict) {
				int _length = w.length();
				int _end = i+_length;
				if(_end>s.length()){
					continue;
				}
				if(s.substring(i, _end).equalsIgnoreCase(w)) {
					flags[_end] = true;
					ArrayList<String> _sl = words.get(i);//start point
					ArrayList<String> _el = words.get(_end);//end point
					for(String _s : _sl){
						_el.add(append(_s, w));
					}
				}
			} 
		}
		
		return words.get(s.length());
    }
	
	private String append(String s1, String s2) {
		if(s2 == null || s2.equalsIgnoreCase("")) {
			throw new RuntimeException("append exception s2:" + s2);
		}
		if(s1 == null || s1.equalsIgnoreCase("")) {
			return s2;
		} else {
			return s1 + " " + s2;
		}
	}
}
