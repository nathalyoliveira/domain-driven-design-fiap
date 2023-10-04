package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable {

    @FXML
    Pagination pagination;

    private int pagina = 1;

    public FlowPane carregar() {

        try {
            // var url = new URL("https://rickandmortyapi.com/api/character?page=" +
            // pagina);
            // var url = new
            // URL("https://dattebayo-api.onrender.com/characters?&limit=9&page=" + pagina);
            var url = new URL("https://cs2-api.vercel.app/api/search?&q=paris&page=" + pagina);
            var con = url.openConnection();
            con.connect();
            var is = con.getInputStream();

            var reader = new BufferedReader(new InputStreamReader(is));
            var json = reader.readLine();

            var lista = jsonParaLista(json);

            return mostrarPersonagens(lista);

        } catch (IOException e) {
            e.printStackTrace();
            mostrarMensagem("Erro. " + e.getMessage());
        }

        return null;

    }

    private FlowPane mostrarPersonagens(List<Collectible> lista) {
        var flow = new FlowPane();
        flow.setVgap(20);
        flow.setHgap(20);

        lista.forEach(itemColecao -> {
            var image = new ImageView(new Image(itemColecao.getImage()));
            image.setFitHeight(150);
            image.setFitWidth(150);
            var labelName = new Label(itemColecao.getName());
            flow.getChildren().add(new VBox(image, labelName));
        });
        return flow;
    }

    private List<Collectible> jsonParaLista(String json) throws JsonMappingException, JsonProcessingException {
        var mapper = new ObjectMapper();
        var data = mapper.readTree(json).get("data");
        // System.out.println("-----------------------" + characters +
        // "-------------------");
        List<Collectible> lista = new ArrayList<>();

        data.forEach(d -> {
            try {
                lista.add(mapper.readValue(d.toString(), Collectible.class));
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        return lista;
    }

    private void mostrarMensagem(String mensagem) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText(mensagem);
        alert.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        pagination.setPageFactory(pag -> {
            pagina = pag + 1;
            return carregar();
        });
    }

}
