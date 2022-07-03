import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {

    private Deque<Conteiner> pilha = new ArrayDeque<>();
    private int contador = 1;
    private int limiteConteiners;
    private char nome;

    Pilha(char nome, int limiteConteiners) {
        this.nome = nome;
        this.limiteConteiners = limiteConteiners;
    }

    public char getNome() {
        return nome;
    }

    public boolean empilhar(Conteiner conteiner) {

        if (pilha.size() < limiteConteiners) {
            conteiner.gerarIdentificador(contador);
            pilha.push(conteiner);
            contador++;
            return true;
        }
        System.out.println("Pilha cheia");

        return false;
    }

    public Conteiner verTopo() {
        if (pilha.isEmpty()) {
            System.out.println("Pilha vazia");
            return null;
        }
        return pilha.peek();
    }

    public boolean desempilhar(String indentificador) {
        if (pilha.isEmpty()) {
            System.out.println("Pilha vazia");
            return false;
        }

        Deque<Conteiner> pilhaAux = new ArrayDeque<Conteiner>();
        Boolean encontrou = false;
        for (int i = 0; i < pilha.size(); i++) {
            Conteiner conteiner = pilha.pop();
            if (conteiner.getIdentificador().equals(indentificador)) {
                encontrou = true;
                break;
            }
            pilhaAux.push(conteiner);
        }

        for (int i = 0; i < pilhaAux.size(); i++) {
            pilha.push(pilhaAux.pop());
        }

        if (!encontrou) {
            System.out.println("Conteiner não encontrado");
        }

        return encontrou;

    }

    public int quantidadeConteiners() {
        return pilha.size();
    }

    public int getQuantidadePorTipoCarga(TipoCarga t) {
        int quantidade = 0;

        Deque<Conteiner> pilhaAux = new ArrayDeque<Conteiner>();
        for (int i = 0; i < pilha.size(); i++) {
            Conteiner conteiner = pilha.pop();
            if (conteiner.getTipoCarga() == t) {
                quantidade++;
            }
            pilhaAux.push(conteiner);
        }
        for (int i = 0; i < pilhaAux.size(); i++) {
            pilha.push(pilhaAux.pop());
        }

        return quantidade;
    }

    public int getQuantidadePorTipoOperacao(TipoOperacao t) {
        int quantidade = 0;
        Deque<Conteiner> pilhaAux = new ArrayDeque<Conteiner>();
        for (int i = 0; i < pilha.size(); i++) {
            Conteiner conteiner = pilha.pop();
            if (conteiner.getTipoOperacao() == t) {
                quantidade++;
            }
            pilhaAux.push(conteiner);
        }
        for (int i = 0; i < pilhaAux.size(); i++) {
            pilha.push(pilhaAux.pop());
        }
        return quantidade;
    }

    public float getPesoTotalPorTipoCarga(TipoCarga t) {
        float peso = 0;

        Deque<Conteiner> pilhaAux = new ArrayDeque<Conteiner>();
        for (int i = 0; i < pilha.size(); i++) {
            Conteiner conteiner = pilha.pop();
            if (conteiner.getTipoCarga() == t) {
                peso += conteiner.getPesoCarga();
            }
            pilhaAux.push(conteiner);
        }
        for (int i = 0; i < pilhaAux.size(); i++) {
            pilha.push(pilhaAux.pop());
        }

        return peso;
    }

}
