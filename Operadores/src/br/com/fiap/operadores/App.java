package br.com.fiap.operadores;

import javax.swing.JOptionPane;

public class App {
	
	public static double media(int a, int b) {
		return (a + b) / 2;
	}
	
	public static double areaTriangulo(double base, double altura) {
		return (base*altura)/2;
	}
	
	public static double imc(double altura, double peso) {
		return peso/(altura*altura);
	}
	
	public static String parOuImpar(int num) {
		if(num % 2 == 0) 
			return "Par";
		return "Ímpar";
	}
	
	public static void main(String[] args) {
		String menu = JOptionPane.showInputDialog("Menu \n1 - Média \n2 - Área do triângulo \n3 - Cálculo do IMC \n4 - Par ou ímpar");
		int acao = Integer.valueOf(menu);
		
		switch(acao) {
		case 1:
			int n1 = Integer.valueOf(JOptionPane.showInputDialog("Digite o primeiro número: "));
			int n2 = Integer.valueOf(JOptionPane.showInputDialog("Digite o segundo número: "));
			JOptionPane.showMessageDialog(null, media(n1,n2), "Média Aritmética", JOptionPane.INFORMATION_MESSAGE);	
			break;
			
		case 2:
			double base = Double.parseDouble(JOptionPane.showInputDialog("Digite a base do triângulo: "));
			double alturaTgl = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura do triângulo: "));
			JOptionPane.showMessageDialog(null, areaTriangulo(base, alturaTgl), "Área do Triângulo Isóscele", JOptionPane.INFORMATION_MESSAGE);	
			break;
			
		case 3:
			double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura: "));
			double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso: "));
			JOptionPane.showMessageDialog(null, imc(altura, peso), "Área do Triângulo Isóscele", JOptionPane.INFORMATION_MESSAGE);
			break;
			
		case 4:
			int num = Integer.valueOf(JOptionPane.showInputDialog("Digite um número: "));
			JOptionPane.showMessageDialog(null, parOuImpar(num), "Área do Triângulo Isóscele", JOptionPane.INFORMATION_MESSAGE);
			break;
			
		}
	}
}
