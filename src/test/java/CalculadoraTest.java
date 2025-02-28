import br.edu.zup.Calculadora;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculadoraTest {
    @Test
    public void testAdicao() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(5.0, 3.0, 'A');
        assertEquals(8.0, result, 0.0001);
    }

    @Test
    public void testSubtracao() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(5.0, 3.0, 'S');
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testMultiplicacao() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(5.0, 3.0, 'M');
        assertEquals(15.0, result, 0.0001);
    }

    @Test
    public void testDivisao() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(6.0, 3.0, 'D');
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testDivisaoPorZero() {
        Calculadora calculadora = new Calculadora();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcular(6.0, 0.0, 'D');
        });
        assertEquals("Não é possível dividir por zero.", exception.getMessage());
    }

    @Test
    public void testOperacaoInvalida() {
        Calculadora calculadora = new Calculadora();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcular(6.0, 3.0, 'X');
        });
        assertEquals("Operação inválida.", exception.getMessage());
    }
}
