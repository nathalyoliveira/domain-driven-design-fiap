package br.com.fiap.welcome;

public class Usuario {
	
	private String nome;
	private String email;
	private int idade;
	
	public Usuario(String nome, String email, int idade) {
		super();
		this.nome = nome;
		this.email = email;
		this.idade = idade;
	}
	
	public String retornaDados() {
		String mensagem = "Nome: %s \nEmail: %s \nIdade: %d";
		return String.format(mensagem, nome,  email, idade);
	}

}
