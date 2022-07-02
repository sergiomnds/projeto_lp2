public enum TipoCarga {
    SECA("Seca"),
    COMMODIT("Commodit"),
    PERIGOSO("Perigoso"),
    PERECIVEL("Perecivel");
    private String descricao;

    TipoCarga(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
