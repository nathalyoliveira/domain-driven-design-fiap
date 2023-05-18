package br.com.fiap.banco;

public class TransacaoException extends RuntimeException{
	
	TransacaoException(String mensagem){
		super(mensagem);
	}

}
