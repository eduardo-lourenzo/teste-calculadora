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
    public void testAdicaoComNegativos() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(-5.0, -3.0, 'A');
        assertEquals(-8.0, result, 0.0001);
    }

    @Test
    public void testSubtracao() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(5.0, 3.0, 'S');
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testSubtracaoComNegativos() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(-5.0, -3.0, 'S');
        assertEquals(-2.0, result, 0.0001);
    }

    @Test
    public void testMultiplicacao() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(5.0, 3.0, 'M');
        assertEquals(15.0, result, 0.0001);
    }

    @Test
    public void testMultiplicacaoComNegativos() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(-5.0, -3.0, 'M');
        assertEquals(15.0, result, 0.0001);
    }

    @Test
    public void testMultiplicacaoComPositivoENegativo() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(-5.0, 3.0, 'M');
        assertEquals(-15.0, result, 0.0001);
    }

    @Test
    public void testDivisao() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(6.0, 3.0, 'D');
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testDivisaoComNegativos() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(-6.0, -3.0, 'D');
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testDivisaoComPositivoENegativo() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(-6.0, 3.0, 'D');
        assertEquals(-2.0, result, 0.0001);
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

    @Test
    public void testAdicaoComMaxValue() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(Double.MAX_VALUE, 2.0, 'A');
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0001);
        // Adição com MAX_VALUE causa overflow
    }

    @Test
    public void testAdicaoComMinValueENegativo() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(Double.MIN_VALUE, -2.0, 'A');
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.0001);
        // Adição com MAX_VALUE e com número negativo causa overflow
    }

    @Test
    public void testSubtracaoComMaxValueENegativo() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(Double.MAX_VALUE, -2.0, 'S');
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0001);
        // Subtração com MAX_VALUE e com número negativo causa overflow
    }

    @Test
    public void testSubtracaoComMinValue() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(Double.MIN_VALUE, 2.0, 'S');
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.0001);
        // Subtração com MIN_VALUE causa overflow
    }

    @Test
    public void testMultiplicacaoComMaxValue() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(Double.MAX_VALUE, 2.0, 'M');
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0001);
    }

    @Test
    public void testMultiplicacaoComMinValue() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(Double.MIN_VALUE, -2.0, 'M');
        assertEquals(Double.NEGATIVE_INFINITY * 2.0, result, 0.0001);
        // Multiplicação com MAX_VALUE e 2 causa overflow
    }

    @Test
    public void testDivisaoComMinValue() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(Double.MIN_VALUE, 2.0, 'D');
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.0001);
        // Divisão com MIN_VALUE e 2 causa overflow
    }

    @Test
    public void testDivisaoDeMaxValuePorMinValue() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(Double.MAX_VALUE, Double.MIN_VALUE, 'D');
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0001);
    }

    @Test
    public void testDivisaoDeMinValuePorMaxValue() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.calcular(Double.MIN_VALUE, Double.MAX_VALUE, 'D');
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.0001);
        // Divisão de MIN_VALUE por MAX_VALUE causa overflow
    }
}
