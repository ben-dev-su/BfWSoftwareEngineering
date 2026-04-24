package software.engineering.passwort_manager;

public class PasswortManager {
    public Boolean istSicheresPasswort(String passwort) {
        if (passwort == null) {
            throw new IllegalArgumentException("Passwort kann nicht null sein.");
        }
        if (passwort.length() < 8) {
            return false;
        }

        int kleinbuchstaben = 0;
        int grossbuchstaben = 0;
        boolean hatSonderzeichen = false;

        for (char c : passwort.toCharArray()) {
            if (Character.isWhitespace(c)) {
                return false;
            }
            if (Character.isUpperCase(c)) {
                grossbuchstaben++;
            } else if (Character.isLowerCase(c)) {
                kleinbuchstaben++;
            } else if (!Character.isDigit(c)) {
                hatSonderzeichen = true;
            }
        }

        return kleinbuchstaben >= 2 && grossbuchstaben >= 2 && hatSonderzeichen;
    }
}
