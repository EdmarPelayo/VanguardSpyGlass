package com.example.vanguardproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView contactsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();
        contactsRecView = findViewById(R.id.contactsRecView);

        contacts.add(new Contact("Tesla", "$140,000","https://media.autoweek.nl/m/h16ya0lbqhsc_480.jpg"));
        contacts.add(new Contact("Vacation","$4,000","https://www.incimages.com/uploaded_files/image/1920x1080/getty_167167350_9706479704500183_94071.jpg"));
        contacts.add(new Contact("College","$89,000","https://cbwestcourtstreetpress.com/wp-content/uploads/2021/12/college.jpg"));
        contacts.add(new Contact("Gaming Pc", "$3,000","https://thesecondangle.com/wp-content/uploads/2022/03/high-gaming-pc.jpg"));

        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecView.setAdapter(adapter);
        contactsRecView.setLayoutManager(new LinearLayoutManager(this));
        //prog();
    }



    /**

    public void prog(){
        pb = (ProgressBar)findViewById(R.id.pb);
        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);
                if(counter==65){
                    t.cancel();
                }
            }
        };
        t.schedule(tt,0,50);
    }
    **/
}