/*
 * 
 */
package ingresso;

import java.util.Scanner;

/**
 *
 * @author joyce
 */
public class Input {

 //Neste, vai retornar o valor boleano (sim ou não), referente ao número digitado 
//do CPF, ter letras. Se tiver letras irá retornar o valor "true" e se não "false".
    static boolean cpfTemLetras(String cpf) {
     
        for (int i = 0; i < cpf.length(); i++) {
            char a = cpf.charAt(i);
            if (a != '0' && a != '1' && a != '2' && a != '3' && a != '4' && a != '5' && a != '6' && a != '7' && a != '8' && a != '9') {
                return true;
            }
        }
        return false;
    }
    

    static String obterCpf() {
        
     // O valor digitado do CPF será armazenado na forma de string.
        String cpf;

        Scanner leia = new Scanner(System.in);
        
        //Nesta estrutura, enquanto o usuário digitar o CPF que tenha um valor
        //acima de 11 números e que tenha letras, o usuário continuará a solicitar
        // e confirmar o valor digitado. Se ele digitar 11 números inteiros, está estrutura
        //retornará o valor do CPF e sairá desta estrutura de repitação.
        
        while (true) {
            
            System.out.println("Digite o CPF:");
            cpf = leia.next();
            
             //A condição se CPF digitou for inválido se tiver o tamanho
             //diferete de 11 e se tiver letras (cpfTemLetras), irá mostrar na
             //na tela a mensagem CPF inválido.
            if (cpf.length() != 11 || cpfTemLetras(cpf)) {
                
                System.out.println("CPF inválido. Digite novamente!");

            } else {
                
                //Se o cpf estiver correto, for de 11 números inteiros, logo terá
                // uma função bolena como codição (confirma) que  se for verdade 
                // proceguirá com as outras estapas para comprar o ingresso, e se
                // for falso irá solicitar novamente para digitar o CPF.
                if (confirmar()) {
                    
                    break;
                }
            }

        }

        return cpf;
    }
    
    // boolean confirmar é uma classe feita para fazer a confirmação do que foi
     // digitado pelo usuário. 
    static boolean confirmar() {
    
        Scanner leia = new Scanner(System.in);
        System.out.println("Confirma:");
        System.out.println("1-Sim");
        System.out.println("2-Não");

        int codigo = leia.nextInt();
        if (codigo == 1) {
            return true;
        }
        return false;

    }

    //O valor do obterData será uma string escolhida pela opção que usuário digitou.
    static String obterData() {
        
        // Primeiro, irá mostrar na tela as opções de datas. Que usuário irá digitar
        //o número referente a data desejada.
        do {
            System.out.println("-----------------------------------");
            System.out.println("Escolha a data:");
            System.out.println("                                   ");
            System.out.println("Opção - Data:");
            System.out.println("1     - 03/12/2021");
            System.out.println("2     - 04/12/2021");
            System.out.println("3     - 05/12/2021");
            Scanner leia = new Scanner(System.in);
            int opcao = leia.nextInt();
            
            // Se o número digitado for igual ao condição "opcao" dos case (1, 2 ou
            //3). Irá retornar a opção escolhida em forma de string e depois irá
            //solicitar que confirme a informação escolhida pela boleana (confirmar ()).
            
            // MATEMÁTICA: Estrutura de igualdade de conjuntos, onde dois conjuntos são comparados
            // se possuem o mesmo valor referente e conectivos lógicos de conjunção.
            // em que só será verdade quandos os elementos relativos forem verdade. 
            //Ou seja, se as duas opções referentes de data são iguais (Verdadeiro ) e a 
            //confirmação for Verdadeiro então é Verdade, o dado é armazenado e segue para
            //outras partes do código. Se as datas forem iguais (verdadeiro) e se a confirmação
            //for falso, então será falso. Retornará novamente ao loope de repetição.
            //para sair da condição de loope (while) é se  ~(0<opcao<=3 ^ confirmar()).
            
            if (confirmar()) {
                switch (opcao) {
                    case 1:
                        return "03/12/2021";
                    case 2:
                        return "04/12/2021";
                    case 3:
                        return "05/12/2021";

                }
            }

        } while (true);

    }
    
//Irá armazenar em string da opção de peça escolhida.
    static String obterPeca() {
        do {
            //Irá mostrar na tela as opções de peça:
            System.out.println("-----------------------------------");
            System.out.println("Escolha a peça teatral:");
            System.out.println("                                   ");
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("                                   ");
            System.out.println("Opção-Peça:");
            System.out.println("                                   ");
            System.out.println("1   - O Rei Leão.  ");
            System.out.println("Horário:  08:00- 11:00");
            System.out.println("                                   ");
            System.out.println("2   - Stand Up- Os parças!");
            System.out.println("Horário:  15:00- 18:00");
            System.out.println("                                   ");
            System.out.println("3   - Fantasma da Ópera.");
            System.out.println("Horário:  19:00-22:00");
            System.out.println("                                   ");
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("                                   ");
            System.out.println("Digite o número da opção da peça desejada!");
            System.out.println("                                   ");

            Scanner leia = new Scanner(System.in);
            int opcao = leia.nextInt();
            
            //Irá escolher a opção referente, que irá retornar uma string. E,logo
            //após o usuário irá confirmar as informações da escolha desejada.
            
            // MATEMÁTICA: Semelhante da escrita no método- static String obterData(),
            //acima.

            if (confirmar()) {
                switch (opcao) {
                    case 1:
                        return "O Rei Leão|Horário:  08:00- 11:00";

                    case 2:
                        return "Stand Up- Os parças!|Horário:  15:00- 18:00";

                    case 3:
                        return "Fantasma da Ópera|Horário:  19:00-22:00";

                }
            }

        } while (true);

    }

    static String obterArea(int[] areasDisponiveis) {
        
        do {
            // Irá mostra na tela do usuários as opções de área, o valor das respectivas
            //e a quantidade de poltronas disponíveis (vagas), referentes aquela área.
            System.out.println("-----------------------------------");
            System.out.println("Escolha a área:");
            System.out.println("                                   ");
            System.out.println("Opção - Área         - Valor     - Poltronas vagas:");
            System.out.println("1     - Plateia A    - R$  40,00 - " + areasDisponiveis[0]);
            System.out.println("2     - Plateia B    - R$  60,00 - " + areasDisponiveis[1]);
            System.out.println("3     - Frisa 01     - R$ 120,00 - " + areasDisponiveis[2]);
            System.out.println("4     - Frisa 02     - R$ 120,00 - " + areasDisponiveis[3]);
            System.out.println("5     - Frisa 03     - R$ 120,00 - " + areasDisponiveis[4]);
            System.out.println("6     - Frisa 04     - R$ 120,00 - " + areasDisponiveis[5]);
            System.out.println("7     - Frisa 05     - R$ 120,00 - " + areasDisponiveis[6]);
            System.out.println("8     - Frisa 06     - R$ 120,00 - " + areasDisponiveis[7]);
            System.out.println("9     - Camarote 01  - R$  80,00 - " + areasDisponiveis[8]);
            System.out.println("10    - Camarote 02  - R$  80,00 - " + areasDisponiveis[9]);
            System.out.println("11    - Camarote 03  - R$  80,00 - " + areasDisponiveis[10]);
            System.out.println("12    - Camarote 04  - R$  80,00 - " + areasDisponiveis[11]);
            System.out.println("13    - Camarote 05  - R$  80,00 - " + areasDisponiveis[12]);
            System.out.println("14    - Balcão Nobre - R$ 250,00 - " + areasDisponiveis[13]);

            Scanner leia = new Scanner(System.in);
            int opcao = leia.nextInt();
            
            // A partir da escolha do usuário, se o valor solicitado estiver nas opções
            // do switch, irá assim, retornar o valor em forma de string da área escolhida.
            // Que logo após terá que confirmar a opção desejada pela estrutura boleana
            //confirmar.
            
             // MATEMÁTICA: Semelhante da escrita no método- static String obterData(),
            //acima.
             
             
            if (confirmar()) {
                switch (opcao) {
                    case 1:
                        return "Plateia A";

                    case 2:
                        return " Plateia B";

                    case 3:
                        return "Frisa 01";

                    case 4:
                        return "Frisa 02";

                    case 5:
                        return "Frisa 03";

                    case 6:
                        return "Frisa 04";

                    case 7:
                        return "Frisa 05";

                    case 8:
                        return "Frisa 06";

                    case 9:
                        return "Camarote 01";

                    case 10:
                        return "Camarote 02";

                    case 11:
                        return "Camarote 03";

                    case 12:
                        return "Camarote 04";

                    case 13:
                        return "Camarote 05";

                    case 14:
                        return "Balcão Nobre ";

                }
            }

        } while (true);

    }

    static int obterQuantidadeIngressos(int cadeirasDisponiveis) {

        do {
            //Irá mostra na tela a mensagem da quantide de ingressos desejados:
            System.out.println("----------------------------------");
            System.out.println("                                   ");
            System.out.println("Digite a quantidade de ingressos:");
            System.out.println("                                   ");

            Scanner leia = new Scanner(System.in);
            int quantidadeIngressos = leia.nextInt();
            
            //Se a quantidade de ingressos que o usuário deseja comprar for maior
            //que a quantidade de cadeiras disponíveis, irá aparecer uma informação
            // referente a isto. Agora, se for menor que a quantidade de cadeiras 
            // disponíveis, irá retornar a quantidade de ingressos. Que logo após,
             //terá que confirmar a informação.
            if (cadeirasDisponiveis<quantidadeIngressos){
                System.out.println("Quantidade de ingressos desejadas é superior ao disponível.");
            } else if (confirmar()) {
       
                    return quantidadeIngressos;
                }
        }
            while (true);

        }
        
   
    }
