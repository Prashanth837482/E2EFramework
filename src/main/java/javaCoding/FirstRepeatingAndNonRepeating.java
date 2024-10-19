package javaCoding;

import org.testng.annotations.Test;

public class FirstRepeatingAndNonRepeating {
	
	@Test
	 public void firstUniqChar() {
			String s = "loveleetcode";
	       for(char ch : s.toCharArray()){
	      //  String chars =""+ch;
	         if(s.indexOf(ch)==s.lastIndexOf(ch)){
	        	 System.out.println("first uniquechar is: "+ch+" with index "+s.indexOf(ch));
	        	 break;
	         }
	       }

	       
	    }
	
	@Test
	 public void firstRepeatedChar() {
		String s = "loveleetcode";
	       for(char ch : s.toCharArray()){
	      //  String chars =""+ch;
	         if(s.indexOf(ch)!=s.lastIndexOf(ch)){
	        	 System.out.println("first repeating is: "+ch+" with index "+s.indexOf(ch));
	        	 break;
	         }
	       }

	       
	    }

}
