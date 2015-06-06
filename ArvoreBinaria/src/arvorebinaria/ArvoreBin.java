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
    }

    @Override
    public NoArvore buscar(int valor) {
        if (valor != 0) {  
            while (valor.getEsquerda != 0) {  
                node = node.esquerda;  
            }  
        }  
        return node;
    }

    @Override
    public void inserirItr(int valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserirRec(int valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerItr(int valor, char tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerRec(int valor, char tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preOrdemItr(NoArvore no) {
       if(no != null){
        System.out.print(no.getChave());
         preOrdemItr(no.getEsquerda());
         preOrdemItr(no.getDireita());
         } 
    }

    @Override
    public void posOrdemItr(NoArvore no) {
        if(no != null){
          preOrdemItr(no.getEsquerda());
          preOrdemItr(no.getDireita());
         System.out.print(no.getChave());
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
