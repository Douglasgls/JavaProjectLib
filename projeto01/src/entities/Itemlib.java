package entities;

import java.util.ArrayList;
import java.util.List;

import interfaces.InterfaceModel;

public abstract class Itemlib implements InterfaceModel {

	private String title;
	
	private ArrayList<String> author; 
	
	private Integer quantity;
	
	private String genre;
	
	
	 public Itemlib(String title, List<String> listaAuthor, int quantity, String genre) {
	        this.title = title;
	        this.author = (ArrayList<String>) listaAuthor;
	        this.quantity = quantity;
	        this.genre = genre;
	    }
	
	  public String itemtype() {
	        return "Item Genérico da Biblioteca";
	    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<String> getAuthor() {
		return author;
	}

	public void setAuthor(ArrayList<String> author) {
		this.author = author;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	  
	  
	  
}
