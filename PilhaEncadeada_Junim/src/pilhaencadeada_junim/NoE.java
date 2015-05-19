package pilhaencadeada_junim;

public class NoE {
    private int numero;
    private NoE next;

    NoE(){
        
    }
    
    NoE(int valor, NoE next) {
        this.numero = valor;
        this.next = next;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int valor) {
        this.numero = valor;
    }

    public NoE getProximo() {
        return next;
    }

    public void setProximo(NoE next) {
        this.next = next;
    }
}
