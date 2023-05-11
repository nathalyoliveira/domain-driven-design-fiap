package br.com.fiap.jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in).useLocale(Locale.US);
		
		List<Jogador> inimigos = new ArrayList<Jogador>();
		
		System.out.println("Digite o nome do seu jogador: ");
		String nomeJogador = ler.next();
		
		var jogador = new Jogador(nomeJogador);
		jogador.ganharExperiencia(10);
		jogador.setXp(20);
		
		var inimigo1 = new Jogador("Ryu");
		inimigo1.ganharExperiencia(10);
		inimigo1.setXp(20);
		
		var inimigo2 = new Jogador("Aleck");
		inimigo2.ganharExperiencia(10);
		inimigo2.setXp(20);
		
		inimigos.add(inimigo1);
		inimigos.add(inimigo2);
			
		System.out.println("Selecione o inimigo que deseja atacar! \n" + inimigo1.getNome() + "\n" + inimigo2.getNome());
		String nomeInimigo = ler.next();
		
		inimigo1.emCombate();
		inimigo2.emCombate();
		jogador.emCombate();
		
		for(Jogador inimigo : inimigos) {
			if(inimigo.souJogador(nomeInimigo)) {
				jogador.atacar(inimigo, inimigo.getXpIni());
			}
		}
		
		System.out.println("Jogador " + jogador.getNome() + " você tem " + jogador.getHp() + " de HP e " + jogador.getXp() + " de XP");
		System.out.println("Inimigo " + inimigo1.getNome() + " tem " + inimigo1.getHp() + " de HP e " + inimigo1.getXp() + " de XP");
		System.out.println("Inimigo " + inimigo2.getNome() + " tem " + inimigo2.getHp() + " de HP e " + inimigo2.getXp() + " de XP");

	}

}
