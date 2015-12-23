package com.jasons.algo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * <pre>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

	For example, given n = 3, a solution set is:
	
	"((()))", "(()())", "(())()", "()(())", "()()()"
	Make sure the returned list of strings are sorted.
 * </pre>
 * 
 * @author shishu
 *
 */
public class Brackets {

	private ArrayList<String> res;

	public ArrayList<String> generateParenthesis(int A) {
		res = new ArrayList<>();
		StringBuilder str = new StringBuilder();
		rec(0, 0, 0, str, A);
		return res;
	}

	public void rec(int leftCount, int rightCount, int index, StringBuilder str, int n) {

		if (leftCount > n || rightCount > n)
			return;

		if (rightCount > leftCount)
			return;

		if (index == 2 * n) {
			res.add(str.toString());
			return;
		}

		str.append('(');
		rec(leftCount + 1, rightCount, index + 1, str, n);
		str.deleteCharAt(str.length() - 1);

		str.append(')');
		rec(leftCount, rightCount + 1, index + 1, str, n);
		str.deleteCharAt(str.length() - 1);
	}

	@Test
	public void test() throws Exception {
		System.out.println(new Brackets().generateParenthesis(3));
	}

	// ========================
	/**
	 * <pre>
	 * We can solve this problem recursively by recursing through the string On
	 * each iteration, we have the index for a particular character in the
	 * string We need to select either a left or a right paren When can we use
	 * left, and when can we use a right paren?
	 *  
	 * » Left: As long as we haven’t
	 * used up all the left parentheses, we can always insert a left paren 
	 * 
	 * »
	 * Right: We can insert a right paren as long as it won’t lead to a syntax
	 * error . When will we get a syntax error? We will get a syntax error if
	 * there are more right parentheses than left 
	 * 
	 * So, we simply keep track of
	 * the number of left and right parentheses allowed If there are left parens
	 * remaining, we’ll insert a left paren and recurse 
	 * If there are more right
	 * parens remaining than left (eg, if there are more left parens used), then
	 * we’ll insert a right paren and recurse
	 * 
	 * </pre>
	 */
	public static void printPar(int l, int r, char[] str, int count) {
		if (l < 0 || r < l)
			return; // invalid state
		if (l == 0 && r == 0) {
			System.out.println(str); // found one, so print it
		} else {
			if (l > 0) { // try a left paren, if there are some available
				str[count] = '(';
				printPar(l - 1, r, str, count + 1);
			}
			if (r > l) { // try a right paren, if there’s a matching left
				str[count] = ')';
				printPar(l, r - 1, str, count + 1);
			}
		}
	}

	public static void printPar(int count) {
		char[] str = new char[count * 2];
		printPar(count, count, str, 0);
	}

	@Test
	public void test2() throws Exception {
		Brackets.printPar(3);
	}
}
