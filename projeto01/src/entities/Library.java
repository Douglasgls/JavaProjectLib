package entities;
import java.util.ArrayList;

public class Library {

    private ArrayList<Itemlib> itensDisponiveis = new ArrayList<>();
    private ArrayList<Itemlib> itensEmprestados = new ArrayList<>();


	// Método para adicionar um item à biblioteca
    public void adicionarItem(Itemlib item) {
        itensDisponiveis.add(item);
    }

   
    // Método para listar os itens disponíveis na biblioteca
    public int listarItensDisponiveis() {
        System.out.println("Itens Disponíveis na Biblioteca:");
        if (itensDisponiveis.isEmpty()) {
            return 0;
        } else {
            for (Itemlib item : itensDisponiveis) {
                System.out.println("title: " + item.getTitle() + ", Quantity: " + item.getQuantity());
            }
            System.out.println(" ");
            return 1;
        }
    }

    // Método para emprestar um item da biblioteca
    public void emprestarItem(Itemlib item, Usuario usuario) throws Exception{
        if (itensDisponiveis.contains(item)) {
            itensEmprestados.add(item);
            item.setQuantity(item.getQuantity() - 1);
            usuario.addBook(item);
            System.out.println("Item emprestado com sucesso: " + item.getTitle());
            if (item.getQuantity() == 0) {
                itensDisponiveis.remove(item);
            }
        } else {
        	throw new Exception("Item não disponível para empréstimo: " + item.getTitle());
    
        }
    }

    public ArrayList<Itemlib> getItensDisponiveis() {
		return itensDisponiveis;
	}

	public ArrayList<Itemlib> getItensEmprestados() {
		return itensEmprestados;
	}

	// Método para devolver um item à biblioteca 
    public void devolverItem(Itemlib item, Usuario user) throws Exception {
        if (itensEmprestados.contains(item)) {
            itensEmprestados.remove(item);
            user.removeBook(item);
            if (item.getQuantity() == 0) {
            	itensDisponiveis.add(item);
            }else {
            	item.setQuantity(item.getQuantity() + 1);
            }
            System.out.println("Item devolvido com sucesso: " + item.getTitle());
        } else {
        	throw new Exception("Item não pode ser devolvido, pois não foi emprestado: " + item.getTitle());
        }
    }
}
