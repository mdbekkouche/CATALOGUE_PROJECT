package metier;

import java.util.List;

import metier.entities.Produit;

import org.hibernate.Session;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class CatalogueMetierImpl implements ICatalogueMetier {

	@Override
	public void addProduit(Produit p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.save(p);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
	}

	@Override
	public List<Produit> listProduits() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req = session.createQuery("select p from Produit p");
		List<Produit> prods = req.list();
		session.getTransaction().commit();
		return prods;
	}

	@Override
	public Produit getProduit(Long idProd) {
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    session.beginTransaction();
	    Object p = session.get(Produit.class, idProd);
	    if (p == null) throw new RuntimeException("Produit introvable");
		return (Produit)p;
	}

	@Override
	public List<Produit> getProduitsParMC(String mc) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req = session.createQuery("select p from Produit p where p.designation like :x");
		req.setParameter("x", "%"+mc+mc+"%");
		List<Produit> prods = req.list();
		session.getTransaction().commit();
		return prods;
	}

	@Override
	public void deleteProduit(Long idProd) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    session.beginTransaction();
	    Object p = session.get(Produit.class, idProd);
	    if (p == null) throw new RuntimeException("Produit introvable");
		session.delete(p);
		session.getTransaction().commit();
	}

	@Override
	public void updateProduit(Produit p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    session.beginTransaction();
	    session.update(p);
	    session.getTransaction().commit();
	}

}
