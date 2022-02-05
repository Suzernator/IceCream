
/** @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Feb 2, 2022
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class CoffeeOrder {
	@Id
	@GeneratedValue
	@Column(name="queue_number")
	private int number;
	@Column(name="customer_name")
	private String name;
	@Column(name="drink_order")
	private String drink;
	
	public CoffeeOrder() {
		super();
	}
	
	public CoffeeOrder(String name, String drink) {
		super();
		this.name = name;
		this.drink = drink;
	}

	public CoffeeOrder(int number, String name, String drink) {
		super();
		this.number = number;
		this.name = name;
		this.drink = drink;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String returnOrder() {
		return "Order # " + this.number + " for " + this.name + ": " + this.drink;
	}
}
