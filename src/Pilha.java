import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.swing.JOptionPane;

public class Pilha implements Serializable {

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
        JOptionPane.showMessageDialog(null, "Pilha Cheia!", "Erro", JOptionPane.ERROR_MESSAGE);

        return false;
    }

    public Conteiner verTopo() {
        if (pilha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pilha Vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return pilha.peek();
    }

    public boolean desempilhar(String indentificador) {
        if (pilha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pilha vazia", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Deque<Conteiner> pilhaAux = new ArrayDeque<Conteiner>();
        Boolean encontrou = false;
        int size = pilha.size();
        for (int i = 0; i < size; i++) {
            Conteiner conteiner = pilha.pop();
            if (conteiner.getIdentificador().equals(indentificador)) {
                encontrou = true;
                break;
            }
            pilhaAux.push(conteiner);
        }
        size = pilhaAux.size();
        for (int i = 0; i < size; i++) {
            pilha.push(pilhaAux.pop());
        }

        if (!encontrou) {
            JOptionPane.showMessageDialog(null, "Contêiner não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return encontrou;

    }

    public int quantidadeConteiners() {
        return pilha.size();
    }

    public int getQuantidadePorTipoCarga(TipoCarga t) {
        int quantidade = 0;
        Deque<Conteiner> pilhaAux = new ArrayDeque<Conteiner>();
        int size = pilha.size();
        for (int i = 0; i < size; i++) {
            Conteiner conteiner = pilha.pop();
            if (conteiner.getTipoCarga() == t) {
                quantidade++;
            }
            pilhaAux.push(conteiner);
        }
        size = pilhaAux.size();
        for (int i = 0; i < size; i++) {
            pilha.push(pilhaAux.pop());
        }

        return quantidade;
    }

    public int getQuantidadePorTipoOperacao(TipoOperacao t) {
        int quantidade = 0;
        Deque<Conteiner> pilhaAux = new ArrayDeque<Conteiner>();
        int size = pilha.size();
        for (int i = 0; i < size; i++) {
            Conteiner conteiner = pilha.pop();
            if (conteiner.getTipoOperacao() == t) {
                quantidade++;
            }
            pilhaAux.push(conteiner);
        }
        size = pilhaAux.size();
        for (int i = 0; i < size; i++) {
            pilha.push(pilhaAux.pop());
        }
        return quantidade;
    }

    public float getPesoTotalPorTipoCarga(TipoCarga t) {
        float peso = 0;

        Deque<Conteiner> pilhaAux = new ArrayDeque<Conteiner>();
        int size = pilha.size();
        for (int i = 0; i < size; i++) {
            Conteiner conteiner = pilha.pop();
            if (conteiner.getTipoCarga() == t) {
                peso += conteiner.getPesoCarga();
            }
            pilhaAux.push(conteiner);
        }
         size = pilhaAux.size();
        for (int i = 0; i < size; i++) {
            pilha.push(pilhaAux.pop());
        }

        return peso;
    }

}
