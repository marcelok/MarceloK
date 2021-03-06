package br.unerj.poo.jogos;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JogoTests {
	
	Jogo jogo;                
	Jogador j1, j2;

	@Before
	public void setUp() throws Exception {
		jogo = new JogoDaVelha();
		j1 = jogo.getJogadores(0);
		j2 = jogo.getJogadores(1);
	}
	@After
	public void tearDown() throws Exception {
		jogo = null;
		j1 = null;
		j2 = null;
	}            

	@Test
	public void testJogaUmDeCadaVez() {
		Assert.assertEquals(j1, jogo.getProximoJogador());
		Assert.assertTrue(jogo.jogar(0, 0));
		Assert.assertEquals(j2, jogo.getProximoJogador());
		Assert.assertTrue(jogo.jogar(1, 1));
		Assert.assertEquals(j1, jogo.getProximoJogador());
	}   
	
	@Test
	public void testNaoPodeJogarEmUmaCasaOcupada() {
		Assert.assertNull(jogo.getPeca(0,0));
		Assert.assertTrue(jogo.jogar(0,0));
		Assert.assertNotNull(jogo.getPeca(0,0));
		Assert.assertFalse(jogo.jogar(0,0));
	}
 
}
