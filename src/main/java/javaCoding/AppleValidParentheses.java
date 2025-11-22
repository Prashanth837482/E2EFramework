package javaCoding;

import org.testng.annotations.Test;

public class AppleValidParentheses {
	
	// https://chatgpt.com/c/691ff6fd-40a0-8322-ab74-5c00cbe27609
	
	public boolean validParenthesesOptimalApproach(String s) {
		
		char[] ch = new char[s.length()];
		int index = -1;
		
		
		for(char ele : s.toCharArray()) {
			if(ele == '[') {
				ch[++index] = ']';
			}
			else if(ele == '(') {
				ch[++index] = ')';
			}
			else if(ele == '{') {
				ch[++index] = '}';
			}
			else {
				if(index == -1 || ch[index--]!=ele) {
					return false;
				}
			}
		}
		return index == -1;
		
	}
	
	
public boolean validParenthesesIfInputContainsAlphabets(String s) {
		
		char[] ch = new char[s.length()];
		int index = -1;
		
		
		for(char ele : s.toCharArray()) {
			if(ele == '[') {
				ch[++index] = ']';
			}
			else if(ele == '(') {
				ch[++index] = ')';
			}
			else if(ele == '{') {
				ch[++index] = '}';
			}
			else if(ele == ')' || ele == ']' || ele == '}'){   // Extra conditions in else if to check the characters are closing braces only
				if(index == -1 || ch[index--]!=ele) {
					return false;
				}
			}
		}
		return index == -1;
		
	}
	
	public static void main(String[] args) {
		AppleValidParentheses obj = new AppleValidParentheses();
		String s = "[([]{})]";
		System.out.println(obj.validParenthesesOptimalApproach(s));
		String s1 = "[()}{]";
		System.out.println(obj.validParenthesesOptimalApproach(s1));
		String s2 = "[test()check]";
		System.out.println(obj.validParenthesesIfInputContainsAlphabets(s2));
	}

}
