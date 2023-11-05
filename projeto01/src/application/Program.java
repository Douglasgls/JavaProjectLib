package application;

import entities.Academybook;
import entities.Book;
import entities.Error;
import entities.Itemlib;
import entities.Library;
import entities.Usuario;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Program {

    public static void main(String[] args) throws Exception {
        List<Usuario> listaUsuario = new ArrayList<>();
        Library library = new Library();
        int comando = -1;
        Scanner sc = new Scanner(System.in);
        
            while (comando != 0) {
                System.out.println();
                System.out.println("0 = exit\n"
                        + "1 = New library Item\n"
                        + "2 = Available items\n"
                        + "3 = New user\n"
                        + "4 = To loan item\n"
                        + "5 = See user books\n"
                        + "6 = Return item\n"
                );
                System.out.println("What do you want?");
                comando = sc.nextInt();

                if (comando == 1) {
                    try {
                        List<String> listaAuthor = new ArrayList<>();
                        System.out.println("What type of book? [a/p]");
                        char tipo = sc.next().charAt(0);
                        
                        if (tipo == 'a') {
                            System.out.println("What title book?");
                            sc.nextLine();
                            String title = sc.nextLine();
                            
                            int num = 0;
                            boolean validInput = false;

                            while (!validInput) {
                                System.out.println("How many authors?");
                                try {
                                    num = sc.nextInt();
                                    sc.nextLine();
                                    if (num > 0) {
                                        validInput = true;
                                    } else {
                                    	throw new Error("Please enter a valid number (greater than 0) for the authors.");
                                        
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter a number for the authors.");
                                    ;
                                }
                            }

                            for (int i = 0; i < num; i++) {
                                System.out.println("Enter author " + (i + 1) + ":");
                                
                                listaAuthor.add(sc.nextLine());
                            }

                            int stockQuantity = 0;
                            validInput = false;
                            while (!validInput) {
                                System.out.println("Stock quantity?");
                                try {
                                    stockQuantity = sc.nextInt();
                                    if (stockQuantity > 0) {
                                        validInput = true;
                                    } else {
                                        throw new Error("numero invalido tente de novo.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter a number for the stock quantity.");
                                }
                            }
                            System.out.println("Genre?");
                            String genre = sc.next();
                            
                            int edition = 0;
                            boolean validEdition =  false;
                            
                            while(!validEdition) {
                            	System.out.println("Edition? ");
                            	try {
                            		edition = sc.nextInt();
                            		if(edition<=0) {
                            			 throw new Error("Erro edition");
                            		}
                            		else {
                            			validEdition = true;
                            		}
                            		
                            	}
                            	 catch (NumberFormatException e) {
                                     System.out.println("Invalid input. Please enter a number for the stock quantity.");
                                 }
                            }
                            library.adicionarItem(new Academybook(title, listaAuthor, stockQuantity, genre, edition));
                        } else {
                            System.out.println("What title book?");
                            sc.nextLine();
                            String title = sc.nextLine();
                            
                            int num = 0;
                            boolean validInput = false;

                            while (!validInput) {
                                System.out.println("How many authors?");
                                try {
                                    num = sc.nextInt();
                                    sc.nextLine();
                                    if (num > 0) {
                                        validInput = true;
                                    } else {
                                        System.out.println("Please enter a valid number (greater than 0) for the authors.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter a number for the authors.");
                                }
                            }

                            for (int i = 0; i < num; i++) {
                                System.out.println("Enter author " + (i + 1) + ":");
                                listaAuthor.add(sc.nextLine());
                            }
                            int quantity = 0;
                            boolean validQuatity = false;
                            
                            while(!validQuatity) {
                            	System.out.println("Stock quantity?");
                            	try {
                            		quantity = sc.nextInt();		
                            		if (quantity >0) {
                            			validQuatity = true;
                            			
                            		}else {
                            			 System.out.println("Please enter a valid number (greater than 0).");
                            		}
								} catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter a number for the authors.");
                                }
                            }
                            System.out.println("Genre?");
                            String genre = sc.next();
                            System.out.println("ISBN?");
                            int isbn = sc.nextInt();
                            library.adicionarItem(new Book(title, listaAuthor, quantity, genre, isbn));
                        }
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    
                } else if (comando == 2) {
                	
                        int choice = library.listarItensDisponiveis();
                           if(choice == 0) {
                        	   System.out.println();
                               System.out.println("Não há itens disponíveis na biblioteca no momento.");
                           }
                } else if (comando == 3) {
                    System.out.println("Enter name");
                    sc.nextLine();
                    String name = sc.nextLine();
                    
                    
                    String cpf = "1";
                    boolean validcpf = false;
                    while (!validcpf) {
                    	System.out.println("Enter cpf: ");
                    	
                    	try {
                    		cpf = sc.next();
                    		if (cpf.length() != 11) {
								throw new Error("Invalid cpf: o mesmo não tem 11 digitos validos");
							}
                    		else {
                    			validcpf = true;
                    		}
                    		for (Usuario user : listaUsuario) {
                				if (user.getCpf().equals(cpf)) {  			
                					cpf = "1";
                				}
                			}
						} catch (Exception e) {
							System.out.println("Invalid CPF");
						}
					}
                    
                    if (cpf.equals("1")) {
                    	System.out.println("\"Invalid cpf:  cpf já foi cadastrado em nosso banco de dados. \"");
					}else {
						listaUsuario.add(new Usuario(name, cpf));						
					}

                } else if (comando == 4) {
                    Itemlib book = null;
                    Usuario user = null;
                    library.listarItensDisponiveis();
                    System.out.println("Which book to borrow?");
                    sc.nextLine();
                    String bookTitle = sc.nextLine();
      
                    boolean validcpf = false;
                    String userCpf = "11111111111";
                    while (!validcpf) {
                    	System.out.println("Which user cpf?");
                    	
                    	try {
                    		userCpf = sc.next();
                    		if ( userCpf.length() != 11) {
								throw new Error("invalid CPF!");
							}
                    		else {
                    			validcpf = true;
                    		}
						} catch (Exception e) {
							System.out.println("Invalid input. entre com numeros");
						}
						
						
					}
                    
                    for (Itemlib item : library.getItensDisponiveis()) {
                        if (item.getTitle().equals(bookTitle)) {
                            book = item;
                        }
                    }
                    for (Usuario usuario : listaUsuario) {
                        if (usuario.getCpf().equals(userCpf)) {
                            user = usuario;
                        }
                    }
                    library.emprestarItem(book, user);
                } else if (comando == 5) {
                	boolean validcpf = false;
                    String userCpf = "11111111111";
                    while (!validcpf) {
                    	System.out.println("Which user cpf?");
                    	
                    	try {
                    		userCpf = sc.next();
                    		if (userCpf.length() != 11) {
								throw new Error("invalid CPF!");
							}
                    		else {
                    			validcpf = true;
                    		}
						} catch (Exception e) {
							System.out.println("Invalid input. entre com numeros");
						}	
					}
                    for (Usuario user : listaUsuario) {
                        if (user.getCpf().equals(userCpf)) {
                            user.book_list();
                        }
                    }
                } else if (comando == 6) {
                    Itemlib book = null;
                    Usuario user = null;
                    
                    String userCpf = "111111111111";
                    boolean validcpf = false;
                    while (!validcpf) {
                    	System.out.println("Which user cpf?");
                    	
                    	try {
                    		userCpf = sc.next();
                    		if (userCpf.length() != 11) {
								throw new Error("invalid CPF!");
							}
                    		else {
                    			validcpf = true;
                    		}
						} catch (Exception e) {
							System.out.println("Invalid input. entre com numeros");
						}
						
						
					}
                    
                    
                    System.out.println("Enter title: ");
                    sc.nextLine();
                    String title = sc.nextLine();
                    for (Usuario usuario : listaUsuario) {
                        if (usuario.getCpf().equals(userCpf)) {
                            user = usuario;
                        }
                    }
                    
                    for (Itemlib item : library.getItensEmprestados()) {
                        if (item.getTitle().equals(title)) {
                            book = item;
                        }
                    }
                    try {						
                    	library.devolverItem(book, user);
					} catch (Exception e) {
						System.out.println("Invalid input. item invalido ");
										}
                } else { 
                    System.out.println("Invalid command !!!");
                    System.out.println("Try again");
                }
          
            }
            sc.close();
    }
}