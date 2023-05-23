package br.com.fiap.escola;

import java.util.List;

public class Turma {
	
	public String situacaoTurma(List<String> situacoes){
		Double aprovados = new Double(0);
		Double reprovados = new Double(0);
		Double total = new Double(0);
		for(String situacao : situacoes){
			if(situacao.equals("APROVADO")){
				aprovados += 1;
			}else if(situacao.equals("REPROVADO")){
				reprovados += 1;
			}	
		}
		total = aprovados + reprovados;
		
		return aprovados + "alunos foram aprovados [" + (aprovados/total)*100 + "%] e " + reprovados + " foram reprovados [" + (reprovados/total)*100 + "%]";
		
	}
	
	public String horarios(String dia){
		
		/*
		 a - segunda
		 b - terça
		 c - quarta
		 d - quinta
		 e - sexta
		*/
		
		if (dia.equals("a"))
			return "As aulas do dia são AI & CHATBOT e BUILDING RELATIONAL DATABASE";
		
		if (dia.equals("b"))
			return "As aulas do dia são DOMAIN DRIVEN DESIGN e COMPUTATIONAL THINKING USING PYTHON";
		
		if (dia.equals("c"))
			return "As aulas do dia são COMPUTATIONAL THINKING USING PYTHON e RESPONSIVE WEB DEVELOPMENT";
		
		if (dia.equals("d"))
			return "As aulas do dia são DOMAIN DRIVEN DESIGN e SOFTWARE DESIGN & TOTAL EXPERIENCE";
		
		if (dia.equals("e"))
			return "As aulas do dia são SOFTWARE DESIGN & TOTAL EXPERIENCE e RESPONSIVE WEB DEVELOPMENT";
		
		return "";
	}

}
