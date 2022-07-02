public enum TipoOperacao {
    EMBARQUE("Embarque"),
    DESEMBARQUE("Desembarque");
    private String descricao;

    TipoOperacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
