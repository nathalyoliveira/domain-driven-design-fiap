package br.com.fiap.welcome;

import javax.swing.JOptionPane;

public class App {

	public static void main(String[] args) {

		String nome = JOptionPane.showInputDialog("Digite seu nome: ");
		String email = JOptionPane.showInputDialog("Digite seu email: ");
		int idade = Integer.valueOf(JOptionPane.showInputDialog("Digite sua idade: "));
		
		var usuario = new Usuario(nome, email, idade);
		
		JOptionPane.showMessageDialog(null, usuario.retornaDados(), "Bem Vindo!", JOptionPane.INFORMATION_MESSAGE);	
	}

}
