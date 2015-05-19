package pilhaencadeada_junim;

public interface interfacePilhaEncadeada {
    void criarPilha();
    boolean eVazia();
    int tamanho();
    void limpar();
    NoE push(int valor);
    NoE pop();
    int pegarTopo();
    void listar();
}
