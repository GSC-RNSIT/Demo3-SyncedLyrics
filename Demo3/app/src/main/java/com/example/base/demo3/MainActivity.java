package com.example.base.demo3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends ActionBarActivity {
    //Create Notification
    NotificationCompat.Builder notif;
    private static final int uniqueID = 707;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notif = new NotificationCompat.Builder(this);
        notif.setAutoCancel(true);



    }


    public void booped(View view) {
        //Get user input
        EditText input = (EditText) findViewById(R.id.myText);
        String data = input.getText().toString();

    //Build notification
     notif.setSmallIcon(R.mipmap.ic_action_star);
     notif.setWhen(System.currentTimeMillis());
      notif.setContentTitle("Demo");
        notif.setContentText(data);


        //Pending Intent
        Intent intent = new Intent(this, MainActivity.class);
      PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
      notif.setContentIntent(pendingIntent);

            //Notification Manager
          NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
         nm.notify(uniqueID, notif.build());

        //Send Broadcast
        Intent i = new Intent();
        i.setAction("tag");
        i.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(i);

       }
}

