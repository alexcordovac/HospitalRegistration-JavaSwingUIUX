/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Alex
 */
public class GenerarDatosRandom {

    List<String> nombresDoctor;

    public GenerarDatosRandom() {
        iniListaNombreDoctor();
    }

    private void iniListaNombreDoctor() {
        nombresDoctor = new ArrayList<>();
        nombresDoctor.add("Armando Arjona");
        nombresDoctor.add("Fabio Melendez");
        nombresDoctor.add("Brenda Trigo");
        nombresDoctor.add("Mariana Ruano");
        nombresDoctor.add("Xavier Salvador");
        nombresDoctor.add("Georgina Belda");
        nombresDoctor.add("Jesica Velasco");
        nombresDoctor.add("Avelino Manzano");
        nombresDoctor.add("Luca Galvan");
        nombresDoctor.add("Arsenio Plaza");
        nombresDoctor.add("Ainara Ramos");
        nombresDoctor.add("Milagros Vegas");
    }

    public String generarNombreDoctor() {
        int min = 0, max = nombresDoctor.size();
        Random random = new Random();
        int index = random.nextInt(max - min) + min;
        return "Dr. "+nombresDoctor.get(index);
    }

    public int generarNumeroConsultorio() {
        int min = 1, max = 100;
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}
