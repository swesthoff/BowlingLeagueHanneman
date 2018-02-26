package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Player;

public class PlayerHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueHanneman");
	
	public void insertItem(Player toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Player> showAllItems() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Player> allResults = em.createQuery("Select li from Player li", Player.class); 
		List<Player> allItems = allResults.getResultList();
		em.close();
		
		return allItems;
	} 
	
	public void deleteItem(Player toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select li from Player li where li.firstName = :selectedFirstName and li.lastName = :selectedLastName", Player.class);
		typedQuery.setParameter("selectedfirstName", toDelete.getFirstName());
		typedQuery.setParameter("selectedlastName",  toDelete.getLastName());
		typedQuery.setMaxResults(1);
		Player result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
}
