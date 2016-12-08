import metier.CatalogueMetierImpl;
import metier.entities.Produit;


public class TestMetier {

	public static void main(String[] args) {
		CatalogueMetierImpl metier = new CatalogueMetierImpl();
		metier.addProduit(new Produit("HP 876", 7864.90, 4));
		metier.addProduit(new Produit("HP 52654", 8000, 7));
		metier.addProduit(new Produit("Compaq", 4000, 3));
	}

}
