import java.io.Serializable;

public class Conteiner implements Serializable {
    private TipoCarga tipoCarga;
    private TipoOperacao tipoOperacao;
    private String identificador;
    private String nomeProprietario;
    private float pesoCarga;
    private char posicaoPatio;
    public Conteiner(TipoCarga tipoCarga, TipoOperacao tipoOperacao, String nomeProprietario, float pesoCarga, char posicaoPatio) {
        this.tipoCarga = tipoCarga;
        this.tipoOperacao = tipoOperacao;
        this.nomeProprietario = nomeProprietario;
        this.pesoCarga = pesoCarga;
        this.posicaoPatio = posicaoPatio;
    }
    public void gerarIdentificador(int posicaoPilha){
        this.identificador = this.posicaoPatio+"."+posicaoPilha;
    }
    public TipoCarga getTipoCarga() {
        return tipoCarga;
    }
    public void setTipoCarga(TipoCarga tipoCarga) {
        this.tipoCarga = tipoCarga;
    }
    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public String getNomeProprietario() {
        return nomeProprietario;
    }
    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }
    public float getPesoCarga() {
        return pesoCarga;
    }
    public void setPesoCarga(float pesoCarga) {
        this.pesoCarga = pesoCarga;
    }
    public char getPosicaoPatio() {
        return posicaoPatio;
    }
    public void setPosicaoPatio(char posicaoPatio) {
        this.posicaoPatio = posicaoPatio;
    }
    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }
    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public String toString(){
        return "Conteiner: "+this.identificador+"\n"+
                "Tipo de carga: "+this.tipoCarga.getDescricao()+"\n"+
                "Tipo de operação: "+this.tipoOperacao.getDescricao()+"\n"+
                "Nome do proprietário: "+this.nomeProprietario+"\n"+
                "Peso da carga: "+this.pesoCarga+"\n"+
                "Posição no patio: "+this.posicaoPatio+"\n";
    }

}
