import Resources.LinkedList;
import com.example.ca1.DisplayCase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class displayCaseTest {
    LinkedList list = new LinkedList();
    @BeforeEach
    void setUp() {
        DisplayCase dc1 = new DisplayCase("1", "Mounted","Lit");
        DisplayCase dc2 = new DisplayCase("2", "Free-Standing","unlit");
        list.addNode(dc1);
        list.addNode(dc2);
    }

    @AfterEach
    void tearDown() {
        list.deleteAll();

    }

    @Test
    void getCaseIDTest() {
        assertEquals("1",((DisplayCase) list.get(0)).getCaseID());
        assertEquals("2",((DisplayCase) list.get(1)).getCaseID());

    }

    @Test
    void setCaseIDTest() {
        assertEquals("1",((DisplayCase) list.get(0)).getCaseID());
        ((DisplayCase) list.get(0)).setCaseID("3");
        assertEquals("3",((DisplayCase) list.get(0)).getCaseID());

    }

    @Test
    void getTypeTest() {
        assertEquals("Mounted",((DisplayCase) list.get(0)).getType());
        assertEquals("Free-Standing",((DisplayCase) list.get(1)).getType());
    }

    @Test
    void setTypeTest() {
        assertEquals("Mounted",((DisplayCase) list.get(0)).getType());
        ((DisplayCase) list.get(0)).setCaseID("Free-Standing");
        assertEquals("Free-Standing",((DisplayCase) list.get(0)).getCaseID());

    }
}
