package br.com.igor.cm;

import br.com.igor.cm.modelo.Tabuleiro;
import br.com.igor.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		new TabuleiroConsole(tabuleiro);
		
		
		
	}
}
