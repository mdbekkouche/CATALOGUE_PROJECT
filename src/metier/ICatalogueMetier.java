package metier;

import java.util.List;

import metier.entities.Produit;

public interface ICatalogueMetier {
	public void addProduit(Produit p);
	public List<Produit> listProduits();
	public Produit getProduit(Long idProd);
	public List<Produit> getProduitsParMC(String mc);
	public void deleteProduit(Long idProd);
	public void updateProduit(Produit p);	
}
