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
                    opcao = 0;
                    break;
                case 2:
                    String marca, auxB, respostaB = "", litragem = "";
                    double preco_custo, preco_venda;
                    int idB = 0;
                    Bebida bebidaId = new Bebida();
                    Bebida bebida = new Bebida();
                    BebidaDAO bebidaDao = new BebidaDAO();

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
                                System.out.println("----REGISTRAR----");
                                System.out.print("[MARCA]       | ");
                                auxB = sc.nextLine();
                                marca = sc.nextLine();
                                System.out.print("[LITRAGEM]    | ");
                                litragem = sc.next();
                                System.out.print("[VALOR CUSTO] | ");
                                preco_custo = sc.nextDouble();
                                System.out.print("[VALOR VENDA] | ");
                                preco_venda = sc.nextDouble();

                                bebida.setMarca(marca);
                                bebida.setLitro(litragem);
                                bebida.setPreco_custo(preco_custo);
                                bebida.setPreco_venda(preco_venda);
                                bebidaDao.create(bebida);
                                break;
                            case 2:
                                System.out.println("--------BEBIDAS--------");
                                for (Bebida b : bebidaDao.read()) {
                                    b.dados(b);
                                    System.out.println("-----------------------");
                                }
                                break;
                            case 3:
                                System.out.println("-----ATUALIZAR-----");
                                System.out.print("[ID]          | ");
                                idB = sc.nextInt();
                                System.out.print("[MARCA]       | ");
                                auxB = sc.nextLine();
                                marca = sc.nextLine();
                                System.out.print("[LITRAGEM]    | ");
                                litragem = sc.next();
                                System.out.print("[VALOR CUSTO] | ");
                                preco_custo = sc.nextDouble();
                                System.out.print("[VALOR VENDA] | ");
                                preco_venda = sc.nextDouble();

                                bebida.setId(idB);
                                bebida.setMarca(marca);
                                bebida.setLitro(litragem);
                                bebida.setPreco_custo(preco_custo);
                                bebida.setPreco_venda(preco_venda);
                                bebidaDao.update(bebida);
                                break;
                            case 4:
                                System.out.println("-----DELETAR-----");
                                System.out.print("Informe o ID: ");
                                idB = sc.nextInt();
                                for (Bebida bId : bebidaDao.read()) {
                                    if (bId.getId() == idB) {
                                        bebidaId = bId;
                                        break;
                                    }
                                }
                                System.out.println("-------BEBIDA-------");
                                bebidaId.dados(bebidaId);
                                System.out.println("--------------------");
                                System.out.println("Deseja excluir essa BEBIDA? S/N");
                                respostaB = sc.next();
                                respostaB.toLowerCase();
                                if (respostaB.equals("s")) {
                                    bebidaDao.delete(idB);
                                }
                                break;
                        }
                    } while (opcao != 9);
                    opcao = 0;
                    break;
            }
        } while (opcao != 9);
    }
}
