package br.com.lanchonete.auxiliar;

import br.com.lanchonete.dao.LancheDAO;
import br.com.lanchonete.model.Lanche;

import java.sql.SQLException;
import java.util.Scanner;

public class LancheAUX {
    private static Lanche lanche = new Lanche();
    private static LancheDAO lancheDAO = new LancheDAO();
    private static Scanner sc = new Scanner(System.in);
    private static int id = 0;
    private static String nome, descricao, resposta = "";
    private static double valor_custo, valor_venda;

    public static void registra() {
        System.out.println("----REGISTRAR----");
        System.out.print("[NOME]        | ");
        nome = sc.nextLine();
        System.out.print("[VALOR CUSTO] | ");
        valor_custo = sc.nextDouble();
        System.out.print("[VALOR VENDA] | ");
        valor_venda = sc.nextDouble();
        System.out.print("[DESCRICAO]   | ");
        sc.nextLine();
        descricao = sc.nextLine();
        lanche.setNome(nome);
        lanche.setValor_custo(valor_custo);
        lanche.setValor_venda(valor_venda);
        lanche.setDescricao(descricao);
        lancheDAO.create(lanche);
    }

    public static void mostra() {
        System.out.println("--------LANCHES--------");
        for (Lanche l : lancheDAO.read()) {
            l.dados(l);
            System.out.println("-----------------------");
        }
    }

    public static void atualiza() {
        System.out.println("-----ATUALIZAR-----");
        System.out.print("[ID]          | ");
        id = sc.nextInt();
        System.out.print("[NOME]        | ");
        sc.nextLine();
        nome = sc.nextLine();
        System.out.print("[VALOR CUSTO] | ");
        valor_custo = sc.nextDouble();
        System.out.print("[VALOR VENDA] | ");
        valor_venda = sc.nextDouble();
        System.out.print("[DESCRICAO]   | ");
        sc.nextLine();
        descricao = sc.nextLine();
        lanche.setId(id);
        lanche.setNome(nome);
        lanche.setValor_custo(valor_custo);
        lanche.setValor_venda(valor_venda);
        lanche.setDescricao(descricao);
        lancheDAO.update(lanche);
    }

    public static void deleta() throws SQLException {
        Lanche lancheId = new Lanche();
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
    }

}
