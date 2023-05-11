package br.com.fiap.jogo;

public class Jogador {

	private String nome;
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
		this.xp = getXp() - pontos;
		if(getXp()<=0) {
			System.out.println("Game Over " + nome);
			derrotado = true;
		}
			
	}
	
	public void receberCura(int pontos) {
		this.xp = getXp() + pontos;
	}
	
	public void ganharExperiencia(int pontos) {
		this.hp = getHp() + pontos;
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
}
