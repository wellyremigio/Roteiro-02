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
		if(leftIndex < rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middle);
			sort(array, middle+1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
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
			if(arrayAux[i].compareTo(arrayAux[j]) < 0){
				array[k] = arrayAux[i];
				i++;
			}else {
				array[k] = arrayAux[j];
				j++;
			}
			k++;
			
		}
		
		while (i <= meio) {
			array[k] = arrayAux[i];
			i++;
			k++;
		}
		while(j <= meio) {
			array[k] = arrayAux[j];
			j++;
			k++;
		}
	}
}
