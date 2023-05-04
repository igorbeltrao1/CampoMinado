package br.com.igor.cm.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.igor.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel{
	
	 public PainelTabuleiro (Tabuleiro tabuleiro){
		 setLayout(new GridLayout(
				 tabuleiro.getLinhas(), tabuleiro.getColunas()));
		 
		 tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
	 
		 tabuleiro.registraObservador(e -> {
			 SwingUtilities.invokeLater(() -> {

				 if(e.isGanhou()) {
					 JOptionPane.showMessageDialog(this, "Ganhou");
				 }else {
					 JOptionPane.showMessageDialog(this, "Perdeu. Tente novamente! :(");
				 }	 
			
			 tabuleiro.reiniciar();
			 
			 });
			
		 });
	 
	 }

}
