package net.porwit.ctci.ArraysAndStrings;

import java.util.HashSet;
import java.text.StringCharacterIterator;
import java.util.Arrays;

class ArraysAndStrings {

	public static boolean isUnique(String s) {
		HashSet<Character> chars = new HashSet<>(s.length());
		boolean ret = true;
		for(char c : s.toCharArray()) {
			ret = chars.add(c);
			if(ret == false) {
				break;
			}
		}
		return ret;
	}
	
	public static boolean isUniqueNoSet(String s) {
		char[] chars = s.toCharArray();
		boolean ret = true;
		char prev = '\0';
		Arrays.sort(chars);
		for(char c : chars) {
			if(c == prev) {
				ret = false;
				break;
			}
			prev = c;
		}
		return ret;
	}

	public static boolean arePermutations(String s1, String s2) throws IllegalArgumentException {
		if(s1 == null || s2 == null) {
			throw new IllegalArgumentException("arguments cannot be null");
		}
		if(s1 == s2) {
			// same reference. not permutations
			return false;
		}
		if(s1.length() != s2.length()) {
			return false;
		}
		
		char[] chars = s1.toCharArray();
		Arrays.sort(chars);
		String s1sorted = new String(chars);
		chars = s2.toCharArray();
		Arrays.sort(chars);
		String s2sorted = new String(chars);
		if(s1sorted.equals(s2sorted)) {
			return true;
		}
		return false;
	}
	
	public static String URLify(String input, int realLen) {
		String ret;
		char[] chars = input.toCharArray();
		int newInd = chars.length -1;
		for(int i = realLen-1; i >= 0; i--) {
			if(chars[i] != ' ') {
				chars[newInd] = chars[i];
				newInd--;
			} else {
				chars[newInd--] = '0';
				chars[newInd--] = '2';
				chars[newInd--] = '%';
			}
		}
		ret = new String(chars);
		return ret;
	}

	public static boolean palindromePermutation(String s) {
		char[] chars = s.toLowerCase().toCharArray();
		Arrays.sort(chars);
		boolean ret = false;
		boolean oddPivot = false;
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] < 'a' || chars[i] > 'z') {
				continue;
			}
			if(chars[i] == chars[i+1]) {
				i++;
				ret = true;
				continue;
			} else {
				if(oddPivot == false) {
					oddPivot = true;
					ret = true;
					continue;
				} else {
					ret = false;
					break;
				}
			}
		}
		return ret;
	}

	public static boolean oneAway(String s1, String s2) {
		int numChanges = 0;
		boolean ret = false;

		StringCharacterIterator sci1 = new StringCharacterIterator(s1);
		StringCharacterIterator sci2 = new StringCharacterIterator(s2);
		char c1 = sci1.first();
		char c2 = sci2.first();
		for(; numChanges < 2; c1 = sci1.next(), c2 = sci2.next()) {
			if(c1 == StringCharacterIterator.DONE && c2 == StringCharacterIterator.DONE) {
				break;
			}
			if(c1 != c2) {
				numChanges++;
				// If strings are of unequal lengths, assume this is a deletion or insertion and advance the longer one
				if(s1.length() > s2.length()) {
					c1 = sci1.next();
				} else if (s1.length() < s2.length()) {
					c2 = sci2.next();
				} else {
					// Strings are of equal length, so assume this is a substitution
					c1 = sci1.next();
					c2 = sci2.next();
				}
			} 
		}
		if(numChanges == 1) 
			ret = true;
		
		return ret;
	}
}
