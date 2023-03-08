import java.util.Scanner;

public class Lista {
    private Nodo head;

    public Lista() {
        head = null;
    }

    public void crearLista() {
        Scanner sc = new Scanner(System.in);
        int dato;
        System.out.println("Ingrese enteros o -1 para terminar");
        dato = sc.nextInt();
        while (dato != -1) {
            head = new Nodo(dato, head);
            dato = sc.nextInt();
        }
        sc.close();
    }

    public void visualizarLista() {
        Nodo temp = head;
        if (temp == null) {
            System.out.println("La lista está vacía");
        } else {
            while (temp != null) {
                System.out.print(temp.getData() + " | ");
                temp = temp.getLink();
            }
            System.out.println();
        }
    }

    public void insertarAlaCabeza(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setLink(head);
        head = nuevo;
    }

    public void insertarALaCola(int dato) {
        Nodo ultimo = new Nodo(dato);
        Nodo temp = head;
        if (temp == null) {
            head = ultimo;
        } else {
            while (temp.getLink() != null) {
                temp = temp.getLink();
            }
            temp.setLink(ultimo);
        }
    }
    public void insertarEnIndice(int dato, int indice) {
        if (indice < 0) {
            System.out.println("Índice inválido");
            return;
        }
        Nodo nuevo = new Nodo(dato);
        if (indice == 0) {
            nuevo.setLink(head);
            head = nuevo;
        } else {
            Nodo temp = head;
            int contador = 0;
            while (temp != null && contador < indice - 1) {
                temp = temp.getLink();
                contador++;
            }
            if (temp == null) {
                System.out.println("Índice inválido");
            } else {
                nuevo.setLink(temp.getLink());
                temp.setLink(nuevo);
            }
        }
    }
}
