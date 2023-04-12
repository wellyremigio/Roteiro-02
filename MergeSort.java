package ordenacao;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] vetor = {4, 6, 7, 3, 5, 1, 2, 8};
		int[] vetorAux = new int[vetor.length];
		
		mergeSort(vetor, vetorAux, 0, vetor.length-1);
		System.out.println(Arrays.toString(vetor));
	}
	
	
	public static void mergeSort(int[] vetor, int[] vetorAux, int inicio, int fim) {
		if(inicio < fim) {
			int meio = (inicio + fim)/2;
			mergeSort(vetor, vetorAux, inicio, meio);
			mergeSort(vetor, vetorAux, meio+1, fim);
			intercalar(vetor, vetorAux, inicio, meio, fim);
		}
	}
	
	public static void intercalar(int[] vetor, int[] vetorAux, int inicio, int meio, int fim) {
		for(int k = inicio; k <= fim; k++) {
			vetorAux[k] = vetor[k];
		}
		
		int esquerda = inicio;
		int direita = meio+1;
		
		for(int i = inicio; i <= fim; i++) {
			if(esquerda > meio) { //Se o vetor da esquerda acabou
				vetor[i] = vetorAux[direita++];
			} else if(direita > fim) { //Se o vetor da direita acabou
				vetor[i] = vetorAux[esquerda++];
			} else if(vetorAux[esquerda] < vetorAux[direita]) {
				vetor[i] = vetorAux[esquerda++];
			} else {
				vetor[i] = vetorAux[direita++];
			}
		}
	}

}
