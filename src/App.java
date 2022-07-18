import javax.swing.JOptionPane;


public class App {
    public static void main(String[] args) throws Exception {

        Empilhador empilhador = new Empilhador();
        boolean sair = false;
        while (!sair) {
            String painel = JOptionPane.showInputDialog(null,
                    "Bem vindo! Digite a opção que deseja: \n1 - Empilhar Contêiner \n2 - Desempilhar Contêiner \n3 - Consultar Contêineres \n4 - Sair",
                    "Gestor de Contêiner Automatizado", JOptionPane.QUESTION_MESSAGE);
            int opcao = 0;
            boolean executado = false;
            do {
                if (painel != null) {
                    try {
                        opcao = Integer.parseInt(painel);
                        executado = true;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente!", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                        painel = JOptionPane.showInputDialog(null,
                                "Bem vindo! Digite a opção que deseja: \n1 - Empilhar Contêiner \n2 - Desempilhar Contêiner \n3 - Consultar Contêineres \n4 - Sair",
                                "Gestor de Contêiner Automatizado", JOptionPane.QUESTION_MESSAGE);
                    }
                } else {
                    sair = true;
                }
            } while (!executado);

            do {
                try {
                    switch (opcao) {
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente!", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                            break;
                        case 1:
                            TipoCarga tipoCarga = null;
                            TipoOperacao tipoOperacao = null;
                            String nomeProprietario = null;
                            float pesoCarga = 0;
                            char posicao = 0;

                            String caseUm = JOptionPane.showInputDialog(null,
                                    "Selecione o tipo da carga: \n0 - Seca \n1 - Commodit \n2 - Produtos Perigosos \n3 - Produtos Perecivel",
                                    "GCA - Empilhar Contêiner", JOptionPane.QUESTION_MESSAGE);
                            boolean valido = false;
                            do {
                                if (caseUm != null) {
                                    try {
                                        int tipoCargaSelecionada = Integer.parseInt(caseUm);
                                        tipoCarga = TipoCarga.values()[tipoCargaSelecionada];
                                        valido = true;
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, "Opção de Carga inválida, tente novamente!",
                                                "Erro - Tipo de Carga",
                                                JOptionPane.ERROR_MESSAGE);
                                        caseUm = JOptionPane.showInputDialog(null,
                                                "Selecione o tipo da carga: \n0 - Seca \n1 - Commodit \n2 - Produtos Perigosos \n3 - Produtos Perecivel",
                                                "GCA - Empilhar Contêiner", JOptionPane.QUESTION_MESSAGE);
                                    }
                                } else {
                                    valido = true;
                                }
                            } while (!valido);

                            caseUm = JOptionPane.showInputDialog(null,
                                    "Selecione o tipo de operação: \n0 - Embarque \n1 - Desembarque",
                                    "GCA - Empilhar Contêiner", JOptionPane.QUESTION_MESSAGE);
                            valido = false;
                            do {
                                if (caseUm != null) {
                                    try {
                                        int tipoOperacaoSelecionada = Integer.parseInt(caseUm);
                                        tipoOperacao = TipoOperacao.values()[tipoOperacaoSelecionada];
                                        valido = true;
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null,
                                                "Opção de Operação inválida, tente novamente!",
                                                "Erro - Tipo de Operação",
                                                JOptionPane.ERROR_MESSAGE);
                                        caseUm = JOptionPane.showInputDialog(null,
                                                "Selecione o tipo de operação: \n0 - Embarque \n1 - Desembarque",
                                                "GCA - Empilhar Contêiner", JOptionPane.QUESTION_MESSAGE);
                                    }
                                } else {
                                    valido = true;
                                }
                            } while (!valido);

                            caseUm = JOptionPane.showInputDialog(null,
                                    "Digite o nome do proprietário do contêiner:",
                                    "GCA - Empilhar Contêiner", JOptionPane.QUESTION_MESSAGE);
                            valido = false;
                            do {
                                if (caseUm != null) {
                                    try {
                                        nomeProprietario = caseUm;
                                        valido = true;
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null,
                                                "Nome inválido, tente novamente!",
                                                "Erro - Nome",
                                                JOptionPane.ERROR_MESSAGE);
                                        caseUm = JOptionPane.showInputDialog(null,
                                                "Digite o nome do proprietário do contêiner:",
                                                "GCA - Empilhar Contêiner", JOptionPane.QUESTION_MESSAGE);
                                    }
                                } else {
                                    valido = true;
                                }
                            } while (!valido);

                            caseUm = JOptionPane.showInputDialog(null,
                                    "Digite o peso da carga (em KG):",
                                    "GCA - Empilhar Contêiner", JOptionPane.QUESTION_MESSAGE);
                            valido = false;
                            do {
                                if (caseUm != null) {
                                    try {
                                        pesoCarga = Integer.parseInt(caseUm);
                                        valido = true;
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null,
                                                "Peso inválido, tente novamente!",
                                                "Erro - Peso",
                                                JOptionPane.ERROR_MESSAGE);
                                        caseUm = JOptionPane.showInputDialog(null,
                                                "Digite o peso da carga (em KG):",
                                                "GCA - Empilhar Contêiner", JOptionPane.QUESTION_MESSAGE);
                                    }
                                } else {
                                    valido = true;
                                }
                            } while (!valido);

                            caseUm = JOptionPane.showInputDialog(null,
                                    "Digite a posição do contêiner, entre A e L:",
                                    "GCA - Empilhar Contêiner", JOptionPane.QUESTION_MESSAGE);
                            valido = false;
                            do {
                                if (caseUm != null) {
                                    try {
                                        posicao = caseUm.toUpperCase().charAt(0);
                                        Conteiner conteiner = new Conteiner(tipoCarga, tipoOperacao, nomeProprietario,
                                                pesoCarga,
                                                posicao);
                                        if (empilhador.empilhar(posicao, conteiner)) {
                                            JOptionPane.showMessageDialog(null, "Contêiner empilhado com sucesso!",
                                                    "GCA - Empilhar Contêiner", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        valido = true;
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null,
                                                "Posição inválida, tente novamente!",
                                                "Erro - Posição",
                                                JOptionPane.ERROR_MESSAGE);
                                        caseUm = JOptionPane.showInputDialog(null,
                                                "Digite a posição do contêiner, entre A e L:",
                                                "GCA - Empilhar Contêiner", JOptionPane.QUESTION_MESSAGE);
                                    }
                                } else {
                                    valido = true;
                                }
                            } while (!valido);
                            break;
                        case 2:
                            String caseDois = JOptionPane.showInputDialog(null,
                                    "Digite o identificador do contêiner que deseja desempilhar: ",
                                    "GCA - Desempilhar Contêiner", JOptionPane.QUESTION_MESSAGE);
                            valido = false;
                            do {
                                if (caseDois != null) {
                                    try {
                                        String identificador = caseDois.toUpperCase();
                                        if (empilhador.desempilhar(identificador)) {
                                            JOptionPane.showMessageDialog(null, "Contêiner Desempilhado com Sucesso!",
                                                    "GCA - Desempilhar Contêiner", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        valido = true;
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null,
                                                "Identificador inválido, tente novamente!",
                                                "Erro - Identificador",
                                                JOptionPane.ERROR_MESSAGE);
                                        caseDois = JOptionPane.showInputDialog(null,
                                                "Digite o identificador do contêiner que deseja desempilhar: ",
                                                "GCA - Desempilhar Contêiner", JOptionPane.QUESTION_MESSAGE);
                                    }
                                } else {
                                    valido = true;
                                }
                            } while (!valido);
                            break;
                        case 3:
                            String caseTres = JOptionPane.showInputDialog(null,
                                    "Digite a opção desejada: \nA - Dados do Contêiner no Topo \nB - Quantidade de Contêineres por Tipo de Carga \nC - Peso total por Tipo de Carga \nD - Quantidade de Contêineres por Tipo de Operação \nE - Posições de Empilhamento Vazias \nF - Gráfico das posições ocupadas",
                                    "GCA - Consultar Contêiner", JOptionPane.QUESTION_MESSAGE);

                            if (caseTres != null) {
                                opcao = caseTres.toUpperCase().charAt(0);
                                switch (opcao) {
                                    case 'A':
                                        caseTres = JOptionPane.showInputDialog(null,
                                                "Digite a posição a ser consultada, entre A e L: ",
                                                "GCA - Consultar Contêiner", JOptionPane.QUESTION_MESSAGE);
                                        valido = false;
                                        do {
                                            if (caseTres != null) {
                                                try {
                                                    posicao = caseTres.toUpperCase().charAt(0);
                                                    if (empilhador.informacaoConteinerTopo(posicao) != null) {
                                                        JOptionPane.showMessageDialog(null,
                                                                empilhador.informacaoConteinerTopo(posicao),
                                                                "GCA - Consultar Contêiner",
                                                                JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                    valido = true;
                                                } catch (Exception e) {
                                                    JOptionPane.showMessageDialog(null,
                                                            "Posição inválida, tente novamente!",
                                                            "Erro - Posição",
                                                            JOptionPane.ERROR_MESSAGE);
                                                    caseTres = JOptionPane.showInputDialog(null,
                                                            "Digite a posição a ser consultada, entre A e L: ",
                                                            "GCA - Consultar Contêiner", JOptionPane.QUESTION_MESSAGE);
                                                }
                                            } else {
                                                valido = true;
                                            }
                                        } while (!valido);

                                        break;
                                    case 'B':
                                        JOptionPane.showMessageDialog(null,
                                                "Quantidade de Contêineres por Tipo de Carga: \n"
                                                        + empilhador.getStringQuantidadePorTipodeCarga(),
                                                "GCA - Consultar Contêiner", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case 'C':
                                        JOptionPane.showMessageDialog(null,
                                                "Peso total por Tipo de Carga: \n"
                                                        + empilhador.getStringPesoTotalPorTipoCarga(),
                                                "GCA - Consultar Contêiner", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case 'D':
                                        JOptionPane.showMessageDialog(null,
                                                "Quantidade de Contêineres por Tipo de Operação: \n"
                                                        + empilhador.getStringQuantidadePorTipoOperacao(),
                                                "GCA - Consultar Contêiner", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case 'E':
                                        if (!empilhador.getPilhasVazias().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "As Posições "
                                                    + empilhador.getPilhasVazias()
                                                    + " estão vazias e não possuem nenhum contêiner.",
                                                    "GCA - Consultar Contêiner", JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Não há nenhuma posição vazia.",
                                                    "GCA - Consultar Contêiner", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        break;
                                    case 'F':
                                        JOptionPane.showMessageDialog(null, "Gráfico das posições ocupadas: \n"
                                                + empilhador.getGraficoPosicoes(),
                                                "GCA - Consultar Contêiner", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null,
                                                "Opção inválida, tente novamente!",
                                                "Erro - Opção",
                                                JOptionPane.ERROR_MESSAGE);
                                        break;
                                }
                            }
                            break;
                        case 4:
                            sair = true;
                    }
                    executado = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Erro inesperado, Falha ao executar operação, por favor, tente novamente \nCaso o erro persista, contate o suporte \nErro: "
                                    + e.getMessage(),
                            "GCA - ERRO", JOptionPane.ERROR_MESSAGE);
                    painel = JOptionPane.showInputDialog(null,
                            "Bem vindo! Digite a opção que deseja: \n1 - Empilhar Contêiner \n2 - Desempilhar Contêiner \n3 - Consultar Contêineres \n4 - Sair",
                            "Gestor de Contêiner Automatizado", JOptionPane.QUESTION_MESSAGE);
                }
            } while (!executado);

        }
    }
}
