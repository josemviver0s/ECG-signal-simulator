
/**
 * Interfaz que define el comportamiento de cualquier señal biomédica.
 * Permite polimorfismo para futuras expansiones (EEG, EMG, etc.).
 */
public interface Signal {

    double getValueAtTime(double time); // Valor de la señal en un instante t

    String getSignalType();            // Tipo de señal (ECG, EEG, etc.)

    int getSamplingRate();            // Frecuencia de muestreo en Hz
}
