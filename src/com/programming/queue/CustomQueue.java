package com.programming.queue;

public class CustomQueue {

	private Object[] dataArr;

	private int size;

	private int frontIndex;

	private int rearIndex;

	private enum RESIZE_ARGS {
		INCREASE_SIZE, DESCREASE_SIZE
	};

	public CustomQueue() {
		dataArr = new Object[16];
	}

	public void add(Object data) {

		if (checkSize()) {
			dataArr[rearIndex] = data;
			addObject();
		} else {
			resizeArray(RESIZE_ARGS.INCREASE_SIZE);
			dataArr[rearIndex] = data;
			addObject();
		}
	}

	private void addObject() {
		rearIndex++;
		size++;
	}

	private void resizeArray(RESIZE_ARGS resizeArgs) {

		switch (resizeArgs) {
		case INCREASE_SIZE:
			int dataArrLength = dataArr.length;
			dataArrLength = dataArrLength + ((int) (dataArrLength * 0.75));
			Object[] objectArr = new Object[dataArrLength];
			for (int i = 0; i < dataArr.length; i++) {
				objectArr[i] = dataArr[i];
			}
			dataArr = null;
			dataArr = objectArr;
			objectArr = null;
			break;
		case DESCREASE_SIZE:

			break;

		default:
			break;
		}
	}

	public Object remove() {

		if (frontIndex < size) {
			Object obj = dataArr[frontIndex];
			dataArr[frontIndex] = null;
			frontIndex++;
			return obj;
		} else {
			throw new IndexOutOfBoundsException("Index out of bound");
		}

	}

	private boolean checkSize() {
		return (rearIndex < size && rearIndex < dataArr.length ? true : false);
	}

}
