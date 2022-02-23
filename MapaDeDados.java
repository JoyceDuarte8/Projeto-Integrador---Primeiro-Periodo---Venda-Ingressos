/*
 *
 */
package ingresso;

/**
 *
 * @author joyce
 */
public class MapaDeDados {
//MATEMÁTICA: Aplica-se neste documento a teoria de conjuntos onde um conjunto
//onde há relacionamento entre conjuntos de equivalencia nestes, ou seja,por exemplo
// se a string data equivale a "03/12/2021, ele irá retornar o valor inteiro 0.
 
    static int stringParaIndiceData(String data) {
        switch (data) {
            case "03/12/2021":
                return 0;

            case "04/12/2021":
                return 1;

            case "05/12/2021":
                return 2;
            default:
                return -1;
        }

    }
    static String intDataParaString(int data){
         switch (data) {
             
             case 0:
                return "03/12/2021";

             case 1: 
                return "04/12/2021";

            case 2: 
                return"05/12/2021" ;
            default:
                return "erro";
        } 
    }

    static int stringParaIndiceSessao(String sessao) {

        switch (sessao) {
            
            case "O Rei Leão|Horário:  08:00- 11:00":

                return 0;

            case "Stand Up- Os parças!|Horário:  15:00- 18:00":

                return 1;

            case "Fantasma da Ópera|Horário:  19:00-22:00":
                return 2;
            default:
                return -1;

        }
    }

    static int stringParaIndiceArea(String area) {
        switch (area) {

            case "Plateia A":
                return 0;

            case " Plateia B":
                return 1;

            case "Frisa 01":
                return 2;

            case "Frisa 02":
                return 3;

            case "Frisa 03":
                return 4;

            case "Frisa 04":
                return 5;

            case "Frisa 05":
                return 6;

            case "Frisa 06":

                return 7;

            case "Camarote 01":
                return 8;

            case "Camarote 02":
                return 9;

            case "Camarote 03":
                return 10;

            case "Camarote 04":
                return 11;

            case "Camarote 05":
                return 12;

            case "Balcão Nobre ":
                return 13;

            default:
                return -1;

        }
    }
    
  

    static String intSessaoParaString(int sessao) {
        switch (sessao) {

            case 0:
                return "Rei Leão";

            case 1:
                return "Stand Up- Os parças!";

            case 2:
                return "Fantasma da Ópera";

            default:
                return "erro";
        }
    }
    
    

    static String intAreaParaString(int sessao) {

        switch (sessao) {

            case 0:
                return "Plateia A";

            case 1:
                return " Plateia B";

            case 2:
                return "Frisa 01";

            case 3:
                return "Frisa 02";

            case 4:
                return "Frisa 03";

            case 5:
                return "Frisa 04";

            case 6:
                return "Frisa 05";

            case 7:

                return "Frisa 06";

            case 8:
                return "Camarote 01";

            case 9:
                return "Camarote 02";

            case 10:
                return "Camarote 03";

            case 11:
                return "Camarote 04";

            case 12:
                return "Camarote 05";

            case 13:
                return "Balcão Nobre ";

            default:
                return "erro";

        }

    }

    static int[][][] disponiveisParaOcupados(int[][][] disponiveis, int[] totalLugares) {

        
    //MATEMÁTICA: Para encontrarmos a quantide de cadeiras ocupadas de cada área
    //, referente a uma data e sessão específica. Nos pegamos a quantidade de 
    // lugares de cada área, ou seja, o total de cadeiras de cada área e diminuimos
    //pela quantidade de cadeiras disponíveis daquela área, daquela data e e daquela
    //sessão.
    
    
        int[][][] ocupados = new int[3][3][14];

        for (int data = 0; data < disponiveis.length; data++) {
            for (int sessao = 0; sessao < disponiveis[data].length; sessao++) {

                for (int area = 0; area < disponiveis[data][sessao].length; area++) {

                    ocupados[data][sessao][area] = totalLugares[area] - disponiveis[data][sessao][area];
                }
            }
        }

        return ocupados;
    }
}
