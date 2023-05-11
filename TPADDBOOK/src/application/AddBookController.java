package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddBookController implements Initializable {

    @FXML 
    private TextField tfNom; 
    @FXML 
    private TextField tfPrenom; 
    @FXML 
    private TextField tfEmail;
    @FXML 
    private TextField tfAge;
    @FXML 
    private Button ajouterBtn; 
    @FXML 
    private Button exporterBtn; 
    @FXML 
    private Button importerBtn; 
    @FXML 
    private Button supprimerBtn; 
    @FXML 
    private Button quitterBtn; 
    @FXML 
    private TableView<Person> table;

    @FXML 
    private TableColumn<Person, String> emailCol; 
    @FXML 
    private TableColumn<Person, String> prenomCol; 
    @FXML 
    private TableColumn<Person, String> nomCol; 
    @FXML 
    private TableColumn<Person, String> ageCol; 

    private DataClass data = new DataClass(); 
    private ObservableList<Person> list = FXCollections.observableArrayList(); 

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        list.addAll(data.getImportList());
        table.setItems(list);
    }

    
    public ObservableList<Person> getList(){
        return list;
    }

    public void ajouterPersonne() {
        String nom = tfNom.getText();
        String prenom = tfPrenom.getText();
        String email = tfEmail.getText();
       int  age = Integer.parseInt(tfAge.getText());    
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty()) {
        	
            System.out.println("Veuillez remplir tous les champs.");
            return;
        }

        // Ajouter une nouvelle personne à la liste
        list.add(new Person(prenom, nom, email,age));

        // Effacer les champs de saisie
        tfNom.clear();
        tfPrenom.clear();
        tfEmail.clear();
    }

    @FXML
    public void supprimerPersonne() {
        // Récupérer la personne sélectionnée dans la table
        Person selectedPerson = table.getSelectionModel().getSelectedItem();

        if (selectedPerson == null) {
            // Afficher un message d'erreur si aucune personne n'a été sélectionnée
            System.out.println("Veuillez sélectionner une personne à supprimer.");
            return;
        }

        // Supprimer la personne de la liste
        list.remove(selectedPerson);
    }

    @FXML
    public void exporterListe() {
        // Exporter la liste dans un fichier
        data.setExportList(list);
    }

    @FXML
    public void importerListe() {
        // Importer la liste depuis un fichier
        list.clear();
        list.addAll(data.getImportList());
    }

    @FXML
    public void quitterApplication() {
        // Fermer l'application
        System.exit(0);
    }
}
