import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Empilhador empilhador = new Empilhador();
        boolean sair = false;
        System.out.println("Bem vindo ao gestor de Contêiner Automatizado");
        while (!sair) {
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println("▒▒ 1 - Empilhar Contêiner                 ▒▒");
            System.out.println("▒▒ 2 - Desempilhar Contêiner              ▒▒");
            System.out.println("▒▒ 3 - Consultar Contêineres              ▒▒");
            System.out.println("▒▒ 4 - Sair                               ▒▒");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            int opcao = 0;
            boolean executado = false;
            do {
                try {

                    System.out.println("Digite a opção desejada: ");
                    opcao = in.nextInt();
                    executado = true;
                } catch (Exception e) {
                    in = new Scanner(System.in);// reseta o scanner para que o usuario possa tentar novamente
                    System.out.println("Opção inválida, tente novamente!");
                    continue;
                }
            } while (!executado);

            do {
                try {
                    switch (opcao) {
                        default:
                            System.out.println("Opção inválida, tente novamente!");
                            break;
                        case 1:
                            TipoCarga tipoCarga = null;
                            TipoOperacao tipoOperacao = null;
                            String nomeProprietario = null;
                            float pesoCarga = 0;
                            char posicao = 0;

                            boolean valido = false;
                            do {
                                try {
                                    System.out.println("Selecione o tipo da carga: ");
                                    for (TipoCarga t : TipoCarga.values()) {
                                        System.out.println(t.ordinal() + " - " + t.getDescricao());
                                    }
                                    int tipoCargaSelecionada = in.nextInt();
                                    tipoCarga = TipoCarga.values()[tipoCargaSelecionada];
                                    valido = true;
                                } catch (Exception e) {
                                    in = new Scanner(System.in);// reseta o scanner para que o usuario possa tentar
                                                                // novamente
                                    System.out.println("Carga inválida, tente novamente!");
                                    continue;
                                }
                            } while (!valido);

                            valido = false;
                            do {
                                try {
                                    System.out.println("Selecione o tipo da operação: ");
                                    for (TipoOperacao t : TipoOperacao.values()) {
                                        System.out.println(t.ordinal() + " - " + t.getDescricao());
                                    }
                                    int tipoOperacaoSelecionada = in.nextInt();
                                    tipoOperacao = TipoOperacao.values()[tipoOperacaoSelecionada];
                                    valido = true;
                                } catch (Exception e) {
                                    in = new Scanner(System.in);
                                    System.out.println("Operação inválida, tente novamente");
                                    continue;
                                }
                            } while (!valido);

                            valido = false;
                            do {
                                try {
                                    System.out.println("Digite o nome do proprietário do conteiner: ");
                                    nomeProprietario = in.next();
                                    valido = true;
                                } catch (Exception e) {
                                    in = new Scanner(System.in);
                                    System.out.println("Nome inválido, tente novamente!");
                                    continue;
                                }
                            } while (!valido);
                            valido = false;
                            do {
                                try {
                                    System.out.println("Digite o peso da carga: (em KG)");
                                    pesoCarga = in.nextFloat();
                                    valido = true;
                                } catch (Exception e) {
                                    in = new Scanner(System.in);
                                    System.out.println("Peso inválido, tente novamente");
                                    continue;
                                }
                            } while (!valido);
                            valido = false;
                            do {
                                try {
                                    System.out.println("Digite a posição do contêiner, entre A e L: ");
                                    posicao = in.next().toUpperCase().charAt(0);

                                    Conteiner conteiner = new Conteiner(tipoCarga, tipoOperacao, nomeProprietario,
                                            pesoCarga,
                                            posicao);
                                    if (empilhador.empilhar(posicao, conteiner)) {
                                        System.out.println("Contêiner empilhado com sucesso!");
                                    }
                                    valido = true;
                                } catch (Exception e) {
                                    in = new Scanner(System.in);
                                    System.out.println("Posição inválida, tente novamente");
                                    continue;
                                }
                            } while (!valido);
                            break;
                        case 2:
                            valido = false;
                            do {
                                try {
                                    System.out.println("Digite o identificador do contêiner que deseja desempilhar: ");
                                    String identificador = in.next();
                                    if (empilhador.desempilhar(identificador)) {
                                        System.out.println("Contêiner desempilhado com sucesso!");
                                    }
                                    valido = true;
                                } catch (Exception e) {
                                    in = new Scanner(System.in);
                                    System.out.println("Identificador inválido, tente novamente");
                                    continue;
                                }
                            } while (!valido);
                            break;
                        case 3:
                            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                            System.out.println("▒▒ A - Dados do Contêiner no Topo                          ▒▒");
                            System.out.println("▒▒ B - Quantidade de Contêineres por Tipo de Carga         ▒▒");
                            System.out.println("▒▒ C - Peso total por Tipo de Carga                        ▒▒");
                            System.out.println("▒▒ D - Quantidade de Contêineres por Tipo de Operação      ▒▒");
                            System.out.println("▒▒ E - Posições de Empilhamento Vazias                     ▒▒");
                            System.out.println("▒▒ F - Gráfico das posições ocupadas                       ▒▒");
                            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                            System.out.println("Digite a opção desejada: ");
                            opcao = in.next().toUpperCase().charAt(0);

                            switch (opcao) {
                                case 'A':
                                    valido = false;
                                    do {
                                        try {
                                            System.out.println("Digite a posição a ser consultada, entre A e L: ");
                                            posicao = in.next().toUpperCase().charAt(0);

                                            System.out.println(empilhador.informacaoConteinerTopo(posicao));
                                            valido = true;
                                        } catch (Exception e) {
                                            in = new Scanner(System.in);
                                            System.out.println("Posição inválida, tente novamente");
                                            continue;
                                        }
                                    } while (!valido);

                                    break;
                                case 'B':
                                    System.out.println("Quantidade de Contêineres por Tipo de Carga: ");
                                    Map<String, Integer> quantidadePorTipoCarga = empilhador
                                            .getQuantidadePorTipoCarga();
                                    for (Map.Entry<String, Integer> entry : quantidadePorTipoCarga.entrySet()) {
                                        System.out.println(entry.getKey() + ": " + entry.getValue() + " Contêineres");
                                    }
                                    break;
                                case 'C':
                                    System.out.println("Peso total por Tipo de Carga: ");
                                    Map<String, Float> pesoTotalPorTipoCarga = empilhador.getPesoTotalPorTipoCarga();
                                    for (Map.Entry<String, Float> entry : pesoTotalPorTipoCarga.entrySet()) {
                                        System.out.println(entry.getKey() + ": " + entry.getValue() + " Kilos");
                                    }
                                    break;
                                case 'D':
                                    System.out.println("Quantidade de Contêineres por Tipo de Operação: ");
                                    Map<String, Integer> quantidadePorTipoOperacao = empilhador
                                            .getQuantidadePorTipoOperacao();
                                    for (Map.Entry<String, Integer> entry : quantidadePorTipoOperacao.entrySet()) {
                                        System.out.println(entry.getKey() + ": " + entry.getValue() + " Contêineres");
                                    }
                                    break;
                                case 'E':
                                    System.out.println("As Posições " + empilhador.getPilhasVazias()
                                            + " estão vazias e não possuem nenhum contêiner.");
                                    break;
                                case 'F':
                                    System.out.println(empilhador.getGraficoPosicoes());
                                    break;
                                default:
                                    System.out.println("Opção inválida, tente novamente");
                                    break;
                            }
                            break;
                        case 4:
                            sair = true;
                    }
                    executado = true;
                } catch (Exception e) {
                    in = new Scanner(System.in);// * reseta o scanner para que o usuario possa tentar novamente
                    System.out.println("Erro inesperado, Falha ao executar operação, por favor, tente novamente");
                    System.out.println("Caso o erro persista, contate o suporte");
                    System.out.println("Erro:");
                    System.out.println(e.getMessage());
                    continue;
                }
            } while (!executado);

        }
        in.close();
    }
}
