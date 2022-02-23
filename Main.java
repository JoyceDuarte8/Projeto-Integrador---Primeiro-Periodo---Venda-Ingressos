/*
 * 
 */
package ingresso;

import static ingresso.Input.confirmar;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author joyce
 */
public class Main {

    static double[] carregarValoresIngressos() {
        
        //Declarado o tipo do vetor "valoresIngressos" que será double de 14 elementos,
        //que com relação a posição da área, atribui um valor de ingresso respectivo.
        double[] valoresIngressos = new double[14];

        //Nesta posição (0), refere-se a Plateia A, que será atribuido o valor
        // de R$40,00 reais nela.
        valoresIngressos[0] = 40.00;
        //Nesta posição (1), refere-se a Plateia B, que será atribuido o valor de
        // R$60 reais nela, e assim, sucessivamente.
        valoresIngressos[1] = 60.00;
        //Nesta posição (2), refere-se a Area Frisa 01:
        valoresIngressos[2] = 120.00;
        //Nesta posição (3), refere-se a Area Frisa 02:
        valoresIngressos[3] = 120.00;
        //Nesta posição (4), refere-se a Area Frisa 03:
        valoresIngressos[4] = 120.00;
        //Nesta posição (5), refere-se a Area Frisa 04:
        valoresIngressos[5] = 120.00;
        //Nesta posição (6), refere-se a Área Frisa 05:
        valoresIngressos[6] = 120.00;
        //Nesta posição (7), refere-se a Área Frisa 06:
        valoresIngressos[7] = 120.00;
        //Nesta posição (8), refere-se a Área Camarote 01;
        valoresIngressos[8] = 80.00;
        //Nesta posição (9), refere-se a Área Camarote 02;
        valoresIngressos[9] = 80.00;
        //Nesta posição (10), refere-se a Área Camarote 03;
        valoresIngressos[10] = 80.00;
        //Nesta posição (11), refere-se a Área Camarote 04;
        valoresIngressos[11] = 80.00;
        //Nesta posição (12), refere-se a Área Camarote 05;
        valoresIngressos[12] = 80.00;
        //Nesta posição (13), refere-se a Área Balcão Nobre;
        valoresIngressos[13] = 250.00;

        return valoresIngressos;
    }

    public static void main(String[] args) {

        
     // As listas (List) seram utilizadas no switch case 2, no caso do usuário
     //solicitar a impressão do ingresso do respectivo CPF informado. Então, está
     // lista irá armazenar as informações referentes a cada ingresso comprado por
     //CPF.
        int[] totalLugaresTeatro = carregarTotalLugaresTeatro();
        double[] valoresIngressos = carregarValoresIngressos();
        int[][][] disponiveis = carregarLugaresDiponiveis(totalLugaresTeatro);

        List<String> cpfs = new ArrayList<>();
        List<String> datas = new ArrayList<>();
        List<String> sessoes = new ArrayList<>();
        List<String> areas = new ArrayList<>();
        List<Integer> quantidadesIngressos = new ArrayList<>();

        //O valor deste booleano "sair" é falso.
        boolean sair = false;
// Enquanto, a opção escolhida for diferente da opção sair, ou seja, se for verdade
// o while será executado.
        while (!sair) {

            System.out.println("-----------------------------------");
            System.out.println("TEATRO ABC:");
            System.out.println("                                   ");
            System.out.println("-----------------------------------");
            System.out.println("Escolha a opção desejada:");
            System.out.println("                                   ");
            System.out.println("Opção:");
            System.out.println("1     - Venda de ingressos");
            System.out.println("2     - Imprimir ingresso");
            System.out.println("3     - Relatório de Estatistica");
            System.out.println("4     - Sair");

            Scanner leia = new Scanner(System.in);
            int opcao = leia.nextInt();

            //No switch, é um conjunto de opções, neste caso 1,2 e 3, que este será comparado ao
            //a variável opcao, e enquanto for verdadeiro, ela é executado e finalizado pelo
            //break. Então, o switch tem a finalidade de que o usuário escolha a opção desejada
            //e que se o digitado for um dos case, este irá executar.
            
            //MATEMÁTICA: Neste switch é utilizado o conectivo lógico de conjunção p^q 
            // no qual é verdade nos casos p e q sejam verdadeiros, ou seja, é verdade quando
            //o valor opção é igual ao valor do case, assim, é processado o que está neste case.
            // se for falso, não irá executar.
            switch (opcao) {

                //Se a opção for 1, irá executar os comandos do arquivo "ComprarIngresso".
                case 1:
                    ComprarIngresso.comprarIngresso(disponiveis, valoresIngressos, cpfs, datas, sessoes, areas, quantidadesIngressos);
                    break;

                //Se a opção for 2, irá imprimir o ingresso comprado do CPF correspondente.  
                case 2:
                    
                       String cpf = Input.obterCpf();
                       
                   // Percorrendo uma lista de cpfs, que se o cpf digitado for igual
                   //ao da lista cpfs da posição de indice i, ele vai obter as informações
                   //da data, sessao, area, quantidade de ingressos e valores de ingressos
                    //e irá parar o processo.
                    for (int i = 0; i < cpfs.size(); i++) {
                     
                        if (cpf.equals(cpfs.get(i))){
                        ComprarIngresso.ingressoComprado(
                                cpfs.get(i), 
                                datas.get(i),
                                sessoes.get(i), 
                                areas.get(i),
                                valoresIngressos[MapaDeDados.stringParaIndiceArea(areas.get(i))], 
                                quantidadesIngressos.get(i));
                        break;
                        }
                      
                    }
                    break;

                //Se a opção for o 3, irá executar os comandos referentes do arquivo "RelatorioDeEstatistica"
               // que trata sobre o "Relatório de vendas" dos ingressos.                  
                case 3:
                    int[][][] ocupados = MapaDeDados.disponiveisParaOcupados(disponiveis, totalLugaresTeatro);
                    RelatorioDeEstatistica.totalDeIngressos(ocupados);
                    RelatorioDeEstatistica.sessaoMaiorOcupacao(ocupados);
                    RelatorioDeEstatistica.sessaoLucroOcupacao(ocupados, valoresIngressos);
                    RelatorioDeEstatistica.lucroMedioTotalIngressos(ocupados, valoresIngressos);

                    break;

//Se a opção for 4, o programa de vendas de ingresso se encerra-ra, e as informações
//referentes a vendas de ingressos serão esvaziadas.
                case 4:
                    sair = Input.confirmar();
                    break;
            }

        }

    }

    // Nesta matriz, está colocada a quantidade de locais disponíveis,
    //o primeiro termo  refere a sessão, que são  três (3)e o segundo termo se refere a
    // area do Teatro:
    private static int[][][] carregarLugaresDiponiveis(int[] totalLugaresTeatro) {

        //Neste, código tem como objetivo preencher nas sessões e areas das poltronas
        //os valores iniciais da disponabilidade, ou seja, o quanto de lugares disponíveis cada 
        //área possui.
        
        //MATEMÁTICA: Matriz de três dimensões- .................
        int[][][] disponiveis = new int[3][3][14];

        for (int data = 0; data < disponiveis.length; data++) {
            for (int sessao = 0; sessao < disponiveis[data].length; sessao++) {

                for (int area = 0; area < disponiveis[data][sessao].length; area++) {

                    disponiveis[data][sessao][area] = totalLugaresTeatro[area];

                }
            }
        }
        return disponiveis;
    }

    //O Void neste caso irá imprimir a informação das Strings cpf, data, peça, valor
    //do ingresso e a Área da poltrona.
    private static int[] carregarTotalLugaresTeatro() {

        //Neste vetor, será colocada a disponabilidade original de cada área, ou
        //seja a quantidade total de cadeiras por area. Os valores deste vetor não
        // poderá ser alterados, pois será importante para os relatórios de estatística.
        int[] totalLugares = new int[14];
        // Neste, representa a posição da matriz (0), que vai receber a quantidade 
        //total de lugares, referente a Platéia A, que são de 25 lugares.
        totalLugares[0] = 25;
        //Nesta posição (1), refere-se a Plateia B:
        totalLugares[1] = 100;
        //Nesta posição (1), refere-se a Area Frisa:
        // Com este inteiro Frisa recebendo 5, signif. que todos Frisas terá 5 lugares.
        int FRISA = 5;
        //Nesta posição (2), refere-se a Area Frisa 01:
        totalLugares[2] = FRISA;
        //Nesta posição (3), refere-se a Area Frisa 02:
        totalLugares[3] = FRISA;
        //Nesta posição (4), refere-se a Area Frisa 03:
        totalLugares[4] = FRISA;
        //Nesta posição (5), refere-se a Area Frisa 04:
        totalLugares[5] = FRISA;
        //Nesta posição (6), refere-se a Área Frisa 05:
        totalLugares[6] = FRISA;
        //Nesta posição (7), refere-se a Área Frisa 06:++
        totalLugares[7] = FRISA;
        int CAMAROTE = 10;
        //Nesta posição (8), refere-se a Área Camarote 01;
        totalLugares[8] = CAMAROTE;
        //Nesta posição (9), refere-se a Área Camarote 02;
        totalLugares[9] = CAMAROTE;
        //Nesta posição (10), refere-se a Área Camarote 03;
        totalLugares[10] = CAMAROTE;
        //Nesta posição (11), refere-se a Área Camarote 04;
        totalLugares[11] = CAMAROTE;
        //Nesta posição (12), refere-se a Área Camarote 05;
        totalLugares[12] = CAMAROTE;
        //Nesta posição (13), refere-se a Área Balcão Nobre;
        totalLugares[13] = 50;
        return totalLugares;
    }

}
