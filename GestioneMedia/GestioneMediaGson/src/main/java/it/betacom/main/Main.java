package it.betacom.main;

import java.io.*;
import com.google.gson.Gson;
import it.betacom.model.Audio;
import it.betacom.model.Foto;
import it.betacom.model.Media;
import it.betacom.model.Video;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final LinkedList<Media> media = new LinkedList<>();

    public static void main(String[] args) {
        Gson gson = new Gson();
        boolean running = true;

        while (running){
            System.out.print("""
                Gestione della multimedialità
                1) Inserire nome del media
                2) Visualizza i nomi di media
                0) Esci dal programma
                >\s""");

            int decisione = -1;
            try {
                decisione = in.nextInt();
                in.nextLine(); // Consuma il resto della riga dopo il numero
            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Inserisci un numero.");
                in.nextLine(); // Pulisce il buffer
                continue;
            }

            switch (decisione) {
                case 0:
                    running = false;
                    break;
                case 1:
                    inserisciMedia();
                    break;
                case 2:
                    try {
                        PrintWriter writer = new PrintWriter("list.json", "UTF-8");
                        writer.println(gson.toJson(media));
                        /*media.forEach(
                                m -> {
                                    writer.println(gson.toJson(m));
                                }
                        );*/
                        writer.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Decisione non valida. Riprova.");
                    break;
            }
        }
        in.close();
    }

    private static void inserisciMedia(){
        int decisione = 0;
        double dimensione = 0;
        String nome = null, formato = null;

        do {
            System.out.print("""
                    Cosa vuoi inserire?
                    1) Foto
                    2) Audio
                    3) Video
                    >\s""");
            try {
                decisione = in.nextInt();
                in.nextLine(); // Consuma il resto della riga dopo il numero
            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Inserisci un numero.");
                in.nextLine(); // Pulisce il buffer
                continue;
            }
        } while (decisione < 1 || decisione > 3 );

        System.out.print("Inserire dimensione in Megabyte> ");
        try {
            dimensione = in.nextDouble();
            in.nextLine(); // Consuma il resto della riga dopo il numero
        } catch (InputMismatchException e) {
            System.out.println("Input non valido. Inserisci un numero.");
            in.nextLine(); // Pulisce il buffer
            return;
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
        System.out.println("\nElemento aggiunto alla lista!\n");
    }

    private static void inFoto(double dimensione, String nome, String formato){
        int risoluzioneX = 0, risoluzioneY = 0;

        System.out.print("Inserire larghezza in pixel> ");
        try {
            risoluzioneX = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input non valido. Inserisci un numero.");
            in.nextLine(); // Pulisce il buffer
            return;
        }

        System.out.print("Inserire altezza in pixel> ");
        try {
            risoluzioneY = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input non valido. Inserisci un numero.");
            in.nextLine(); // Pulisce il buffer
            return;
        }

        media.add(new Foto(dimensione, nome, risoluzioneX, risoluzioneY, formato));
    }

    private static void inAudio(double dimensione, String nome, String formato){
        int durata = 0;

        System.out.print("Inserire durata in secondi> ");
        try {
            durata = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input non valido. Inserisci un numero.");
            in.nextLine(); // Pulisce il buffer
            return;
        }

        media.add(new Audio(dimensione, nome, formato, durata));
    }

    private static void inVideo(double dimensione, String nome, String formato){
        int durata = 0;

        System.out.print("Inserire durata in secondi> ");
        try {
            durata = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input non valido. Inserisci un numero.");
            in.nextLine(); // Pulisce il buffer
            return;
        }

        media.add(new Video(dimensione, nome, formato, durata));
    }
}
