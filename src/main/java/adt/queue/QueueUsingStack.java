package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		try {
			stack1.push(element);
		} catch (StackOverflowException e) {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {

		try {

			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
	
			T result = stack2.pop();
	
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
	
			return result;

		} catch (StackOverflowException | StackUnderflowException e) {
			throw new QueueUnderflowException();
		}
		

		
	}

	@Override
	public T head() {

		if (isEmpty()) {
			return null;
		}

		T result = null;

		try {

			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
	
			result = stack2.top();
	
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
	
		} catch (StackOverflowException | StackUnderflowException e) {
			
		}

		return result;
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}

}
