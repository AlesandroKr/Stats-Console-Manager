package com.github.alesandrokr;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static boolean keepRunning = true;
    
    static StatsManager statsManager = new StatsManager();


    private static final Map<String, Command> commands = new HashMap<>();

    public static void main(String[] args) {
        
        commands.put("add", new AddCommand(statsManager));
        commands.put("create", new CreateCommand());
        commands.put("stats", new StatsCommand(statsManager));
        commands.put("help", new HelpCommand(commands));

        Scanner scanner = new Scanner(System.in);

        System.out.println("\033c");
        
        System.out.println("");
        System.out.println("=== SISTEMA DE CONSOLA DE ESTADÍSTICAS ===");
        System.out.println("");
        System.out.println("Escribe 'help' para ver los comandos disponibles.\n");
        System.out.println(""); 

        while (keepRunning) {
            System.out.print("> ");
            String linea = scanner.nextLine().trim();

            if (linea.isEmpty()) continue;

            String[] partes = linea.split("\\s+(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            processCommand(partes);
        }

        scanner.close();
        System.out.println("\n¡Proceso finalizado!");
    }

    private static void processCommand(String[] args) {
        String mainCommand = args[0].toLowerCase();

        if (mainCommand.equals("exit")) {
            keepRunning = false;
            return;
        }

        Command command = commands.get(mainCommand);

        if (command != null) {
            command.execute(args);
        } else {
            System.out.println(" Comando no reconocido. Escribe 'help' para ver la lista.");
        }
    }
}