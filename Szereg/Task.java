package Szereg;

// Plik: Task.java
// Klasa reprezentująca pojedyncze zadanie do zaplanowania

public class Task {
    private String name;       // Nazwa zadania
    private int duration;      // Czas trwania zadania

    // Konstruktor główny – przypisuje bezpośrednio do pól
    public Task(String name, int duration) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nazwa zadania nie może być pusta.");
        }
        if (duration <= 0) {
            throw new IllegalArgumentException("Czas trwania musi być większy od zera.");
        }

        this.name = name;
        this.duration = duration;
    }

    // Przeciążony konstruktor – używa wartości domyślnych
    public Task() {
        this.name = "Zadanie domyślne";
        this.duration = 10;
    }

    // Getter nazwy zadania
    public String getName() {
        return name;
    }

    // Setter nazwy zadania
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nazwa zadania nie może być pusta.");
        }
        this.name = name;
    }

    // Getter czasu trwania
    public int getDuration() {
        return duration;
    }

    // Setter czasu trwania
    public void setDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("Czas trwania musi być większy od zera.");
        }
        this.duration = duration;
    }

    // Reprezentacja tekstowa zadania
    @Override
    public String toString() {
        return name + " (" + duration + ")";
    }
}
