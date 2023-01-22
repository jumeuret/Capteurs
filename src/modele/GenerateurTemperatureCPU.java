package modele;

import java.io.IOException;
import java.util.Random;

public class GenerateurTemperatureCPU extends GenerateurTemperature {

    public GenerateurTemperatureCPU(CapteurTemperatureActif capteur, Bipper bipper){
        super(capteur, bipper);
    }

    public void change() throws IOException {
        ProcessBuilder bash = new ProcessBuilder();
        bash.command("cd", "cd /sys/class/thermal/", "ls | grep 'thermal_zone'");
        Process result = bash.start();
        System.out.println(result.getOutputStream());
    }
}
