
package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Esame;
import it.polito.tdp.libretto.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
	
	Model model;

   

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCodice;

    @FXML
    private TextField txtDocente;

    @FXML
    private TextField txtTitolo;

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleCerca(ActionEvent event) {
    	String codice= txtCodice.getText();
    	if(codice.length()<5){
    		txtResult.appendText("Codice corso non valido\n");
    		return;
    	}
    	Esame e= model.trovaEsame(codice);
    	
    	if(e==null){
    		txtResult.appendText("Codice "+codice+" non trovato\n");
    	}
    	else{
    		txtResult.appendText("Codice "+codice+"trovato\n");
    		txtCodice.setText(e.getCodice());
    		txtCodice.setText(e.getTitolo());
    		txtCodice.setText(e.getDocente());
    	}

    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	//recupera i dati dalla vista
    	String codice=txtCodice.getText();
    	String titolo=txtTitolo.getText();
    	String docente=txtDocente.getText();
    	
    	//verifica validita' dati
    	if(codice.length()<5 || titolo.length()==0 || docente.length()==0){
    		txtResult.appendText("Dati esame insufficienti\n");
    		return;
    		//mi fermo: non posso andare avanti perche' mi mancano i dati
    	}
    	
    	//chiedi al model di effettuare operazione
    	Esame e= new Esame(codice,titolo,docente);
    	boolean result=model.addEsame(e);
    	
    	//aggiorna la vista con il risultato dell'operazione
    	if(result){
    		txtResult.appendText("Esame aggiunto correttamente");
    	}
    	else{
    		txtResult.appendText("Esame NON AGGIUNTO (codice duplicato)\n");
    	}

    }

    @FXML
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Libretto.fxml'.";

    }
    
    /**
   	 * @param model the model to set
   	 */
   	public void setModel(Model model) {
   		this.model = model;
   	}

	
    
    
}

