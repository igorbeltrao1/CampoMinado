package br.com.igor.cm.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.igor.cm.excessao.ExplosaoException;

public class CampoTeste {

	private Campo campo;
	
	@BeforeEach 
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}
	
	@Test
	void teseVizinhoDistancia1() {
	Campo vizinho = new Campo(3, 2);
	
	boolean reultado = campo.adicionarVizinho(vizinho);
	
	assertTrue(reultado);
	}
	@Test
	void teseVizinhoDistancia1Direita() {
	Campo vizinho = new Campo(3, 4);
	
	boolean reultado = campo.adicionarVizinho(vizinho);
	
	assertTrue(reultado);
	}
	@Test
	void teseVizinhoDistancia1Esquera() {
	Campo vizinho = new Campo(3, 2);
	
	boolean reultado = campo.adicionarVizinho(vizinho);
	
	assertTrue(reultado);
	}
	@Test
	void teseVizinhoDistancia1EmCima() {
	Campo vizinho = new Campo(4, 3);
	
	boolean reultado = campo.adicionarVizinho(vizinho);
	
	assertTrue(reultado);

	}
 
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
		
	}

	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
		
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
		
	}

	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
		 
	}
	@Test
	void testeAbrir() {
		assertTrue(campo.abrir());
		 
	}
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}

	@Test
	void testeAbrirComVizinhos() {
		Campo campo11 = new Campo(1, 1);
		Campo campo22 = new Campo(2, 2);
	
		campo22.adicionarVizinho(campo11);	
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	
	@Test
	void testeAbrirComVizinhos2() {
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,1);
		campo12.minar();
		
		Campo campo22 = new Campo(2, 2);
		
		campo22.adicionarVizinho(campo11);	
		campo22.adicionarVizinho(campo12);	
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}
	 

 



}







