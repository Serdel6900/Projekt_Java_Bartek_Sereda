# Projekt - System do szeregowania zadań na maszynach równoległych - Bartłomiej Sereda

## System do zarządzania zadaniami na maszynach równoległych

### Opis
Aplikacja konsolowa napisana w Javie implementująca algorytmy szeregowania zadań (LPT i BPP) na maszynach równoległych. Umożliwia optymalne przydzielanie zadań do maszyn z uwzględnieniem czasu wykonania i obciążenia.

### Struktura aplikacji
- **Main** - klasa startowa uruchamiająca aplikację
- **TaskSchedulerApp** - główna klasa z interfejsem użytkownika i logiką zarządzania
- **Task** - klasa reprezentująca zadanie z polami: nazwa, czas wykonania (z walidacją)
- **Machine** - klasa reprezentująca maszynę z listą przypisanych zadań
- **Scheduler** (abstrakcyjna) - bazowa klasa dla algorytmów szeregowania
- **LPTScheduler** - implementacja algorytmu Longest Processing Time
- **BPPScheduler** - implementacja algorytmu Bin Packing Problem

### Algorytmy
1. **LPT (Longest Processing Time)**:
   - Sortuje zadania malejąco według czasu wykonania
   - Przydziela zadania do maszyn z najmniejszym aktualnym obciążeniem
   - Minimalizuje maksymalne obciążenie (makespan)

2. **BPP (Bin Packing Problem)**:
   - Sortuje zadania malejąco
   - Pakuje zadania do maszyn z uwzględnieniem maksymalnego obciążenia
   - Minimalizuje liczbę użytych maszyn

### Działanie
1. Uruchom klasę `Main`
2. Wybierz opcję z menu:
   - Dodaj nowe zadanie (nazwa + czas wykonania)
   - Wyświetl listę zadań
   - Utwórz maszyny
   - Wykonaj szeregowanie (LPT lub BPP)
   - Wyświetl wyniki
   - Zakończ program
3. Dane przechowywane w pamięci (ArrayList dla zadań, HashMap dla maszyn)
4. Program zawiera pełną walidację danych i obsługę wyjątków

### Wymagania
- Java 17+
- Środowisko IDE (IntelliJ, Eclipse) lub Maven do kompilacji

### Autor
Bartłomiej Sereda  
Uniwersytet Rzeszowski  
Informatyka i Ekonometria
Rok akademicki: 2024/2025
