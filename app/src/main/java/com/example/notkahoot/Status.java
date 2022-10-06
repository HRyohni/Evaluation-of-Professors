package com.example.notkahoot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Status extends AppCompatActivity {


    AnyChartView graph;
  int   jedinica=0,dvojka=0,trojka=0,cetvora=0,petica=0;
  int Bodovi=0;




    TextView ImePrfoesoraTextView,BrojBodova,BrojKorisnika;
    private FirebaseFirestore db;

 String sessionId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        graph  = findViewById(R.id.graph);
        ImePrfoesoraTextView = findViewById(R.id.imeprof);
        BrojBodova = findViewById(R.id.BrojBodova);
        BrojKorisnika = findViewById(R.id.BrojKorisnika);


        db= FirebaseFirestore.getInstance();

        sessionId = (String) getIntent().getStringExtra("ImeProfesora");
        ImePrfoesoraTextView.setText(sessionId);


        DocumentReference docRef = db.collection("Profesori").document(sessionId);

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
              try {

                    String brojkorisnika = document.get("Broj Korisnika").toString();
                    String bodovi= document.get("Bodovi").toString();
                    importOcijene(document);
                    ImePrfoesoraTextView.setText(sessionId);
                    BrojBodova.setText(bodovi+"/"+Integer.parseInt(brojkorisnika)*50);
                    BrojKorisnika.setText(brojkorisnika);
                    int Ibrojkorisnika =Integer.parseInt(brojkorisnika);
                    Bodovi =Integer.parseInt(bodovi);
                    setupchart();
                    setupchart();
                }


                catch (Exception e)
                {
                    Toast.makeText(Status.this, "Greška pri učitavanju podataka!", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i=new Intent(Status.this,Rezultati.class);
                            startActivity(i);
                            finish();
                        }
                    },1000); // POPRAVIOTI KASNIJE
                }

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

    public void setupchart()
    {
        int[] ocjene ={jedinica, dvojka, trojka,cetvora,petica};
        String[] Imeocjene ={"jedinica", "dvojka", "trojka","četvo","petica"};
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEnteries = new ArrayList<>();
        int count=0;
        for (int i = 1; i <= 5;++i)
        {
            dataEnteries.add(new ValueDataEntry(Imeocjene[count],ocjene[count++]));
        }
        pie.data(dataEnteries);
        pie.title("Ocjene");
        pie.background("#B7D8D6");

        pie.animation(true);




        graph.setChart(pie);

    }

    public void setupchartMZ()
    {
        int[] ocjene ={3, 5};
        String[] Imeocjene ={"Muško", "Žensko"};
        Pie mz = AnyChart.pie();
        List<DataEntry> dataEnteries = new ArrayList<>();
        int count=0;
        for (int i = 1; i <= 2;++i)
        {
            dataEnteries.add(new ValueDataEntry(Imeocjene[count],ocjene[count++]));
        }
        mz.data(dataEnteries);
        mz.title("Ocjene");
        mz.animation(true);

        mz.credits().enabled(false);

        graph.setChart(mz);

    }








}