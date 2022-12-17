package com.cajablanca.editor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cajanegra.EmptyCollectionException;

class GetLineTest {
	private static Editor editorVacio;

	@BeforeEach
	void setUp() throws Exception {
		editorVacio = new Editor();
		editorVacio.cargarEditor("./resources/editorVacio.txt");
	}

	@Test
	void testGetLineaV1() {
		assertThrows (EmptyCollectionException.class, () -> editorVacio.getLinea(2));
	}

}
