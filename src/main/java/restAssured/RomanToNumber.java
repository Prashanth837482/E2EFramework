package restAssured;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class RomanToNumber {
	
	@Test()
	public void romanToNumer() {
		
	String InputRoman="MCMIV";
	int length = InputRoman.length();
	int number=0;
		
	Map<Character,Integer> roman = new HashMap<Character,Integer>() ;

    roman.put('I', 1);
    roman.put('V', 5);
    roman.put('X', 10);
    roman.put('L', 50);
    roman.put('C', 100);
    roman.put('D', 500);
    roman.put('M', 1000);
    
    
    for(int i =0; i < length ; i++) {
    	
    	if(i!=length && roman.get(InputRoman.charAt(i)) < roman.get(InputRoman.charAt(i+1))) {
    		
    		number+= roman.get(InputRoman.charAt(i+1))-roman.get(InputRoman.charAt(i));
    		i++;
    	}
    	else {
    		number+=roman.get(InputRoman.charAt(i));
    	}
    }
    
    System.out.println("number is: "+number);
    
	}

}
