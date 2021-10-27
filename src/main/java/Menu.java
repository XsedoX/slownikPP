

import Dictionary.Dictionary;
import Dictionary.DictionaryBuilder;
import JsonManagment.JsonManagment;
import LoadDictionaries.LoadDictionaries;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Menu
{
    private Scanner keyboard = new Scanner(System.in);
    private String opcja;
    private String jezyk;
    private String slowo;
    private Set<String> wordsList = new HashSet<>();
    private Dictionary newDictionary;
    private DictionaryBuilder dBuilder = new DictionaryBuilder();
    private JsonManagment jManagment = new JsonManagment();
    private Set<Dictionary> dictsSet;
    private LoadDictionaries lDirectiories = new LoadDictionaries();
    private Set<String> jezyki = new HashSet<>();
    private Integer iloscSlow = 0;

    public Menu()
    {
        do
        {
            System.out.println("Wybierz funkcje:");
            System.out.println("1 - wyszukiwanie slownikow po slowach");
            System.out.println("2 - Tworzenie nowego slownika.");
            System.out.println("0 - Wylaczenie programu.");
            opcja = keyboard.nextLine();

            switch (opcja) {
                case "1":
                    System.out.println("Wypisz slowa oddzielajac je enterem. Gdy wpiszesz 0, to wrocisz do menu.");
                    do {
                        slowo = keyboard.nextLine();
                        if(!slowo.equals("0"))
                        {
                            iloscSlow++;
                            try {
                                if(dictsSet!=null)
                                    dictsSet.clear();
                                dictsSet = lDirectiories.getDictsSet();
                                AtomicBoolean exists = new AtomicBoolean(false);
                                dictsSet.forEach(dict ->
                                        {
                                            if(dict.searchWord(slowo))
                                            {
                                                System.out.println(dict.getLanguage());
                                                jezyki.add(dict.getLanguage());
                                                exists.set(true);
                                            }
                                        });
                                if(!exists.get())
                                {
                                    System.out.println("Zaden slownik nie posiada tego slowa.");
                                    exists.set(false);
                                }


                            } catch (IOException e) {}
                        }


                    }while(!slowo.equals("0"));

                    PDFCreator PDF = new PDFCreator();
                    try {
                        PDF.createPDF(jezyki, iloscSlow);
                    } catch (IOException e) {}

                    iloscSlow=0;
                    if(jezyki!=null)
                        jezyki.clear();

                    System.out.println("Pomyslnie sie cofnales do menu.");
                    break;

                case "2":
                    System.out.println("Wpisz jezyk nowego slownika:");
                    jezyk = keyboard.nextLine();
                    System.out.println("Wypisuj slowa, ktore chcesz dodac do swojego slownika oddzielajac je enterem(Gdy wpiszesz 0, to zakonczy dodawanie slow i wrocisz do menu):");
                    if(wordsList!=null)
                        wordsList.clear();
                    do {
                        slowo = keyboard.nextLine();
                        if (!slowo.equals("0"))
                            wordsList.add(slowo);

                    } while (!slowo.equals("0"));

                    System.out.println("Pomyslnie sie cofnales do menu.");

                    newDictionary = dBuilder
                            .language(jezyk)
                            .wordsList(wordsList)
                            .build();
                    if(jManagment.serializeDict(newDictionary))
                        System.out.println("Dodano nowy slownik.");
                    else
                        System.out.println("Blad, nie udalo sie dodac nowego slownika.");

                    break;
                case "0":
                    System.out.println("Zamykam program");
                    return;
                default:
                    System.out.println("Blad! Nie wpisano ani 1 ani 2.");
            }
        }while(true);
    }
}
