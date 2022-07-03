import java.util.HashMap;
import java.util.Map;

public class Empilhador {
    private Map<Character, Pilha> pilhas = new HashMap<>();
    private int limiteEmpilhamento=6;

    Empilhador() {
        for (int i = 0; i < 12; i++) {
            char letra = (char) (i + 65);
            pilhas.put(letra, new Pilha(letra,limiteEmpilhamento));
        }
    }

    public Conteiner informacaoConteinerTopo(char posicao) {

        this.throwsIfNotHasPilha(posicao);

        return pilhas.get(posicao).verTopo();
    }

    public boolean empilhar(char posicao, Conteiner conteiner) throws IllegalArgumentException {

        this.throwsIfNotHasPilha(posicao);

        Pilha pilha = pilhas.get(posicao);
        return pilha.empilhar(conteiner);
    }

    public boolean desempilhar(String indentificador) throws IllegalArgumentException {
        char posicao = indentificador.toUpperCase().charAt(0);

        this.throwsIfNotHasPilha(posicao);

        return pilhas.get(posicao).desempilhar(indentificador);

    }

    private void throwsIfNotHasPilha(char posicao) {
        if (!this.hasPilha(posicao)) {
            System.out.println("posição inválida");
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
    public Map<String,Integer> getQuantidadePorTipoOperacao(){
        Map<String,Integer> quantidadePorTipoOperacao = new HashMap<>();
        for(TipoOperacao t : TipoOperacao.values()){
            int quantidade = 0;
            for(Pilha pilha : pilhas.values()){
                quantidade += pilha.getQuantidadePorTipoOperacao(t);
            }
            quantidadePorTipoOperacao.put(t.getDescricao(),quantidade);
        }
        return quantidadePorTipoOperacao;
    }
    public Map<String,Float> getPesoTotalPorTipoCarga() {
        Map<String,Float> pesoTotalPorTipoCarga = new HashMap<>();
        for (TipoCarga t : TipoCarga.values()) {
            float peso = 0;
            for (Pilha pilha : pilhas.values()) {
                peso += pilha.getPesoTotalPorTipoCarga(t);
            }
            pesoTotalPorTipoCarga.put(t.getDescricao(), peso);
        }

        return pesoTotalPorTipoCarga;
    }

    public String getPilhasVazias(){
        String pilhasVazias = "";
        for(Pilha pilha : pilhas.values()){
            if(pilha.quantidadeConteiners() == 0){
                pilhasVazias += " "+pilha.getNome();
            }
        }
        return pilhasVazias;
    }
    
    public String getGraficoPosicoes(){
        String grafico = "Relação de posições e seus conteiners:\n\n";
        Map<Character,Integer> quantidadePorPilha = new HashMap<>();

        for (Pilha pilha : pilhas.values()) {
            quantidadePorPilha.put(pilha.getNome(), pilha.quantidadeConteiners());
        }
        for (int j = limiteEmpilhamento; j >0 ; j--) {
            for (int i = 0+65; i < 6+65; i++) {
                char letra = (char) i ;
                if(quantidadePorPilha.get(letra)>=j){
                    grafico += "|█|   ";
                }else{
                    grafico += "| |   ";
                }
            }
            grafico += "\n";
        }
        for (int i = 0+65; i < 6+65; i++) {
            char letra = (char) i ;
            grafico +=" "+letra+"    ";
        }
        grafico += "\n\n";
        for (int j = limiteEmpilhamento; j >0 ; j--) {
            for (int i = 6+65; i < 12+65; i++) {
                char letra = (char) i ;
                if(quantidadePorPilha.get(letra)>=j){
                    grafico += "|█|   ";
                }else{
                    grafico += "| |   ";
                }
            }
            grafico += "\n";
        }
        for (int i = 6+65; i < 12+65; i++) {
            char letra = (char) i ;
            grafico +=" "+letra+"    ";
        }
        grafico += "\n\n";
        return grafico;
    }
    public boolean hasPilha(char posicao) {
        return pilhas.containsKey(posicao);
    }
}
