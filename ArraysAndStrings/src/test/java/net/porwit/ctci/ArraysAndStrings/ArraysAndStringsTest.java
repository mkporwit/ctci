package net.porwit.ctci.ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysAndStringsTest {

	@Test
	public void isUniqueTest() {
		String allUnique = "abcdefghij";
		String notUnique = "abcdefghab";
		boolean ret = ArraysAndStrings.isUnique(allUnique);
		assertTrue("[" + allUnique + "] is unique", ret);
		ret = ArraysAndStrings.isUnique(notUnique);
		assertFalse("[" + notUnique + "] is not unique", ret);		
	}
	
	@Test
	public void isUniqueNoSetTest() {
		String allUnique = "abcdefghij";
		String notUnique = "abcdefghab";
		boolean ret = ArraysAndStrings.isUniqueNoSet(allUnique);
		assertTrue("[" + allUnique + "] is unique", ret);
		ret = ArraysAndStrings.isUniqueNoSet(notUnique);
		assertFalse("[" + notUnique + "] is not unique", ret);
	}
	
	@Test
	public void arePermutationsTest() {
		String perm1 = "cat";
		String perm2 = "act";
		String nonPerm = "bat";
		
		boolean ret = ArraysAndStrings.arePermutations(perm1, perm2);
		assertTrue("[" + perm1 + "] and [" + perm2 + "] are permutations", ret);
		ret = ArraysAndStrings.arePermutations(perm1, nonPerm);
		assertFalse("[" + perm1 + "] and [" + nonPerm + "] are not permutations", ret);
	}

	@Test
	public void URLifyTest() {
		String initial = "Mr John Smith    ";
		int initialLen = 13;
		String converted = "Mr%20John%20Smith";
		String ret = ArraysAndStrings.URLify(initial, initialLen);
		assertNotNull(ret);
		assertEquals("[" + initial + "] is converted", converted, ret);
	}
	
	@Test
	public void palindromePermutationTest() {
		String s = "Tact Coa";
		boolean ret = ArraysAndStrings.palindromePermutation(s);
		assertTrue("[" + s + "] can be a palindrome", ret);
		s = "Tact Boa";
		ret = ArraysAndStrings.palindromePermutation(s);
		assertFalse("[" + s + "] cannot be a palindrome", ret);
	}
	
	@Test
	public void oneAwayTest() {
		String s1 = "pale", s2 = "ple";
		boolean ret = ArraysAndStrings.oneAway(s1, s2);
		assertTrue("[" + s1 + "] and [" + s2 + "] are one away", ret);
		s1 = "pales";
		s2 = "pale";
		ret = ArraysAndStrings.oneAway(s1, s2);
		assertTrue("[" + s1 + "] and [" + s2 + "] are one away", ret);
		s1 = "pale";
		s2 = "bale";
		ret = ArraysAndStrings.oneAway(s1, s2);
		assertTrue("[" + s1 + "] and [" + s2 + "] are one away", ret);
		s1 = "pale";
		s2 = "bake";
		ret = ArraysAndStrings.oneAway(s1, s2);
		assertFalse("[" + s1 + "] and [" + s2 + "] are not one away", ret);
	}
}
