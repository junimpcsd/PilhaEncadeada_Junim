package arvorebinaria;

public interface interfaceArvoreBinaria {

    NoArvore raiz(); //retorna a raiz da árvore

    NoArvore buscar(int valor); //retorna um nó da árvore, caso ele se encontre nela

    void inserirItr(int valor); //adiciona um novo nó na árvore de forma iterativa (while)
    
    void inserirRec(int valor, NoArvore val); //adiciona um novo nó na árvore de forma iterativa (while)

    void removerItr(int valor); //remover um nó da árvore de forma iterativa (while)
    
    void removerRec(int valor, char tipo); //remover um nó da árvore de forma recursiva

    void preOrdemItr(NoArvore no);  //percorre a árvore na pré-ordem de forma iterativa  (usando pilha)    

    void posOrdemItr(NoArvore no);  //percorre a árvore na pos-ordem de forma iterativa  (usando pilha)      

    void inOrdemItr(NoArvore No);  //percorre a árvore na em-ordem de forma iterativa  (usando pilha)   
}
