package algorithm.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortStringBuildPalindrome {
	public static void main(String[] args) {
		String inputString = "aabcbcbdcc";
		int size = getSizePalindrome(inputString);
		System.out.println(size);
	}

	private static int getSizePalindrome(String inputString) {
		Map<Character, Integer> histogram = new HashMap<>();
		for(Character c : inputString.toCharArray()){
			int value = histogram.containsKey(c) ? histogram.get(c) : 0;
			histogram.put(c, ++value);
		}
		Set<Entry<Character, Integer>> entrySet = histogram.entrySet();
		StringBuilder sb = new StringBuilder();
		String middle = "";
		for(Entry<Character, Integer> entry : entrySet){
			System.out.println(entry.getKey()+" - "+entry.getValue());
			if(entry.getValue() == 1){
				middle = entry.getKey().toString();
			} else if(entry.getValue() % 2 == 0){
				int count = 0;
				while(count < entry.getValue()/2){
					sb.append(entry.getKey());
					count++;
				}
			} else {
				int count = 0;
				while(count < (entry.getValue()-1)/2){
					sb.append(entry.getKey());
					count++;
				}
			}
			
		}
		String first = sb.toString();
		String last = sb.reverse().toString();
		String result = first+middle+last;
		System.out.println(result);
		return result.length();
	}
}
