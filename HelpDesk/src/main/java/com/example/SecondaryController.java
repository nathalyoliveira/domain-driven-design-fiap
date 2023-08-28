package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondaryController implements Initializable{

    @FXML TextField txtUsuario;
    @FXML TextField txtCodEquipamento;
    @FXML ListView<Chamado> lista;

    @FXML RadioButton optComputador;
    @FXML RadioButton optImpressora;
    @FXML RadioButton optRede;

    @FXML CheckBox cbContato;
    @FXML CheckBox cbAtendido;
    @FXML CheckBox cbEncerrado;


    private int seqChamado;
    ArrayList<Chamado> chamados = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setaChamado(Chamado chamado, ArrayList<Chamado> chamados){

        seqChamado = chamado.seqChamado();
        this.chamados = chamados;

        txtUsuario.setText(chamado.nome());
        txtCodEquipamento.setText(chamado.codEquipamento());

        if(optComputador.getText().equals(chamado.categoria()))
            optComputador.setSelected(true);

        if(optImpressora.getText().equals(chamado.categoria()))
            optImpressora.setSelected(true);

        if(optRede.getText().equals(chamado.categoria()))
            optRede.setSelected(true);

        if(chamado.atividades().contains(cbContato.getText()))
            cbContato.setSelected(true);
            
        if(chamado.atividades().contains(cbAtendido.getText()))
            cbAtendido.setSelected(true);

        if(chamado.atividades().contains(cbEncerrado.getText()))
            cbEncerrado.setSelected(true);
    }


    public void alteraChamado() throws IOException{

        
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
            seqChamado,
            txtUsuario.getText(),
            txtCodEquipamento.getText(),
            categoria,
            atividades
        );

        chamados.set(seqChamado, chamado);

        retornaParaTelaInicial();
        
    }

    public void retornaParaTelaInicial() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        PrimaryController priController = fxmlLoader.getController();
        priController.recebeChamadoEditado(chamados);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}