package Commodity.entity;

import java.io.Serializable;

public class Commodity implements Serializable {
	private Integer id;
	private String name;
	private Integer number;
	private Double price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + ", number=" + number + ", price=" + price + "]";
	}

	public Commodity(Integer id, String name, Integer number, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.price = price;
	}

	public Commodity() {
		super();
	}

	public Commodity(String name, Integer number, Double price) {
		super();
		this.name = name;
		this.number = number;
		this.price = price;
	}

}
