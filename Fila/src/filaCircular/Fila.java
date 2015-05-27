package filaCircular;

import filaArranjoSimples.NoVS;

public class Fila implements interfaceFilaCircular {

    private int capacidade;
    private int quantidade = 0;
    private NoFC fila[];
    private int inicio = 0;
    private int fim = 0;
    
    @Override
    public void criarFila(int tamanho) {
        fila = new NoFC[tamanho];
        capacidade = tamanho;
        System.out.println("Fila criada.");
    }

    @Override
    public boolean eCheia() {
        return quantidade == capacidade;
    }

    @Override
    public boolean eVazia() {
        return quantidade == 0;
    }

    @Override
    public int tamanho() {
        return fim + 1;
    }

    @Override
    public NoFC enfileirar(int valor) {
        if (!eCheia()) {
            NoFC elemento = new NoFC(valor);
            if(quantidade < capacidade && fim < capacidade){
                fila[fim++] = elemento;
                quantidade++;
                System.out.println("Elemento "+valor+" adicionado no campo "+fim);
                return elemento;
            } else if (fim == capacidade){
                fim = 0;
                fila[++fim] = elemento;
                quantidade++;
                System.out.println("Elemento "+valor+" adicionado no campo "+fim);
                return elemento;
            }
        }
        System.out.println("A fila está cheia.");
        return null;
    }

    @Override
    public NoFC desenfileirar() {
        if (!eVazia()) {
                NoFC aux = fila[inicio];
                fila[inicio++] = null;
                quantidade--;
                System.out.println("Elemento "+aux.getValor()+" retirado do campo "+inicio+".");
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
// batata
