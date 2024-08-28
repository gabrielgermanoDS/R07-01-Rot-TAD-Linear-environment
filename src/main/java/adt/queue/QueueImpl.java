package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		if (isEmpty()) {
			return null;
		}

		return array[0];
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		return tail == (array.length - 1);
	}

	private void shiftLeft() {


		for (int i = 1; i <= tail; i++) {
			array[i - 1] = array[i];
		}

		// [1,2,3(tail)] -> [2, 3, null]
		if (isFull()) {
			array[tail] = null;
		}

	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		if (element == null) return;

		if (isFull()) {
			throw new QueueOverflowException();
		}

		tail = tail + 1;
		array[tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {

		if (isEmpty()) {
			throw new QueueUnderflowException();
		}

		T result = array[0];

		// [3] -> [null]
		if (array.length == 1) {
			array[0] = null;
			tail = tail - 1;
			return result;
		}

		
		shiftLeft();
		tail = tail - 1;

		return result;
	}

}
