package br.com.fiap.banco;

public class App {
	
	public static void main(String[] args) {
		
		try {
			Conta conta = new Conta("12345-5");
			conta.depositar(10);
//			conta.sacar(11);
//			conta.depositar((-1));
			
			ContaPoupanca poupanca = new ContaPoupanca("12345-5");
			poupanca.depositar(200);
			poupanca.getNumero();
//			poupanca.sacar(0);
		}catch(TransacaoException e) {
			System.out.println(e.getMessage());
		}
//		catch(ValorNegativoException e) {
//			System.out.println(e.getMessage());
//		}catch(ValorMaiorQueSaldoException e) {
//			System.out.println(e.getMessage());
//		}catch(TransferenciaTitularesIguaisException e) {
//			System.out.println(e.getMessage());
//		}catch(SaquePoupancaException e) {
//			System.out.println(e.getMessage());
//		}

	}

}
