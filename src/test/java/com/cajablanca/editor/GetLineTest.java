package com.cajablanca.editor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;


class GetLineTest {
	private static Editor editorVacio;
	private static Editor editor;

	@BeforeEach
	void setUp() throws Exception {
		editorVacio = new Editor();
		editorVacio.cargarEditor("./resources/editorVacio.txt");
		
		editor = new Editor();
		editor.cargarEditor("./pom.xml");
	}

	
	@Test
	@DisplayName ("V1. Lanza excepción al estar el editor vacío.")
	/*
	 * editor.isEmpty() == true
	 * First - 1 - 2 - Last
	 */
	void testGetLineaV1() {
		
		assertThrows (EmptyCollectionException.class, () -> editorVacio.getLinea(2));
	}
	
	
	@Test
	@DisplayName ("V2. Lanza excepción al seleccionar una línea negativa.")
	/*
	 * editor.isEmpty() == false
	 * linea < 0 == true
	 * linea > editor.size() == indiferente
	 * First - 1 - 3 - 4 - 5 - Last
	 */
	void testGetLineaV2() {
		
		assertThrows (IllegalArgumentException.class, () -> editor.getLinea(-1));
	}
	
	
	@Test
	@DisplayName ("V3. Lanza excepción al seleccionar una línea mayor que size.")
	/*
	 * editor.isEmpty() == false
	 * linea < 0 == false
	 * linea > editor.size() == true
	 * First - 1 - 3 - 4 - 6 - 5 - Last
	 */
	void testGetLineaV3() {
		
		assertThrows (IllegalArgumentException.class, () -> editor.getLinea(100));
	}
	
	
	@Test()
    @DisplayName("V4. Devuelve la línea. También vale si la línea está vacía (por ejemplo separación entre párrafos")
	/*
	 * editor.isEmpty() == false
	 * linea < 0 == false
	 * linea > editor.size() == true
	 * First - 1 - 3 - 4 - 6 - 7 - 8 - Last
	 */
    public void getLineaV4() throws EmptyCollectionException {
		
        AbstractSingleLinkedListImpl<String> list = new SingleLinkedListImpl<>();
        
        list.addFirst("project");
        list.addLast("xmlnshttpmavenapacheorgPOM400");
        
        assertEquals(list.toString(), editor.getLinea(1).toString());
    }
	
}
