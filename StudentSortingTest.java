package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import sorting.divideAndConquer.QuickSort;
import sorting.divideAndConquer.hybridMergesort.HybridMergeSort;
import sorting.divideAndConquer.quicksort3.QuickSortMedianOfThree;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorDecrescente;
	private Integer[] vetorValoresNegativos;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		populaVetorDecrescente(new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
		populaVetorValoresNegativos(new Integer[] {-1, -17, -5, -30, -81, -105, 37});

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new MergeSort<Integer>(); 
		this.implementation = new QuickSort<Integer>();
		this.implementation = new QuickSortMedianOfThree<Integer>();
		this.implementation = new HybridMergeSort<Integer>();
	} 

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}
	
	public void populaVetorDecrescente(Integer[] arrayPadrao) {
		this.vetorDecrescente = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}
	
	public void populaVetorValoresNegativos(Integer[] arrayPadrao) {
		this.vetorValoresNegativos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}
	
	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	

	public void myGenericTest(Integer[] array) {
		Integer[] copy  = {};
		if(array.length > 0) {
			copy = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, 2, 5);
		Arrays.sort(copy, 2, 6);
		Assert.assertArrayEquals(copy, array);
	}
	
	@Test
	public void testSort06() {
		myGenericTest(vetorTamPar);
	}
	
	@Test
	public void testSort07() {
		myGenericTest(vetorTamImpar);
	}
	
	@Test
	public void testSort08() {
		myGenericTest(vetorValoresIguais);
	}
	
	@Test
	public void testSort09() {
		myGenericTest(vetorValoresRepetidos);
	}
	
	@Test
	public void testSort10() {
		myGenericTest(vetorDecrescente);
	}
	
	@Test
	public void testSort11() {
		myGenericTest(vetorValoresNegativos);
	}
}