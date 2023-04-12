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
		T[] arrayAux = (T[]) new Comparable[array.length];
		mergeSort(array, arrayAux, leftIndex, rightIndex);
	}

	private void mergeSort(T[] array, T[] arrayAux, int inicio, int fim) {
		if(inicio < fim) {
			int meio = (inicio+fim)/2;
			mergeSort(array, arrayAux, inicio, meio);
			mergeSort(array, arrayAux, meio+1, fim);
			intercalar(array, arrayAux, inicio, meio, fim);
		}
		
	}

	private void intercalar(T[] array, T[] arrayAux, int inicio, int meio, int fim) {
		for(int k = inicio; k <= fim; k++) {
			arrayAux[k] = array[k];
		}
		
		int esquerda = inicio;
		int direita = meio+1;
		
		for(int i = inicio; i <= fim; i++) {
			if(esquerda > meio) {
				array[i] = arrayAux[direita++]; 
			} else if(direita > fim) {
				array[i] = arrayAux[esquerda++];
			} else if(arrayAux[esquerda].compareTo(arrayAux[direita]) < 0) {
				array[i] = arrayAux[esquerda++];
			} else {
				array[i] = arrayAux[direita++];
			}
		}
	}
}
