package Szereg;

// Przydziela zadania w kolejności od najdłuższych do maszyn o najmniejszym obciążeniu

import java.util.Comparator;
import java.util.List;

public class LPTScheduler extends Scheduler {

    public LPTScheduler(List<Task> tasks, List<Machine> machines) {
        super(tasks, machines);
    }

    @Override
    public void schedule() {
        // Sortuj zadania malejąco po czasie trwania
        tasks.sort(Comparator.comparingInt(Task::getDuration).reversed());

        // Przypisz każde zadanie do maszyny z najmniejszym łącznym obciążeniem
        for (Task task : tasks) {
            machines.stream()
                    .min(Comparator.comparingInt(Machine::getTotalLoad))
                    .ifPresent(machine -> machine.assignTask(task));
        }
    }
}
