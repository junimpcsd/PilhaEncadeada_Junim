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

    @Override
    public void removerItr(int valor) {
        System.out.println("Removendo: "+valor+", aguarde...");
        NoArvore pai = null;
        NoArvore val = buscar(valor);
        
        if(val == null){
            System.out.println("Valor não encontrado.");
        }
        
        if(val != null && val.getChave() == valor){
            pai = Pai(val);
            
            if (val.getDireita() == null && val.getEsquerda() == null) { 
                solto(val);
            }
            
            if (val.getDireita() == null || val.getEsquerda() == null) { 
                filhoUnico(val);
            } 
            
            if (val.getDireita() == null && val.getEsquerda() == null){
                casalDeFilhos(val);
            }
        }
    }

    // Verifica se o
    public void solto(NoArvore nomePretendido){
        NoArvore pai = Pai(nomePretendido);

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
    
    public void filhoUnico(NoArvore nome){
        
    }
    
    public void casalDeFilhos(NoArvore duplaSertaneja){
        
    }
  /*
    @Override
    public void removerRec(int valor, char tipo) {
        NoArvore aux = raiz;
        if(aux == null){
            System.out.println("Árvore vazia!");
        } else {            
            if(valor < aux.getChave()){
                removerRec(Integer.parseInt(aux.getEsquerda().toString()));
            } else if(valor > aux.getChave()){
                removerRec(Integer.parseInt(aux.getDireita().toString()));
            } else if (aux.getEsquerda() != null && aux.getDireita() != null) {
              
                System.out.println("Removido o nó: " + aux.getChave());
                aux.setChave(Integer.parseInt(aux.getDireita().toString()));
                aux.setDireita(aux.getDireita());
            } else {  
                System.out.println("Removido o nó: " + aux.getChave());  
                aux = (aux.getEsquerda() != null) ? aux.getEsquerda() : aux.getDireita();  
            }  
        }
    }
   */
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

    @Override
    public void removerRec(int valor, char tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
