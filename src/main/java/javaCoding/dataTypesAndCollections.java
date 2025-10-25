package javaCoding;

import java.util.*;

import org.testng.annotations.Test;

public class dataTypesAndCollections {
	
	@Test(enabled = true, dependsOnMethods = "Map")
	public void set() {
		
		Set<String> set = new HashSet<>();
		
		set.add("test");
		set.add("check");
		set.add("check");
		
		System.out.println(set);
		
		set.remove("check");
		System.out.println(set);
		
		
		Set<String> setWithValuesDruingDeclaration = new HashSet<>(List.of("value1","value2"));
		System.out.println(setWithValuesDruingDeclaration.size());
		
		List<String> listOfValues = List.of("listVal1","listval2","listVal3");
		//listOfValues.add("test");  we cannot add values when data inserted into collections using list.of or set.of or map.of as collection will be created as immutable.
		// We use below line or 24 line to assign values using list.of or map.of or set.of passing as collection and modify afterwards.
		Set<String> setListDruingDeclaration = new HashSet<>(listOfValues);
		System.out.println(setListDruingDeclaration.size());
		
		List<String> listOfValues2 = new ArrayList<>(List.of("listVal1","listVal1","listVal3"));
		Set<String> removeDupes = new HashSet<>(listOfValues2);
		System.out.println(removeDupes.size());
		System.out.println(removeDupes);
		
	}
	
	@Test(enabled = true , priority = 1)
	public void List() {
		
		List<String> list = new ArrayList<>();
		
		list.add("test");
		list.add("check");
		list.add(1,"insertBetween");
		
		System.out.println(list);
		
		list.remove("check");
		System.out.println(list);
		
		
		
		List<String> listOfValues = new ArrayList<>(List.of("listVal1","listval2","listVal3"));
		listOfValues.add("Test");
		listOfValues.set(2,"Test2");	
		System.out.println(listOfValues);
		
		
		
	}
	
	@Test(enabled = true, priority = 1)
	public void Map() {
		
		
		Map<String, Integer> map = new LinkedHashMap<>();
		
		map.put("test",4);
		map.put("checking",7);
		
		System.out.println(map);
		
		map.remove("checking");
		System.out.println(map);
		
		
		
		Map<Character, Integer> mapWithValuesDec = new LinkedHashMap<>(Map.of('c',1,'d',2));
		mapWithValuesDec.put('e',3);
		mapWithValuesDec.put('e',4);	
		System.out.println(mapWithValuesDec);
		
		for(Map.Entry<Character, Integer> eachKeyValue : mapWithValuesDec.entrySet()) {
			System.out.println(eachKeyValue.getKey() +" : "+ eachKeyValue.getValue());
		}
		
		String text = "prashanth";
		
		
		
	}

}
