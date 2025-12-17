import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    private DoublyLinkedList list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList();
    }

    @Test
    void TC_DLL_001_deleteOnEmptyList() {
        boolean result = list.deleteByValue(10);
        assertFalse(result, "Eliminar en lista vacía debe retornar false");
        assertTrue(list.isEmpty(), "La lista debe seguir vacía");
    }

    @Test
    void TC_DLL_002_reverseEmptyList() {
        list.reverse();
        assertTrue(list.isEmpty(), "Reverse en lista vacía no debe modificarla");
    }

    @Test
    void TC_DLL_003_insertOnEmptyList() {
        list.insertAtEnd(5);
        assertFalse(list.isEmpty(), "La lista no debe estar vacía");
        assertNotNull(list.getHead(), "Head no debe ser null");
        assertEquals(list.getHead(), list.getTail(), "Head y Tail deben ser iguales");
    }

    @Test
    void TC_DLL_004_reverseSingleElement() {
        list.insertAtEnd(10);
        list.reverse();
        assertEquals(list.getHead(), list.getTail(), "Lista de un elemento no cambia");
    }

    @Test
    void TC_DLL_005_deleteSingleElement() {
        list.insertAtEnd(10);
        boolean result = list.deleteByValue(10);
        assertTrue(result, "Debe eliminar el único elemento");
        assertTrue(list.isEmpty(), "La lista debe quedar vacía");
    }

    @Test
    void TC_DLL_006_deleteHead() {
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);

        boolean result = list.deleteByValue(1);
        assertTrue(result, "Debe eliminar el head");
        assertNull(list.getHead().prev, "El nuevo head.prev debe ser null");
    }

    @Test
    void TC_DLL_007_deleteTail() {
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);

        boolean result = list.deleteByValue(3);
        assertTrue(result, "Debe eliminar el tail");
        assertNull(list.getTail().next, "El nuevo tail.next debe ser null");
    }

    @Test
    void TC_DLL_008_deleteMiddleElement() {
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);

        boolean result = list.deleteByValue(2);
        assertTrue(result, "Debe eliminar nodo intermedio");
        assertEquals(3, list.getHead().next.data, "Los enlaces deben reacomodarse");
    }

    @Test
    void TC_DLL_009_deleteNonExistingElement() {
        list.insertAtEnd(1);
        list.insertAtEnd(2);

        boolean result = list.deleteByValue(99);
        assertFalse(result, "Eliminar elemento inexistente debe retornar false");
    }

    @Test
    void TC_DLL_010_reverseMultipleElements() {
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);

        list.reverse();

        assertEquals(4, list.getHead().data, "El head debe ser el último elemento");
        assertEquals(1, list.getTail().data, "El tail debe ser el primer elemento");
        assertNull(list.getHead().prev, "Head.prev debe ser null");
        assertNull(list.getTail().next, "Tail.next debe ser null");
    }
}
