import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
	
	public static List <Fruits> avaibleFruits; 
	public static Map <String, Integer> nuberOfSeparateFruits;
	
	public static void main(String[] args) {
		
		avaibleFruits = new ArrayList<>();
		avaibleFruits.add(new Apple());
		avaibleFruits.add(new Orange());
		
		List<String> receipt =  Arrays.asList("Apple","Apple","Apple","Orange","Orange","Orange");
		
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.print(df.format(total(listOfFruits(avaibleFruits, receipt))));
	}

	// create list of fruits objects, relying on available fruits and array of string
	public static List<Fruits> listOfFruits(List<Fruits> avaibleFruits , List<String> receipt) {
		if ((!receipt.isEmpty() && receipt != null) && (!avaibleFruits.isEmpty() && avaibleFruits != null)) {
			List<Fruits> fruits = new ArrayList<>();
			for (String name : receipt) {
				for(Fruits f : avaibleFruits ) {
					if (name.toLowerCase().equals(f.getName().toLowerCase())) {
						fruits.add(f);
					}
				}
			}
			return fruits;
		}
		return null;
	}
	
	// count total price from list of fruits
	public static float total(List<Fruits> fruits) {
		if(!fruits.isEmpty() && fruits != null) {
			float total = 0;
			for(Fruits fruit : fruits) {
				total += fruit.getPrice();
			}
			// adding discouts to total price
			getNuberOfFruits(fruits);
			total = total - (applesDiscount(fruits) * 0.60f);  
			total = total - (orangeDiscount(fruits) * 0.25f);  
			return total;
		}
		return 0;
	}
	
	// store number of each kind of fruits in map
	public static void getNuberOfFruits(List<Fruits> fruits){
		if(!fruits.isEmpty() && fruits != null) {
			Map<String, Integer> numberF = new HashMap<>();
			for(Fruits avible : avaibleFruits) {
				numberF.put(avible.getName(), 0);
			}
			for(Fruits avible : avaibleFruits) {
				for(Fruits fruit : fruits) {
					if(fruit.getName().toLowerCase().equals(avible.getName().toLowerCase())) {
						numberF.replace(fruit.getName(), numberF.get(fruit.getName())+1);
					}
				}
			}
			nuberOfSeparateFruits = numberF;	
		}
	}
	
	// discount for each of fruits
	public static int applesDiscount(List<Fruits> fruits) {
		if(!fruits.isEmpty() && fruits != null) {
			int apples = nuberOfSeparateFruits.get("apple");
			if( apples >= 2) {
				if(apples%2 >0) {
					return (apples - 1) / 2; 
				}else return apples  / 2 ; 
			}
		}
		return 0;		
	}
	
	public static int orangeDiscount(List<Fruits> fruits) {
		if(!fruits.isEmpty() && fruits != null) {
			int oranges = nuberOfSeparateFruits.get("orange");
			if(oranges >= 3) {
				if(oranges%3 >0) {
					return (oranges - (oranges%3)) / 3; 
				}else return oranges  / 3 ; 
			}
		}
		return 0;		
	}
}
