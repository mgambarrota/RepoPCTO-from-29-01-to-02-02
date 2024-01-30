

import classiMultimediali.*;
import com.google.gson.Gson;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        LinkedList<Media> media = new LinkedList<>();

        while(true){
            int x;
            System.out.println("Gestione Media:\n1) Aggiungi\n2) Visualizza\n3) Esci\n");
            do { x = in.nextInt();
            } while(x>3 || x<1);
            //Aggiungi
            if (x == 1) {
                int y;
                System.out.println("Tipo media:\n1) Foto\n2) Audio\n3) Video\n");
                //input tipo media
                do {
                    y = in.nextInt();
                }while(y<1 || y>3);
                //input nome e dimensione
                double dimensione;
                System.out.print("Inserire nome: "); String nome = in.next();
                do {
                    System.out.print("Inserire dimensione: "); dimensione = in.nextDouble();
                } while(dimensione<1);
                //Foto
                if (y == 1) {
                    int altezza, larghezza;
                    //input altezza
                    do {
                        System.out.print("Inserire altezza: ");
                        altezza = in.nextInt();
                    }while(altezza<1);
                    //input larghezza
                    do {
                        System.out.print("Inserire larghezza: ");
                        larghezza = in.nextInt();
                    }while(larghezza<1);
                    //aggiungi Foto
                    media.add(new Foto(dimensione, nome, altezza, larghezza));
                //Audio
                } else if (y == 2) {
                    int durata;
                    //input durata
                    do {
                        System.out.print("Inserire durata: "); durata = in.nextInt();
                    }while(durata<1);
                    //aggiungi Audio
                    media.add(new Audio(dimensione, nome, durata));
                //Video
                } else if (y == 3) {
                    int durata;
                    //input durata
                    do {
                        System.out.print("Inserire durata: "); durata = in.nextInt();
                    }while(durata<1);
                    //input qualità
                    System.out.print("Inserire qualità: "); String qualità = in.next();
                    //aggiungi Video
                    media.add(new Video(dimensione, nome, durata, qualità));
                }
            //Visualizza
            } else if (x == 2) {
                //mostra ogni riga in gson
                try {
                    File fileJson = new File("Visualizzazione.json");
                    if (fileJson.createNewFile()) {
                        System.out.println("File creato: " + fileJson.getName());
                    } else {
                        System.out.println("File esistente.");
                    }
                    try {
                        FileWriter fileJsonScrittura = new FileWriter(fileJson);
                        fileJsonScrittura.write(new Gson().toJson(media));
                        fileJsonScrittura.close();
                    }
                    catch(IOException errore) {
                        System.out.println("Errore: scrittura file");
                    }
                } catch (IOException errore) {
                    System.out.println("Errore: creazione file");

                }

                System.out.println("Oggetto convertito in Json:\n " + new Gson().toJson(media));
            //Esci
            } else if (x == 3) {
                return;
            }
        }
    }
}