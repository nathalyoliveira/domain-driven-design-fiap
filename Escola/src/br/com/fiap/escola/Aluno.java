package br.com.fiap.escola;

import java.util.List;

public class Aluno {
	
	private String nome;
	private List<Double> notas;
	
	public Aluno(){
		
	}
	
	public Aluno(String nome) {
		super();
		this.nome = nome;
	}
	
	public Aluno(String nome, List<Double> notas) {
		super();
		this.nome = nome;
		this.notas = notas;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Double> getNotas() {
		return notas;
	}
	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}
	
	public Double calculaMediaCheckpoint(Double n1, Double n2, Double n3){
		Double maior = new Double(0);
		Double meio = new Double(0);
		
		if(n1 > n2 && n1 > n3){
			maior = n1;
			if(n2 > n3){
				meio = n2;
			}else{
				meio = n3;
			}
		}
			
		else{
			if(n2 > n1 && n2 > n3){
				maior = n2;
				if(n1 > n3){
					meio = n1;
				}else{
					meio = n3;
				}
			}
				
			else {
				maior = n3;
				if(n1 > n2){
					meio = n1;
				}else{
					meio = n2;
				}
			}
		}
		return (maior + meio) / 2;
	}
	
	public Double calculaMedia(Double n1, Double n2, Double n3){
		return (n1 + n2 + n3)/ 3;
	}
	
	public Double calculaMedia(List<Double> notas){
		Double media = new Double(0);
		for( Double nota : notas){
			media = media + nota;
		}
		return media / notas.size();
	}
	
	public String statusAluno(Double nota){
		if(nota > 7 )
			return nome + " está aprovado!";
		return nome + " está retido!";
	}
	
	public String statusAluno(Double mediaFinal, Double frequencia){
		if(mediaFinal >= 7 && frequencia >= 75)
			return nome + " está aprovado!";
		return nome + " está reprovado!";
	}
	
	public double frequenciaAluno(Double aulas, Double faltas){
		Double presencas = aulas - faltas;
		double frequencia = presencas / aulas;
		return frequencia * 100;
	}

}
