package software.engineering.passwort_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Unit test for simple App.
 */
public class PasswortManagerTest {
    private PasswortManager pm;

    @BeforeEach
    public void passwortManager_shouldNotNull() {
        pm = new PasswortManager();
        assertNotNull(pm);
    }

    @Test
    public void istSicheresPasswort_should_throw_on_null() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> pm.istSicheresPasswort(null));
        assertEquals("Passwort kann nicht null sein.", ex.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " ", "p", "pa", "pas", "PAs!", "pasSW+", "pASW*o" })
    public void istSicheresPasswort_shouldReturnFalse_ifInputIsTooShort(String passwort) {
        assertFalse(pm.istSicheresPasswort(passwort));
    }

    @ParameterizedTest
    @ValueSource(strings = { "PpaS wort!", "LAngespasswort+ ", " APasswort!WithSpace" })
    public void istSicheresPasswort_shouldReturnFalse_ifInputContainsSpace(String passwort) {
        assertFalse(pm.istSicheresPasswort(passwort));
    }

    @ParameterizedTest
    @ValueSource(strings = { "SecurePasswor", "AAAAAAAbbbbBBBBcccc" })
    public void istSicheresPasswort_shouldReturnFalse_ifInputContainsNoSpecialCharacter(String passwort) {
        assertFalse(pm.istSicheresPasswort(passwort));
    }

    @ParameterizedTest
    @ValueSource(strings = { "passwort!", "Passwort#" })
    public void istSicheresPasswort_shouldReturnFalse_ifNotEnoughUpperCase(String passwort) {
        assertFalse(pm.istSicheresPasswort(passwort));
    }

    @ParameterizedTest
    @ValueSource(strings = { "PASSWORT!", "VERYSECURe#" })
    public void istSicheresPasswort_shouldReturnFalse_ifNotEnoughLowerCase(String passwort) {
        assertFalse(pm.istSicheresPasswort(passwort));
    }

    @ParameterizedTest
    @ValueSource(strings = { "PassworT!", "PASSWOrt#" })
    public void istSicheresPasswort_shouldReturnTrue_forValidPassword(String passwort) {
        assertTrue(pm.istSicheresPasswort(passwort));
    }
}
