package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private Stack<Integer> stackTamanhoZero;
    private Stack<Integer> stackCheia;
    private Stack<Integer> stackVazia;

    @Before
    public void setUp() throws StackOverflowException{
        getImplementations();

        // Pilha com 5 elementos cheia
        stackCheia.push(1);
        stackCheia.push(2);
        stackCheia.push(3);
        stackCheia.push(4);
        stackCheia.push(5);
    }

    private void getImplementations() {
        this.stackCheia = new StackImpl<>(5);
        this.stackVazia = new StackImpl<>(4);
        this.stackTamanhoZero = new StackImpl<>(0);
    }

    // TESTES STACK CHEIA

    @Test(expected = StackOverflowException.class)
    public void testPushStackCheia() throws StackOverflowException {
        stackCheia.push(6);
    }

    @Test
    public void testTopStackCheia() throws StackUnderflowException {
        assertEquals(new Integer(5), stackCheia.pop());
    }

    @Test
    public void testPopStackCheia() throws StackUnderflowException {
        assertEquals(new Integer(5), (Integer) stackCheia.pop());
        assertEquals(new Integer(4), stackCheia.top());
    }

    @Test
    public void testNovoTopStackCheia() throws StackUnderflowException {
        assertEquals(new Integer(5), (Integer) stackCheia.pop());
        assertEquals(new Integer(4), stackCheia.top());
    }

    @Test
    public void testEhVaziaStackCheia() {
        assertFalse(stackCheia.isEmpty());
    }

    @Test
    public void testEhCheiaStackCheia() {
        assertTrue(stackCheia.isFull());
    }

    @Test
    public void testEhVaziaRemovendoTodosElementosStackCheia() throws StackUnderflowException {
        stackCheia.pop();
        stackCheia.pop();
        stackCheia.pop();
        stackCheia.pop();
        stackCheia.pop();
        assertTrue(stackCheia.isEmpty());
    }

    @Test
    public void testEhVaziaRemovendoQuaseTodosElementosStackCheia() throws StackUnderflowException {
        stackCheia.pop();
        stackCheia.pop();
        stackCheia.pop();
        stackCheia.pop();
        assertFalse(stackCheia.isEmpty());
    }

    // TESTES STACK VAZIA

    @Test(expected = StackUnderflowException.class)
    public void testPopStackVazia() throws StackUnderflowException {
        stackVazia.pop();
    }

    @Test
    public void testEhVaziaStackVazia() {
        assertTrue(stackVazia.isEmpty());
    }

    @Test
    public void testTopStackVazia() {
        assertEquals(null, stackVazia.top());
    }

    @Test
    public void testEhCheiaStackVazia() {
        assertFalse(stackVazia.isFull());
    }

    // TESTES STACK TAMANHO ZERO

    @Test(expected = StackUnderflowException.class)
    public void testPopStackTamanhoZero() throws StackUnderflowException {
        stackTamanhoZero.pop();
    }

    @Test(expected = StackOverflowException.class)
    public void testPushStackTamanhoZero() throws StackOverflowException {
        stackTamanhoZero.push(1);
    }

    @Test
    public void testEhVaziaStackTamanhoZero() {
        assertTrue(stackTamanhoZero.isEmpty());
    }

    @Test
    public void testTopStackTamanhoZero() {
        assertEquals(null, stackVazia.top());
    }

    
}
