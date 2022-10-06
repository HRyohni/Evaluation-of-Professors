package com.example.notkahoot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Rezultati extends AppCompatActivity {
        ListView lista;
        Button osvjezi;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultati);
        lista= findViewById(R.id.listViewRezulatit);
        osvjezi= findViewById(R.id.osvjezi);
        db=FirebaseFirestore.getInstance();

        ArrayList<String> arraylist = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.customlistview, arraylist);




        refreshonStart(arraylist,adapter); // refresh on start





        osvjezi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            refreshonStart(arraylist,adapter);// changed
            }
        });

    }


public void refreshonStart(  ArrayList<String> arraylist,  ArrayAdapter adapter)
{

    lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




            //Toast.makeText(Rezultati.this, arraylist.get(position), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getBaseContext(), Status.class);
            intent.putExtra("ImeProfesora", arraylist.get(position));
            startActivity(intent);

        }
    });

    db.collection("Profesori").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {
            if (task.isSuccessful()) {

                arraylist.clear();

                for (QueryDocumentSnapshot document : task.getResult()) {


                    adapter.add(document.getId());
                }


                if (adapter.isEmpty()) {
                    Toast.makeText(Rezultati.this, "Nema dodanih profesora", Toast.LENGTH_SHORT).show();
                }

            }

            else {
                Toast.makeText(Rezultati.this,"nesto nije uredu",Toast.LENGTH_LONG);
            }
        }
    });

    lista.setAdapter(adapter);

}
}


