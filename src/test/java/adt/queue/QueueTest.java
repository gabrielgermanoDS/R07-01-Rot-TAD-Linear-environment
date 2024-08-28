package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import adt.stack.StackOverflowException;

public class QueueTest {

    private Queue<Integer> queueTamanhoZero;
    private Queue<Integer> queueCheia;
    private Queue<Integer> queueVazia;

    @Before
    public void setUp() throws QueueOverflowException{
        getImplementations();

        // Queue com 5 elementos cheia
        queueCheia.enqueue(1);
        queueCheia.enqueue(2);
        queueCheia.enqueue(3);
        queueCheia.enqueue(4);
        queueCheia.enqueue(5);
        
    }

    private void getImplementations() {
        this.queueTamanhoZero = new CircularQueue<>(0);
        this.queueCheia = new CircularQueue<>(5);
        this.queueVazia = new CircularQueue<>(4);
    }

    // TESTES QUEUE CHEIA

    @Test(expected = QueueOverflowException.class)
    public void testEnqueueQueueCheia() throws QueueOverflowException {
        queueCheia.enqueue(6);
    }

    @Test
    public void testHeadQueueCheia() {
        assertEquals(new Integer(1), queueCheia.head());
    }

    @Test
    public void testDequeueQueueCheia() throws QueueUnderflowException {
        assertEquals(new Integer(1), queueCheia.dequeue());
    }

    @Test
    public void testDequeueNovaHeadQueueCheia() throws QueueUnderflowException {
        queueCheia.dequeue();
        assertEquals(new Integer(2), queueCheia.head());
    }


    @Test
    public void testEhCheiaQueueCheia() {
        assertTrue(queueCheia.isFull());
    }

    @Test
    public void testEhVaziaQueueCheia() {
        assertFalse(queueCheia.isEmpty());
    }

    // TESTES QUEUE VAZIA

    @Test(expected = QueueUnderflowException.class)
    public void testDequeueQueueVazia() throws QueueUnderflowException {
        queueVazia.dequeue();
    }

    @Test
    public void testHeadQueueVazia() {
        assertEquals(null, queueVazia.head());
    }

    @Test
    public void testHeadDepoisDeQueueQueueVazia() throws QueueOverflowException {
        queueVazia.enqueue(1);
        assertEquals(new Integer(1), queueVazia.head());
    }

    @Test
    public void testEhVaziaQueueVazia() {
        assertTrue(queueVazia.isEmpty());
    }

    @Test
    public void testEhCheiaQueueVazia() {
        assertFalse(queueVazia.isFull());
    }

    @Test
    public void testEnqueueNullQueueVazia() throws QueueOverflowException {
        queueVazia.enqueue(1);
        queueVazia.enqueue(null);
        assertEquals(new Integer(1), queueVazia.head());
    }


    // TESTES QUEUE TAMANHO ZERO
    @Test(expected = QueueUnderflowException.class)
    public void testDequeueQueueTamanhoZero() throws QueueUnderflowException {
        queueTamanhoZero.dequeue();
    }

    @Test(expected = QueueOverflowException.class)
    public void testEnqueueQueueTamanhoZero() throws QueueOverflowException {
        queueTamanhoZero.enqueue(1);
    }

    @Test
    public void testHeadQueueTamanhoZero() {
        assertEquals(null, queueTamanhoZero.head());
    }

    @Test
    public void testEhCheiaQueueTamanhoZero() {
        assertTrue(queueTamanhoZero.isFull());
    }

    @Test
    public void testEhVaziaQueueTamanhoZero() {
        assertTrue(queueTamanhoZero.isEmpty());
    }
    
}
