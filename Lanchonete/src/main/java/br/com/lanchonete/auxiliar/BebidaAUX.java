package br.com.lanchonete.auxiliar;

import br.com.lanchonete.dao.BebidaDAO;
import br.com.lanchonete.model.Bebida;

import java.util.Scanner;

public class BebidaAUX {
    private static String marca, respostaB = "", litragem = "";
    private static Scanner sc = new Scanner(System.in);
    private static double preco_custo, preco_venda;
    private static int id = 0;
    private static Bebida bebidaId = new Bebida();
    private static Bebida bebida = new Bebida();
    private static BebidaDAO bebidaDao = new BebidaDAO();

    public static void registra() {
        System.out.println("----REGISTRAR----");
        System.out.print("[MARCA]       | ");
        marca = sc.nextLine();
        if (marca.equals("")) {
            marca = sc.nextLine();
        }
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
    }

    public static void mostra() {
        System.out.println("--------BEBIDAS--------");
        for (Bebida b : bebidaDao.read()) {
            b.dados(b);
            System.out.println("-----------------------");
        }
    }

    public static void atualiza() {
        System.out.println("-----ATUALIZAR-----");
        System.out.print("[ID]          | ");
        id = sc.nextInt();
        System.out.print("[MARCA]       | ");
        sc.nextLine();
        marca = sc.nextLine();
        System.out.print("[LITRAGEM]    | ");
        litragem = sc.next();
        System.out.print("[VALOR CUSTO] | ");
        preco_custo = sc.nextDouble();
        System.out.print("[VALOR VENDA] | ");
        preco_venda = sc.nextDouble();
        bebida.setId(id);
        bebida.setMarca(marca);
        bebida.setLitro(litragem);
        bebida.setPreco_custo(preco_custo);
        bebida.setPreco_venda(preco_venda);
        bebidaDao.update(bebida);
    }

    public static void deleta() {
        System.out.println("-----DELETAR-----");
        System.out.print("Informe o ID: ");
        id = sc.nextInt();
        for (Bebida bId : bebidaDao.read()) {
            if (bId.getId() == id) {
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
            bebidaDao.delete(id);
        }
    }
}
