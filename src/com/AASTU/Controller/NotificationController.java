package com.AASTU.Controller;

import com.AASTU.Model.Patient;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Pos;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


public class NotificationController {

    static void savedNotification(String title, String textContent, String image){
        Notifications notifications =  Notifications.create()
                .title(title)
                .text(textContent)
                .graphic(new ImageView(image))
                .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_CENTER);
            notifications.show();
    }

    static void deletedNotification(String title, String textContent, String image){
        Notifications notifications =  Notifications.create()
                .title(title)
                .text(textContent)
                .graphic(new ImageView(image))
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_CENTER);
                notifications.show();
    }

    static void searchFieldHandler(ObservableList<Patient> patientList, TableView<Patient> TableView, TextField searchfield){
        FilteredList<Patient> list=new FilteredList<>(patientList, p ->true);
        searchfield.textProperty().addListener(((observable, oldValue, newValue) -> {
            list.setPredicate(myObject ->{
                if (newValue==null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter=newValue.toLowerCase();
                if(String.valueOf(myObject.getFirstName()).toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(String.valueOf(myObject.getLastName()).toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(String.valueOf(myObject.getPhoneNumber()).toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                return false;
            });
        }
        ));
        // sorted value of filtered list and add the list value to the table list
        SortedList<Patient> sortedList=new SortedList<>(list);
        sortedList.comparatorProperty().bind(TableView.comparatorProperty());
        TableView.setItems(sortedList);
    }
}
