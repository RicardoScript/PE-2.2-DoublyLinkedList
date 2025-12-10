public class Main {
    public static void main(String[] args) {

        System.out.println("============= PARTE 1: Estructura basica ==============");

        DoublyLinkedList list = new DoublyLinkedList();

        System.out.println("Lista vacia: " + list.isEmpty());

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(60);

        System.out.println("Lista creada: ");

        list.display();

        System.out.println("============= PARTE 2: ALgoritmo de inversion ==============");
        System.out.println("Lista original");
        list.display();
        System.out.println("Lista reverse");
        list.reverse();
        list.display();


        DoublyLinkedList singleList = new DoublyLinkedList();

        System.out.println("UN solo elemento (Caso borde): ");
        singleList.insertAtEnd(60);
        singleList.display();
        System.out.println("Reversa");
        list.reverse();
        list.display();

        System.out.println("============= PARTE 3: Eliminacion de nodos ==============");
        System.out.println("====== PARTE 3.1: Eliminacion de nodos =====");
        System.out.println("Lista original");
        list.display();
        System.out.println("Nodo eliminado:" + list.deleteByValue(40));
        // list.deleteByValue(40);
        list.display();

    }
}
