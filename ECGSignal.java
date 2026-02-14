
import java.util.ArrayList;
import java.util.List;

/**
 * Simulador de señal de electrocardiograma (ECG). Genera latidos cardíacos
 * sintéticos basados en: - Frecuencia cardíaca (BPM) - Amplitud del complejo
 * QRS - Ruido añadido
 */
public class ECGSignal implements Signal {

    private int heartRate;          // Latidos por minuto (BPM)
    private double amplitude;       // Amplitud máxima del pico R (mV)
    private double samplingRate;    // Puntos por segundo (Hz)
    private double noiseLevel;      // Nivel de ruido (0 = limpio, 0.5 = ruidoso)

    public ECGSignal(int heartRate, double amplitude, double samplingRate, double noiseLevel) {
        this.heartRate = heartRate;
        this.amplitude = amplitude;
        this.samplingRate = samplingRate;
        this.noiseLevel = noiseLevel;
    }

    @Override
    public double getValueAtTime(double time) {
        double heartPeriod = 60.0 / heartRate; // Periodo entre latidos (segundos)

        // Posición dentro del ciclo cardíaco (0 a 1)
        double tCycle = (time % heartPeriod) / heartPeriod;

        double ecgValue = 0.0;

        // Simular complejo QRS (pico R)
        if (tCycle < 0.1) { // 10% del ciclo es el pico
            ecgValue = amplitude * Math.sin(Math.PI * tCycle * 10);
        } else if (tCycle < 0.2) { // Onda T
            ecgValue = 0.3 * amplitude * Math.sin(Math.PI * (tCycle - 0.1) * 10);
        } else {
            ecgValue = 0.05 * amplitude; // Línea base
        }

        // Añadir ruido aleatorio controlado
        if (noiseLevel > 0) {
            ecgValue += (Math.random() - 0.5) * noiseLevel * amplitude;
        }

        return ecgValue;
    }

    @Override
    public String getSignalType() {
        return "ECG";
    }

    @Override
    public int getSamplingRate() {
        return (int) samplingRate;
    }

    public List<double[]> generateSignal(int duration) {
        List<double[]> signalData = new ArrayList<>();
        double dt = 1.0 / samplingRate; // Intervalo de muestreo

        for (double t = 0; t < duration; t += dt) {
            double value = getValueAtTime(t);
            signalData.add(new double[]{t, value});
        }

        return signalData;
    }
}
