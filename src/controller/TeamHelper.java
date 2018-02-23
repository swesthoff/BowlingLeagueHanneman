package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Team;

public class TeamHelper {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueHanneman");
	
	public void insertTeam(Team t) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
}
