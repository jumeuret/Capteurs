package modele.generateur;

import modele.Bipper;
import modele.capteur.CapteurTemperatureActif;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GenerateurTemperatureCPU extends GenerateurTemperature {

    public GenerateurTemperatureCPU(CapteurTemperatureActif capteur, Bipper bipper){
        super(capteur, bipper);
    }

    public void change() {
        double temperature = 0;
        try {

            File fichier = new File("/sys/class/thermal");
            List<File> thermal_zones = new ArrayList<>();
            if (fichier.isDirectory()) {
                for (File fils : fichier.listFiles()) {
                    if (fils.getName().contains("thermal_zone")) {
                        thermal_zones.add(fils);
                    }
                }
            }

            for (File fich : thermal_zones) {
                for (File file : fich.listFiles()) {
                    if (file.getName().equals("type")) {
                        Scanner reader = new Scanner(file);
                        if (reader.nextLine().equals("x86_pkg_temp")) {
                            File temp = new File(String.format("/sys/class/thermal/%s/temp", fich.getName()));
                            Scanner lecteur = new Scanner(temp);
                            String ligne = lecteur.nextLine();
                            temperature = Double.parseDouble(ligne);
                            temperature = temperature / 1000;
                            lecteur.close();
                        }
                        reader.close();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        capteurTemp.setTemperature(temperature);
    }
}
