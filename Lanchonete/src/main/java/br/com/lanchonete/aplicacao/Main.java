package br.com.lanchonete.aplicacao;
/**
 * @author Daniel Marques
 */

import br.com.lanchonete.auxiliar.BebidaAUX;
import br.com.lanchonete.auxiliar.LancheAUX;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1 - Lanche");
            System.out.println("2 - Bebida");
            System.out.println("9 - Finalizar");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    do {
                        opcao = 0;
                        System.out.println("1 - Registrar Lanche");
                        System.out.println("2 - Mostrar Lanches");
                        System.out.println("3 - Alterar Lanche");
                        System.out.println("4 - Deletar Lanche");
                        System.out.println("9 - Finalizar");
                        opcao = sc.nextInt();
                        switch (opcao) {
                            case 1:
                                LancheAUX.registra();
                                break;
                            case 2:
                                LancheAUX.mostra();
                                break;
                            case 3:
                                LancheAUX.atualiza();
                                break;
                            case 4:
                                LancheAUX.deleta();
                                break;
                        }
                    } while (opcao != 9);
                    opcao = 0;
                    break;
                case 2:
                    do {
                        opcao = 0;
                        System.out.println("1 - Registrar Bebida");
                        System.out.println("2 - Mostrar Bebidas");
                        System.out.println("3 - Alterar Bebida");
                        System.out.println("4 - Deletar Bebida");
                        System.out.println("9 - Finalizar");
                        opcao = sc.nextInt();
                        switch (opcao) {
                            case 1:
                                BebidaAUX.registra();
                                break;
                            case 2:
                                BebidaAUX.mostra();
                                break;
                            case 3:
                                BebidaAUX.atualiza();
                                break;
                            case 4:
                                BebidaAUX.deleta();
                                break;
                        }
                    } while (opcao != 9);
                    opcao = 0;
                    break;
            }
        } while (opcao != 9);
    }
}
