/*
 *

 */
package ingresso;

/**
 *
 * @author joyce
 */
public class RelatorioDeEstatistica {

//MATEMÁTICA:
//-Qual a peça teve mais ingressos vendidos e menos vendidos;
//Resposta: A soma de todos os ingressos de todos os dias por peça.
//Qual sessão teve maior e menor ocupação de poltronas;
//Resposta: A sessao de tal dia, teve a maior venda de ingresssos, e ela é qual peça.
//- Qual a peça/sessão mais lucrativa e menos lucrativa;
//Resposta: Qual foi a sessão mais lucrativa, de qual dia, e a menos lucrativa, ela
//é da peça tal.
//-Lucro médio do teatro com todas as áreas por peça.
//Resposta: Soma-se o valor total da venda de todos os ingresos, de todos os dias
//e divide pela quantidade de peça.
    
    // OBS - O void não retorna em nenhum arquivo, ele apenas irá mostrar as informações
    //processadas.
    static void totalDeIngressos(int[][][] ocupacao) {
     
        // Neste vetor "ocupacaoPorPecaTodosDias" irá receber o somatório do total
        //de ingressos vendidos de todas as datas, de todas as áreas e separados por
        //peças (3).
        int[] ocupacaoPorPecaTotalDias = new int[3];

        
        //Laço para a somatória da venda de ingressos de todas as datas, de todas as peças (sessao)
        //e de todas as áreas do tanto de ingressos vendidos da variável (ocupacao)
        // esta irá atribuir o somatório para a variável "ocupacaoPorPecaTotalDias",
        //que será separada por sessao.
        
        // Aqui buscou-se somar os valores de uma matriz de três dimensões e agrupa-los
        //o somatorio em um vetor chamado "ocupacaoPorPecaTotalDias",em uma dimensão, e 
        //mostrando os valores da posição sessao. 
        
        // MATEMÁTICA: Matriz de três dimensões- 
        for (int data = 0; data < ocupacao.length; data++) {
            for (int sessao = 0; sessao < ocupacao[data].length; sessao++) {

                for (int area = 0; area < ocupacao[data][sessao].length; area++) {

                    ocupacaoPorPecaTotalDias[sessao] += ocupacao[data][sessao][area];
                }
            }
        }
        System.out.println("----------------------------------------------------------------------:");
        System.out.println("                                    ");
        System.out.println("ESTATÍSTICA DE VENDAS: ");
        System.out.println("                                    ");
    
        //Essa variável irá receber o valor da "sessaoMaisOcupada" e da "sessãoMenos
        //Ocupada", que será retornada após a execussão do laço de repetição (for) e
        // e da estrutura de seleção (if).
        int sessaoMaisOcupada = 0, sessaoMenosOcupada = 0;
        //
        for (int sessao = 0; sessao < ocupacaoPorPecaTotalDias.length; sessao++) {
            //Neste, vai retornar a sessão mais ocupada. Então, se a "ocupacaoPorPecaTotal
            //Dias" do valor total por sessão, for maior que 

            // (CONTINUAR A EXPLICAÇÃO).
            //a variável "sessaoMaisOcupada" vai receber o valor da variável "sessao", que
            //é a sessão mais ocupada de todos os dias de venda de ingressos.
            if (ocupacaoPorPecaTotalDias[sessao] > ocupacaoPorPecaTotalDias[sessaoMaisOcupada]) {
                sessaoMaisOcupada = sessao;
            }

            if (ocupacaoPorPecaTotalDias[sessao] < ocupacaoPorPecaTotalDias[sessaoMenosOcupada]) {
                sessaoMenosOcupada = sessao;
            }
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.println("                                    ");
        System.out.println("Peça com ingressos mais vendidos e menos vendidos: ");
        System.out.println("                                    ");
        System.out.printf(
                "Peça com ingressos mais vendidos: %s - %d ingressos vendidos\n",
                MapaDeDados.intSessaoParaString(sessaoMaisOcupada),
                ocupacaoPorPecaTotalDias[sessaoMaisOcupada]);
        System.out.printf(
                "Peça com ingressos menos vendidos: %s - %d ingressos vendidos\n",
                MapaDeDados.intSessaoParaString(sessaoMenosOcupada),
                ocupacaoPorPecaTotalDias[sessaoMenosOcupada]);
        System.out.println("                                    ");

    }

    static void sessaoMaiorOcupacao(int[][][] ocupacao) {
        
        //Nesta matriz "int sessaoOcupacaoEntreDias", irá receber a somatória da
        //ocupação da matriz de três dimensões (data,sessao e de cada area)na variável
        //"ocupacao" e vai atribuir este valor na variável de duas dimensões (data e sessão)
        //chamada "sessaoOcupacaoEntreOsDias", que mostrará o somatório da ocupação
        //das peças separadas por datas. Então, o "sessaoOcupacaoEntreOsDias" receberá
        //o somatório da ocupação das três peças, separada pelos três dias.

        int[][] sessaoOcupacaoEntreOsDias = new int[3][3];

        for (int data = 0; data < ocupacao.length; data++) {
            for (int sessao = 0; sessao < ocupacao[data].length; sessao++) {

                for (int area = 0; area < ocupacao[data][sessao].length; area++) {

                    sessaoOcupacaoEntreOsDias[data][sessao] += ocupacao[data][sessao][area];
                }
            }
        }

        System.out.println("                                    ");
        
        
//Neste inteiros será atribuido o **INDICE** - ou seja o "endereço" da matriz
// referentes onde tem a sessão mais ocupada e menos ocupada e as respectivas datas
//, estes indices foram dados pelo for associado ao if. Ele não retorna o valor
//dentro da matriz, mas o seu "endereço" pois com ele posso dizer a data e sessão
//respectiva.
        int indiceSessaoMaisOcupada = 0, indiceSessaoMenosOcupada = 0;
        int indiceDataSessaoMaisOcupada = 0, indiceDataSessaoMenosOcupada = 0;


        for (int indiceData = 0; indiceData < ocupacao.length; indiceData++) {
            for (int indiceSessao = 0; indiceSessao < sessaoOcupacaoEntreOsDias.length; indiceSessao++) {
             
     
      
         //Neste, "ocupacaoDataSessao", será atribuido o valor que está no endereço da data e sessao.
         //Exemplo, total de ingressos vendidos na data 03 (inicie 0) e da sessão Os parsas (indice 1),
         //então dos indices 0 1, do total de ocupação tem dentro dessa matriz a venda de 29 cadeiras.
         // o valor 29 será colocado no int "ocupacaoDataSessao", que o numero 29 será comparado no if.
         // o após constar que este é o maior numero, será atribuido para o "indiceSessaoMaisOcupada" e
         // "indiceDataSessaoMaisOcupada", o endereço do numero 29, que é 0 e 1.
 
                int ocupacaoDataSessao = sessaoOcupacaoEntreOsDias[indiceData][indiceSessao];
        
                int ocupacaoMaiorDataSessao = sessaoOcupacaoEntreOsDias[indiceDataSessaoMaisOcupada][indiceSessaoMaisOcupada];
   
                if (ocupacaoDataSessao > ocupacaoMaiorDataSessao) {
                    indiceSessaoMaisOcupada = indiceSessao;
                    indiceDataSessaoMaisOcupada = indiceData;
                }
                
                int ocupacaoMenorDataSessao = sessaoOcupacaoEntreOsDias[indiceDataSessaoMenosOcupada][indiceSessaoMenosOcupada];
                if (ocupacaoDataSessao < ocupacaoMenorDataSessao) {
                    indiceSessaoMenosOcupada = indiceSessao;
                    indiceDataSessaoMenosOcupada = indiceData;
                }
            }
        }
        
        
        System.out.println("----------------------------------------------------------------------");
        System.out.println("                                    ");
        System.out.println("Sessão mais e menos ocupada: ");
        System.out.println("                                    ");
        System.out.printf("Sessão mais ocupada: %s %s - %d poltronas ocupadas.\n",
                MapaDeDados.intSessaoParaString(indiceSessaoMaisOcupada),
                MapaDeDados.intDataParaString(indiceDataSessaoMaisOcupada), 
                sessaoOcupacaoEntreOsDias[indiceSessaoMaisOcupada][indiceDataSessaoMaisOcupada]);
        System.out.printf("Sessão menos ocupada: %s %s - %d poltronas ocupadas.\n",
                MapaDeDados.intSessaoParaString(indiceSessaoMenosOcupada),
                MapaDeDados.intDataParaString(indiceDataSessaoMenosOcupada), 
                sessaoOcupacaoEntreOsDias[indiceSessaoMenosOcupada][indiceDataSessaoMenosOcupada]);
        System.out.println("                                    ");
        System.out.println("----------------------------------------------------------------------");

    }

    static void sessaoLucroOcupacao(int[][][] ocupacao, double[] valoresIngressos) {

        double[][] sessaoLucroOcupacao = new double[3][3];

        for (int data = 0; data < ocupacao.length; data++) {
            for (int sessao = 0; sessao < ocupacao[data].length; sessao++) {

                for (int area = 0; area < ocupacao[data][sessao].length; area++) {

                    sessaoLucroOcupacao[data][sessao] += ocupacao[data][sessao][area] * valoresIngressos[area];
                }
            }
        }

        System.out.println("                                    ");

        int sessaoMaisLucrativa = 0, sessaoMenosLucrativa = 0;
        int dataSessaoMaisLucrativa = 0, dataSessaoMenosLucrativa = 0;

        for (int data = 0; data < ocupacao.length; data++) {
            for (int sessao = 0; sessao < sessaoLucroOcupacao.length; sessao++) {
                if (sessaoLucroOcupacao[data][sessao] > sessaoLucroOcupacao[dataSessaoMaisLucrativa][sessaoMaisLucrativa]) {
                    sessaoMaisLucrativa = sessao;
                    dataSessaoMaisLucrativa = data;
                }

                if (sessaoLucroOcupacao[data][sessao] < sessaoLucroOcupacao[dataSessaoMenosLucrativa][sessaoMenosLucrativa]) {
                    sessaoMenosLucrativa = sessao;
                    dataSessaoMenosLucrativa = data;
                }
            }
        }

        System.out.println("                                    ");
        System.out.println("Sessão mais e menos lucrativa: ");
        System.out.println("                                    ");
        System.out.printf("Sessão mais lucrativa: %s - %s - R$ %.2f reais.\n",
                MapaDeDados.intSessaoParaString(sessaoMaisLucrativa),
                MapaDeDados.intDataParaString(dataSessaoMaisLucrativa),
                sessaoLucroOcupacao[dataSessaoMaisLucrativa][sessaoMaisLucrativa]);
        System.out.printf("Sessão menos lucrativa: %s - %s - R$ %.2f reais.\n",
                MapaDeDados.intSessaoParaString(sessaoMenosLucrativa),
                MapaDeDados.intDataParaString(dataSessaoMenosLucrativa),
                sessaoLucroOcupacao[dataSessaoMenosLucrativa][sessaoMenosLucrativa]);
        System.out.println("                                    ");
        System.out.println("----------------------------------------------------------------------");

    }

    static void lucroMedioTotalIngressos(int[][][] ocupacao, double[] valoresIngressos) {
    
        
        
        double lucroTotalIngressos = 0;

        for (int data = 0; data < ocupacao.length; data++) {
            for (int sessao = 0; sessao < ocupacao[data].length; sessao++) {

                for (int area = 0; area < ocupacao[data][sessao].length; area++) {

                    lucroTotalIngressos += ocupacao[data][sessao][area] * valoresIngressos[area];

                }
            }
        }
        double lucroMedioTotalIngressos = lucroTotalIngressos / 3;

        System.out.println("Lucro Médio do Teatro: ");
        System.out.println("                                    ");
        System.out.printf("Lucro Médio do Teatro foi de R$ %.2f reais.\n", lucroMedioTotalIngressos);
        System.out.println("                                    ");

    }

}
