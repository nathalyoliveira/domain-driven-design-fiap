package br.com.fiap.jogo;

public abstract class Jogador extends ElementoVisual{

	private String nome = "Anonimo";
	private int xpIni;
	private int xp;
	private int hp;
	private boolean envenenado;
	private boolean derrotado;
	private boolean emCombate;
	
	public Jogador() {
	}
	
	public Jogador(String nome) {
		this.nome = nome;
		System.out.println("Criando jogador chamado " + nome);
	}
	
	public int getXpIni() {
		return xpIni;
	}
	
	public int getXp() {
		return xp;
	}
	
	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public String getNome() {
		return nome;
	}
	
	public boolean isEnvenenado() {
		return envenenado;
	}
	
	public boolean isDerrotado() {
		return derrotado;
	}
	
	public boolean isEmCombate() {
		return emCombate;
	}

	public void setEmCombate(boolean emCombate) {
		this.emCombate = emCombate;
	}
	
	public void receberDano(int pontos) {
		this.hp -= pontos;
		if(this.hp<=0) {
			System.out.println("Game Over " + nome);
			this.hp = 0;
			derrotado = true;
		}
			
	}
	
	public void receberCura(int pontos) {
		this.hp += pontos;
	}
	
	public void ganharExperiencia(int pontos) {
		this.xp += pontos;
	}
	
	public void receberAntidoto() {
		this.envenenado = !this.envenenado;
	}
	
	public void atacar(Jogador jogador, int xpInicial) {
		jogador.receberDano(xp);
		if(jogador.isDerrotado())
			xp = getXp() + xpInicial;
	}
	
	public void emCombate() {
		this.emCombate = !this.emCombate;
		this.xpIni = this.xp;
	}
	
	public boolean souJogador(String nome) {
		return nome.toLowerCase().equals(this.nome.toLowerCase());
	}
	
	public abstract void mover();
}
