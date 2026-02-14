
/**
 * Clase que representa un paciente y sus parámetros fisiológicos.
 */
public class Patient {

    private String name;
    private int age;
    private String condition; // Normal, Taquicardia, Bradicardia

    public Patient(String name, int age, String condition) {
        this.name = name;
        this.age = age;
        this.condition = condition;
    }

    public int getSuggestedHeartRate() {
        switch (condition.toLowerCase()) {
            case "taquicardia":
                return 120;
            case "bradicardia":
                return 45;
            default:
                return 70;
        }
    }

    public String getInfo() {
        return String.format("Paciente: %s | Edad: %d | Condición: %s | BPM: %d",
                name, age, condition, getSuggestedHeartRate());
    }
}
