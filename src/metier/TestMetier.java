package metier;

import java.util.List;

public class TestMetier {

	public static void main(String[] args) {

		MetierImpl m= new MetierImpl();
		List<Produit> prods = m.getProduitParMotCle("Pc");
		for(Produit p: prods) {
			System.out.println(p);
		}

	}

}
