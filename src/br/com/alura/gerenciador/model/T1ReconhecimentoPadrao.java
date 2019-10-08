package br.com.alura.gerenciador.model;

import java.util.Scanner;

public class T1ReconhecimentoPadrao {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int linha = 0, coluna = 0, l = 0, c = 0;
		
		float porcao1 = 0.0f, porcao2 = 0.0f;
		
		do {// Do while usado para validar o tamanho de linhas e colunas da matriz
			System.out.println("Digite o numero de linhas da matriz  (A matriz deve conter pelo menos 3 linhas): ");
			l = scan.nextInt();
			linha = l;
		} while (l < 3);

		do {
			System.out.println("Digite o numero de colunas da matriz  (A matriz deve conter pelo menos 3 colunas): ");
			c = scan.nextInt();
			coluna = c;
		} while (c < 3);

		System.out.println("LInhas: " + linha + " Colunas: " + coluna);//Apagar isso

		float matriz[][] = new float[linha][coluna];

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {//For para percorrer e popular os campos da matriz
				float aux = 2f;
				do {
					System.out.println("Digite o valor da matriz[" + i + "][" + j + "] (O valor deve ser entre 0 e 1)");
					aux = scan.nextFloat();
					matriz[i][j] = (float) aux;
				} while (aux > 1 || aux < 0);
			}//Fim j
		}// Fim i

		/*for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {//For para imprimir a matriz
				System.out.print(matriz[i][j] + " ");
				if(j==matriz[i].length-1)//Quando for a última coluna da matriz pula uma linha
				System.out.println("");
			}//Fim j
		}//Fim i*/
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if((i-1)>=0 && (i+1)<matriz.length && (j-1)>=0 && (j+1)<matriz[i].length) {//Verifica se tem colunas e linhas ao redor para filtrar o calculo
					
				}
					
			}
		}
		
	}//Fim do main

}
