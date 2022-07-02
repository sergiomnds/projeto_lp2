public class Conteiner {
    TipoCarga tipoCarga;
    TipoOperacao tipoOperacao;
    String identificador;
    String nomeProprietario;
    float pesoCarga;
    char posicao;
    public Conteiner(TipoCarga tipoCarga, TipoOperacao tipoOperacao, String nomeProprietario, float pesoCarga, char posicao) {
        this.tipoCarga = tipoCarga;
        this.tipoOperacao = tipoOperacao;
        this.nomeProprietario = nomeProprietario;
        this.pesoCarga = pesoCarga;
        this.posicao = posicao;
    }
    public void gerarIdentificador(int posicao){
        this.identificador = this.posicao+"."+posicao;
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
    public char getPosicao() {
        return posicao;
    }
    public void setPosicao(char posicao) {
        this.posicao = posicao;
    }
    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }
    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

}
