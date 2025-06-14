package Szereg;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Klasa BPPScheduler dziedziczy po klasie abstrakcyjnej Scheduler
public class BPPScheduler extends Scheduler {

    // Konstruktor przyjmujący listę zadań i maszyn
    public BPPScheduler(List<Task> tasks, List<Machine> machines) {
        super(tasks, machines);
    }

    // Implementacja metody schedule() zgodna z algorytmem BPP
    @Override
    public void schedule() {
        // Sortujemy zadania malejąco według czasu trwania (najdłuższe najpierw)
        Collections.sort(tasks, Comparator.comparingInt(Task::getDuration).reversed());

        // Przypisujemy każde zadanie do maszyny o najmniejszym aktualnym obciążeniu
        for (Task task : tasks) {
            machines.stream()
                    .min(Comparator.comparingInt(Machine::getTotalLoad))
                    .ifPresent(machine -> machine.assignTask(task));
        }
    }
}