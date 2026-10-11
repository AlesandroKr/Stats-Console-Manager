package com.github.alesandrokr;

import java.util.Map;

public class HelpCommand implements Command {

    private final Map<String, Command> commands;

    
    public HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(String[] args) {
        System.out.println("\n=== COMANDOS DISPONIBLES ===");
        System.out.println();

        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            
            Command cmd = entry.getValue();

            System.out.println(" > " + cmd.getUsage());
        }
        
        System.out.println("");
        System.out.println(" > exit → Termina la aplicación");
        System.out.println("");
        System.out.println("=============================\n");
    }

    @Override
    public String getUsage() {
        return "help";
    }
}