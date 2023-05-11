package br.com.fiap.jogo;

public class Mago extends Jogador{
	
	private int mp;
	
	public Mago() {}
	
	public Mago(String nome) {
		super(nome);
	}
	
	public Mago(int mp) {
		this.mp = mp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	@Override
	public void mover() {
		
	}

}
