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

	public void sort(T[] array, int leftIndex, int rightIndex) {
		T[] arrayAux = (T[]) new Comparable[array.length];
		
	}
	//https://iq.opengenus.org/merge-insertion-sort/
	
	private void intercalar(T[] array, T[] arrayAux, int leftIndex, int meio, int rightIndex) {
		for(int k = leftIndex; k <= rightIndex; k++) {
			arrayAux[k] = array[k];
		}
		
		int esquerda = leftIndex;
		int direita = meio+1;
		
		for(int i = leftIndex; i <= rightIndex; i++) {
			if(esquerda > meio) {
				array[i] = arrayAux[direita++];
			} else if(direita > rightIndex) {
				array[i] = arrayAux[esquerda++];
			} else if(arrayAux[esquerda].compareTo(arrayAux[direita]) < 0) {
				array[i] = arrayAux[esquerda++];
			} else {
				array[i] = arrayAux[direita++];
			}
		}
	}
	
	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for(int i = leftIndex + 1; i <= rightIndex; i++) {
			T chave = array[i];
			int j = i - 1;
			while(j >= 0 && array[j].compareTo(chave) > 0) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = chave;
		}
	}
}
