package metier;

import java.util.List;

public interface IMetierCatalogue {
	
	public List<Produit> getProduitParMotCle(String mc);
	public void addProduit(Produit p);
	public Produit saveProduit(Produit p);
	public Produit updateProduit(Produit p);
	public Produit getProduit(Long id);
	public void deleteProduit(Long id);

}
