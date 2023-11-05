package entities;

import java.util.ArrayList;

public class Usuario {
	
	private String name;
	private String cpf;
    private ArrayList<Itemlib> books = new ArrayList<>();	
	
	public Usuario(String name, String cpf) {
		this.name = name;
		this.cpf = cpf;
	} 
	
	protected void addBook(Itemlib book) {
		books.add(book);
	}
	protected void removeBook(Itemlib book) {
		books.remove(book);
	}
	
	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public void book_list() {
		for (Itemlib book : books) {
			System.out.println("Título: " + book.getTitle());
	        System.out.println("Autores: " + book.getAuthor());
	        System.out.println("Quantidade: " + book.getQuantity());
	        System.out.println("Gênero: " + book.getGenre());
		}
	}
	@Override
	public String toString() {
		return "Name: " + getName()
		+ ", Cpf: " + getCpf();
	}
		
	
}
