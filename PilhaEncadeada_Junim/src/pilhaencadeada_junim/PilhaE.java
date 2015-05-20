package pilhaencadeada_junim;

public class PilhaE implements interfacePilhaEncadeada{

    private int tamanho = 0;
    private NoE topo = null;
    
    @Override
    public void criarPilha() {
        tamanho = 0;
        topo = null;
        System.out.println("Pilha criada!");
    }

    @Override
    public boolean eVazia() {
        return tamanho == 0 || topo == null;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public void limpar() {
        tamanho = 0;
        topo = null;
        System.out.println("Pilha esvaziada!");
    }

    @Override
    public NoE push(int valor) {
            tamanho = tamanho + 1;
            NoE aux = new NoE(valor, topo);
            topo = aux;
            System.out.println("Elemento "+valor+" adicionado.");
            return aux;
    }

    @Override
    public NoE pop() {
        if (eVazia()) {
            System.out.println("Pilha vazia, não posso retirar o elemento desejado.");
            return null;
        } else {
            tamanho = tamanho - 1;
            NoE s = topo;
            System.out.println("Elemento "+s.getNumero()+" retirado.");
            topo = s.getProximo();
            return s;
        }
    }

    @Override
    public int pegarTopo() {
        return topo.getNumero();
    }

    @Override
    public void listar() {
        NoE aux;
        if(topo == null){
            System.out.println("A pilha está vazia!");
        } else {
            aux = topo;
            while(aux!=null){
                System.out.println(aux.getNumero());
                aux = aux.getProximo();
            }
        }
    }
    
}
