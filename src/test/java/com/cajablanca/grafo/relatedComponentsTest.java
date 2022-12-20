package com.cajablanca.grafo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


class relatedComponentsTest {
	
	private static Grafo grafoVacio;
	private static Grafo grafoUnNodo;
	private static Grafo grafoUnNodoReflexivo;
	private static Grafo grafoDosNodos;

	@BeforeEach
	void setUp() throws Exception {
		grafoVacio = new Grafo();
		
		grafoUnNodo = new Grafo();
		grafoUnNodo.addVertice(1);
		
		grafoUnNodoReflexivo = new Grafo();
		grafoUnNodoReflexivo.addVertice(1);
		grafoUnNodoReflexivo.addArco(new Arco(1, 1, 1));
		
		grafoDosNodos = new Grafo();
		grafoDosNodos.addVertice(1);
		grafoDosNodos.addVertice(2);
		grafoDosNodos.addArco(new Arco(1, 2, 1));
		
		
	}

	@Test
	@DisplayName("V1. Grafo vacio. Devuelve espacio en blanco")
	/*
	 * while(!todosVisitado) == false
	 * First - 1 - 2 - 21 - Last
	 */
	void testComponentsRelatedV1() {
		
		assertEquals("", grafoVacio.componentsRelated());
	}
	
	
	@Test
	@DisplayName("V6. Grafo con un nodo. Devuelve que solo hay un componente relacionado")
	/*
	 * while(!todosVisitado) == true
	 * while(i<this.visitados.length) == true
	 * while(!found) == true
	 * if(!this.visitados[i]) == true
	 * while(!queue.isEmpty()) == true
	 * for (Arco arco : listAdy) == false
	 * First - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 9 - 10 - 4 - 11 - 12 - 13 - 18 - 11 - 19 - 20 - 2 - 21 - Last 
	 */
	void testComponentsRelatedV6() {
		
		assertEquals("[1]", grafoUnNodo.componentsRelated());
	}
	
	
	@Test
	@DisplayName("V7. Grafo con un nodo reflexivo (conectado a sí mismo). Devuelve que solo hay un componente relacionado")
	/*
	 * while(!todosVisitado) == true
	 * while(i<this.visitados.length) == true
	 * while(!found) == true
	 * if(!this.visitados[i]) == true
	 * while(!queue.isEmpty()) == true
	 * for(Arco arco : listAdy) == true
	 * if(!this.visitados[arco.getDestino()]) == false
	 * First - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 9 - 10 - 4 - 11 - 12 - 13 - 14 - 16 - 17 - 13 - 18 - 11 - 19 - 20 - 2 - 21 - Last 
	 */
	void testComponentsRelatedV7() {
		
		assertEquals("[1]", grafoUnNodoReflexivo.componentsRelated());
	}
	
	@Test
	@DisplayName("V8. Grafo con dos nodo. Devuelve que hay dos componentes relacionados")
	/*
	 * while(!todosVisitado) == true
	 * while(i<this.visitados.length) == true
	 * while(!found) == true
	 * if(!this.visitados[i]) == true
	 * while(!queue.isEmpty()) == true
	 * for(Arco arco : listAdy) == true
	 * if(!this.visitados[arco.getDestino()]) == true
	 * First-1-2-3-4-5-6-7-9-10-4-11-12-13-14-15-16-17-13-18-11-19-20-2-21-Last 
	 */
	void testComponentsRelatedV8() {
		
		assertEquals("[1 2]", grafoDosNodos.componentsRelated());
	}

}
