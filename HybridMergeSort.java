package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;

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
		
	private void mergeSort(T[] array, int leftIndex, int rightIndex) {
		int middle = (leftIndex + rightIndex) / 2;
		sort(array, leftIndex, middle);
		sort(array, middle+1, rightIndex);
		merge(array, leftIndex, middle, rightIndex);
	}
	
	private void merge(T[] array, int inicio, int meio, int fim) {
		@SuppressWarnings("unchecked")
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
	
	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for(int i = leftIndex+1; i <= rightIndex; i++) {
			T chave = array[i];
			int j = i-1;
			while(j >= 0 && array[j].compareTo(chave) > 0) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = chave;
		}
	}
	
	/*
	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for(int i = leftIndex+1; i <= rightIndex; i++) {
			//T chave = array[i];
			int j = i;
			while(j > 0 && array[j].compareTo(array[j-1]) < 0) {
				Util.swap(array, j, j-1);
				j--;
			}
		}
	}
	*/
}
