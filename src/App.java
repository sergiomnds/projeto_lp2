import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Empilhador empilhador = new Empilhador();
        boolean sair = false;
        System.out.println("Bem vindo ao gestor de Conteiner automatizado");
        while (!sair) {
            System.out.println("##########################################");
            System.out.println("# 1 - Empilhar Contêiner                 #");
            System.out.println("# 2 - Desempilhar Contêiner              #");
            System.out.println("# 3 - Consultar Contêineres              #");
            System.out.println("# 4 - Sair                               #");
            System.out.println("##########################################");

            System.out.println("Digite a opção desejada: ");
            int opcao = in.nextInt();

            switch (opcao) {
                case 1:
                    TipoCarga tipoCarga;
                    TipoOperacao tipoOperacao;
                    String nomeProprietario;
                    float pesoCarga;
                    char posicao;

                    System.out.println("Selecione o tipo da carga: ");
                    for (TipoCarga t : TipoCarga.values()) {
                        System.out.println(t.ordinal() + " - " + t.name());
                    }
                    int tipoCargaSelecionada = in.nextInt();
                    tipoCarga = TipoCarga.values()[tipoCargaSelecionada];

                    System.out.println("Selecione o tipo da operação: ");
                    for (TipoOperacao t : TipoOperacao.values()) {
                        System.out.println(t.ordinal() + " - " + t.name());
                    }
                    int tipoOperacaoSelecionada = in.nextInt();
                    tipoOperacao = TipoOperacao.values()[tipoOperacaoSelecionada];
                    System.out.println("Digite o nome do proprietário do conteiner: ");
                    nomeProprietario = in.next();
                    System.out.println("Digite o peso da carga: ");
                    pesoCarga = in.nextFloat();
                    System.out.println("Digite a posição do conteiner, entre (A e L): ");
                    posicao = in.next().charAt(0);
                    Conteiner conteiner = new Conteiner(tipoCarga, tipoOperacao, nomeProprietario, pesoCarga, posicao);
                    if (empilhador.empilhar(posicao, conteiner)) {
                        System.out.println("Conteiner empilhado com sucesso!");
                    }
                    break;
                case 2:
                    System.out.println("Digite o identificador do conteiner que deseja desempilhar: ");
                    String identificador = in.next();
                    if (empilhador.desempilhar(identificador)) {
                        System.out.println("Conteiner desempilhado com sucesso!");
                    }
                    break;
                case 3:
                    System.out.println("######################################################################");
                    System.out.println("# A - Dados do Contêiner no Topo de uma Posição de Empilhamento      #");
                    System.out.println("# B - Quantidade de Contêineres por Tipo de Carga                    #");
                    System.out.println("# C - Peso total por Tipo de Carga                                   #");
                    System.out.println("# D - Quantidade de Contêineres por Tipo de Operação                 #");
                    System.out.println("# E - Posições de Empilhamento Vazias                                #");
                    System.out.println("######################################################################");

                    System.out.println("Digite a opção desejada: ");
                    char opcao2 = in.next().toUpperCase().charAt(0);
                    if (opcao2 != 'A' && opcao2 != 'B' && opcao2 != 'C' && opcao2 != 'D' && opcao2 != 'E') {
                        System.out.println("Opção inválida!");
                        break;
                    }

                    switch (opcao2) {
                        case 'A':
                            System.out.println("Digite de qual posição deseja ver o contêiner (A até L):");
                            posicao = in.next().toUpperCase().charAt(0);
                            if (empilhador.pilhas.containsKey(posicao)) {
                                System.out.println(
                                        "Identificador: "
                                                + empilhador.pilhas.get(posicao).pilha.peek().getIdentificador());
                                System.out.println(
                                        "Tipo de Carga: " + empilhador.pilhas.get(posicao).pilha.peek().getTipoCarga());
                                System.out.println(
                                        "Peso da Carga: " + empilhador.pilhas.get(posicao).pilha.peek().getPesoCarga()
                                                + " Kilos");
                                System.out.println(
                                        "Tipo de Operação: "
                                                + empilhador.pilhas.get(posicao).pilha.peek().getTipoOperacao());
                            } else {
                                System.out.println("Posição inválida");
                            }
                            break;
                        case 'B':
                            System.out.println("Quantidade de Conteineres por Tipo de Carga: ");
                            for (TipoCarga t : TipoCarga.values()) {
                                System.out.println(
                                        t.name() + ": " + empilhador.quantidadePorTipoCarga(t) + " Contêineres");
                            }
                            break;
                        case 'C':
                            System.out.println("Peso total por Tipo de Carga: ");
                            for (TipoCarga t : TipoCarga.values()) {
                                System.out.println(t.name() + ": " + empilhador.pesoTotalPorTipoCarga(t) + " Kilos");
                            }
                            break;
                        case 'D':
                            System.out.println("Quantidade de Conteineres por Tipo de Operação: ");
                            for (TipoOperacao t : TipoOperacao.values()) {
                                System.out.println(
                                        t.name() + ": " + empilhador.quantidadePorTipoOperacao(t) + " Contêineres");
                            }
                            break;
                        case 'E':
                            // ? Não me ficou claro se era completamente vazias, ou se é possui espaço
                            // ! Optei por mostrar COMPLETAMENTE VAZIAS.
                            System.out.println("Posições de Empilhamento Vazias: ");
                            for (char c : empilhador.pilhas.keySet()) {
                                if (empilhador.pilhas.get(c).pilha.isEmpty()) {
                                    System.out.println(c + " está Vazia!");
                                }
                            }
                            break;
                    }
            }
        }
        in.close();
    }
}
