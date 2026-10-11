package com.github.alesandrokr;


import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class StatsManager {
    private Map<String, Section> sections = new HashMap<>();

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final File sectionJson = new File("section.json");

    public StatsManager()
    {
        cargarDatos();
    }



    public Section getOrCreateSection(String name) {
        String key = name.toLowerCase();
        if (!sections.containsKey(key)) {
            sections.put(key, new Section(name));
            guardarDatos();
        }
        return sections.get(key);
    }

    public Map<String, Section> getSections() {
        return sections;
    }

    public void guardarDatos()
    {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(sectionJson, sections);
        } catch (IOException e) {
            System.out.println("Error al guardar lso datos: " + e.getMessage());
        }
    }

    public void cargarDatos()
    {
        if(sectionJson.exists())
        {
            try {
                sections = objectMapper.readValue(sectionJson, new TypeReference<Map<String,Section>>() { 
                });
            } catch (IOException e) {
                System.out.println("Error al cargar los datos: " + e.getMessage());
            }
        }
    }

}