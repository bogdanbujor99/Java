# Lab3
Compulsory:
- am creat clasa abstracta Location cu metoda compareTo;
- am creat interfetele Visitable, Payable, Classifiable;
- am creat clasele City, Hotel, Museum, Church, Restaurant;
- am facut ca ordonarea cu ajutorul lui compareTo din Location;
- am creat Map cu timpul de la o locatie la alta;
- si am creat un exemplu de problema;

Optional:
- la prima cerinta:
  1. caut locatiile care are sunt visitabile, dar nu si payable;
  2. in functie de orele de deschidere cu ajutorul unui compareTo sortez locatiile si apoi le afisez;
- la a doua cerinta am creat o metota default care returneaza o ora de deschidere si una care retuneaza ora de inchidere;
- la a treia cerinta am creat metoda statica getVisitingDuration si mai apoi:
  1. daca se inchide la miezeul noptii adaug 24 de ore la diferenta ca sa fiseze timpul corect
  2. daca se deschide la miezeul noptii adaug 24 de ore la diferenta ca sa fiseze timpuul corect
  3. altfel fac doar diferenta
- la a patra cerinta am creat clasa TravelPlan care are un oras si adaug locatii in fucntie de preferinte , avand grija ca acele locatii sa existe in oras;
- la ultima cerinta am creat 3 functii:
  1. minDistance : returnez pozitia unde se afla nodul cu distanta cea mai mica care nu este inclus in graful meu;
  2. dijkstra:  
    a. setez distantele pe infinit si incluziunile in shortest path pe false;  
    b. caut min = pozitia unde se afla nodul cu cea mai mica distanta cautand-o cu ajutorul functiei minDistance;  
    c. included[min] = true; // il trecem ca inclus;  
    d. apoi voi schimba valoarea distantei a varfurilor adiacente daca:nu a fost deja inclus nodul sau daca valoarea ar fi mai mica decat valoarea curenta;  
    e. afisez distanta minima intre cele doua locatii;  
  3. shortestPath care va apela dijkstra pentru a afla distanta minima intre locatiile preferate in functie de ordine;
