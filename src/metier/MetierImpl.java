package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements IMetierCatalogue {

	@Override
	public List<Produit> getProduitParMotCle(String mc) {
		System.out.println(mc+"--------------------------");
		List<Produit> listProd = new ArrayList<Produit>();
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement pr = con.prepareStatement("SELECT * FROM produit where nom like ? ");
			pr.setString(1, "%"+mc+"%");
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getLong("Id"));
				p.setNom(rs.getString("nom"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				listProd.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(listProd.size());
		return listProd;
	}

	@Override
	public void addProduit(Produit p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Produit saveProduit(Produit p) {
		Connection con = SingletonConnection.getConnection();
		try {
			
			System.out.println();
			
			// SAVE PRODUIT
			PreparedStatement pr = con.prepareStatement("insert into produit values (null,?,?,?)");
			pr.setString(1, p.getNom());
			pr.setDouble(2, p.getPrix());
			pr.setInt(3, p.getQuantite());
			pr.executeUpdate();
			
			// Get ID PRODUIT
			PreparedStatement ps2 = con.prepareStatement("SELECT MAX(ID) AS MAXID FROM produit");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				p.setId(rs.getLong("MAXID"));
			}
			
			pr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Produit updateProduit(Produit p) {
		Connection con = SingletonConnection.getConnection();
		try {
			
			// Update PRODUIT
			PreparedStatement pr = con.prepareStatement("update produit set nom=?, prix=?, quantite=? where id=? ");
			pr.setString(1, p.getNom());
			pr.setDouble(2, p.getPrix());
			pr.setInt(3, p.getQuantite());
			pr.setLong(4, p.getId());
			pr.executeUpdate();
			pr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Produit getProduit(Long id) {
		Connection con = SingletonConnection.getConnection();
		Produit p = new Produit();
		try {
			PreparedStatement pr = con.prepareStatement("SELECT * FROM produit where id= ? ");
			pr.setLong(1, id);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				
				p.setId(rs.getLong("Id"));
				p.setNom(rs.getString("nom"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deleteProduit(Long id) {
		Connection con = SingletonConnection.getConnection();
		try {
			
			System.out.println();
			
			// SAVE PRODUIT
			PreparedStatement pr = con.prepareStatement("delete from produit where id=? ");
			pr.setLong(1, id);
			pr.executeUpdate();
			pr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void init() {
		System.out.println("Initialisation.........");
	}

}
