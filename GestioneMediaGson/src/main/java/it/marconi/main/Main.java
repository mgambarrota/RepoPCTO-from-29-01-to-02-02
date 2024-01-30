package it.marconi.main;

import it.marconi.model.Audio;
import it.marconi.model.Foto;
import it.marconi.model.Media;
import it.marconi.model.Video;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        List<Media> media = new ArrayList<>();
        FileWriter file = new FileWriter("media.json");
        try {
            if (file.createNewFile()) {
                System.out.println("File creato correttamente");
            } else {
                System.out.println("Il file esiste già");
            }
        }
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1 - Inserisci i dati di un video");
            System.out.println("2 - Inserisci i dati di una foto");
            System.out.println("3 - Inserisci i dati di un audio");
            System.out.println("4 - Visualizza i media inseriti");
            System.out.println("5 - Esci");


            System.out.println("Scelta:");
            String scelta = scanner.next();

            String nomeMedia;
            String pesoMedia;
            String estensioneMedia;
            String autoreMedia;

            Gson gson = new Gson();
            String json = "";

            switch (scelta){
                case "1":
                    System.out.println("Nome media:");
                    nomeMedia = scanner.next();
                    System.out.println("Peso media:");
                    pesoMedia = scanner.next();
                    System.out.println("Estensione media:");
                    estensioneMedia = scanner.next();
                    System.out.println("Autore media:");
                    autoreMedia = scanner.next();
                    System.out.println("Risoluzione:");
                    String risoluzioneVideo = scanner.next();
                    System.out.println("Durata video:");
                    String durata = scanner.next();

                   Video v =  new Video(media.size() + 1, nomeMedia, pesoMedia, estensioneMedia, autoreMedia, risoluzioneVideo, durata);

                   json = gson.toJson(v);
                   try {
                       file.write(json);
                   } catch {

                }

                    break;
                case "2":
                    System.out.println("Nome media:");
                    nomeMedia = scanner.next();
                    System.out.println("Pesp media:");
                    pesoMedia = scanner.next();
                    System.out.println("Estensione media:");
                    estensioneMedia = scanner.next();
                    System.out.println("Autore media:");
                    autoreMedia = scanner.next();
                    System.out.println("Risoluzione foto:");
                    String risoluzioneFoto = scanner.next();
                    System.out.println("ISO:");
                    String ISO = scanner.next();
                    System.out.println("Lunghezza focale:");
                    String lunghezzaFocale = scanner.next();

                    media.add(new Foto(media.size() + 1, nomeMedia, pesoMedia, estensioneMedia, autoreMedia, risoluzioneFoto, ISO, lunghezzaFocale));

                    break;
                case "3":
                    System.out.println("Nome media:");
                    nomeMedia = scanner.next();
                    System.out.println("Peso media:");
                    pesoMedia = scanner.next();
                    System.out.println("Estensione media:");
                    estensioneMedia = scanner.next();
                    System.out.println("Autore media:");
                    autoreMedia = scanner.next();
                    System.out.println("Sample resolution:");
                    String sampleResolution = scanner.next();
                    System.out.println("Canale audio:");
                    String canaleAudio = scanner.next();
                    System.out.println("Frequenza:");
                    String frequenza = scanner.next();

                    media.add(new Audio(media.size() + 1, nomeMedia, pesoMedia, estensioneMedia, autoreMedia, sampleResolution, canaleAudio, frequenza));

                    break;
                case "4":

                    media.forEach(
                            m -> {
                                System.out.println(m.toString());
                            }
                    );

                    break;
                case "5":
                    return;
                default:
                    System.out.println("Scelta non valida. Riprova!");
                    break;
            }

        }
    }
}