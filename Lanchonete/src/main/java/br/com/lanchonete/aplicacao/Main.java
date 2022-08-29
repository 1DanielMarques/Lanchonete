package br.com.lanchonete.aplicacao;
/**
 * @author Daniel Marques
 */

import br.com.lanchonete.dao.BebidaDAO;
import br.com.lanchonete.dao.LancheDAO;
import br.com.lanchonete.model.Bebida;
import br.com.lanchonete.model.Lanche;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Bebida bebida = new Bebida();
        BebidaDAO bebidaDao = new BebidaDAO();
        int opcao = 0;
        Scanner sc = new Scanner(System.in);


        do {
            System.out.println("1 - Lanche");
            System.out.println("2 - Bebida");
            System.out.println("9 - Finalizar");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    String nome, descricao, aux, resposta = "";
                    double valor_custo, valor_venda;
                    int id = 0;

                    Lanche lanche = new Lanche();
                    LancheDAO lancheDAO = new LancheDAO();
                    Lanche lancheId = new Lanche();
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
                                System.out.println("----REGISTRAR----");
                                System.out.print("[NOME]        | ");
                                aux = sc.nextLine();
                                nome = sc.nextLine();
                                System.out.print("[VALOR CUSTO] | ");
                                valor_custo = sc.nextDouble();
                                System.out.print("[VALOR VENDA] | ");
                                valor_venda = sc.nextDouble();
                                System.out.print("[DESCRICAO]   | ");
                                aux = sc.nextLine();
                                descricao = sc.nextLine();
                                lanche.setNome(nome);
                                lanche.setValor_custo(valor_custo);
                                lanche.setValor_venda(valor_venda);
                                lanche.setDescricao(descricao);
                                lancheDAO.create(lanche);
                                break;
                            case 2:
                                System.out.println("--------LANCHES--------");
                                for (Lanche l : lancheDAO.read()) {
                                    l.dados(l);
                                    System.out.println("-----------------------");
                                }
                                break;
                            case 3:
                                System.out.println("-----ATUALIZAR-----");
                                System.out.print("[ID]          | ");
                                id = sc.nextInt();
                                System.out.print("[NOME]        | ");
                                aux = sc.nextLine();
                                nome = sc.nextLine();
                                System.out.print("[VALOR CUSTO] | ");
                                valor_custo = sc.nextDouble();
                                System.out.print("[VALOR VENDA] | ");
                                valor_venda = sc.nextDouble();
                                System.out.print("[DESCRICAO]   | ");
                                aux = sc.nextLine();
                                descricao = sc.nextLine();
                                lanche.setId(id);
                                lanche.setNome(nome);
                                lanche.setValor_custo(valor_custo);
                                lanche.setValor_venda(valor_venda);
                                lanche.setDescricao(descricao);
                                lancheDAO.update(lanche);
                                break;
                            case 4:
                                System.out.println("-----DELETAR-----");
                                System.out.print("Informe o ID: ");
                                id = sc.nextInt();
                                for (Lanche lId : lancheDAO.read()) {
                                    if (lId.getId() == id) {
                                        lancheId = lId;
                                        break;
                                    }
                                }
                                System.out.println("-------LANCHE-------");
                                lancheId.dados(lancheId);
                                System.out.println("--------------------");
                                System.out.println("Deseja excluir esse LANCHE? S/N");
                                resposta = sc.next();
                                resposta.toLowerCase();
                                if (resposta.equals("s")) {
                                    lancheDAO.delete(id);
                                }
                                break;
                        }
                    } while (opcao != 9);
                    break;
                case 2:
                    System.out.println("bebidas");
                    break;
            }


        } while (opcao != 9);
    }
}
