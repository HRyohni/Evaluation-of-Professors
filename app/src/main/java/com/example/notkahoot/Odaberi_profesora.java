package com.example.notkahoot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Odaberi_profesora extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    ListView lista;
    Button tipka;
    EditText unos;
    TextView prikaz;
    ListView simpleList;

    private Button add;

    TextView test;
    private FirebaseFirestore db;

    public ProgressBar progres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odaberi_profesora);
        tipka= findViewById(R.id.button8);

        add = findViewById(R.id.dijalog);
        lista= findViewById(R.id.simpleListView);
        db=FirebaseFirestore.getInstance();
        simpleList = (ListView) findViewById(R.id.simpleListView);
        db = FirebaseFirestore.getInstance();
        progres= findViewById(R.id.progressBar2);

        progres.setVisibility(View.GONE);


        ArrayList<String> arraylist = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.customlistview, arraylist);





        OnStartRefresh(arraylist,adapter);

    //refresh
        tipka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnStartRefresh(arraylist,adapter);
            }
        });
        // dodaj
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

         lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(getBaseContext(), Pitanja.class);
                intent.putExtra("EXTRA_SESSION_ID", arraylist.get(position));
                startActivity(intent);

            }
        });




    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String username) {
        if (username.isEmpty())
        {
            Toast.makeText(Odaberi_profesora.this,"Upiši ime/prezime profesora",Toast.LENGTH_LONG).show();

        }
        else
        {
            //dodaje document
            Map<String, Object> data = new HashMap<>();
            data.put("Broj Korisnika",0);
            data.put("Bodovi",0);
            data.put("Ocijena",null);
            dodajOcjene(data);
            db.collection("Profesori").document(username).set(data);
            Toast.makeText(Odaberi_profesora.this,"Dodan, Osvježi",Toast.LENGTH_LONG).show();



        }
    }

    private void dodajOcjene( Map<String, Object> data) {
        data.put("jedan",0);
        data.put("dva",0);
        data.put("tri",0);
        data.put("cetiri",0);
        data.put("pet",0);
    }

    public void OnStartRefresh( ArrayList<String> arraylist,ArrayAdapter adapter)
    {
        {



            db.collection("Profesori").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {

                        arraylist.clear();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            arraylist.add(document.getId());
                        }
                    }

                    else {
                        Toast.makeText(Odaberi_profesora.this,"nesto nije uredu",Toast.LENGTH_LONG);
                    }
                }
            });

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    progres.setVisibility(View.GONE);

                    simpleList.setAdapter(adapter);
                }
            },1000); // POPRAVIOTI KASNIJE
            progres.setVisibility(View.VISIBLE);

        }
    }

}
