package br.com.fiap.banco;

public class ValorMaiorQueSaldoException extends RuntimeException{
	
	ValorMaiorQueSaldoException(String mensagem){
		super(mensagem);
	}

}
