package web;

import java.util.ArrayList;
import java.util.List;

import metier.Produit;

public class ProduitModele {
	
	private String motCle;
	List<Produit> prods = new ArrayList<Produit>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Produit> getProds() {
		return prods;
	}
	public void setProds(List<Produit> prods) {
		this.prods = prods;
	}

	
	
}
