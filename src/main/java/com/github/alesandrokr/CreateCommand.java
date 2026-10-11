package com.github.alesandrokr;


public class CreateCommand implements Command {

    @Override
    public void execute(String[] args) {
        if (args.length < 3) {
            System.out.println("Error: Faltan argumentos");
            System.out.println(" ---------------------- ");
            System.out.println(" create section <name>");
            return;
        }

        String subCommand = args[1].toLowerCase();

        if (subCommand.equals("section")) {
            String zona = args[2].replace("\"", "");
            Section section = new Section(zona);
            System.out.println("Se creó con éxito la sección: " + section);
        } else {
            System.out.println(" Subcomando desconocido: " + subCommand);
        }
    }
    @Override
    public String getUsage() {
        return "create section <nombre>";
    }
}