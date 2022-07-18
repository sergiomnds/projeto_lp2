import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Empilhador {
    private Map<Character, Pilha> pilhas = new HashMap<>();
    private int limiteEmpilhamento = 6;

    Empilhador() {
        boolean conseguiuLerDados = this.lerDados();
        if (!conseguiuLerDados) {
            for (int i = 0; i < 12; i++) {
                char letra = (char) (i + 65);
                pilhas.put(letra, new Pilha(letra, limiteEmpilhamento));
            }
        }
    }

    public Conteiner informacaoConteinerTopo(char posicao) {

        this.throwsIfNotHasPilha(posicao);

        return pilhas.get(posicao).verTopo();
    }

    public boolean empilhar(char posicao, Conteiner conteiner) throws IllegalArgumentException {

        this.throwsIfNotHasPilha(posicao);

        Pilha pilha = pilhas.get(posicao);
        boolean resposta = pilha.empilhar(conteiner);
        if (resposta) {
            this.salvarDados();
        }
        return resposta;
    }

    public boolean desempilhar(String indentificador) throws IllegalArgumentException {
        char posicao = indentificador.toUpperCase().charAt(0);

        this.throwsIfNotHasPilha(posicao);

        boolean resposta = pilhas.get(posicao).desempilhar(indentificador);

        if (resposta) {
            this.salvarDados();
        }
        return resposta;

    }

    private void throwsIfNotHasPilha(char posicao) {
        if (!this.hasPilha(posicao)) {
            // JOptionPane.showMessageDialog(null, "Posição inválida!", "Erro",
            // JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("posição inválida");
        }
    }

    public Map<String, Integer> getQuantidadePorTipoCarga() {
        Map<String, Integer> qauntidadePorTipoCarga = new HashMap<>();
        for (TipoCarga t : TipoCarga.values()) {
            int quantidade = 0;
            for (Pilha pilha : pilhas.values()) {
                quantidade += pilha.getQuantidadePorTipoCarga(t);
            }
            qauntidadePorTipoCarga.put(t.getDescricao(), quantidade);
        }

        return qauntidadePorTipoCarga;
    }

    public Map<String, Integer> getQuantidadePorTipoOperacao() {
        Map<String, Integer> quantidadePorTipoOperacao = new HashMap<>();
        for (TipoOperacao t : TipoOperacao.values()) {
            int quantidade = 0;
            for (Pilha pilha : pilhas.values()) {
                quantidade += pilha.getQuantidadePorTipoOperacao(t);
            }
            quantidadePorTipoOperacao.put(t.getDescricao(), quantidade);
        }
        return quantidadePorTipoOperacao;
    }

    public Map<String, Float> getPesoTotalPorTipoCarga() {
        Map<String, Float> pesoTotalPorTipoCarga = new HashMap<>();
        for (TipoCarga t : TipoCarga.values()) {
            float peso = 0;
            for (Pilha pilha : pilhas.values()) {
                peso += pilha.getPesoTotalPorTipoCarga(t);
            }
            pesoTotalPorTipoCarga.put(t.getDescricao(), peso);
        }

        return pesoTotalPorTipoCarga;
    }

    public String getPilhasVazias() {
        String pilhasVazias = "";
        for (Pilha pilha : pilhas.values()) {
            if (pilha.quantidadeConteiners() == 0) {
                pilhasVazias += " " + pilha.getNome();
            }
        }
        return pilhasVazias;
    }

    public String getGraficoPosicoes() {
        String grafico = "Relação de posições e seus contêineres:\n\n";
        Map<Character, Integer> quantidadePorPilha = new HashMap<>();

        for (Pilha pilha : pilhas.values()) {
            quantidadePorPilha.put(pilha.getNome(), pilha.quantidadeConteiners());
        }
        for (int j = limiteEmpilhamento; j > 0; j--) {
            grafico += j + " _";
            for (int i = 0 + 65; i < 6 + 65; i++) {
                char letra = (char) i;
                if (quantidadePorPilha.get(letra) >= j) {
                    grafico += "█_";
                } else {
                    grafico += "___";
                }
            }
            grafico += "\n";
        }
        grafico += " ";
        for (int i = 0 + 65; i < 6 + 65; i++) {
            char letra = (char) i;
            grafico += "     " + letra;
        }
        grafico += "\n\n";
        for (int j = limiteEmpilhamento; j > 0; j--) {
            grafico += j + " _";
            for (int i = 6 + 65; i < 12 + 65; i++) {
                char letra = (char) i;

                if (quantidadePorPilha.get(letra) >= j) {
                    grafico += "█_";
                } else {
                    grafico += "___";
                }
            }
            grafico += "\n";
        }
        grafico += "  ";
        for (int i = 6 + 65; i < 12 + 65; i++) {
            char letra = (char) i;
            grafico += "     " + letra;
        }
        grafico += "\n\n";
        return grafico;
    }

    public boolean hasPilha(char posicao) {
        return pilhas.containsKey(posicao);
    }

    public boolean salvarDados() {
        try {
            File output = new File("database");
            if (!output.exists()) {
                output.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(output);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pilhas);
            oos.flush();
            oos.close();
            fos.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean lerDados() {
        try {
            File input = new File("database");
            if (!input.exists()) {
                return false;
            }
            FileInputStream fis = new FileInputStream(input);
            ObjectInputStream ois = new ObjectInputStream(fis);
            pilhas = (Map<Character, Pilha>) ois.readObject();

            ois.close();
            fis.close();
            if (pilhas == null) {
                return false;
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public String getStringQuantidadePorTipodeCarga() {
        String quantidadePorTipoCarga = "";
        Map<String, Integer> qtdTipoCarga = getQuantidadePorTipoCarga();
        for (TipoCarga t : TipoCarga.values()) {
            quantidadePorTipoCarga += t.getDescricao() + ": " + qtdTipoCarga.get(t.getDescricao())
                    + " Contêiner(es)\n";
        }
        return quantidadePorTipoCarga;
    }

    public String getStringQuantidadePorTipoOperacao() {
        String quantidadePorTipoOperacao = "";
        Map<String, Integer> qtdTipoOperacao = getQuantidadePorTipoOperacao();
        for (TipoOperacao t : TipoOperacao.values()) {
            quantidadePorTipoOperacao += t.getDescricao() + ": " + qtdTipoOperacao.get(t.getDescricao())
                    + " Contêiner(es)\n";
        }
        return quantidadePorTipoOperacao;
    }

    public String getStringPesoTotalPorTipoCarga() {
        String pesoTotalPorTipoCarga = "";
        Map<String, Float> pesoTipoCarga = getPesoTotalPorTipoCarga();
        for (TipoCarga t : TipoCarga.values()) {
            pesoTotalPorTipoCarga += t.getDescricao() + ": " + pesoTipoCarga.get(t.getDescricao())
                    + " Kilos\n";
        }
        return pesoTotalPorTipoCarga;
    }
}
