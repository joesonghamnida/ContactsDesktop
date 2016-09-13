package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ObservableList<Contact>contacts= FXCollections.observableArrayList();

    @FXML
    TextField name;
    @FXML
    TextField phone;
    @FXML
    TextField email;
    @FXML
    ListView list;

    public void addContact(){
        String n=name.getText();
        String p=phone.getText();
        String e=email.getText();
        if(!(n.isEmpty() && p.isEmpty() && e.isEmpty())) {
            contacts.add(new Contact(n,p,e));
            System.out.println("Contact created");
        }
        else{
            System.out.println("All fields are required");
        }
    }
    public void removeContact(){
        Contact contact = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
        System.out.println("Contact removed");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }

}
