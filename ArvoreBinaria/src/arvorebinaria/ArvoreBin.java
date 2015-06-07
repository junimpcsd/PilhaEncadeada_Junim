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
       raiz = new NoArvore(15);  
       
       return raiz;
    }

    @Override
    public NoArvore buscar(int valor) {
        NoArvore inter = raiz;
        if (valor != 0) {  
            while (Integer.parseInt(inter.getEsquerda().toString()) != 0) {  
                if(Integer.parseInt(inter.getEsquerda().toString()) < valor){
                    inter = inter.getEsquerda();
                }  else if(Integer.parseInt(inter.getEsquerda().toString()) == valor){
                    inter = inter.getEsquerda();
                    System.out.println("Valor encontrado!");
                    return inter;
                }
            }  
            while (Integer.parseInt(inter.getDireita().toString()) != 0) {
                if(Integer.parseInt(inter.getDireita().toString()) > valor){
                    inter = inter.getEsquerda();
                }  else if(Integer.parseInt(inter.getDireita().toString()) == valor){
                    inter = inter.getDireita();
                    System.out.println("Valor encontrado!");
                    return inter;
                }
            }
            if(inter.getChave() == valor){
                    return inter;
            }
        } else {
            System.out.println("Valor inválido!");
        }
            return null;
        } 

    @Override
    public void inserirItr(int valor) {
        NoArvore aux = raiz;
        if (aux != null){
            if (valor < aux.getChave()){
                if (aux.getEsquerda() != null) { 
                   inserirItr(Integer.parseInt(aux.getEsquerda().toString())); 
                } else { 
                   aux.setEsquerda(new NoArvore(valor)); 
                } 
            } else if (valor > aux.getChave()){
                if (aux.getDireita() != null) { 
                   inserirItr(Integer.parseInt(aux.getDireita().toString())); 
                } else { 
                   aux.setDireita(new NoArvore(valor)); 
                } 
            }
        } else {
             raiz = new NoArvore(valor);
        }
    }

    @Override
    public void inserirRec(int valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerItr(int valor) {
        NoArvore aux = raiz;
        if(aux == null){
            System.out.println("Árvore vazia!");
        } else {            
            if(valor < aux.getChave()){
                removerItr(Integer.parseInt(aux.getEsquerda().toString()));
            } else if(valor > aux.getChave()){
                removerItr(Integer.parseInt(aux.getDireita().toString()));
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
    public void removerRec(int valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
