
import java.util.List;
import java.util.Scanner;

/**
 * Aplicación principal del Simulador de Señales Biomédicas.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("   ECG SIGNAL SIMULATOR v1.0");
        System.out.println("   Ingeniería Biomédica / Electrónica");
        System.out.println("==========================================");

        System.out.println("\n--- SELECCIONE CONDICIÓN CLÍNICA ---");
        System.out.println("1. Paciente normal (70 BPM)");
        System.out.println("2. Taquicardia (120 BPM)");
        System.out.println("3. Bradicardia (45 BPM)");
        System.out.println("4. Personalizar");
        System.out.print("Opción: ");

        int option = scanner.nextInt();
        Patient patient;

        switch (option) {
            case 1:
                patient = new Patient("Juan Pérez", 35, "Normal");
                break;
            case 2:
                patient = new Patient("María Gómez", 28, "Taquicardia");
                break;
            case 3:
                patient = new Patient("Carlos Ruiz", 62, "Bradicardia");
                break;
            default:
                patient = new Patient("Personalizado", 40, "Normal");
                break;
        }

        System.out.println("\n" + patient.getInfo());

        System.out.print("Duración de la simulación (segundos, ej: 10): ");
        int duration = scanner.nextInt();

        System.out.print("Nivel de ruido (0 = limpio, 0.3 = moderado, 0.6 = ruidoso): ");
        double noise = scanner.nextDouble();

        ECGSignal ecg = new ECGSignal(patient.getSuggestedHeartRate(), 1.0, 500, noise);

        System.out.println("\n⏳ Generando señal ECG...");
        List<double[]> signalData = ecg.generateSignal(duration);

        String filename = String.format("ecg_%dbpm_%ds_ruido%.1f.csv",
                patient.getSuggestedHeartRate(), duration, noise);
        CSVExporter.exportECGSignal(signalData, filename, patient.getInfo());

        System.out.println("\n📁 Archivo generado: " + filename);
        System.out.println("📊 Puedes abrirlo en Excel y graficar la señal.");
        System.out.println("\n✅ Simulación completada.");

        scanner.close();
    }
}
