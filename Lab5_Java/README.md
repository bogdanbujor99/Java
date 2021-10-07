Compulsory:
- am creat clasa abstracta Item, apoi clasele Song si Movie care mostenesc Item, iar apoi Catalog, care contine o lista de Item.
- in Catalog am creat metodele: findByName, add si list;
- am creat clasa InvalidCatalogException;
- am creat clasa CatalogUtil cu metodele save,play si load impreuna cu mostenirile aferente de exceptii;
- am creat functiile testCreateSave , testLoadView care verifica exceptiile create;

Optional:
- am creat o functie read care citeste de la tastatura ce item doreste sa adauge utilizatorul;
- am creat clasa abstracta Command care este mostenite de mai multe clase fiecare avand o metoda proprie (add, list, save, load, play, report);
- am creat nume.ftl unde am scris codul html si folosind report si FreeMarker am creat pagina report.html in care afisez detaliile desre un catalog;
- am creat exceptia Invalid care daca utilizatorul nu da o comanda existenta, atunci sa ii fie aruncat un mesaj;
- aplicatia se afla la adresa : Lab5_Java-1.0-SNAPSHOT.jar;
- se executa sub forma java jar Lab5_Java-1.0-SNAPSHOT.jar;
