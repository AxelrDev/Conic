public class Mcm {
  /**
   * @brief Minimo común multiplo
   * @param a primer valor
   * @param b segundo valor
   * @return mcm de ambos valores
   */
  public double calculateMCM(double a, double b) {
    return (a * b) / calculateMCD(a, b);
  }
  /**
   * @brief Maximo común divisor
   * @param a primer valor
   * @param b segundo valor
   * @return MCD de ambos valores
   */
  private static double calculateMCD(double a, double b) {
    if (b == 0) {
        return a;
    }
    return calculateMCD(b, a % b);
  }
}
