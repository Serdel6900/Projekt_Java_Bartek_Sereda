package Szereg;

// Abstrakcyjna klasa bazowa dla różnych algorytmów szeregowania zadań na maszynach

import java.util.List;

public abstract class Scheduler {
    protected List<Task> tasks;
    protected List<Machine> machines;

    public Scheduler(List<Task> tasks, List<Machine> machines) {
        if (tasks == null || machines == null) {
            throw new IllegalArgumentException("Lista zadań i maszyn nie może być null.");
        }
        this.tasks = tasks;
        this.machines = machines;
    }

    // Metoda abstrakcyjna do implementacji konkretnego algorytmu szeregowania
    public abstract void schedule();
}
