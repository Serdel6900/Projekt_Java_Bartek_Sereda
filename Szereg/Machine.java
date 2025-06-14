package Szereg;

// Plik: Machine.java
// Klasa reprezentująca maszynę, na której wykonujemy zadania

import java.util.ArrayList;
import java.util.List;

public class Machine {
    private String name;                // Nazwa maszyny
    private List<Task> assignedTasks;  // Lista zadań przypisanych do maszyny

    // Konstruktor z walidacją nazwy
    public Machine(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nazwa maszyny nie może być pusta.");
        }
        this.name = name;
        this.assignedTasks = new ArrayList<>();
    }

    // Getter nazwy maszyny
    public String getName() {
        return name;
    }

    // Setter nazwy maszyny z walidacją
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nazwa maszyny nie może być pusta.");
        }
        this.name = name;
    }

    // Pobiera łączny czas pracy (sumę czasów wszystkich zadań)
    public int getTotalLoad() {
        int total = 0;
        for (Task task : assignedTasks) {
            total += task.getDuration();
        }
        return total;
    }

    // Przypisuje zadanie do maszyny
    public void assignTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Zadanie nie może być puste.");
        }
        assignedTasks.add(task);
    }

    // Pobiera listę zadań przypisanych do maszyny
    public List<Task> getAssignedTasks() {
        return new ArrayList<>(assignedTasks); // zwracamy kopię listy, by zachować hermetyzację
    }

    // Reprezentacja tekstowa maszyny z jej obciążeniem i zadaniami
    @Override
    public String toString() {
        return name + " [obciążenie: " + getTotalLoad() + "] " + assignedTasks;
    }
}
