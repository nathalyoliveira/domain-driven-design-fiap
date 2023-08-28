package com.example;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PrimaryController {
    
    @FXML TextField txtUsuario;
    @FXML TextField txtCodEquipamento;
    @FXML ListView<Chamado> lista;

    @FXML RadioButton optComputador;
    @FXML RadioButton optImpressora;
    @FXML RadioButton optRede;

    @FXML CheckBox cbContato;
    @FXML CheckBox cbAtendido;
    @FXML CheckBox cbEncerrado;

    private int contador = 0;

    ArrayList<Chamado> chamados = new ArrayList<>();

    public void adicionarChamado(){

        contador = chamados.size() > 0 ? chamados.size() : 0;
        
        String categoria = "";

        if(optComputador.isSelected())
            categoria = optComputador.getText();
            
        if(optImpressora.isSelected())
            categoria = optImpressora.getText();

        if(optRede.isSelected())
            categoria = optRede.getText();


        ArrayList<String> atividades = new ArrayList<String>();

        if(cbContato.isSelected())
            atividades.add(cbContato.getText());
            
        if(cbAtendido.isSelected())
            atividades.add(cbAtendido.getText());

        if(cbEncerrado.isSelected())
            atividades.add(cbEncerrado.getText());

        var chamado = new Chamado(
            contador,
            txtUsuario.getText(),
            txtCodEquipamento.getText(),
            categoria,
            atividades
        );

        chamados.add(chamado);

        txtUsuario.clear();
        txtCodEquipamento.clear();
        optComputador.disarm();
        optImpressora.disarm();
        optRede.disarm();
        cbContato.disarm();
        cbAtendido.disarm();
        cbEncerrado.disarm();

        atualizarTela();
    }

    public void atualizarTela(){
        ordenar();
        lista.getItems().clear();

        for (var chamado: chamados){
            lista.getItems().add(chamado);
        }
    }

    private void ordenar(){
        chamados.sort( (o1, o2) -> o1.seqChamado() - o2.seqChamado() );
    }

    public void apagar(){
        var chamado = lista.getSelectionModel().getSelectedItem();
        chamados.remove(chamado);
        atualizarTela();

        Alert mensagem = new Alert(AlertType.INFORMATION);
        mensagem.setTitle("Aviso");
        mensagem.setHeaderText("Sucesso");
        mensagem.setContentText("Chamado Apagado com Sucesso");
        mensagem.show();
    }

    public void alterar() throws IOException{
        var chamado = lista.getSelectionModel().getSelectedItem();
       
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        SecondaryController secController = fxmlLoader.getController();
        secController.setaChamado(chamado, chamados);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void recebeChamadoEditado(ArrayList<Chamado> chamados){
        this.chamados = chamados;
        atualizarTela();
    }
}

