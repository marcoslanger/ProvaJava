package br.com.prova.marcos.testes;
import org.junit.jupiter.api.Test;

import br.com.prova.marcos.localizador.LocalizarVogal;

/**
 * Classe para testes da classe localizar vogal.
 * @author Marcos
 *
 */
class LocalizarVogalTeste {

	@Test
	void testLocalizarVogal() {		
		
		String teste1= "aAbBABacafe";
		String teste2 = "BcCaaAeuIdcuFoXXGHe";
		String teste3= "cccAdeefiffCCuuOEeaf";
		String teste4 = "BBCxaeeEEiiOOUEeeebBffGGG";	
		String teste5 = "HPoiYa";
		String teste6 = "wqUYIIOiieeaaLLKjjghPNVFwelukoaaIAAOeeBBEEKÇPe";
		String teste7 = "";
		
		System.out.println("Deve retornar a letra e:  " + LocalizarVogal.localizar(teste1));		
		
		System.out.println("Deve retornar a letra o:  " + LocalizarVogal.localizar(teste2));		
		
		System.out.println("Deve retornar a letra i:  " + LocalizarVogal.localizar(teste3));		
		
		System.out.println(LocalizarVogal.localizar(teste4));
		
		System.out.println("Deve retornar a letra a:  " + LocalizarVogal.localizar(teste5));
		
		System.out.println("Deve retornar a letra u:  " + LocalizarVogal.localizar(teste6));
		
		System.out.println(LocalizarVogal.localizar(teste7));
	}

}
