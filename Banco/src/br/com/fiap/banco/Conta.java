package br.com.fiap.banco;

public class Conta extends Object{ //Generalização

	private String numero;
	private double saldo;
	
	public Conta(String numero) {
		this.numero = numero;
	}
	
	public void depositar(double valor) throws ValorNegativoException{
		if(valor < 0 )
			throw new TransacaoException("O depósito não pôde ser realizado pois o valor informado é menor que zero.");
//			throw new ValorNegativoException("O depósito não pôde ser realizado pois o valor informado é menor que zero.");
		saldo += valor;
	}
	
	public void sacar(double valor) throws ValorMaiorQueSaldoException{
		if(valor > saldo)
			throw new TransacaoException("O saque não pôde ser realizado pois o valor informado é maior que o saldo.");
//			throw new ValorMaiorQueSaldoException("O saque não pôde ser realizado pois o valor informado é maior que o saldo.");
		saldo -= valor;
	}
	
	public void transferir(double valor, Conta conta) throws TransacaoException /*ValorNegativoException, ValorMaiorQueSaldoException, TransferenciaTitularesIguaisException*/{
		if(valor > saldo)
			throw new TransacaoException("A transferência não pôde ser realizada pois o valor informado é menor que zero.");
//			throw new ValorNegativoException("A transferência não pôde ser realizada pois o valor informado é menor que zero.");
		if(valor > saldo)
			throw new TransacaoException("A transferência não pôde ser realizada pois o valor informado é maior que o saldo.");
//			throw new ValorMaiorQueSaldoException("A transferência não pôde ser realizada pois o valor informado é maior que o saldo.");
		if (conta.numero == this.numero)
			throw new TransacaoException("A transferência não pôde ser realizada pois os titulares são os mesmos.");
//			throw new TransferenciaTitularesIguaisException("A transferência não pôde ser realizada pois os titulares são os mesmos.");
			
		conta.depositar(valor);
		saldo -= valor;
	}

	public String getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	
}
