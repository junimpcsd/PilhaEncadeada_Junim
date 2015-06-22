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
    } // Pega a raiz, ok

    public NoArvore Pai(NoArvore val){
        NoArvore Pai = null;
        NoArvore orfao = raiz;
        
        while(orfao != null){
            if(orfao == val){
                System.out.println("Pai encontrado!");
                return Pai;
            }
            
            if(val.getChave() > orfao.getChave()){
                Pai = orfao;
                orfao = orfao.getDireita();
            }
            
            if(val.getChave() < orfao.getChave()){
                Pai = orfao;
                orfao = orfao.getEsquerda();
            }
        }
        return Pai;
    } // Encontrar pai, ok
    
    @Override
    public NoArvore buscar(int valor) {
        NoArvore aux = raiz;
        NoArvore aux1;
        while (aux != null){
            if (valor == aux.getChave()){
                return aux;
            }

            if (valor < aux.getChave()){
                aux1 = aux;
                System.out.println(valor+" encontrado! À sua esquerda está "+aux.getChave());
                aux = aux.getEsquerda(); // Anda para a esquerda.
            } else {
                aux1 = aux;
                System.out.println(valor+" encontrado! À sua direita está "+aux.getChave());
                aux = aux.getDireita(); // Anda para a direita.
            }

            if(aux == null){
                return aux1;
            }
            return aux;
        }
        return null;
    } // Busca, ok

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
    } // Insere iterativamente, com o While, ok

    @Override
    public void inserirRec(int valor, NoArvore val) {
        NoArvore no = new NoArvore(valor);
        no.setEsquerda(null);
        no.setDireita(null);

        // Verificar se árvore está vazia
        if(raiz == null){
            raiz = no; // Inserido
            System.out.println("Árvore criada com a raiz: "+valor);
            return;
        }
        //Andar nos Nós
        
        if(val == null){
            System.out.println("Fail, o Nó não pode ser nulo.");
            return;
        }
        
        if (val.getChave() == valor) {
            System.out.println("Esse no ja existe!");
        }
        
        if (valor < val.getChave()) {
            if (val.getEsquerda() == null) {
                System.out.println(valor+" inserido à esquerda de: "+val.getChave());
                val.setEsquerda(no);
            } else {
                inserirRec(valor, val.getEsquerda());
            }
        } 
        
        if (valor > val.getChave()) {
            if (val.getDireita() == null) {
                System.out.println(valor+" inserido à direita de: "+val.getChave());
                val.setDireita(no);
            } else {
                inserirRec(valor, val.getDireita());
            }
        }
        //raiz = noTemporario;
    } // Insere recursivamente, com recursividade, ok

    // Removendo iterativamente, ok
    @Override
    public void removerItr(int valor) {
        System.out.println("Removendo "+valor+", aguarde...");
        NoArvore val = buscar(valor);
        
        if(val == null){
            System.out.println("Valor não encontrado.");
            return;
        }
        
        if(val.getChave() == valor){   
            if (val.getDireita() == null && val.getEsquerda() == null) { 
                semFilho(val);
                System.out.println(valor+" não tem filhos, removido!");
                return;
            }
            
            if (val.getDireita() != null && val.getEsquerda() != null){
                System.out.println("O "+valor+" elemento tinha 2 filhos, ");
                doisFilhos(val);
                return;
            }
            
            if (val.getDireita() != null) { 
                System.out.println(valor+" tem 1 filho à direita, e ele herdará o lugar do pai!");
                umFilho(val);
                return;
            } 
            
            if (val.getEsquerda() != null){
                System.out.println(valor+" tem 1 filho à esquerda e ele herdará o lugar do pai!");
                umFilho(val);
            }
        }
    }

    // Matarei o pai sem filhos, ok
    public void semFilho(NoArvore nomePretendido){
        NoArvore pai = Pai(nomePretendido);

        // Se a raiz for nula, é para retornar zero.
        if (nomePretendido == raiz) {
            raiz = null;
            return;
        }

        if (nomePretendido.getDireita() == null && nomePretendido.getEsquerda() == null) { 
            if (nomePretendido.getChave() < pai.getChave()){
                pai.setEsquerda(null);
            } 
            if (nomePretendido.getChave() > pai.getChave()){
                pai.setDireita(null);
            }
        }
    }
    
    // Matarei o pai, mas manterei o filho, ok
    public void umFilho(NoArvore nome){
        NoArvore pai = Pai(nome);
        
        if (nome == raiz) {
            if (nome.getEsquerda() != null && nome.getDireita() == null) {
                raiz = raiz.getEsquerda();
            } 
            if (nome.getDireita() != null && nome.getEsquerda() == null) {
                raiz = raiz.getDireita();
            }
            System.out.println("Removido!");
            return;
        }
        
        if (nome.getEsquerda() == null && nome.getDireita() != null) { 
            if (nome.getChave() < pai.getChave()) {
                pai.setEsquerda(nome.getDireita());
            } 
            if (nome.getChave() > pai.getChave()) {
                pai.setDireita(nome.getDireita());
            }
            System.out.println("Direita movida para o pai!");
            return;
        } 
        
        if (nome.getEsquerda() != null && nome.getDireita() == null) {
            if (nome.getChave() < pai.getChave()) {
                pai.setEsquerda(nome.getEsquerda());
            } 
            if (nome.getChave() > pai.getChave()) {
                pai.setDireita(nome.getEsquerda());
            }
            System.out.println("Esquerda movido para o pai!");
        }
    }
    
    // Essa função vai descer toda a direita, ok
    public NoArvore desceTodaDireita(NoArvore val){
        NoArvore aux2 = val;
        NoArvore aux1 = null;

        while (aux2 != null) {
            aux1 = aux2;
            aux2 = aux2.getDireita();
        }
        return aux1;
    }
    
    // Matarei o pai, mas manterei vivo os filhos, ok
    public void doisFilhos (NoArvore duplaSertaneja){
        NoArvore pai = Pai(duplaSertaneja);

        NoArvore aux = desceTodaDireita(duplaSertaneja.getEsquerda());
        aux.setDireita(duplaSertaneja.getDireita());
        aux.setEsquerda(duplaSertaneja.getEsquerda());

        NoArvore pai2 = Pai(aux);

        if (pai2 != null) {
            pai2.setDireita(null);
        }

        if (duplaSertaneja == raiz) {
            raiz = aux;
            return;
        }

        // Se o valor a ser removido for menor
        // que o valor do pai, então o filho à esquerda
        // será o pai, e o filho da direita permanecerá
        // no seu canto.
        if (duplaSertaneja.getChave() < pai.getChave()) {
            pai.setEsquerda(aux);  
        } 
        
        // Se o valor a ser removido for maior
        // que o valor do pai, então o filho à direita
        // será o pai, e o filho da esquerda permanecerá
        // no seu canto.
        if (duplaSertaneja.getChave() > pai.getChave()) {
            pai.setDireita(aux);
        }
    }
    
    // Removendo recursivamente, ok
    @Override
    public void removerRec(int valor, NoArvore val) {        
        if(val == null){
            System.out.println(valor+" não encontrado!");
            return;
        }
        
        if(valor < val.getChave()){
            removerRec(valor, val.getEsquerda());
        } else if(valor > val.getChave()){
            removerRec(valor, val.getDireita());
        }

        if(valor == val.getChave()){
            if (val.getEsquerda() != null && val.getDireita() != null) {
                doisFilhos(val);
            } else if (val.getEsquerda() != null || val.getDireita() != null) {  
                umFilho(val);
            }  else {
                semFilho(val);
            }
             System.out.println(valor+" removido.");
        }
    }
   
    @Override
    public void preOrdemItr() {
       
    }

    @Override
    public void posOrdemItr() {
        
    }

    @Override
    public void inOrdemItr() {
        
    }
}
