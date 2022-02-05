/** @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Feb 2, 2022
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CoffeeOrder;


public class OrderHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CoffeeOrder");

	public void insertDrink(CoffeeOrder ordr) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ordr);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<CoffeeOrder> showAllDrinks(){
		EntityManager em = emfactory.createEntityManager();
		List<CoffeeOrder> allDrinks = em.createQuery("select ordr from CoffeeOrder ordr").getResultList();
		return allDrinks;
	}

	public void deleteDrink(CoffeeOrder toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CoffeeOrder> typedQuery = em.createQuery("select ordr from CoffeeOrder ordr where ordr.number = :selectedNumber and ordr.name = :selectedName and ordr.drink = :selectedDrink", CoffeeOrder.class);
		
		typedQuery.setParameter("selected number", toDelete.getNumber());
		typedQuery.setParameter("selected name", toDelete.getName());
		typedQuery.setParameter("selected drink", toDelete.getDrink());
		
		typedQuery.setMaxResults(1);
		
		CoffeeOrder result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public CoffeeOrder searchOrderByNum(int numToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CoffeeOrder found = em.find(CoffeeOrder.class, numToEdit);
		em.close();
		return found;
	}
	
	public void updateDrink(CoffeeOrder toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CoffeeOrder> searchOrderByName(String customerName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CoffeeOrder> typedQuery = em.createQuery("select ordr from CoffeeOrder ordr where ordr.name = :selectedName", CoffeeOrder.class);
		typedQuery.setParameter("selectedName", customerName);
		
		List<CoffeeOrder> foundDrinks = typedQuery.getResultList();
		em.close();
		return foundDrinks;
	}
	
	public List<CoffeeOrder> searchOrderByDrink(String drinkName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CoffeeOrder> typedQuery = em.createQuery("select ordr from CoffeeOrder ordr where ordr.drink = :selectedDrink", CoffeeOrder.class);
		typedQuery.setParameter("selectedDrink", drinkName);
		
		List<CoffeeOrder> foundDrinks = typedQuery.getResultList();
		em.close();
		return foundDrinks;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
