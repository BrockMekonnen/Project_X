package com.AASTU.Controller;

import javafx.geometry.Pos;
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
}
