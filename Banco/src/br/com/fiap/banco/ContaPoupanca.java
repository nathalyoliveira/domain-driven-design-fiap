package br.com.fiap.banco;

public class ContaPoupanca extends Conta{
	
	private double taxa;
	
	public ContaPoupanca(String numero) {
		super(numero);
	}

	public double getTaxa() {
		return taxa;
	}

	@Override
	public void sacar(double valor) throws TransacaoException /*ValorMaiorQueSaldoException*/ {
		throw new TransacaoException("Não é possível realizar saques em uma conta poupança.");
//		throw new SaquePoupancaException("Não é possível realizar saques em uma conta poupança.");
	}
	
	

}
