public class PruebaCalculadora {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO PRUEBAS DE LA CALCULADORA ===\n");

        System.out.println("--- 1. Operaciones Simples ---");
        // Suma de enteros (deberían convertirse a Racional)
        probarExito("+ 1 2", "3R1"); 
        // Resta con racionales
        probarExito("- 3R2 1R2", "2R2"); // 2/2 (equivalente a 1)
        // Multiplicación
        probarExito("* 2R3 3R4", "6R12"); // 6/12 (equivalente a 1/2)
        // División
        probarExito("/ 1R2 2", "1R4"); // (1/2) / (2/1) = 1/4

        System.out.println("\n--- 2. Operaciones Prefijas Complejas ---");
        // (1/2 + 1/3) * 2 = 5/6 * 2 = 10/6 (o 5/3 simplificado)
        probarExito("* + 1R2 1R3 2", "10R6"); 
        
        // (3 - 1/2) / (1 + 1) = (5/2) / 2 = 5/4
        probarExito("/ - 3 1R2 + 1 1", "5R4"); 
        
        // ((2/3 * 3/2) + (5 - 4)) / 2 = (1 + 1) / 2 = 2/2 = 1
        probarExito("/ + * 2R3 3R2 - 5 4 2", "2R2");

        System.out.println("\n--- 3. Casos Límite y Errores (Deben fallar) ---");
        // Carácter inválido (letra 'a')
        probarError("+ 1R2 a");
        // Exceso de operadores (falta un número)
        probarError("+ + 1 2");
        // Exceso de números (falta un operador)
        probarError("+ 1 2 3");
        // Formato de racional inválido (dos 'R')
        probarError("+ 1RR2 3");
        // División por cero 
        probarError("/ 5 0"); 
        
        System.out.println("\n=== PRUEBAS FINALIZADAS ===");
    }

    /**
     * Prueba una expresión válida y compara el resultado con lo esperado.
     */
    private static void probarExito(String expresion, String esperado) {
        System.out.print("Evaluando: '" + expresion + "' -> ");
        try {
            // Llamamos al método estático de tu clase Calculadora
            Racional resultado = Calculadora.evaluarExpresion(expresion);
            
            // Comparamos el resultado usando el toString() de tu RacionalConEnteros
            System.out.println("Resultado: " + resultado + " | Esperado: [" + esperado + "]");
        } catch (Exception e) {
            System.out.println("[FALLÓ] Lanzó excepción inesperada: " + e.getMessage());
        }
    }

    /**
     * Prueba una expresión inválida asegurando que la calculadora lance un error
     * y no se rompa silenciosamente.
     */
    private static void probarError(String expresion) {
        System.out.print("Probando error en: '" + expresion + "' -> ");
        try {
            // Llamamos al método estático de tu clase Calculadora
            Racional resultado = Calculadora.evaluarExpresion(expresion);
            System.out.println("[FALLÓ] Debería haber lanzado un error, pero dio: " + resultado);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("[OK] Error capturado correctamente: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[ADVERTENCIA] Capturó un error, pero de un tipo no esperado: " + e.getClass().getSimpleName());
        }
    }
}