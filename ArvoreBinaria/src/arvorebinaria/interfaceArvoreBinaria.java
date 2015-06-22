package arvorebinaria;

public interface interfaceArvoreBinaria {

    NoArvore raiz(); //retorna a raiz da árvore

    NoArvore buscar(int valor); //retorna um nó da árvore, caso ele se encontre nela

    void inserirItr(int valor); //adiciona um novo nó na árvore de forma iterativa (while)
    
    void inserirRec(int valor, NoArvore val); //adiciona um novo nó na árvore de forma iterativa (while)

    void removerItr(int valor); //remover um nó da árvore de forma iterativa (while)
    
    void removerRec(int valor, NoArvore val); // Substitui o "char tipo" por "NoArvore val", fica melhor de trabalhar, pois não sabia como mexer com o char

    void preOrdemItr();  //percorre a árvore na pré-ordem de forma iterativa  (usando pilha)    

    void posOrdemItr();  //percorre a árvore na pos-ordem de forma iterativa  (usando pilha)      

    void inOrdemItr();  //percorre a árvore na em-ordem de forma iterativa  (usando pilha)   
}
