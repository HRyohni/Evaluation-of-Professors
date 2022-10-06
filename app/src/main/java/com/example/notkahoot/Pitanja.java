package com.example.notkahoot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static com.example.notkahoot.R.drawable.test;
import static com.example.notkahoot.R.drawable.test2;

public class Pitanja extends AppCompatActivity {
    Button ocj1,ocj2,ocj3,ocj4,ocj5;
    int jedinica=0,dvojka=0,trojka=0,cetvora=0,petica=0;
    TextView pitanje;
    ImageView slike;
    int Bodovi=1;
    int Brojpitanja=0;
    float Prosjek;
    int ocjena;
    int korisnik=0;
    boolean a=false;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitanja);
        pitanje = findViewById(R.id.Pitanje);
        ocj1 = findViewById(R.id.ocjena1);
        ocj2 = findViewById(R.id.ocjena2);
        ocj3 = findViewById(R.id.ocjena3);
        ocj4 = findViewById(R.id.ocjena4);
        ocj5 = findViewById(R.id.ocjena5);



        String[] Pitanja = {"Jeli je Profesor objektivan u ocjenjivanju.", "Profesor neomalovažava učenike", "Profesor ocjenjuje i trud i zalaganje, a ne samo znanje", "Profesor me je zainteresirao za učenje","Nastavnik je redovito dostupan za komunikaciju te pruža korisne povratne informacije o mom radu.","Nastavnik se prema meni odnosi s poštovanjem","Nastavnik redovito održava nastavu.","Jasno sam i detaljno informiran o\n" +
                "ciljevima nastave, radnim zadacima i\n" +
                "kriterijima ocjenjivanja \n","Nastavnik je motiviran tijekom izvođenja\n" +
                "nastave i pokazuje entuzijazam u radu ","Nastavnik potiče interakciju i suradnju\n" +
                "među studentima "};
        pitanje.setText(Pitanja[Brojpitanja]);
                //prijenos stringa imena profesora
        String sessionId = getIntent().getStringExtra("EXTRA_SESSION_ID");
        db=FirebaseFirestore.getInstance();
        Map<String, Object> data = new HashMap<>();

        DocumentReference docRef = db.collection("Profesori").document(sessionId);

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                try
                {

                   String brojkorisnika = document.get("Broj Korisnika").toString();
                    String bodovi= document.get("Bodovi").toString();

                    importOcijene(document);



                    int Ibrojkorisnika =Integer.parseInt(brojkorisnika);
                    Bodovi =Integer.parseInt(bodovi);

                    data.put("Broj Korisnika",Ibrojkorisnika+=1);

                }

                catch (Exception e)
                {
                    Toast.makeText(Pitanja.this, "Nastala greska", Toast.LENGTH_LONG).show();

                }

            }
        });

       ocj1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (Brojpitanja>8)
               {
                   BrojOcijena(data,1);
                   Bodovi++;
                   data.put("Bodovi",Bodovi);
                   db.collection("Profesori").document(sessionId).set(data);
                   Intent i=new Intent(Pitanja.this,Rezultati.class);
                   startActivity(i);
               }
               else {
                   BrojOcijena(data,1);
                   Bodovi++;
                   pitanje.setText(Pitanja[++Brojpitanja]);
                   data.put("Bodovi",Bodovi);
               }




               db.collection("Profesori").document(sessionId).set(data);
           }
       });


       ocj2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (Brojpitanja>8)
               {
                   BrojOcijena(data,2);

                   Bodovi+=2;
                   data.put("Bodovi",Bodovi);
                   db.collection("Profesori").document(sessionId).set(data);
                   Intent i=new Intent(Pitanja.this,Rezultati.class);
                   startActivity(i);
               }
               else {
                   BrojOcijena(data,2);
                   pitanje.setText(Pitanja[++Brojpitanja]);
                   Bodovi+=2;
                   data.put("Bodovi",Bodovi);
                   db.collection("Profesori").document(sessionId).set(data);
               }

           }
       });

       ocj3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (Brojpitanja>8)
               {
                   BrojOcijena(data,3);
                   Bodovi+=3;
                   data.put("Bodovi",Bodovi);
                   db.collection("Profesori").document(sessionId).set(data);
                   Intent i=new Intent(Pitanja.this,Rezultati.class);
                   startActivity(i);
               }
               else
               {      BrojOcijena(data,3);
                   pitanje.setText(Pitanja[++Brojpitanja]);
                   Bodovi+=3;
                   data.put("Bodovi",Bodovi);
                   db.collection("Profesori").document(sessionId).set(data);}
           }
       });

        ocj4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Brojpitanja>8)
                {  BrojOcijena(data,4);
                    Bodovi+=4;
                    data.put("Bodovi",Bodovi);
                    db.collection("Profesori").document(sessionId).set(data);
                    Intent i=new Intent(Pitanja.this,Rezultati.class);
                    startActivity(i);
                }
                else
                {
                    BrojOcijena(data,4);
                    pitanje.setText(Pitanja[++Brojpitanja]);
                    Bodovi+=4;
                    data.put("Bodovi",Bodovi);
                    db.collection("Profesori").document(sessionId).set(data);
                }
            }
        });

        ocj5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Brojpitanja>8)
                {
                    BrojOcijena(data,5);
                    Bodovi+=5;
                    data.put("Bodovi",Bodovi);
                    db.collection("Profesori").document(sessionId).set(data);
                    Intent i=new Intent(Pitanja.this,Rezultati.class);
                    startActivity(i);
                }
                else
                {      BrojOcijena(data,5);
                    pitanje.setText(Pitanja[++Brojpitanja]);
                    Bodovi+=5;
                    data.put("Bodovi",Bodovi);
                    db.collection("Profesori").document(sessionId).set(data);}

            }
        });
    }

    private void importOcijene(DocumentSnapshot document) {


       String sjedinica=  document.get("jedan").toString();
       String sdvojka=  document.get("dva").toString();
       String strojka=  document.get("tri").toString();
       String  scetvora=  document.get("cetiri").toString();
       String spetica=  document.get("pet").toString();

        jedinica= Integer.parseInt(sjedinica);
        dvojka= Integer.parseInt(sdvojka);
        trojka= Integer.parseInt(strojka);
        cetvora= Integer.parseInt(scetvora);
        petica= Integer.parseInt(spetica);
    }

    public void BrojOcijena(Map<String,Object> data ,int ocjena){
        if (ocjena ==1)
        {
            jedinica+=1;
            data.put("jedan",jedinica);
        }
        if (ocjena ==2)
        {
            dvojka+=1;
            data.put("dva",dvojka);
        }

        if (ocjena ==3)
        {
            trojka+=1;
            data.put("tri",trojka);
        }

        if (ocjena ==4)
        {
            cetvora+=1;
            data.put("cetiri",cetvora);
        }

        if (ocjena ==5)
        {
            petica+=1;
            data.put("pet",petica);
        }

        data.put("jedan",jedinica);
        data.put("dva",dvojka);
        data.put("tri",trojka);
        data.put("cetiri",cetvora);
        data.put("pet",petica);


    }

}