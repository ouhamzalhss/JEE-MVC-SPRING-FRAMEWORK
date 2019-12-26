package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import metier.IMetierCatalogue;
import metier.MetierImpl;
import metier.Produit;

public class ControleurServlet extends HttpServlet{

	private IMetierCatalogue metier;
	
	@Override
	public void init() throws ServletException {
       metier = new MetierImpl();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		System.out.println(path);
		ProduitModele model = new ProduitModele();
		if(path.equals("/index.php")) {
			req.getRequestDispatcher("produits.jsp").forward(req, resp);
		}
		else if(path.equals("/chercher.php")) {
			String mc = req.getParameter("mc");
			model.setMotCle(mc);
			List<Produit> prods = metier.getProduitParMotCle(mc);
			model.setProds(prods);
			req.setAttribute("model", model);
			req.getRequestDispatcher("produits.jsp").forward(req, resp);
		}
		else if(path.equals("/saisie.php")) {
			req.setAttribute("produit", new Produit());
			req.getRequestDispatcher("saisie.jsp").forward(req, resp);
		}
		else if(path.equals("/saveProduit.php") && req.getMethod().equals("POST")) {
			Produit p = new Produit();
			p.setNom(req.getParameter("designation"));
			p.setPrix(Double.parseDouble(req.getParameter("prix")));
			p.setQuantite(Integer.parseInt(req.getParameter("qte")));
			metier.saveProduit(p);
			req.setAttribute("produit", p);
			req.getRequestDispatcher("confirmation.jsp").forward(req, resp);
			
		}
		else if(path.equals("/supprimer.php")){
			Long id = Long.parseLong(req.getParameter("id"));
			metier.deleteProduit(id);
			//req.getRequestDispatcher("produits.jsp").forward(req, resp);
			resp.sendRedirect("chercher.php?mc=");
		}
		else if(path.equals("/edit.php")) {
			Long id = Long.parseLong(req.getParameter("id"));
			Produit p = metier.getProduit(id);
			req.setAttribute("produit", p);
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
		}
		else if(path.equals("/UpdateProduit.php") && req.getMethod().equals("POST")){
			Long id = Long.parseLong(req.getParameter("id"));
			Produit p = metier.getProduit(id);
			p.setNom(req.getParameter("designation"));
			p.setPrix(Double.parseDouble(req.getParameter("prix")));
			p.setQuantite(Integer.parseInt(req.getParameter("qte")));
			metier.updateProduit(p);
			req.setAttribute("produit", p);
			req.getRequestDispatcher("confirmation.jsp").forward(req, resp);
		}
		else {
			resp.sendError(Response.SC_NOT_FOUND);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
