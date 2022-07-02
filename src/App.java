import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Empilhador empilhador = new Empilhador();
        boolean sair = false;
        System.out.println("Bem vindo ao gestor de Conteiner automatizado");
        while(!sair){
            System.out.println("##########################################");
            System.out.println("# 1 - Empilhar Conteiner                 #");
            System.out.println("# 2 - Desempilhar Conteiner              #");
            System.out.println("# 3 - Consultar Conteineres              #");
            System.out.println("# 4 - Sair                               #");
            System.out.println("##########################################");

            System.out.println("Digite a opção desejada: ");
            int opcao = in.nextInt();

            switch(opcao){
                case 1:
                TipoCarga tipoCarga;
                TipoOperacao tipoOperacao;
                String nomeProprietario;
                float pesoCarga;
                char posicao;
                System.out.println("Selecione o tipo da carga: ");
                for(TipoCarga t: TipoCarga.values()){
                    System.out.println(t.ordinal()+" - "+t.name());
                }
                int tipoCargaSelecionada = in.nextInt();
                tipoCarga = TipoCarga.values()[tipoCargaSelecionada];
                System.out.println("Selecione o tipo da operação: ");
                for(TipoOperacao t: TipoOperacao.values()){
                    System.out.println(t.ordinal()+" - "+t.name());
                }
                int tipoOperacaoSelecionada = in.nextInt();
                tipoOperacao = TipoOperacao.values()[tipoOperacaoSelecionada];
                System.out.println("Digite o nome do proprietário do conteiner: ");
                nomeProprietario = in.next();
                System.out.println("Digite o peso da carga: ");
                pesoCarga = in.nextFloat();
                System.out.println("Digite a posição do conteiner, entre (A e L): ");
                posicao = in.next().charAt(0);
                Conteiner conteiner = new Conteiner(tipoCarga,tipoOperacao, nomeProprietario, pesoCarga, posicao);
                if(empilhador.empilhar(posicao,conteiner)){
                    System.out.println("Conteiner empilhado com sucesso!");
                }
                break;
                case 2:
                System.out.println("Digite o identificador do conteiner que deseja desempilhar: ");
                String identificador = in.next();
                if(empilhador.desempilhar(identificador) ){
                    System.out.println("Conteiner desempilhado com sucesso!");
                }
                break;
                case 3:

                System.out.println("###########################################################");
                System.out.println("# A - Dados do Conteiner no Topo                          #");
                System.out.println("# B - Quantidade de Conteineres por Tipo de Carga         #");
                System.out.println("# C - Peso total por Tipo de Carga                        #");
                System.out.println("# D - Quantidade de Conteineres por Tipo de Operação      #");
                System.out.println("# E - Posições de Empilhamento Vazias                     #");
                System.out.println("###########################################################");
    
                System.out.println("Digite a opção desejada: ");
                char opcao2 = in.next().toUpperCase().charAt(0);
                /* 
                switch(opcao2){
                    case 'A':
                    System.out.println("Digite o Identificador da Pilha:");
                    String identificador = in.next();
                    if()
                        System.out.println("Identificador: "+conteiner.getIdentificador());
                        System.out.println("Proprietário: "+conteiner.getNomeProprietario());
                        System.out.println("Tipo de Carga: "+conteiner.getTipoCarga());
                        System.out.println("Peso: "+conteiner.getPesoCarga());
                        System.out.println("Tipo de Operação: "+conteiner.getTipoOperacao());
                    }else{
                        System.out.println("Não há contêineres empilhados!");
                    }
                    break;
                    case 'B':
                    System.out.println("Quantidade de Conteineres por Tipo de Carga: ");
                    for(TipoCarga t: TipoCarga.values()){
                        System.out.println(t.name()+": "+empilhador.getQuantidadeConteineresPorTipoCarga(t));
                    }
                    break;
                    case 'C':
                    System.out.println("Peso total por Tipo de Carga: ");
                    for(TipoCarga t: TipoCarga.values()){
                        System.out.println(t.name()+": "+empilhador.getPesoTotalCargasPorTipoCarga(t));
                    }
                    break;
                    case 'D':
                    System.out.println("Quantidade de Conteineres por Tipo de Operação: ");
                    for(TipoOperacao t: TipoOperacao.values()){
                        System.out.println(t.name()+": "+empilhador.getQuantidadeConteineresPorTipoOperacao(t));
                    }
                    break;
                    case 'E':
                    */
            }
        }

    }
}
