package eva;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import models.Contacto;
import models.Persona;

public class PersonaController {
    public Set<Persona> filtrarYOrdenar(int edadMinima) {
         Set<Persona> tablaCompleta = new TreeSet<>(
                (c1, c2) -> {
                    
                    if (c1.getNombre().equalsIgnoreCase(c2.getNombre()) && c1.getEdad() == c2.getEdad()) {
                        return 0;
                    }
                    return Integer.compare(c2.getEdad(), c1.getEdad());
                });

        
        Set<String> setJoven = new LinkedHashSet<>();
        Set<String> setAdulto = new LinkedHashSet<>();
        Set<String> setMayor = new LinkedHashSet<>();
        for (Persona persona : tablaCompleta) {

            if (persona.getEdad() < 30) {
                setJoven.add(primerNombre(persona.getNombre()));
            } else if (persona.getEdad() < 60) {
                setAdulto.add(primerNombre(persona.getNombre()));
            } else {
                setMayor.add(primerNombre(persona.getNombre()));
            }
        }

        Map<String, Set<String>> mapa = new TreeMap<>();

        mapa.put("Joven", setJoven);
        mapa.put("Adulto", setAdulto);
        mapa.put("Mayor", setMayor);

        return null;
    }
   
    

    public Map<String, Set<String>> agruparPorEdad(List<Persona> personas) {
        // RETORNAR CINTACTOS UNICOS
        Set<Persona> tablaCompleta = new TreeSet<>(
                (c1, c2) -> {
                    if (primerNombre(c1.getNombre()).equals(primerNombre(c2.getNombre()))) {
                        return 0;
                    }
                    return Integer.compare(c1.getEdad(), c2.getEdad());
                });

        for (Persona persona : personas) {
            tablaCompleta.add(persona);
        }

        Set<String> setJoven = new TreeSet<>();
        Set<String> setAdulto = new TreeSet<>();
        Set<String> setMayor = new TreeSet<>();
        for (Persona persona : tablaCompleta) {

            if (persona.getEdad() < 30) {
                setJoven.add(primerNombre(persona.getNombre()));
            } else if (persona.getEdad() < 60) {
                setAdulto.add(primerNombre(persona.getNombre()));
            } else {
                setMayor.add(primerNombre(persona.getNombre()));
            }
        }

        Map<String, Set<String>> mapa = new TreeMap<>();

        mapa.put("Joven", setJoven);
        mapa.put("Adulto", setAdulto);
        mapa.put("Mayor", setMayor);

        return mapa;
    }
    public String primerNombre(String nombreCompleto) {
        return nombreCompleto.split(" ")[0];
    }

}