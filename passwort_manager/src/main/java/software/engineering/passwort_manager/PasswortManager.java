package software.engineering.passwort_manager;

public class PasswortManager {
    public Boolean istSicheresPasswort(String passwort) {
        if (passwort == null) {
            throw new IllegalArgumentException("Passwort kann nicht null sein.");
        }

        if (passwort.length() < 8)
            return false;

        int klein = 0;
        int groß = 0;
        boolean isSpecialCharater = false;

        for (char c : passwort.toCharArray()) {
            if (!Character.isLetterOrDigit(c))
                isSpecialCharater = true;

            if (Character.isWhitespace(c))
                return false;

            if (Character.isUpperCase(c))
                groß++;
            if (Character.isLowerCase(c))
                klein++;
        }

        if (klein < 2 || groß < 2 || !isSpecialCharater) {
            return false;
        }

        return true;
    }
}
