package entities;


import java.util.List;

public class Book extends Itemlib{
    private Integer isbn;

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Book(String title, List<String> author, Integer quantity, String genre, Integer isbn) {
        super(title, author, quantity, genre);
        this.isbn = isbn;
    }

    public Integer getIsbn() {
        return isbn;
    }

    @Override
    public String itemType() {
        return "Livro padrão";
    }

}