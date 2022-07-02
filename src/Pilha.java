import java.util.Stack;

public class Pilha {

    Stack<Conteiner> pilha= new Stack<>();
    private int contador = 1;
    int limiteConteiners = 6;

    public boolean empilhar(Conteiner conteiner){

        if(pilha.size() < limiteConteiners){
            conteiner.gerarIdentificador(contador);
            pilha.push(conteiner);
            contador++;
            return true;
        }
            System.out.println("Pilha cheia");
        
        return false;
    }
    
    public boolean desempilhar(String indentificador){
        if(pilha.size() == 0){
            System.out.println("Pilha vazia");
            return false;
        }

        Stack<Conteiner> pilhaAux = new Stack<Conteiner>();
        Boolean encontrou = false;
        for(int i = 0; i < pilha.size(); i++){
            Conteiner conteiner = pilha.pop();
            if(conteiner.getIdentificador().equals(indentificador)){
                encontrou = true;
                break;
            }
            pilhaAux.push(conteiner);
        }

        for(int i = 0; i < pilhaAux.size(); i++){
            pilha.push(pilhaAux.pop());
        }

        if(!encontrou){
            System.out.println("Conteiner não encontrado");
        }

        return encontrou;
        
    }
}
