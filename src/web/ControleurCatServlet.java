package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogueMetierImpl;
import metier.ICatalogueMetier;

/**
 * Servlet implementation class ControleurCatServlet
 */
@WebServlet("/ControleurCatServlet")
public class ControleurCatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ICatalogueMetier metier;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleurCatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
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
		// TODO Auto-generated method stub
	}

}
