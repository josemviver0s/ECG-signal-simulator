
/**
 * Utilidad para generar diferentes tipos de ruido en señales.
 */
public class NoiseGenerator {

    public static double whiteNoise(double amplitude) {
        return (Math.random() - 0.5) * 2 * amplitude;
    }

    public static double powerLineNoise(double time, double amplitude) {
        return amplitude * Math.sin(2 * Math.PI * 60 * time); // 60 Hz
    }
}
