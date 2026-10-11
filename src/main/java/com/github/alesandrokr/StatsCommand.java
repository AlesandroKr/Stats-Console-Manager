package com.github.alesandrokr;

public class StatsCommand implements Command {
    private final StatsManager statsManager;

    public StatsCommand(StatsManager statsManager) {
        this.statsManager = statsManager;
    }

    @Override
    public void execute(String[] args) {
        System.out.println("\n=== ESTADÍSTICAS POR ZONA / HÁBITO ===");
        if (statsManager.getSections().isEmpty()) {
            System.out.println(" Aún no has registrado puntos o experiencia en ninguna zona.");
        } else {
            for (Section sec : statsManager.getSections().values()) {
                System.out.println(" • " + sec.toString() );
            }
        }
        System.out.println("=====================================\n");
    }

    @Override
    public String getUsage() {
        return "stats";
    }
}