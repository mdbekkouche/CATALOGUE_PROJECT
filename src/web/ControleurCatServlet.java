package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogueMetierImpl;
import metier.ICatalogueMetier;
import metier.entities.Produit;

/**
 * Servlet implementation class ControleurCatServlet
 */
@WebServlet("/ControleurCatServlet")
public class ControleurCatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ICatalogueMetier metier;
	
    
    
    @Override
    public void init() throws ServletException {
    	metier = new CatalogueMetierImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("produits", metier.listProduits());
		request.getRequestDispatcher("/WEB-INF/vues/Produits.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("save")) {
			String des = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int qte = Integer.parseInt(request.getParameter("quantite"));
			metier.addProduit(new Produit(des,prix,qte));			
		}
		request.setAttribute("produits", metier.listProduits());
		request.getRequestDispatcher("/WEB-INF/vues/Produits.jsp").forward(request, response);	
	}

}
