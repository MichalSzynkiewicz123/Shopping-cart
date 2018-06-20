import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingCart {
	
	public static List <Fruits> avaibleFruits; 
	
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
			return total;
		}
		return 0;
	}
}
