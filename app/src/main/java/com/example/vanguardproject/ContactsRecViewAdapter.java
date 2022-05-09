package com.example.vanguardproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ContactsRecViewAdapter extends RecyclerView.Adapter<ContactsRecViewAdapter.ViewHolder> {

    private ArrayList<Contact> contacts = new ArrayList<>();
    private Context context;

    public ContactsRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        DecimalFormat converts = new DecimalFormat();
        holder.txtName.setText(contacts.get(position).getGoalName());
        holder.txtEmail.setText("$"+converts.format(contacts.get(position).getGoalAmount()));

        holder.progressBarAnimation(holder.progressBar,contacts.get(position).getCurrentAmount());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Going to "+contacts.get(position).getGoalName()+ " Goal", Toast.LENGTH_SHORT).show();
            }
        });
        Glide.with(context).asBitmap().load(contacts.get(position).getImageUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName, txtEmail;
        private CardView parent;
        private ImageView image;
        private ProgressBar progressBar;
        int progressBarCounter = 0;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            parent = itemView.findViewById(R.id.parent);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            progressBar = itemView.findViewById(R.id.goalProgressBar);
            image = itemView.findViewById(R.id.image);
        }

        public void progressBarAnimation(ProgressBar pb ,int percentage){
            Timer t = new Timer();
            TimerTask tt = new TimerTask() {
                @Override
                public void run() {
                    progressBarCounter++;
                    pb.setProgress(progressBarCounter);

                    if(progressBarCounter == percentage){
                        t.cancel();
                    }
                }
            };
            t.schedule(tt,0,20);
        }
    }


}
