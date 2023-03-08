public class Nodo {
    private int data;
    private Nodo link;

    public Nodo(int data) {
        this.data = data;
        this.link = null;
    }

    public Nodo(int data, Nodo link) {
        this.data = data;
        this.link = link;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Nodo getLink() {
        return link;
    }

    public void setLink(Nodo link) {
        this.link = link;
    }
}

