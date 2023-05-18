package br.com.fiap.banco;

public class ValorNegativoException extends RuntimeException{
	
	ValorNegativoException(String mensagem){
		super(mensagem);
	}

}
