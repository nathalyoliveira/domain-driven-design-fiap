package br.com.fiap.escola;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
	
	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
		Aluno aluno = new Aluno(nome);
		
		Double n1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a primeira nota: "));
		Double n2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a segunda nota: "));
		Double n3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a terceira nota: "));
		
		Double nota;
		String situacao = "";
		
		//	Exerc�cio 1
		nota = aluno.calculaMedia(n1,n2,n3);
		JOptionPane.showMessageDialog(null, nota, "M�dia Aritm�tica", JOptionPane.INFORMATION_MESSAGE);	
		
		// Exerc�cio 2
		nota = aluno.calculaMediaCheckpoint(n1,n2,n3);
		JOptionPane.showMessageDialog(null, nota, "M�dia Checkpoint", JOptionPane.INFORMATION_MESSAGE);
		
		// Exerc�cio 3
		situacao = aluno.statusAluno(nota);
		JOptionPane.showMessageDialog(null, situacao, "Situa��o aluno", JOptionPane.INFORMATION_MESSAGE);
		
		
		// Exerc�cio 4
		List<Double> notas = new ArrayList<Double>();
		String nomeAluno2 = JOptionPane.showInputDialog("Digite o nome do aluno: ");
		int i = 0;
		while (i >= 0){
			Double notaLista = Double.parseDouble(JOptionPane.showInputDialog("Digite uma nota ou um n�mero negativo para finalizar "));
			
			if(notaLista >= 0) 
				notas.add(notaLista);
				
			i = (int) Math.round(notaLista);
		}
		Aluno aluno2 = new Aluno(nomeAluno2);
		Double media = aluno2.calculaMedia(notas);
		
		JOptionPane.showMessageDialog(null, media, "M�dia aritm�tica do aluno " + nomeAluno2, JOptionPane.INFORMATION_MESSAGE);
		
		
		// Exerc�cio 5
		Double frequencia = Double.parseDouble(JOptionPane.showInputDialog("Digite a frequ�ncia do aluno " + aluno2.getNome()));
		situacao = aluno2.statusAluno(media, frequencia);
		JOptionPane.showMessageDialog(null, situacao, "Situa��o do aluno " + aluno2.getNome(), JOptionPane.INFORMATION_MESSAGE);
		
		
		// Exerc�cio 6
		Double aulas = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de aulas"));
		Double faltas = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de faltas"));
		Double frequencia2 = aluno2.frequenciaAluno(aulas, faltas);
		JOptionPane.showMessageDialog(null, frequencia2 + "%", "Frequ�ncia do aluno " + aluno2.getNome(), JOptionPane.INFORMATION_MESSAGE);
		
		// Exerc�cio 7
		List<String> situacoes = new ArrayList<String>();
		String j = "APROVADO";
		while (j.equals("APROVADO") || j.equals("REPROVADO")){
			String situacaoLista = JOptionPane.showInputDialog("Digite a situa��o do aluno: ");
			situacoes.add(situacaoLista);
			j = situacaoLista;
		}
		Turma turma = new Turma();
		JOptionPane.showMessageDialog(null, turma.situacaoTurma(situacoes), "Status da turma ", JOptionPane.INFORMATION_MESSAGE);
		
		// Exerc�cio 8
		String dia = JOptionPane.showInputDialog("Escolha uma op��o: "
				+ "\n a - segunda"
				+ "\n b - terca"
				+ "\n c - quarta"
				+ "\n d - quinta"
				+ "\n e - sexta");
		
		JOptionPane.showMessageDialog(null, turma.horarios(dia), "Aulas do dia ", JOptionPane.INFORMATION_MESSAGE);
		
		
	} 

}
