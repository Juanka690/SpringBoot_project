public class Main {

    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.crearLista();
        lista.insertarAlaCabeza(8);
        lista.insertarALaCola(9);
        lista.insertarEnIndice(7, 2);
        lista.visualizarLista();
    }

}
