package com.github.alesandrokr;

public class AddCommand implements Command {
    private final StatsManager statsManager;

    public AddCommand(StatsManager statsManager) {
        this.statsManager = statsManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 3) {
            System.out.println("Error: Faltan argumentos.");
            System.out.println("Uso: add exp <cantidad> <zona>");
            System.out.println("     add point <cantidad> <zona>");
            return;
        }

        String subCommand = args[1].toLowerCase();

        try {
            int cantidad = Integer.parseInt(args[2]);
            
            String zonaNombre = (args.length >= 4) ? args[3].replace("\"", "") : "General";

            
            Section section = statsManager.getOrCreateSection(zonaNombre);

            if (subCommand.equals("exp")) {
                section.addExp(cantidad);
                System.out.println(" + " + cantidad + " EXP añadida a [" + section.getName() + "]. Total: " + section.getExperiency());
            } else if (subCommand.equals("point")) {
                section.addPoints(cantidad);
                System.out.println(" + " + cantidad + " Puntos añadidos a [" + section.getName() + "]. Total: " + section.getPoints());
            } else {
                System.out.println(" Subcomando no reconocido: " + subCommand);
            }

        } catch (NumberFormatException e) {
            System.out.println(" Error: La cantidad debe ser un número entero válido.");
        }
    }

    @Override
    public String getUsage() {
        return "add exp <cantidad> <zona>\n       add point <cantidad> <zona>";
    }
}