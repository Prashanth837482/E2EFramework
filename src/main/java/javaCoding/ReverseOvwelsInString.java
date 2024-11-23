package javaCoding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class ReverseOvwelsInString {
	
	// brute force or my own method
	@Test
	 public void reverseVowels() {
	       String s ="IceCreAm";  //output: AceCreIm
	       Set<Character> vowels = Set.of('a','e','i','o','u','A','E','I','O','U');
	       List<Integer> index= new ArrayList<>();
	       // for loop to find the vowels index in the string
	       for(int i =0; i<s.length(); i++){
	        if(vowels.contains(s.charAt(i))){
	            index.add(i);
	        }
	       }
	        char[] charArray = s.toCharArray();
	        // loop through the set and update the vowel characters with the index
	       for(int j =0; j<index.size() ; j++){
	        charArray[index.get(j)] =s.charAt(index.get(index.size()-1-j));
	       }
	       System.out.println(new String(charArray));
	      
	    }
	
	//Optimal method or approach
	@Test
	public void reverseOfVowelsOptimalSol() {
		String s ="IceCreAm";  //output: AceCreIm
		  char[] arr=s.toCharArray();
	        int i=0,j=arr.length-1;
	        
	        //Running the loop for the entire input string.
	         while(i<j){
	        	 
	        	 // if string from left has vowel it goes in, else increments i by 1
	            if(arr[i]=='a' ||arr[i]=='e' ||arr[i]=='i' ||arr[i]=='o' ||arr[i]=='u' ||arr[i]=='A' ||arr[i]=='E' ||arr[i]=='I' ||arr[i]=='O' ||arr[i]=='U'){
	            	 // if string from right has vowel it goes in and swaps the chars, else decrements j by 1
	                if(arr[j]=='a' ||arr[j]=='e' ||arr[j]=='i' ||arr[j]=='o' ||arr[j]=='u' ||arr[j]=='A' ||arr[j]=='E' ||arr[j]=='I' ||arr[j]=='O' ||arr[j]=='U'){
	                    char temp=arr[i];
	                    arr[i]=arr[j];
	                    arr[j]=temp;
	                    i++;
	                    j--;
	                }
	                else{
	                    j--;
	                }
	            }
	            else{
	                i++;
	            }
	         }
	        System.out.println(String.valueOf(arr));
	}
	

}
