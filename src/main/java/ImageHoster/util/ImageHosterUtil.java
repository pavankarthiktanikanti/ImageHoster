package ImageHoster.util;

public class ImageHosterUtil {

    /**
     * Method to Validate the Strength of the password to have at least 1 alphabet, 1 number, and 1 special character
     *
     * @param password The password entered by the user at the time of registration
     * @return true if password is strong and satisfy the rules, else false
     */
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 3) return false;
        boolean hasLetter = false, hasDigit = false, hasSplChar = false;
        for (int i = 0; i < password.length(); i++) {

            if (Character.isLetter(password.charAt(i))) { // Check for validating if any character is an alphabet
                hasLetter = true;
            } else if (Character.isDigit(password.charAt(i))) { // Check for validating if any character is a digit
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(password.charAt(i))) { // Check for validating if any character is other than alphabet/digit (Special Character)
                hasSplChar = true;
            }
            if (hasLetter && hasDigit && hasSplChar) return true;
        }
        return (hasLetter && hasDigit && hasSplChar);
    }
}
