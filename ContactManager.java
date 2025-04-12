import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ContactList contactList = new ContactList();
            int option;
            
            do {
                System.out.println("\n===== Menu de Gerenciamento de Contatos =====");
                System.out.println("1. Adicionar Contato");
                System.out.println("2. Buscar Contato");
                System.out.println("3. Remover Contato");
                System.out.println("4. Listar Contatos");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                option = scanner.nextInt();
                scanner.nextLine(); // consumir a quebra de linha
                
                switch (option) {
                    case 1 -> {
                        System.out.print("Nome: ");
                        String name = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String phone = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        Contact newContact = new Contact(name, phone, email);
                        contactList.addContact(newContact);
                    }
                    case 2 -> {
                        System.out.print("Digite o nome ou telefone do contato: ");
                        String query = scanner.nextLine();
                        Contact found = contactList.searchContact(query);
                        if (found != null) {
                            System.out.println("Contato encontrado:\n" + found);
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                    }
                    case 3 -> {
                        System.out.print("Digite o nome ou telefone do contato a ser removido: ");
                        String toRemove = scanner.nextLine();
                        contactList.removeContact(toRemove);
                    }
                    case 4 -> contactList.listContacts();
                    case 5 -> System.out.println("Saindo... Obrigado por usar o sistema!");
                    default -> System.out.println("Opção inválida.");
                }
            } while (option != 5);
        }
    }
}
