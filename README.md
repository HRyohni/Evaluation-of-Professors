**Sažetak**

Tema ovog završnog rada u srednjoj je izrada aplikacije za ocjenjivanje nastavnika. Aplikacija je izrađena u
android studiju u programskom jeziku java. Koristi jednostavan dizajn za lakšu uporabu
aplikacije te navigacija unutar nje. Prije same izrade aplikacije bitno je poznavati programski
jezik java, a u radu je objašnjen pojednostavljeni primjer korištenja jave, što je to firebase, čemu
služi i kako se koristi i sl. Objašnjen je cijeli proces izrade aplikacije.



## Sadržaj

- 1. Uvod
   - 1.1. Android
   - 1.2. Android studio
   - 1.3. Navigacija Android Studiom
   - 1.4. Gradle
   - 1.5. Firebase
   - 1.6. Firestore
   - 1.7. Programiranje u Android Studio Java
   - 1.8. Primjer programiranja u android studiu
   - 1.9. Splash screen
- 2. Razrada aplikacije
   - 2.1. Sustav prijave / registracije
   - 2.2. Korištenje
   - 2.3. Zadovoljavanje uvijeta lozinke i imena
   - 2.4. Mjenjanje registracije i prijave
   - 2.5. Korištenje Firebase baze podataka
   - 2.6. Implementiranje firebase u sam program
   - 2.7. Proces registracije
   - 2.8. Proces prijava
   - 2.9. Odabir profesora te dodavanje - Korištenje
   - 2.10. OnStartRefesh
   - 2.11. dodajOcjene
   - 2.12. Ocjenjivanje profesora
   - 2.13. Korištenje
   - 2.14. Kako funkcionira ocjenjivanje
   - 2.15. Grafički prikaz
   - 2.16. importOcjena
   - 2.17. Setupchart
- 3. Zaključak
- 4. Literatura




## 1. Uvod

U ovom radu ću objasniti kako sam izradio aplikaciju za ocjenjivanje nastavnika. Cilj aplikacije
je pojednostaviti ocjenjivanje nastavnika, lakša uporaba i pregled rezultata. Objasniti funkcije i
mogućnosti Android-a studio-a. Objasniti što je to gradle. Ova aplikacija je isprogramirana na
javi (programskom jeziku). Aplikacija je izrađena na principu ocjenjivanja nastavnika tako da
korisnici aplikacije mogu po postavljenim pitanjima ocijeniti pojedinog nastavnika. Objasniti ću
što je to Firebase baza podataka, kako je jednostavno implementirat i koristiti u izradi aplikacije.
Vidjeti ćete i kako sam izradio splash screen i sustav prijave i registracije te kako se podatci
spremaju na bazu podataka. Ocjene kojima su korisnici ocijenili nastavnike mogu se vidjeti
unutar aplikacije u obliku grafa i drugih podataka kao što su broj bodova i broj glasova.
Osim djela o programiranju i izradi funkcije aplikacije objasnit ću kako napraviti dizajn i šta sam
koristio kako bi ga oblikovao.


### 1.1. Android

Android operativni sustav je mobilni operacijski sustav koji je razvio Google (GOOGLE) kako
bi se prvenstveno koristio za uređaje s dodirnim zaslonima, mobitele i tablete. Njegov dizajn
omogućuje korisnicima intuitivno manipuliranje mobilnim uređajima, pokretima prstiju koji
odražavaju uobičajene pokrete, poput stezanja, prevlačenja i tapkanja. Google također koristi
Android softver u televizorima, automobilima i ručnim satovima - od kojih je svaki opremljen
jedinstvenim korisničkim sučeljem.

Operativni sustav Android prvi je razvio Android, Inc., softverska tvrtka smještena u Silicijskoj
dolini prije nego što ga je Google kupio 2005. Investitori i analitičari elektroničke industrije
sumnjaju u istinske namjere Googlea za ulazak na prostor mobilnog tržišta od te akvizicije. No, u
svakom slučaju, ubrzo nakon toga, Google je najavio predstojeće predstavljanje svojeg prvog
komercijalno dostupnog uređaja s Androidom 2007. godine, iako je taj proizvod na tržište stigao 2008. godine.

![Logo Android-a](https://cdn.discordapp.com/attachments/759467826440044585/1027580122292834325/image-000.jpg)


### 1.2. Android studio

Android Studio službeno je integrirano razvojno okruženje za Googleov operativni sustav
Android, izgrađen na JetBrains-ovom IntelliJ IDEA softveru i dizajniran posebno za razvoj
Androida. Dostupan je za preuzimanje na operacijskim sustavima sa sustavom Windows,
macOS i Linux.

![Grafičko sučelje android studia](https://cdn.discordapp.com/attachments/759467826440044585/1027580122578030683/image-001.jpg)

### 1.3. Navigacija Android Studiom

Android Studio je okruženje s prozorima. Kako bi najbolje iskoristio prostor, Android Studio u
svakom trenutku prikazuje samo mali dio dostupnih prozora. Neki od ovih prozora ovise o
kontekstu i pojavljuju se samo kad je kontekst prikladan, dok drugi ostaju skriveni dok ih ne
odlučite prikazati ili obratno ostaju vidljivi dok ih ne odlučite sakriti. Da biste u potpunosti
iskoristili prednost Android Studija, morate razumjeti funkcije ovih prozora, kao i kako i kada ih
prikazati. U ovom ćemo vam poglavlju pokazati kako upravljati prozorima u sustavu Android
Studio. Jedna od bitnih funkcija bilo kojeg integriranog razvojnog okruženja (IDE) je navigacija.
Android projekti obično se sastoje od mnogih paketa, direktorija i datoteka, a Android projekt
čak i skromne složenosti može sadržavati stotine takvih sredstava. Vaša produktivnost s Android
Studiom ovisit će u velikoj mjeri o tome koliko se udobno krećete unutar tih elemenata i preko
njih. 


![navigacija android studia](https://cdn.discordapp.com/attachments/759467826440044585/1027580122875826237/image-002.jpg)


### 1.4. Gradle

Prevođenje (engl. compilation) programa je proces prevođenja programskog koda u strojni kod
(tako zvani objektni kôd). Danas kompajleri uz prevođenje vrše i povezivanje (engl. linking),
koje strojni kod pretvara u datoteku koja se može izvršiti na računalu. Gradnja (engl. build)
projekta, uz prevođenje i povezivanje, uključuje i neke dodatne radnje, na primjer izradu
programa za instalaciju (engl. installer). Gradnja još omogućuje da se provode testovi
prevedenog koda, moguće je definirati korake koje treba učiniti prije ili poslije prevođenja nekog
dijela projekta, odrediti gdje će se izvršivi program nalaziti i još mnogo toga. Procesom gradnje
moguće je stvarati statičke i dinamičke pomoćne biblioteke koje se kasnije mogu samostalno
koristiti. Razlika među njima je u tome što kad statičku biblioteku unesemo u neki kod, ona se u
cijelosti povezuje prilikom prevođenja, dok se kod dinamičke datoteke povezuje samo dio koji će
se koristiti u izvršnom programu. U slučaju razvoja Android aplikacija, build sustav služi kako bi
uzeo izvorne programske datoteke (java ili .xml), na njih primijenio neke alate prevođenja i
povezivanja (na primjer java datoteku pretvorio u dex), te grupirao sve te datoteke u jednu
komprimiranu .apk datoteku s kojom Android sustav zna raditi. Build sustav koji se koristi u
Android Studiju naziva se Gradle. Ovaj sustav je razvijen promatrajući druge build sustave, te
integriranjem njihovih najboljih karakteristika. Gradle je baziran na JVM (Java Virtual Machine)
build sustavima što znači da se mogu pisati skripte za gradnju u programskom jeziku Java. koje rade bez obzira na kašnjenje mreže ili internetsku povezanost. Cloud Firestore također nudi
besprijekornu integraciju s ostalim Firebase i Google Cloud proizvodima, uključujući Cloud
Functions. 

### 1.5. Firebase

Firebase je platforma za razvoj softvera koju je 2011. pokrenuo Firebase inc., A Google je kupio 2014. godine. Pokretao se kao baza podataka u stvarnom vremenu, sada ima 18 usluga (od kojih
su 4 trenutno u beta verziji) i namjenske API-je.

### 1.6. Firestore

Cloud Firestore fleksibilna je, skalabilna baza podataka za razvoj mobilnih uređaja, weba i
poslužitelja iz Firebasea i Google Cloud-a. Poput Firebase baze podataka u stvarnom vremenu,
sinkronizira vaše podatke u klijentskim aplikacijama putem slušatelja u stvarnom vremenu i nudi
izvanmrežnu podršku za mobilne uređaje i web, tako da možete izrađivati responzivne aplikacije


![Izgled baze podataka](https://cdn.discordapp.com/attachments/759467826440044585/1027580123148455946/image-003.png)


### 1.7. Programiranje u Android Studio Java

- Objektno orijentirano: U Javi je sve objekt. Java se lako može proširiti budući da se temelji na
  objektnom modelu.
- Jednostavno: Java je dizajnirana da bude laka za učenje.
-  Sigurno: S Java-ovom sigurnom značajkom omogućuje razvoj virusa bez neovlaštenog pristupa
  sustavima. Tehnike provjere autentičnosti temelje se na šifriranju s javnim ključem.
-  Visoke performanse: Korištenjem Just-in-Time kompajlera Java omogućuje visoke performanse.
-  Robusno: Java se trudi ukloniti situacije sklone pogreškama naglašavanjem uglavnom na provjeri
  pogrešaka u vremenu kompajliranja i provjeri vremena izvođenja.^6


### 1.8. Primjer programiranja u android studiu

na primjeru je jednostavnog programa koji ispiše tekst prilikom pokretanja
aplikacije „Ovo je Tekst!“. Prvo je potrebno izraditi dizajn te kako će ta aktivnost izgledati. U
primjeru je dodan jedan TextView. TextView element koji prikazuje tekst. Tom elementu je
potrebno dodati njegov id po kojem će se moći pozivati u kodu. U primjeru je dodan id
„Tekst_view_Tekst“.


![aktivnost programa](https://cdn.discordapp.com/attachments/759467826440044585/1027580124121542787/image-007.jpg)

Zatim je potrebno isprogramirati. Dodajemo element unutar koda TextView imenom Tekst, te
spojimo element Tekst sa id „Tekst_view_Tekst“. Sada možemo koristiti razne naredbe za
uređivanje teksta u kodu. U primjeru je korištena naredba „Tekst.setText(“Ovo je Tekst!“)“ koja
samo postavlja tekst u tekst napisan u zagradi.

```java
public class MainActivity extends AppCompatActivity {
public TextView Tekst;
}
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        Tekst = findViewById ( R.id . Tekst_View_Tekst );
   }
        Tekst.setText ( " Ovo je Tekst ! " );
```

### 1.9. Splash screen

Početni zaslon (Splash Screen eng.) najčešći je prvi početni zaslon koji se pojavljuje kada se
aplikacija otvori. Drugim riječima, to je jednostavan stalni zaslon tijekom određenog
vremenskog razdoblja koji se koristi za prikaz loga tvrtke, imena, reklamnog sadržaja itd. Obično
se prikazuje kada se aplikacija prvi put pokreće na Android uređaju ili može biti neka vrsta
procesa koji se koristi za prikaz zaslona korisniku neposredno prije nego što se aplikacija u
potpunosti učita.

![primjeri splashscreenova](https://cdn.discordapp.com/attachments/759467826440044585/1027580124431929454/image-008.jpg)


## 2. Razrada aplikacije

Prilikom otvaranja aplikacije prvo će se otvoriti početni zaslon (eng. splash screen), koji navodi
na animirani logo u trajanju 3 sekunde. OnCreate() funkcija koja se izvodi na početku koda. U
kodu je inicijaliziran logo i animacija, zatim korišteći handeler blok naredbi će se izvesti za neko
određeno vrijeme. U aplikacije je to postavljeno na 3 sekunde (3000 ms).

![slika splashscreena](https://cdn.discordapp.com/attachments/759467826440044585/1027580125014921256/image-009.png)



### 2.1. Sustav prijave / registracije

Sustav prijave registracije napravljeno je pomoću baze podataka firebase.

![izgled prijave](https://cdn.discordapp.com/attachments/759467826440044585/1027580151380332645/image-011.jpg)

### 2.2. Korištenje

Sustav prijave i registracije je što više pojednostavljen radi lakšeg snalaženja, da bi se lakše
prijavio ili registriro korisnički račun. Prilikom pokretanja moguće se prijaviti. Pritiskom tipke
„Registracija?“ prebacuje se na registaciju te mjenja ime „Prijava“ u „Registracija“. Tako je
moguće i obratno iz registracije u prijavu. Ako su zadovoljeni svi uvjeti imena i lozinke onda će
se prijaviti/registrirati, te prebaciti na sljedeću aktivnost (Odabir profesora te dodavanje).

### 2.3. Zadovoljavanje uvijeta lozinke i imena

Submit() funkcija projverava jesu li ostavljena prazna polja u mjesto za upis imena ili lozinke, te
ako je mjesto za lozinku ostavljeno prazno nakon pritiska tipke “Prihvati“, pojaviti će se poruka
„Lozinka mora sadržavati barem 8 znakova.“, a ako je ostavljeno mjesto za ime prazno nakon
pritiska tipke „Prihvati“ pojavit će se poruka „Ime mora imati barem 8 znakova.“. Sustav je
kreiran radi sigurnosti i boljeg očuvanja identiteta, te lozinke.

```java
  if (Editime.getText().toString().isEmpty() || EditLozinka.getText().length()<8 || EditLozinka.getText().toString().isEmpty() )
            {
                if (Editime.getText().toString().isEmpty() || EditLozinka.getText().toString().isEmpty())
                { Toast.makeText(Izradi_racun.this,"Lozinka i ime moraju imati barem 8 znakova",Toast.LENGTH_LONG).show();}


                if (EditLozinka.getText().length()<8)
                {
                    Toast.makeText(this, "Lozinka mora sadržavati barem 8 znakova", Toast.LENGTH_SHORT).show();
                }
            }
```





### 2.4. Mjenjanje registracije i prijave

SwitchText() provjerava je li prijava ili registracija u pitanju. Ako je „Registracija“ postavlja
naslov u prijavu i vrši se sustav prijave, u suprotnom naslov se postavlja u registaciju i vrši se
proces prijave.

```java
public void SwitchText ( View v )
{
    if ( checkregister.getText().equals ("Registracija?"))
   {
   }
        checkregister.setText ("Prijava?");
       Opis.setText ("Registracija") ;
    else if ( checkregister.getText().equals("Prijava?"))
   {
   }
        checkregister.setText ("Registracija?");
        Opis.setText ("Prijava");
```


### 2.5. Korištenje Firebase baze podataka

Firebase je jednostavno implementirati u android studio jer je već u alatima spreman za
korištenje. Samo u par klikova može se implementirati u kod, te je jednostavan za korištenje.
Firebase omogućuje i jednostavno razumjenvanje primjene zbog bogatog objašnjenja
Aplikacijskog programskog sučelja (eng. API), koji se nalazi na njihovoj službenoj stranici
firebase. Dokumentacija u vezi aplikacijskog programskog sučelja ne sadrži samo podatke u vezi
android studia, to jest jave nego i za više programskih jezika.

### 2.6. Implementiranje firebase u sam program

Kako bi implementirali firebase u program moramo unutar programa pod Tools>Firebase. Novi
prozor će se otvoriti te će prikazati sve moguće alate koje nudi Firebase.
Odaberemo od ponuđenih alata koji želimo te kliknemo na „Get started with Firestore“
(u primjeru je odabran Cloud Firestore). Ispisati će sva objašnjenja kako implementirati u sam
kod i povezati se s firebase bazom podataka. Zatim trebamo izraditi račun na stranici Firebase te
kreirati projekt.

![](https://cdn.discordapp.com/attachments/759467826440044585/1027580152374378516/image-014.jpg)


### 2.7. Proces registracije

Proces registracije prvo provjerava je li to sustav prijave ili registracije. U slučaju da je sustav
registracije izvršava se blok naredbi za registraciju tako da pomoću upisanih podataka imena i
lozinke stvara račun na bazu podataka.

```java
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
```



### 2.8. Proces prijava

Za prijavu potrebno se spojiti na bazu podataka te putanja dokumenta kojeg pretražujemo.
Prijava provjerava postoji li upisani korisnički račun, u suprotnom pojavi se poruka „Nema
takvog korisnika“. Uspijemo li se pravilno prijaviti prebacuje se na sljedeću aktivnost „Odabir
profesora te dodavanje“.

```java
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
               }});}
```



### 2.9. Odabir profesora te dodavanje - Korištenje

Dizajn je osmišljen da bude jednostavan za uporabu te zbog boljeg pregleda. Prilikom pokretanja
akitivity-a ispišu se već izrađeni korisnički računi imena profesora. Tipkom „Osvježi“ će
pokrenuti animaciju za učitavanje dok ne završi s pregledom novih mogućih korisnika, te ispisati
ih. Klikom na Simbol „+“ će otvoriti novi prozor u kojem je moguće upisati ime i prezime
profesora, tipkom dodaj će kreirati novi korisnički račun profesora s upisanim imenom i
prezimenom. Pritiskom na Ime profesora će otvoriti novu aktivnost „ocjenjivanje profesora“.

![](https://cdn.discordapp.com/attachments/759467826440044585/1027580153473290270/image-017.jpg)


### 2.10. OnStartRefesh()

OnStartRefesh() je funkcija koja će pregledati listu imena profesora te dodati nove ako ih ima.
Postoje li novi korisnički račun profesora dodati će ime na listu popisa profesora.

```java
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
        }}}
```



### 2.11. dodajOcjene()

Funkcija dodajOcjene() će prilikom dodavanja novog profesora postaviti podatke spremne za
upis novih ocjena.

```java
    private void dodajOcjene( Map<String, Object> data) {
        data.put("jedan",0);
        data.put("dva",0);
        data.put("tri",0);
        data.put("cetiri",0);
        data.put("pet",0);
    }
```
### 2.12. Ocjenjivanje profesora

Cilj je da se pojedini profesor ocijeni te zapišu njegovi bodovi na bazu podataka koji će se
kasnije obrađivati. Podatci kao što su broj bodova i količina jedinica, dvojki, trojki...

![](https://cdn.discordapp.com/attachments/759467826440044585/1027580166333026335/image-020.jpg)



### 2.13. Korištenje

U bijelom kvadratu su ispisana pitanja za pojedinog profesora. Cilj je da korisnik po pitanjima
pomoću zvjezdica ocijeni profesora od jedan do pet s tim da je jedna zvjezdica (ocjena jedan) u
potpunosti se ne slažem, a pet zvjezdica (ocjena pet) u potpunosti se slažem. Postoji 10 mogućih
pitanja za odgovoriti koji se ocjenjuju u cjelini.

### 2.14. Kako funkcionira ocjenjivanje

Bitno je preuzeti podatke od profesora zato što ako je neki korisnik već ocijenio treba ažurirati
stare podatke te promijenjene podatke opet prebaciti na bazu podataka. Preuzima podatke s baze podataka. Ažurira se broj korisnika koji je ocijenio profesora
zbog ukupnoga broja bodova. Npr. ako je mogućih 50 bodova i 3 korisnika koji ocijenjuju
maksimalan broj bodova je 150.

```java
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
                }}});
```



### 2.15. Grafički prikaz

Ova aktivnost prikazuje grafički prikaz ocjena i broj bodova. Koristi se grafikon „pie“ koji se
dijeli na pet dijelova, pet ocjena. Kako bismo mogli koristiti grafikone potrebno je
implementirati „anychart“ biblioteku, a da bi koristili biblioteku potrebno je implementirati u
datoteku build.gradle.

![](https://cdn.discordapp.com/attachments/759467826440044585/1027580166744068156/image-022.jpg)

### 2.16. importOcjena()

ImportOcjena kasnije() je funkcija koja služi da preuzme podatke sa baze podataka. Podatci koji
će se kasnije koristiti za grafikon.

```java
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
```



### 2.17. Setupchart()

Setupchart() je funkcija koja koristi anychart biblioteku. Postavlja potrebne podatke za grafikon
kao što su vrijednosti, ocjene, naziv grafikona, itd.

```java
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

```
Potrebno sve to ispisati na aktivnost. Kod koji preuzima sve potrebne
podatke, izračunava sveukupan broj bodova i ispisuje na aktivnost.

```java
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
                    },1000);
                }
            }
        });
```

## 3. Zaključak

Izrada aplikacije za ocjenjivanje profesora nije zahtjevno za isprogramirati, veći zahtjevni dio
bio je kako i na koji način izabrati dobar dizajn. Postoji puno stranica koje objašnjavaju kako
izraditi dobar dizajn unutar aplikacije. Postoje razne biblioteke koje omogućuju lakše uporabu
dobrog i modernog dizajna.

Izradom ove aplikacije naučio sam koristiti razne biblioteke kao što su grafikoni te kako povezati
aplikaciju sa firebase-om i kako ga upotrebljavati.


