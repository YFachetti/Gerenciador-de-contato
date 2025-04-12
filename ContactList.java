public class ContactList {
    private Node head;

    public void addContact(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Contato adicionado com sucesso!");
    }

    public Contact searchContact(String nameOrPhone) {
        Node current = head;
        while (current != null) {
            if (current.contact.getName().equalsIgnoreCase(nameOrPhone) ||
                current.contact.getPhoneNumber().equals(nameOrPhone)) {
                return current.contact;
            }
            current = current.next;
        }
        return null;
    }

    public boolean removeContact(String nameOrPhone) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.contact.getName().equalsIgnoreCase(nameOrPhone) ||
                current.contact.getPhoneNumber().equals(nameOrPhone)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                System.out.println("Contato removido com sucesso!");
                return true;
            }
            previous = current;
            current = current.next;
        }

        System.out.println("Contato não encontrado.");
        return false;
    }

    public void listContacts() {
        if (head == null) {
            System.out.println("A lista de contatos está vazia.");
            return;
        }

        Node current = head;
        System.out.println("Lista de Contatos:");
        while (current != null) {
            System.out.println(current.contact);
            current = current.next;
        }
    }
}
