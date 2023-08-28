package com.example;

import java.util.ArrayList;

public record Chamado (int seqChamado, String nome, String codEquipamento, String categoria, ArrayList<String> atividades) {

    @Override
    public String toString(){
        String atvs = "";
        for(String atv : atividades){
            atvs = atvs == "" ? atvs + atv : atvs + ", " + atv;
        }

        return "Chamado " + seqChamado + " Usuário: " + 
        nome + " Equipamento: " + codEquipamento + " Categoria: " + categoria + 
        " Atividades: " + atvs;
    }

}
