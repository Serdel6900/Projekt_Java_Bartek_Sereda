package Szereg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskSchedulerApp {
    // Lista przechowująca zadania
    private static List<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Metoda startowa uruchamiająca menu główne
    public static void start() {
        while (true) {
            printMenu();
            String choice = scanner.nextLine();

            // Obsługa wyboru użytkownika
            switch (choice) {
                case "1" -> addTask(); // Dodaj zadanie
                case "2" -> showTasks(); // Pokaż zadania
                case "3" -> deleteTask(); // Usuń zadanie
                case "4" -> updateTask(); // Zaktualizuj zadanie
                case "5" -> runScheduler(new LPTScheduler(new ArrayList<>(tasks), createMachines())); // Algorytm LPT
                case "6" -> runScheduler(new BPPScheduler(new ArrayList<>(tasks), createMachines())); // Algorytm BPP
                case "0" -> {
                    System.out.println("Koniec programu.");
                    return;
                }
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    // Wyświetla menu użytkownika
    private static void printMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Dodaj zadanie");
        System.out.println("2. Pokaż zadania");
        System.out.println("3. Usuń zadanie");
        System.out.println("4. Zaktualizuj zadanie");
        System.out.println("5. Wykonaj szeregowanie (LPT)");
        System.out.println("6. Wykonaj szeregowanie (BPP)");
        System.out.println("0. Wyjście");
        System.out.print("Wybór: ");
    }

    // Dodaje nowe zadanie
    private static void addTask() {
        try {
            System.out.print("Nazwa zadania: ");
            String name = scanner.nextLine();
            System.out.print("Czas trwania (liczba całkowita > 0): ");
            int duration = Integer.parseInt(scanner.nextLine());
            tasks.add(new Task(name, duration));
            System.out.println("Zadanie dodane.");
        } catch (Exception e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }

    // Wyświetla listę zadań
    private static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Brak zadań.");
            return;
        }
        System.out.println("Lista zadań:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i)); // Indeks +1 dla użytkownika
        }
    }

    // Usuwa zadanie na podstawie numeru
    private static void deleteTask() {
        showTasks();
        if (tasks.isEmpty()) return;
        try {
            System.out.print("Podaj numer zadania do usunięcia: ");
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            Task removed = tasks.remove(index);
            System.out.println("Usunięto zadanie: " + removed);
        } catch (Exception e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }

    // Umożliwia aktualizację istniejącego zadania
    private static void updateTask() {
        showTasks();
        if (tasks.isEmpty()) return;
        try {
            System.out.print("Podaj numer zadania do aktualizacji: ");
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            Task task = tasks.get(index);

            System.out.print("Nowa nazwa (Enter aby pominąć): ");
            String name = scanner.nextLine();
            if (!name.isBlank()) task.setName(name);

            System.out.print("Nowy czas trwania (Enter aby pominąć): ");
            String durationStr = scanner.nextLine();
            if (!durationStr.isBlank()) {
                int duration = Integer.parseInt(durationStr);
                task.setDuration(duration);
            }

            System.out.println("Zaktualizowano zadanie.");
        } catch (Exception e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }

    // Tworzy listę maszyn na podstawie podanej liczby
    private static List<Machine> createMachines() {
        List<Machine> machines = new ArrayList<>();
        try {
            System.out.print("Podaj liczbę maszyn: ");
            int num = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < num; i++) {
                machines.add(new Machine("Maszyna " + (i + 1)));
            }
        } catch (Exception e) {
            System.out.println("Błąd: " + e.getMessage());
        }
        return machines;
    }

    // Wykonuje szeregowanie dla podanego algorytmu
    private static void runScheduler(Scheduler scheduler) {
        if (scheduler.machines.isEmpty()) {
            System.out.println("Nie utworzono żadnych maszyn.");
            return;
        }
        scheduler.schedule();
        System.out.println("\nWynik szeregowania:");
        scheduler.machines.forEach(System.out::println);
    }
}