/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

/**
 *
 * @author Junim
 */
public class ArvoreBin implements interfaceArvoreBinaria{

    NoArvore raiz;
    
    @Override
    public NoArvore raiz() {
        return raiz;
    }

    @Override
    public NoArvore buscar(int valor) {
        NoArvore inter = raiz;
        while (inter != null){
                if (valor == inter.getChave()){
                    return inter;
                }
                if (valor < inter.getChave()){
                    System.out.println(valor+" encontrado! À sua esquerda está "+inter.getChave());
                    inter = inter.getEsquerda(); // Anda para a esquerda.
                } else {
                    System.out.println(valor+" encontrado! À sua direita está "+inter.getChave());
                    inter = inter.getDireita(); // Anda para a direita.
                }
            }
            return null;
        } 

    @Override
    public void inserirItr(int valor) {
        NoArvore no = new NoArvore(valor);
        no.setEsquerda(null);
        no.setDireita(null);

        // Verificar se árvore está vazia
        if(raiz == null){
            raiz = no; // Inseriu
            System.out.println("Árvore criada com a raiz: "+valor);
            return;
        }
        //Andar nos Nós
        NoArvore noTemporario = raiz;
        while (noTemporario != null){
            if(valor == noTemporario.getChave()){
                System.out.println("Esse nó já existe!");
                return; // Nó já existe!! Abandona.
            }
            if(valor < noTemporario.getChave()){
                // Verificar lado esquerdo
                if (noTemporario.getEsquerda() == null){
                    System.out.println(valor+" inserido à esquerda de: "+noTemporario.getChave());
                    no.setChave(valor);
                    noTemporario.setEsquerda(no); // Insere na esquerda.
                    return;
                }
                noTemporario = noTemporario.getEsquerda(); // Anda para a esquerda.
            } else {
                // Verificar lado direito.
                if(noTemporario.getDireita() == null){
                    System.out.println(valor+" inserido à direita de: "+noTemporario.getChave());
                    no.setChave(valor);
                    noTemporario.setDireita(no); // Insere na direita.
 
                    return;
                }
                noTemporario = noTemporario.getDireita(); // Anda para a direita.
            }
        }
    }

    @Override
    public void inserirRec(int valor) {
        NoArvore aux = raiz;
        
        if (aux != null){
            if (valor < aux.getChave()){
                if (aux.getEsquerda() != null) { 
                   inserirRec(Integer.parseInt(aux.getEsquerda().toString())); 
                } else { 
                   aux.setEsquerda(new NoArvore(valor)); 
                    System.out.println(valor+" inserido à esquerda de: "+aux.getChave());
                } 
            } else if (valor > aux.getChave()){
                if (aux.getDireita() != null) { 
                   inserirRec(Integer.parseInt(aux.getDireita().toString())); 
                } else { 
                   aux.setDireita(new NoArvore(valor)); 
                   System.out.println(valor+" inserido à direita de: "+aux.getChave());
                } 
            }
        } else {
             raiz = new NoArvore(valor);
             System.out.println("Árvore criada com a raiz: "+valor);
        }
    }

    @Override
    public void removerItr(int valor) {
        
    }

    @Override
    public void removerRec(int valor) {
        NoArvore aux = raiz;
        if(aux == null){
            System.out.println("Árvore vazia!");
        } else {            
            if(valor < aux.getChave()){
                removerRec(Integer.parseInt(aux.getEsquerda().toString()));
            } else if(valor > aux.getChave()){
                removerRec(Integer.parseInt(aux.getDireita().toString()));
            } else if (aux.getEsquerda() != null && aux.getDireita() != null) {
                /*2 filhos*/  
                System.out.println("Removido o nó: " + aux.getChave());
                aux.setChave(Integer.parseInt(aux.getDireita().toString()));
                aux.setDireita(aux.getDireita());
            } else {  
                System.out.println("Removido o nó: " + aux.getChave());  
                aux = (aux.getEsquerda() != null) ? aux.getEsquerda() : aux.getDireita();  
            }  
        }
    }

    @Override
    public void preOrdemItr(NoArvore no) {
       if(no != null){
            System.out.print(no.getChave()+" ");
            preOrdemItr(no.getEsquerda());
            preOrdemItr(no.getDireita());
        }
    }

    @Override
    public void posOrdemItr(NoArvore no) {
        if(no != null){
            posOrdemItr(no.getEsquerda());
            posOrdemItr(no.getDireita());
            System.out.print(no.getChave()+" ");
        }
    }

    @Override
    public void inOrdemItr(NoArvore No) {
        if(No != null){
            preOrdemItr(No.getEsquerda());
            System.out.print(No.getChave());
            preOrdemItr(No.getDireita());
        }
    }
    
}
