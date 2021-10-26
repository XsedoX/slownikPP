

import Dictionary.Dictionary;
import Dictionary.DictionaryBuilder;
import JsonManagment.JsonManagment;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu
{
    private Scanner keyboard = new Scanner(System.in);
    private String opcja;
    private String jezyk;
    private String slowo;
    private List<String> wordsList = new ArrayList<>();
    private Dictionary newDictionary;
    private DictionaryBuilder dBuilder = new DictionaryBuilder();
    private JsonManagment jManagment = new JsonManagment();

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
                    break;

                case "2":
                    System.out.println("Wpisz jezyk nowego slownika:");
                    jezyk = keyboard.nextLine();
                    System.out.println("Wypisuj slowa, ktore chcesz dodac do swojego slownika oddzielajac je enterem(Gdy wpiszesz 0, to zakonczy dodawanie slow i wrocisz do menu):");
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
                    break;
                case "0":

                    System.out.println("Zamykam program");
                    break;
                default:
                    System.out.println("Blad! Nie wpisano ani 1 ani 2.");
            }
        }while(true);
    }
}
