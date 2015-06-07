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
        if (valor != 0) {
            if(inter.getChave() == valor){
               return inter;
            }  
            
            if(Integer.parseInt(inter.getEsquerda().toString()) < valor){
                buscar(Integer.parseInt(inter.getEsquerda().toString()));
            }  else if(Integer.parseInt(inter.getEsquerda().toString()) == valor){
                inter = inter.getEsquerda();
                return inter;
            }
            
            if(Integer.parseInt(inter.getDireita().toString()) > valor){
                buscar(Integer.parseInt(inter.getDireita().toString()));
            }  else if(Integer.parseInt(inter.getDireita().toString()) == valor){
                inter = inter.getDireita();
                return inter;
            }
            
            /*while (inter.getEsquerda() != null) {
                if(Integer.parseInt(inter.getEsquerda().toString()) < valor){
                    inter = inter.getEsquerda();
                }  else if(Integer.parseInt(inter.getEsquerda().toString()) == valor){
                    inter = inter.getEsquerda();
                    return inter;
                }
            }  
            while (inter.getDireita() != null) {
                if(Integer.parseInt(inter.getDireita().toString()) > valor){
                    inter = inter.getDireita();
                }  else if(Integer.parseInt(inter.getDireita().toString()) == valor){
                    inter = inter.getDireita();
                    return inter;
                }
            }*/
            
        } else {
            System.out.println("Valor inválido!");
        }
            return null;
        } 

    @Override
    public void inserirItr(int valor) {
        
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
