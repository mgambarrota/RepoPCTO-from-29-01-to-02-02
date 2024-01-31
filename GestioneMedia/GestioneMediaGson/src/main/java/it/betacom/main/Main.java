package it.betacom.main;

import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.betacom.model.Audio;
import it.betacom.model.Foto;
import it.betacom.model.Media;
import it.betacom.model.Video;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.logging.Logger;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final LinkedList<Media> media = new LinkedList<>();
    private static final Logger logger = Logger.getLogger(Main.class.getName());



    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        boolean runnable = true;

        while (runnable){
            System.out.print("""
                Gestione della multimedialità
                1) Inserire nome del media
                2) Anteprima dei media
                3) Visualizza i media su file Json
                0) Esci dal programma
                >\s""");

            int decisione;
            try {
                decisione = in.nextInt();
                in.nextLine(); // Pulisci il buffer
            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Inserisci un numero.");
                in.nextLine(); // Pulisce il buffer
                continue;
            }

            switch (decisione) {
                case 0:
                    runnable = false;
                    System.out.println("\nArrivederci!");
                    break;
                case 1:
                    inserisciMedia();
                    System.out.println("\nElemento aggiunto alla lista!\n");
                    break;
                case 2:
                    if (!media.isEmpty()) {
                        System.out.println("\n" + gson.toJson(media) + "\n");
                    } else System.out.println("La lista dei media è vuota!\n");
                    break;
                case 3:
                    try {
                        if (!media.isEmpty()) {
                            PrintWriter writer = new PrintWriter("outList.json", StandardCharsets.UTF_8);
                            writer.println(gson.toJson(media));
                            writer.close();

                            System.out.println("\n" + ((media.size() > 1) ? "Stampati" : "Stampato") + "sul file 'outList.json' correttamente\n");
                        } else System.out.println("La lista dei media è vuota!\n");
                    }catch(IOException e){
                        logger.severe("\nErrore nella scrittura del file... (Permesso negato?)\n");
                    }
                    break;
                default:
                    System.out.println("\nDecisione non valida. Riprova.\n");
                    break;
            }
        }
        in.close();
    }
    private static void inserisciMedia(){
        int decisione = 0;
        boolean runnable = true;
        double dimensione = 0;
        String nome, formato;

        do {
            System.out.print("""
                    \nCosa vuoi inserire?
                    1) Foto
                    2) Audio
                    3) Video
                    >\s""");
            try {
                decisione = in.nextInt();
                in.nextLine(); // Pulisci il buffer
            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Inserisci un numero.");
                in.nextLine(); // Pulisce il buffer
            }
        } while (decisione < 1 || decisione > 3 );

        while (runnable) {
            System.out.print("Inserire dimensione in Megabyte> ");
            try {
                dimensione = in.nextDouble();
                in.nextLine(); // Pulisci il buffer
                runnable = false;
            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Inserisci un numero.");
                in.nextLine(); // Pulisce il buffer
                return;
            }
        }

        System.out.print("Inserire nome> ");
        nome = in.nextLine();

        System.out.print("Inserire formato> ");
        formato = in.nextLine();

        switch (decisione){
            case 1:
                inFoto(dimensione, nome, formato);
                break;
            case 2:
                inAudio(dimensione, nome, formato);
                break;
            case 3:
                inVideo(dimensione, nome, formato);
                break;
        }
    }

    private static void inFoto(double dimensione, String nome, String formato){
        int risoluzioneX = 0, risoluzioneY = 0;
        boolean runnable = true;

        while (runnable) {
            System.out.print("Inserire larghezza in pixel> ");
            try {
                risoluzioneX = in.nextInt();
                runnable = false;
            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Inserisci un numero.");
                in.nextLine(); // Pulisce il buffer
            }
        }
        runnable = true;
        while (runnable) {
            System.out.print("Inserire altezza in pixel> ");
            try {
                risoluzioneY = in.nextInt();
                runnable = false;
            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Inserisci un numero.");
                in.nextLine(); // Pulisce il buffer
            }
        }

        media.add(new Foto(dimensione, nome, risoluzioneX, risoluzioneY, formato));
    }

    private static void inAudio(double dimensione, String nome, String formato){
        int durata = 0;
        boolean runnable = true;

        while (runnable) {
            System.out.print("Inserire durata in secondi> ");
            try {
                durata = in.nextInt();
                runnable = false;
            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Inserisci un numero.");
                in.nextLine(); // Pulisce il buffer
            }
        }

        media.add(new Audio(dimensione, nome, formato, durata));
    }

    private static void inVideo(double dimensione, String nome, String formato){
        int durata = 0;
        boolean runnable = true;

        while (runnable) {
            System.out.print("Inserire durata in secondi> ");
            try {
                durata = in.nextInt();
                runnable = false;
            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Inserisci un numero.");
                in.nextLine(); // Pulisce il buffer
            }
        }

        media.add(new Video(dimensione, nome, formato, durata));
    }
}
