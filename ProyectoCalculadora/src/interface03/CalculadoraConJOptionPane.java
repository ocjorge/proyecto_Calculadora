package interface03;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Jorge
 */
public class CalculadoraConJOptionPane {

    public static void main(String[] args) {
         List<String> numerosIngresados = new ArrayList<>();

        System.out.println("\n------------- Calculadora Aritmetica---------");

        ingresarNumeros(numerosIngresados);

        if (numerosIngresados.size() < 2) {
            JOptionPane.showMessageDialog(null, "Se deben ingresar al menos dos números para realizar una operación.");
        } else {
            realizarOperacion(numerosIngresados);
        }
    }

    public static void ingresarNumeros(List<String> numerosIngresados) {
        while (true) {
            String entrada = JOptionPane.showInputDialog("Ingrese un número o escriba 'fin' para terminar");
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }

            if (esNumeroValido(entrada)) {
                numerosIngresados.add(entrada);
            } else {
                JOptionPane.showMessageDialog(null, "No ha ingresado un número válido.");
            }
        }
    }

    public static void realizarOperacion(List<String> numeros) {
        int opcion;
        do {
            String entrada = JOptionPane.showInputDialog("¿Qué operación desea realizar?\n1. Suma\n2. Resta\n3. Multiplicación\n4. División");
            opcion = Integer.parseInt(entrada);

            if (opcion >= 1 && opcion <= 4) {
                try {
                    double resultado = 0;

                    switch (opcion) {
                        case 1:
                            resultado = realizarOperacion(numeros, "suma");
                            break;
                        case 2:
                            resultado = realizarOperacion(numeros, "resta");
                            break;
                        case 3:
                            resultado = realizarOperacion(numeros, "multiplica");
                            break;
                        case 4:
                            resultado = realizarOperacion(numeros, "divide");
                            break;
                    }

                    JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);
                } catch (ArithmeticException e) {
                    JOptionPane.showMessageDialog(null, "No se puede dividir por cero.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion < 1 || opcion > 4);
    }

    public static double realizarOperacion(List<String> numeros, String operacion) {
        Object[] valores = numeros.toArray();

        if (sonEnteros(valores) && valores.length == 2) {
            int n1 = Integer.parseInt((String) valores[0]);
            int n2 = Integer.parseInt((String) valores[1]);
            return aplicarOperacion(operacion, n1, n2);
        } else if (sonDobles(valores) && valores.length == 2) {
            double n1 = Double.parseDouble((String) valores[0]);
            double n2 = Double.parseDouble((String) valores[1]);
            return aplicarOperacion(operacion, n1, n2);
        } else if (sonEnteros(valores)) {
            int[] nums = Arrays.stream(valores).mapToInt(val -> Integer.parseInt((String) val)).toArray();
            return aplicarOperacion(operacion, nums);
        } else {
            double[] nums = Arrays.stream(valores).mapToDouble(val -> Double.parseDouble((String) val)).toArray();
            return aplicarOperacion(operacion, nums);
        }
    }

    public static double aplicarOperacion(String operacion, int n1, int n2) {
        CalculadoraBasica calculadora = new CalculadoraBasica();
        switch (operacion) {
            case "suma":
                return calculadora.suma(n1, n2);
            case "resta":
                return calculadora.resta(n1, n2);
            case "multiplica":
                return calculadora.multiplica(n1, n2);
            case "divide":
                return calculadora.divide(n1, n2);
            default:
                return 0;
        }
    }

    public static double aplicarOperacion(String operacion, double n1, double n2) {
        CalculadoraBasica calculadora = new CalculadoraBasica();
        switch (operacion) {
            case "suma":
                return calculadora.suma(n1, n2);
            case "resta":
                return calculadora.resta(n1, n2);
            case "multiplica":
                return calculadora.multiplica(n1, n2);
            case "divide":
                return calculadora.divide(n1, n2);
            default:
                return 0;
        }
    }

    public static double aplicarOperacion(String operacion, int[] nums) {
        CalculadoraBasica calculadora = new CalculadoraBasica();
        switch (operacion) {
            case "suma":
                return calculadora.suma(nums);
            case "resta":
                return calculadora.resta(nums);
            case "multiplica":
                return calculadora.multiplica(nums);
            case "divide":
                return calculadora.divide(nums);
            default:
                return 0;
        }
    }

    public static double aplicarOperacion(String operacion, double[] nums) {
        CalculadoraBasica calculadora = new CalculadoraBasica();
        switch (operacion) {
            case "suma":
                return calculadora.suma(nums);
            case "resta":
                return calculadora.resta(nums);
            case "multiplica":
                return calculadora.multiplica(nums);
            case "divide":
                return calculadora.divide(nums);
            default:
                return 0;
        }
    }

    public static boolean sonEnteros(Object[] valores) {
        for (Object valor : valores) {
            if (!esEntero((String) valor)) {
                return false;
            }
        }
        return true;
    }

    public static boolean sonDobles(Object[] valores) {
        for (Object valor : valores) {
            if (!esDouble((String) valor)) {
                return false;
            }
        }
        return true;
    }

    public static boolean esEntero(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean esDouble(String valor) {
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean esNumeroValido(String valor) {
        return esEntero(valor) || esDouble(valor);
    }
}
    