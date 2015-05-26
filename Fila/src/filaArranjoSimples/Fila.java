package filaArranjoSimples;

public class Fila implements interfaceFilaASimples {

    private NoVS fila[];
    private int capacidade;
    private int inicio = 0;
    private int fim = 0;

    @Override
    public void criarFila(int tamanho) {
        fila = new NoVS[tamanho];
        capacidade = tamanho;
        System.out.println("Fila criada.");
    }

    @Override
    public boolean eCheia() {
        return fim == capacidade;
    }

    @Override
    public boolean eVazia() {
        return fim == inicio;
    }

    @Override
    public int tamanho() {
        return fim + 1;
    }

    @Override
    public NoVS enfileirar(int valor) {
        if (!eCheia()) {
            NoVS elemento = new NoVS(valor);
            fila[fim++] = elemento;
            System.out.println("Elemento "+valor+" adicionado.");
            return elemento;
        }
        System.out.println("A fila está cheia.");
        return null;
    }

    @Override
    public NoVS desenfileirar() {
        if (!eVazia()) {
            NoVS aux = fila[inicio];
            fila[inicio++] = null;
            System.out.println("Elemento "+aux.getValor()+" retirado.");
            return aux;
        }
        System.out.println("A fila não possui elementos.");
        return null;
    }

    @Override
    public int pegarInicio() {
        if (inicio != 0 && fim != 0) {
            return fila[inicio].getValor();
        } else {
            return -1;
        }

    }

    @Override
    public void listar() {
        if (!eVazia()) {
            for (int i = inicio; i < fim; i++) {
                System.out.println(fila[i].getValor());
            }
            System.out.println("----------------------------------");
        }
    }

}