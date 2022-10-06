package com.example.notkahoot;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Izradi_racun extends AppCompatActivity {


    String Acces;
    TextView statustxt, checkregister;
    EditText Editime,EditLozinka;
    Switch PR;
    EditText doajEditText;
    private  ProgressBar progress;
    TextView Opis;
    private FirebaseFirestore db;
    private DatabaseReference mDatabase;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izradi_racun);
        //database

        db=FirebaseFirestore.getInstance();
        //<-------------------------->


       // statustxt = findViewById(R.id.statustxt);
        //PR = findViewById(R.id.switch1);
        Opis=findViewById(R.id.opis);

        checkregister = findViewById(R.id.registerr);

        Editime = findViewById(R.id.koristnickoime);
        EditLozinka=findViewById(R.id.lozinka);

       progress = findViewById(R.id.progressBar);
      progress.setVisibility(View.GONE);
        Map<String, Object> data = new HashMap<>();
        data.put("Samo radi",null);
     // db.collection("Profesori").document("moras radit").set(data);
    }


    public void Registracija(View v)
    {
        if (PR.isChecked())
        {
            Opis.setText("Registracija");



        }

        else
        {
            Opis.setText("Prijava");
        }
    }



    public void submit (View v) {


        if (Editime.getText().toString().isEmpty() || EditLozinka.getText().length()<8 || EditLozinka.getText().toString().isEmpty() )
            {
                if (Editime.getText().toString().isEmpty() || EditLozinka.getText().toString().isEmpty())
                { Toast.makeText(Izradi_racun.this,"Lozinka i ime moraju imati barem 8 znakova",Toast.LENGTH_LONG).show();}


                if (EditLozinka.getText().length()<8)
                {
                    Toast.makeText(this, "Lozinka mora sadržavati barem 8 znakova", Toast.LENGTH_SHORT).show();
                }
            }

        else
        {
            //Register
            if ( checkregister.getText().equals("Prijava?"))
        {
            CollectionReference dbPrijave = db.collection("Prijave");
            Prijave prijava = new Prijave(Editime.getText().toString(),EditLozinka.getText().toString());
            //dodaje document
            dbPrijave.document(Editime.getText().toString()).set(prijava);
            Toast.makeText(Izradi_racun.this,"Uspjesno kreiran Korisnicki racun",Toast.LENGTH_LONG);

            progress.setVisibility(View.VISIBLE);

            EditLozinka.setText(null);
            Editime.setText(null);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent i=new Intent(Izradi_racun.this,Izradi_racun.class);
                    startActivity(i);
                    finish();
                }
            },3000);

        }

        //Login
       if ( checkregister.getText().equals("Registracija?"))
       {
           //provjerava jeli ima takva datoteka
           DocumentReference docRef = db.collection("Prijave").document(Editime.getText().toString());

           docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
               @Override
               public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                   DocumentSnapshot document = task.getResult();
                   try

                   {

                       if (document.get("lozinka").toString().equals(EditLozinka.getText().toString())  && document.get("ime").toString().equals(Editime.getText().toString()))
                       {
                           Intent i=new Intent(Izradi_racun.this,Odaberi_profesora.class);
                           startActivity(i);
                       }
                   }

                    catch (Exception e)
                   {
                       Toast.makeText(Izradi_racun.this, "Nema takvog korisnika", Toast.LENGTH_LONG).show();
                   }

               }
           });
       }}

    }


public  void Rezulatati (View v)
{
    Intent i=new Intent(Izradi_racun.this,Rezultati.class);
    startActivity(i);
}


    public void SwitchText(View v)
    {
        if (checkregister.getText().equals("Registracija?"))
        {
            checkregister.setText("Prijava?");
            Opis.setText("Registracija");

        }

        else if (checkregister.getText().equals("Prijava?"))
        {
            checkregister.setText("Registracija?");
            Opis.setText("Prijava");
        }

    }


}



