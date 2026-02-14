
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Exportador de señales a formato CSV para análisis en Excel.
 */
public class CSVExporter {

    public static boolean exportECGSignal(List<double[]> signalData, String filename, String patientInfo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            writer.write("# ECG Signal Simulation");
            writer.newLine();
            writer.write("# " + patientInfo);
            writer.newLine();
            writer.write("# Tiempo (s), Voltaje (mV)");
            writer.newLine();

            for (double[] point : signalData) {
                writer.write(String.format("%.4f,%.4f", point[0], point[1]));
                writer.newLine();
            }

            System.out.println("✅ Señal ECG exportada: " + filename);
            return true;

        } catch (IOException e) {
            System.out.println("❌ Error al exportar: " + e.getMessage());
            return false;
        }
    }
}
