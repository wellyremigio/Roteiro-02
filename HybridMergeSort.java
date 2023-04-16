package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 * //https://iq.opengenus.org/merge-insertion-sort/
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;
	
	public void sort(T[] array) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		sort(array, 0, array.length - 1);
	}

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && rightIndex < array.length && leftIndex >= 0) {
			if(rightIndex - leftIndex + 1 <= SIZE_LIMIT) {
				insertionSort(array, leftIndex, rightIndex);
				INSERTIONSORT_APPLICATIONS++;
			}else {
				mergeSort(array, leftIndex, rightIndex);
				MERGESORT_APPLICATIONS++;
			}
		}
	}
	
	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		int i = leftIndex + 1;
		while(i <= rightIndex) {
			int j = i;
			while(j > leftIndex && array[j].compareTo(array[j-1]) < 0) {
				Util.swap(array, j, j-1);
				j--;
			}
			i++;
		}
	}
	
	
	private void mergeSort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex >= rightIndex) {
			return;
		}else {
			int middle = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, middle);
			mergeSort(array, middle + 1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
		}
	}
	
	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		T[] arrayAux = (T[]) new Comparable[array.length];
		for(int i = leftIndex; i <= rightIndex; i++) {
			arrayAux[i] = array[i];
		}
		
		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;
		
		while(i <= middle && j <= rightIndex) {
			if(arrayAux[i].compareTo(arrayAux[j]) < 0 || arrayAux[i].compareTo(arrayAux[j]) == 0) {
				array[k++] = arrayAux[i++];
			}else {
				array[k++] = arrayAux[j++];
			}
		}
		
		while(i <= middle) {
			array[k++] = arrayAux[i++];
		}
		
		while(j <= rightIndex) {
			array[k++] = arrayAux[j++];
		}
	}
	
}
