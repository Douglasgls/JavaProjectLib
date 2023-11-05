package entities;

import java.util.List;

public class Academybook extends Itemlib {

	private Integer edicao;
	
	
	public Academybook(String title, List<String> listaAuthor, Integer quantity, String genre, Integer edicao) {
		super(title, listaAuthor, quantity,genre);
		this.edicao = edicao;
		
	}


	public int getEdicao() {
		return edicao;
	}


	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	
	
	@Override
	public String itemType() {
		return "Livro Acadêmico";
	}
}
