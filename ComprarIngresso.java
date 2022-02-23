/*
 * 
 */
package ingresso;

import java.util.List;

/**
 *
 * @author joyce
 */
public class ComprarIngresso {

    
    
    static void comprarIngresso(int[][][] disponiveis,
                                double[]valoresIngressos,
                                List<String> cpfs, 
                                List<String> datas, 
                                List<String> sessoes, 
                                List<String> areas, 
                                List<Integer> quantidadesIngressos) {

        System.out.println("-----------------------------------");
        System.out.println("TEATRO ABC:");
        System.out.println("                                   ");
        System.out.println("-----------------------------------");
        System.out.println("Peças em cartaz:");
        System.out.println("                                   ");
        System.out.println("Do dia 03 a 05 de novembro 2021.");
        System.out.println("                                   ");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("1   - O Rei Leão  ");
        System.out.println("Horário:  08:00- 11:00");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("2   - Stand Up- Os parças!");
        System.out.println("Horário:  15:00- 18:00");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("3   - Fantasma da Ópera  ");
        System.out.println(" Horário:  19:00-22:00");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("                                   ");
        System.out.println(" COMPRE O SEU INGRESSO:");
        System.out.println("                                   ");

        // Tem-se a chamada de métodos criados no arquivo "Input.java" e no arquivo
        //"MapaDeDados.java", que irá executar neste arquivo, os códigos lá criados.
        //Assim, irá executar se o cpf digitado está correto, irá armazenar a escolha
        //da data e peça em forma de string, irá transformar a escolha desta data e
        // peça em um número inteiro em "dataIndice" e "sessaoIndice", para que essas
        //informações sejam tratadas em uma matriz.
        String cpf = Input.obterCpf();
        
        //Os registros de CPFs serão adiconados na lista ( List<String> cpfs) .
         cpfs.add(cpf);
        String data = Input.obterData();
        
        //As datas serão adicionados na lista (List<String> datas).
        datas.add(data);
        int dataIndice = MapaDeDados.stringParaIndiceData(data);
        String sessao = Input.obterPeca();
        
        //As sessões serão adicionados na lista (List<String> sessões).
        sessoes.add(sessao);
        int sessaoIndice = MapaDeDados.stringParaIndiceSessao(sessao);
        
        // Nesta chamada de método "String area" vai receber as informaçãoes do 
        //arquivo "obterArea", mostrando especificamente a lista de áreas 
        // disponíveis,naquele dia e naquela sessão.
        String area = Input.obterArea(disponiveis[dataIndice][sessaoIndice]);
        areas.add(area);
        int areaIndice = MapaDeDados.stringParaIndiceArea(area);
        
        int quantidadeIngressos = Input.obterQuantidadeIngressos(disponiveis[dataIndice][sessaoIndice][areaIndice]);
        quantidadesIngressos.add(quantidadeIngressos);
        
        
        //Nessa matriz "disponíveis", que refere a quantidade de poltronas vagas,
        //recebe o valor quantidade de ingressos comprados a menos.
        disponiveis[dataIndice][sessaoIndice][areaIndice] -= quantidadeIngressos;

        
        double valorIngresso = valoresIngressos[areaIndice];
        ingressoComprado(cpf, data, sessao, area, valorIngresso,quantidadeIngressos);
    }

    //Neste, irá mostrar na tela do usuário, as informações referentes ao ingresso
    //comprado.
    static void ingressoComprado(String cpf, String data, String sessao, String area, double valorUnitario,int quantidadeIngressos) {
        System.out.println("                                    ");
        System.out.println("                                    ");
        System.out.println("                                    ");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("                                    ");
        System.out.println(data + "           " + area);
        System.out.println("CPF: " + cpf);
        System.out.printf("%d INGRESSOS: R$ %.2f\n ",quantidadeIngressos, valorUnitario*quantidadeIngressos);
        System.out.println("                                    ");
        System.out.println("                                    ");
        System.out.println("                                    ");
        System.out.println("      " + sessao);
        System.out.println("                                    ");
        System.out.println("                                    ");
        System.out.println("             Teatro ABC");
        System.out.println("                Goiania-GO.");
        System.out.println("                                    ");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("                                    ");
        System.out.println("Java Café - Ingressos");
        System.out.println("                                    ");
        System.out.println("                                    ");

    }

}
