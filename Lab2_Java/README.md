# Lab2
Compulsory:
- am creat fiecare clasa;
- am creat constructorii folosind Insert Code...-> Constructor... iar aici am bifat ce aveam nevoie;
- am creat fiecare getter si setter folosind Refactor...-> Encapsulate Fields
- am creat toString folosind  Insert Code...-> toString()...;
- apoi in main am creat datele problemei si le-am afisat;

Optional:
- am creat equals folosind Insert Code...-> equals()...;
- am avut grija sa modific setSources si setDestionations de la Problem ca sa nu fie aduagate doua surse sau destinatii identice;
- am creat clasele Factory si Warehouse, iar clasa Source a devenit abstracta;
- am creat clasa solution;
- am creat clasa abstracta algorithm care este mostenita de clasa GreedyAlgorithm;
- solve din GreedyAlgorithm face urmatoarele lucruri:
  1. creaza o noua solutie;
  2. cat timp exista supply de oferit:
     1. cautam cea mai mica valoare din matricea cost cu functia minCoordonate;
     2. schimbam valoarea acelui element cu o valoare maxima pentru a nu mai fi gasita;
     3. apoi o sa avem 3 cazuri: daca supply-ul este mai mare decat demand-ul, daca supply-ul este mai mic si ultimul caz daca este egal cu demanand-ul;
     4. setam cate unitati primeste Dcolumn de la Srow, updatam Dcolumn si Srow;
     5. din nou la punctul 2;
  3. returnam solutia;
-am creat cateva doc comments in VogelAlgorithm;

Bonus:
- am creat clasa VogelAlgorithm pentru a rezolva problema cu "Vogel’s Approximation Method";
- solve din GreedyAlgorithm face urmatoarele lucruri:
  1. creaza o noua solutie;
  2. cat timp exista supply si demand:
     1. pentru fiecare linie si coloana in parte aflu diferenta absoluta dintre cele mai mici 2 elemente;
     2. aflu cea mai mare valoare dintre diferentele de pe linie si coloana;
     3. apoi o sa avem 3 cazuri: daca supply-ul este mai mare decat demand-ul, daca supply-ul este mai mic si ultimul caz daca este egal cu demanand-ul;
     4. setam cate unitati primeste Dcolumn de la Srow, updatam Dcolumn si Srow si daca nu mai avem demand sau supply la vreo linie sau coloana punem o valoare maxima 
        pentru a nu mai fi folosita;
     5. din nou la punctul 2;
  3. returnam solutia;
- in clasa Problem am creat functia publica RandomProblem() care are urmatorii pasi:
  1. generarea supply-ului si demand-ului total;
  2. generarea surcelor si supply-ului propriu;
  3. generarea destinatiilor si demand-ului propriu;
  4. setarea numelor surcelor, fiecare fiind de forma Si;
  5. setarea numelor destinatiilor,  fiecare fiind de forma Di;
  6. setarea costului;
