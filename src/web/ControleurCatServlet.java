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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("Save")) {

				String des;
				double prix;
				int qte;
				try {
					des = request.getParameter("designation");
					prix = Double.parseDouble(request.getParameter("prix"));
					qte = Integer.parseInt(request.getParameter("quantite"));
					metier.addProduit(new Produit(des, prix, qte));
				} catch (Exception e) {
					request.setAttribute("exception", "Erreur de saisie");
				}

			} else if (action.equals("supprimer")) {
				Long id = Long.parseLong(request.getParameter("id"));
				metier.deleteProduit(id);
			} else if (action.equals("editer")) {
				Long id = Long.parseLong(request.getParameter("id"));
				Produit p = metier.getProduit(id);
				request.setAttribute("produit", p);
			} else if (action.equals("Update")) {
				try {
					Long idP = Long.parseLong(request.getParameter("idProduit"));
					String des = request.getParameter("designation");
					double prix = Double.parseDouble(request.getParameter("prix"));
					int qte = Integer.parseInt(request.getParameter("quantite"));
					Produit p = new Produit(des, prix, qte);
					p.setIdProduit(idP);
					metier.updateProduit(p);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("exception", "Erreur de saisie");
				}
			}
		}
		request.setAttribute("produits", metier.listProduits());
		request.getRequestDispatcher("/WEB-INF/vues/Produits.jsp").forward(request, response);	
	}

}
