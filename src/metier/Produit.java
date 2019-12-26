package metier;

import java.io.Serializable;

public class Produit implements Serializable{

	private Long Id;
	private String nom;
	private Double prix;
	private int quantite;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	@Override
	public String toString() {
		return "Produit [Id=" + Id + ", nom=" + nom + ", prix=" + prix + "]";
	}
	public Produit(Long id, String nom, Double prix,int qte) {
		super();
		Id = id;
		this.nom = nom;
		this.prix = prix;
		this.quantite = qte;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
}
