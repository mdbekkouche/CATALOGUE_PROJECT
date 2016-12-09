import java.util.List;

import metier.CatalogueMetierImpl;
import metier.entities.Produit;


public class TestMetier {

	public static void main(String[] args) {
		CatalogueMetierImpl metier = new CatalogueMetierImpl();
		metier.addProduit(new Produit("HP 876", 7864.90, 4));
		metier.addProduit(new Produit("HP 52654", 8000, 7));
		metier.addProduit(new Produit("Compaq", 4000, 3));
		
		List<Produit> prods = metier.getProduitsParMC("H");
		for (Produit p : prods) {
			System.out.println(p.getDesignation());			
		}
		System.out.println("--------------------");
		Produit p = metier.getProduit(1L);
		System.out.println(p.getDesignation());
		System.out.println(p.getPrix());
		p.setPrix(11111);
		metier.updateProduit(p);
		System.out.println("--------------------");
		metier.deleteProduit(1L);
	}

}
