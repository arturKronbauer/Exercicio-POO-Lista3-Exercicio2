package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Produto> list = new ArrayList<>();
		
		System.out.print("Entre com o número de produtos: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println();
			System.out.println("Dados do produto #" + i + ":");
			System.out.print("Comum, usado, importado (c/u/i)? ");
			char tipo = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			if (tipo == 'c') {
				list.add(new Produto(nome, preco));
			}
			else if (tipo == 'u') {
				System.out.print("Data de fabricacao (DD/MM/YYYY): ");
				LocalDate data = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new ProdutoUsado(nome, preco, data));
			}
			else {
				System.out.print("Taxa de importação: ");
				double taxa = sc.nextDouble();
				list.add(new ProdutoImportado(nome, preco, taxa));
			}
		}

		System.out.println();
		System.out.println("ETIQUETAS DE PREÇO:");
		for (Produto prod : list) {
			System.out.println(prod.etiqueta());
		}
		sc.close();
	}
}
