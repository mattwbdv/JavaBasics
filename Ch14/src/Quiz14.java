
// Matt Koenig
// Monday February 11, 2019
// Quiz 14
// CS 211 

import java.util.*;

public class Quiz14 {

	public static Stack<Integer> mirror(Stack<Integer> s) {
		Stack<Integer> frontHalfStack = new Stack<Integer>();
		Stack<Integer> answer = new Stack<Integer>();
		Stack<Integer> repopulator = new Stack<Integer>();
		Queue<Integer> backHalfQueue = new LinkedList<Integer>();
		int size = s.size();

		// takes given stack and pushes it into multiple stacks and queues
		for (int i = 0; i < size; i++) {
			int temp = s.pop();
			frontHalfStack.push(temp);
			backHalfQueue.add(temp);
			repopulator.push(temp);

		}

		// uses regular stack to fill in the front half of the returned stack
		for (int i = 0; i < size; i++) {
			int temp = frontHalfStack.pop();
			answer.push(temp);
		}

		// uses back half queue to fill the mirrored back half of the returned stack
		for (int i = 0; i < size; i++) {
			int temp = backHalfQueue.remove();
			answer.push(temp);
		}

		// re-populates original stack
		for (int i = 0; i < size; i++) {
			int temp = repopulator.pop();
			s.push(temp);
		}

		return answer;

	}

	public static Queue<Integer> mirror(Queue<Integer> q) {
		Queue<Integer> frontHalfQueue = new LinkedList<Integer>();
		Queue<Integer> answer = new LinkedList<Integer>();
		Queue<Integer> repopulator = new LinkedList<Integer>();
		Stack<Integer> backHalfStack = new Stack<Integer>();
		int size = q.size();

		// takes given queue and pushes it into multiple stacks and queues
		for (int i = 0; i < size; i++) {
			int temp = q.remove();
			frontHalfQueue.add(temp);
			backHalfStack.push(temp);
			repopulator.add(temp);

		}

		// uses regular queue to fill in the front half of the returned queue
		for (int i = 0; i < size; i++) {
			int temp = frontHalfQueue.remove();
			answer.add(temp);
		}

		// uses back half stack to fill the mirrored back half of the returned queue
		for (int i = 0; i < size; i++) {
			int temp = backHalfStack.pop();
			answer.add(temp);
		}

		// re-populates original queue
		for (int i = 0; i < size; i++) {
			int temp = repopulator.remove();
			q.add(temp);
		}

		return answer;

	}
}
