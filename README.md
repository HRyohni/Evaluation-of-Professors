ELEKTROTEHNIČKA I EKONOMSKA ŠKOLA

Ljudevita Gaja 24

35400 Nova Gradiška

```
Završni rad iz predmeta:
```
Programiranje Mobilnih **Uređaja**

```
Tema:
Android sustav ocjenjivanja nastavnika
```
Mentor: Učenik:
Zoran Ivančić mag. Ing. elektrotehnike Leo M., 4.e
Smjer: Tehničar za računalstvo

```
Nova Gradiška, ljetni rok
Šk. god. 2020/2021.
```

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


**Sažetak**

Tema ovog završnog rada je izrada aplikacije za ocjenjivanje nastavnika. Aplikacija je izrađena u
android studiju u programskom jeziku java. Koristi jednostavan dizajn za lakšu uporabu
aplikacije te navigacija unutar nje. Prije same izrade aplikacije bitno je poznavati programski
jezik java, a u radu je objašnjen pojednostavljeni primjer korištenja jave, što je to firebase, čemu
služi i kako se koristi i sl. Objašnjen je cijeli proces izrade aplikacije.


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
jedinstvenim korisničkim sučeljem.^1

Operativni sustav Android prvi je razvio Android, Inc., softverska tvrtka smještena u Silicijskoj
dolini prije nego što ga je Google kupio 2005. Investitori i analitičari elektroničke industrije
sumnjaju u istinske namjere Googlea za ulazak na prostor mobilnog tržišta od te akvizicije. No, u
svakom slučaju, ubrzo nakon toga, Google je najavio predstojeće predstavljanje svojeg prvog
komercijalno dostupnog uređaja s Androidom 2007. godine, iako je taj proizvod na tržište stigao

2008. godine.

```
Slika 1 Logo Android-a
```
(^1) Android Operating System, URL: https://www.investopedia.com/terms/a/android-operating-system.asp


### 1.2. Android studio

Android Studio službeno je integrirano razvojno okruženje za Googleov operativni sustav
Android, izgrađen na JetBrains-ovom IntelliJ IDEA softveru i dizajniran posebno za razvoj
Androida. Dostupan je za preuzimanje na operacijskim sustavima sa sustavom Windows,
macOS i Linux.

```
Slika 2 Grafičko sučelje android studia
```

### 1.3. Navigacija Android Studiom......................................................................................................................

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
njih. 2

```
Slika 3 navigacija android studia
```
(^2) Learn Android Studio, 25.4.2021. URL: [http://barbra-coco.dyndns.org/student/learning_android_studio.pdf](http://barbra-coco.dyndns.org/student/learning_android_studio.pdf)


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
build sustavima što znači da se mogu pisati skripte za gradnju u programskom jeziku Java.^3

(^3) Maja Karaga, Marko Stojanović, Programiranje aplikacija za android, str 5


```
koje rade bez obzira na kašnjenje mreže ili internetsku povezanost. Cloud Firestore također nudi
besprijekornu integraciju s ostalim Firebase i Google Cloud proizvodima, uključujući Cloud
Functions. 5
```
### 1.5. Firebase

```
Firebase je platforma za razvoj softvera koju je 2011. pokrenuo Firebase inc., A Google je kupio
```
2014. godine. Pokretao se kao baza podataka u stvarnom vremenu, sada ima 18 usluga (od kojih
su 4 trenutno u beta verziji) i namjenske API-je.^4

### 1.6. Firestore

```
Cloud Firestore fleksibilna je, skalabilna baza podataka za razvoj mobilnih uređaja, weba i
poslužitelja iz Firebasea i Google Cloud-a. Poput Firebase baze podataka u stvarnom vremenu,
sinkronizira vaše podatke u klijentskim aplikacijama putem slušatelja u stvarnom vremenu i nudi
izvanmrežnu podršku za mobilne uređaje i web, tako da možete izrađivati responzivne aplikacije
```
```
Slika 4 Izgled baze podataka
```
(^)
(^4) The Good and the Bad of Firebase Backend Services, Url: https://www.altexsoft.com/blog/firebase-review-pros-
cons-alternatives/
(^5) Firebase Realtime Database Url: https://firebase.google.com/docs/database


### 1.7. Programiranje u Android Studio Java

```
➢ Objektno orijentirano: U Javi je sve objekt. Java se lako može proširiti budući da se temelji na
objektnom modelu.
➢ Jednostavno: Java je dizajnirana da bude laka za učenje.
➢ Sigurno: S Java-ovom sigurnom značajkom omogućuje razvoj virusa bez neovlaštenog pristupa
sustavima. Tehnike provjere autentičnosti temelje se na šifriranju s javnim ključem.
➢ Visoke performanse: Korištenjem Just-in-Time kompajlera Java omogućuje visoke performanse.
➢ Robusno: Java se trudi ukloniti situacije sklone pogreškama naglašavanjem uglavnom na provjeri
pogrešaka u vremenu kompajliranja i provjeri vremena izvođenja.^6
```
(^)
_Slika 3 Logo Java_
(^)
(^6) Java Tuturial, Url: https://www.tutorialspoint.com/java/java_tutorial.pdf


### 1.8. Primjer programiranja u android studiu

Na slici (Slika 4.) primjer je jednostavnog programa koji ispiše tekst prilikom pokretanja
aplikacije „Ovo je Tekst!“. Prvo je potrebno izraditi dizajn te kako će ta aktivnost izgledati. U
primjeru je dodan jedan TextView. TextView element koji prikazuje tekst. Tom elementu je
potrebno dodati njegov id po kojem će se moći pozivati u kodu. U primjeru je dodan id
„Tekst_view_Tekst“.

```
Slika 4 Aktivnost programa
```
Zatim je potrebno isprogramirati. Dodajemo element unutar koda TextView imenom Tekst, te
spojimo element Tekst sa id „Tekst_view_Tekst“. Sada možemo koristiti razne naredbe za
uređivanje teksta u kodu. U primjeru je korištena naredba „Tekst.setText(“Ovo je Tekst!“)“ koja
samo postavlja tekst u tekst napisan u zagradi.

```
Slika 5 kod primjera
```

### 1.9. Splash screen

Početni zaslon (Splash Screen eng.) najčešći je prvi početni zaslon koji se pojavljuje kada se
aplikacija otvori. Drugim riječima, to je jednostavan stalni zaslon tijekom određenog
vremenskog razdoblja koji se koristi za prikaz loga tvrtke, imena, reklamnog sadržaja itd. Obično
se prikazuje kada se aplikacija prvi put pokreće na Android uređaju ili može biti neka vrsta
procesa koji se koristi za prikaz zaslona korisniku neposredno prije nego što se aplikacija u
potpunosti učita.^7

```
Slika 6 primjer splash screen-a
```
(^7) Url:
https://static1.squarespace.com/static/601b49cf5d76be323d847d41/t/601b54304666534b7cc09356/1612403761632/
splash_screen_in_android_studio.pdf


## 2. Razrada aplikacije

Prilikom otvaranja aplikacije prvo će se otvoriti početni zaslon (eng. splash screen), koji navodi
na animirani logo u trajanju 3 sekunde. OnCreate() funkcija koja se izvodi na početku koda. U
kodu je inicijaliziran logo i animacija, zatim korišteći handeler blok naredbi će se izvesti za neko
određeno vrijeme. U aplikacije je to postavljeno na 3 sekunde (3000 ms).

```
Slika 7 Splash Screen Slika 8 Kod za splash screen
```

### 2.1. Sustav prijave / registracije

Sustav prijave registracije napravljeno je pomoću baze podataka firebase. Izgled aktivnosti na
slici (Slika 7.)

```
Slika 9 Izgled Prijave
```
### 2.2. Korištenje

Sustav prijave i registracije je što više pojednostavljen radi lakšeg snalaženja, da bi se lakše
prijavio ili registriro korisnički račun. Prilikom pokretanja moguće se prijaviti. Pritiskom tipke
„Registracija?“ prebacuje se na registaciju te mjenja ime „Prijava“ u „Registracija“. Tako je
moguće i obratno iz registracije u prijavu. Ako su zadovoljeni svi uvjeti imena i lozinke onda će
se prijaviti/registrirati, te prebaciti na sljedeću aktivnost (Odabir profesora te dodavanje).


### 2.3. Zadovoljavanje uvijeta lozinke i imena

```
Submit() funkcija projverava jesu li ostavljena prazna polja u mjesto za upis imena ili lozinke, te
ako je mjesto za lozinku ostavljeno prazno nakon pritiska tipke “Prihvati“, pojaviti će se poruka
„Lozinka mora sadržavati barem 8 znakova.“, a ako je ostavljeno mjesto za ime prazno nakon
pritiska tipke „Prihvati“ pojavit će se poruka „Ime mora imati barem 8 znakova.“. Sustav je
kreiran radi sigurnosti i boljeg očuvanja identiteta, te lozinke.
```
```
Slika 10 funkcija Submit()
```
### 2.4. Mjenjanje registracije i prijave

```
SwitchText() provjerava je li prijava ili registracija u pitanju. Ako je „Registracija“ postavlja
naslov u prijavu i vrši se sustav prijave, u suprotnom naslov se postavlja u registaciju i vrši se
proces prijave.
```
(^)
Slika 11 Mijenjanje registracije i prijave


### 2.5. Korištenje Firebase baze podataka

```
Firebase je jednostavno implementirati u android studio jer je već u alatima spreman za
korištenje. Samo u par klikova može se implementirati u kod, te je jednostavan za korištenje.
Firebase omogućuje i jednostavno razumjenvanje primjene zbog bogatog objašnjenja
Aplikacijskog programskog sučelja (eng. API), koji se nalazi na njihovoj službenoj stranici
firebase. Dokumentacija u vezi aplikacijskog programskog sučelja ne sadrži samo podatke u vezi
android studia, to jest jave nego i za više programskih jezika.
```
### 2.6. Implementiranje firebase u sam program

```
Kako bi implementirali firebase u program moramo unutar programa pod Tools>Firebase. Novi
prozor će se otvoriti te će prikazati sve moguće alate koje nudi Firebase.
Odaberemo od ponuđenih alata koji želimo te kliknemo na „Get started with Firestore“
(u primjeru je odabran Cloud Firestore). Ispisati će sva objašnjenja kako implementirati u sam
kod i povezati se s firebase bazom podataka. Zatim trebamo izraditi račun na stranici Firebase te
kreirati projekt.
```
(^)
Slika 12 Implementiranje firebase


### 2.7. Proces registracije

Proces registracije prvo provjerava je li to sustav prijave ili registracije. U slučaju da je sustav
registracije izvršava se blok naredbi za registraciju tako da pomoću upisanih podataka imena i
lozinke stvara račun na bazu podataka.

```
Slika 13 Proces registracije
```
### 2.8. Proces prijava

Za prijavu potrebno se spojiti na bazu podataka te putanja dokumenta kojeg pretražujemo.
Prijava provjerava postoji li upisani korisnički račun, u suprotnom pojavi se poruka „Nema
takvog korisnika“. Uspijemo li se pravilno prijaviti prebacuje se na sljedeću aktivnost „Odabir
profesora te dodavanje“.

```
Slika 14 Proces prijave
```

### 2.9. Odabir profesora te dodavanje - Korištenje..............................................................................................

```
Dizajn je osmišljen da bude jednostavan za uporabu te zbog boljeg pregleda. Prilikom pokretanja
akitivity-a ispišu se već izrađeni korisnički računi imena profesora. Tipkom „Osvježi“ će
pokrenuti animaciju za učitavanje dok ne završi s pregledom novih mogućih korisnika, te ispisati
ih. Klikom na Simbol „+“ će otvoriti novi prozor u kojem je moguće upisati ime i prezime
profesora, tipkom dodaj će kreirati novi korisnički račun profesora s upisanim imenom i
prezimenom. Pritiskom na Ime profesora će otvoriti novu aktivnost „ocjenjivanje profesora“.
```
(^)
Slika 15 Prikaz aktivnosti odaberi profesora


### 2.10. OnStartRefesh()

```
OnStartRefesh() je funkcija koja će pregledati listu imena profesora te dodati nove ako ih ima.
Postoje li novi korisnički račun profesora dodati će ime na listu popisa profesora.
```
```
Slika 16 funkcija OnStartRefesh()
```
### 2.11. dodajOcjene()

```
Funkcija dodajOcjene() će prilikom dodavanja novog profesora postaviti podatke spremne za
upis novih ocjena.
```
```
Slika 17 funkcija dodajOcjene()
```

### 2.12. Ocjenjivanje profesora

```
Cilj je da se pojedini profesor ocijeni te zapišu njegovi bodovi na bazu podataka koji će se
kasnije obrađivati. Podatci kao što su broj bodova i količina jedinica, dvojki, trojki...
```
### 2.13. Korištenje

```
U bijelom kvadratu su ispisana pitanja za pojedinog profesora. Cilj je da korisnik po pitanjima
pomoću zvjezdica ocijeni profesora od jedan do pet s tim da je jedna zvjezdica (ocjena jedan) u
potpunosti se ne slažem, a pet zvjezdica (ocjena pet) u potpunosti se slažem. Postoji 10 mogućih
pitanja za odgovoriti koji se ocjenjuju u cjelini.
```
```
Slika 18 Aktivnost za ocjenjivanje profesora
```

### 2.14. Kako funkcionira ocjenjivanje

```
Bitno je preuzeti podatke od profesora zato što ako je neki korisnik već ocijenio treba ažurirati
stare podatke te promijenjene podatke opet prebaciti na bazu podataka. U bloku naredbe na slici
(Slika 17.) preuzima podatke s baze podataka. Ažurira se broj korisnika koji je ocijenio profesora
zbog ukupnoga broja bodova. Npr. ako je mogućih 50 bodova i 3 korisnika koji ocijenjuju
maksimalan broj bodova je 150.
```
```
Slika 19 Preuzimanje podataka
```

### 2.15. Grafički prikaz

Ova aktivnost prikazuje grafički prikaz ocjena i broj bodova. Koristi se grafikon „pie“ koji se
dijeli na pet dijelova, pet ocjena. Kako bismo mogli koristiti grafikone potrebno je
implementirati „anychart“ biblioteku, a da bi koristili biblioteku potrebno je implementirati u
datoteku build.gradle.

```
Slika 20 aktivnost grafički prikaz
```
### 2.16. importOcjena()

ImportOcjena kasnije() je funkcija koja služi da preuzme podatke sa baze podataka. Podatci koji
će se kasnije koristiti za grafikon.

```
Slika 21 Funkcija importOcjena()
```

### 2.17. Setupchart()..............................................................................................................................................

Setupchart() je funkcija koja koristi anychart biblioteku. Postavlja potrebne podatke za grafikon
kao što su vrijednosti, ocjene, naziv grafikona, itd.

```
Slika 22 funkcija Setupchart()
```
Potrebno sve to ispisati na aktivnost. Na slici (slika 21.) je kod koji preuzima sve potrebne
podatke, izračunava sveukupan broj bodova i ispisuje na aktivnost.

```
Slika 23 Preuzimanje podataka
```

## 3. Zaključak

Izrada aplikacije za ocjenjivanje profesora nije zahtjevno za isprogramirati, veći zahtjevni dio
bio je kako i na koji način izabrati dobar dizajn. Postoji puno stranica koje objašnjavaju kako
izraditi dobar dizajn unutar aplikacije. Postoje razne biblioteke koje omogućuju lakše uporabu
dobrog i modernog dizajna.

Izradom ove aplikacije naučio sam koristiti razne biblioteke kao što su grafikoni te kako povezati
aplikaciju sa firebase-om i kako ga upotrebljavati.


## 4. Literatura

1. Android Operating System,
URL: https://www.investopedia.com/terms/a/android-operating-system.asp
2. Everything you need to build on Android, 25.4.2021.
URL: https://developer.android.com/studio/features
3. Learn Android Studio, 25.4.2021.
URL: [http://barbra-coco.dyndns.org/student/learning_android_studio.pdf](http://barbra-coco.dyndns.org/student/learning_android_studio.pdf)
4. Maja Karaga, Marko Stojanović, Programiranje aplikacija za android, str 5
5. The Good and the Bad of Firebase Backend Services,
Url: https://www.altexsoft.com/blog/firebase-review-pros-cons-alternatives/
6. Firebase Realtime Database,
Url: https://firebase.google.com/docs/database
7. Java Tuturial,
Url: https://www.tutorialspoint.com/java/java_tutorial.pdf
8. Splash screen in android studio
Url:
https://static1.squarespace.com/static/601b49cf5d76be323d847d41/t/601b54304666534b7cc093
56/1612403761632/splash_screen_in_android_studio.pdf


Datum predaje rada:
(mentor je prihvatio izradbu)

Potpis mentora:

Ocjena pisanog rada:

Datum obrane rada:

Ocjena obrane rada:

**Konačna** ocjena:

Povjerenstvo:

1. mentor:
2. profesor struke:
3. profesor struke:

Prostor za izdvojeno mišljenje ili eventualni komentar:



