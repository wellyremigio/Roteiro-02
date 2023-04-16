package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		mergeSort(array, leftIndex,rightIndex);
	}
	
	private void mergeSort(T[] array, int inicio, int fim) {
		if(inicio >= fim || array.length <= 0 || fim > array.length) {
			return;
		}else {
			int meio = (inicio + fim) / 2;
			mergeSort(array, inicio, meio);
			mergeSort(array, meio+1, fim);
			merge(array, inicio, meio, fim);
		}
	}
	
	private void merge(T[] array, int inicio, int meio, int fim) {
		T[] arrayAux = (T[]) new Comparable[array.length];
		for(int k = inicio; k <= fim; k++) {
			arrayAux[k] = array[k];
		}
		
		int i = inicio;
		int j = meio+1;
		int k = inicio;
		
		while(i <= meio && j <= fim) {
			if(arrayAux[i].compareTo(arrayAux[j]) < 0 || arrayAux[i].compareTo(arrayAux[j]) == 0) {
				array[k++] = arrayAux[i++];
			}else {
				array[k++] = arrayAux[j++];
			}
		}
		
		while(i <= meio) {
			array[k++] = arrayAux[i++];
		}
		
		while(j <= fim) {
			array[k++] = arrayAux[j++];
		}
	}
}
