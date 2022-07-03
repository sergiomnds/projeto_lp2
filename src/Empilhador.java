import java.util.HashMap;
import java.util.Map;

public class Empilhador {
    Map<Character, Pilha> pilhas = new HashMap<>();

    Empilhador() {
        for (int i = 0; i < 12; i++) {
            pilhas.put((char) (i + 65), new Pilha());
        }
    }

    public boolean empilhar(char posicao, Conteiner conteiner) {
        Pilha pilha = pilhas.get(posicao);
        return pilha.empilhar(conteiner);
    }

    public boolean desempilhar(String indentificador) {
        char posicao = indentificador.toUpperCase().charAt(0);
        if (!pilhas.containsKey(posicao)) {
            System.out.println("Identificador inválido");
            return false;
        }
        return pilhas.get(posicao).desempilhar(indentificador);

    }

    public int quantidadePorTipoCarga(TipoCarga tipoCarga) {
        int quantidadeCarga = 0;
        for (Pilha pilha : pilhas.values()) {
            quantidadeCarga += pilha.quantidadePorTipoCarga(tipoCarga);
        }
        return quantidadeCarga;
    }

    public float pesoTotalPorTipoCarga(TipoCarga tipoCarga) {
        float pesoTotal = 0;
        for (Pilha pilha : pilhas.values()) {
            pesoTotal += pilha.pesoTotalPorTipoCarga(tipoCarga);
        }
        return pesoTotal;
    }

    public int quantidadePorTipoOperacao(TipoOperacao tipoOperacao) {
        int quantidadeOperacao = 0;
        for (Pilha pilha : pilhas.values()) {
            quantidadeOperacao += pilha.quantidadePorTipoOperacao(tipoOperacao);
        }
        return quantidadeOperacao;
    }
}
