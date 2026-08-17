import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptPasswordEncoderPractice {

    public static void main(String[] args) {

        // ============================================================
        // STEP 1: CREATE PASSWORD ENCODER
        // ============================================================

        /*
         * BCryptPasswordEncoder is provided by Spring Security.
         *
         * It uses the BCrypt hashing algorithm to securely hash
         * passwords.
         *
         * PasswordEncoder is the interface.
         *
         * BCryptPasswordEncoder is one implementation of it.
         */

        PasswordEncoder passwordEncoder =
                new BCryptPasswordEncoder();


        // ============================================================
        // STEP 2: ORIGINAL PASSWORD
        // ============================================================

        /*
         * This is the password entered by the user during
         * registration.
         *
         * IMPORTANT:
         *
         * We should NEVER store this plain-text password
         * directly in the database.
         */

        String rawPassword = "densil123";


        // ============================================================
        // STEP 3: HASH THE PASSWORD
        // ============================================================

        /*
         * encode() takes the plain-text password and generates
         * a BCrypt hash.
         *
         * The returned value is what we store in the database.
         */

        String encodedPassword =
                passwordEncoder.encode(rawPassword);


        System.out.println(
                "Original password: "
                + rawPassword
        );

        System.out.println(
                "BCrypt password: "
                + encodedPassword
        );


        // ============================================================
        // STEP 4: VERIFY PASSWORD
        // ============================================================

        /*
         * During LOGIN, the user enters the password again.
         *
         * Example:
         *
         * User enters:
         *
         * densil123
         *
         * We should NOT simply compare:
         *
         * rawPassword.equals(encodedPassword)
         *
         * because the BCrypt hash is not the original password.
         *
         *
         * Instead, use:
         *
         * passwordEncoder.matches()
         */


        String loginPassword = "densil123";


        boolean passwordMatches =
                passwordEncoder.matches(
                        loginPassword,
                        encodedPassword
                );


        System.out.println(
                "Password matches: "
                + passwordMatches
        );


        // ============================================================
        // STEP 5: WRONG PASSWORD
        // ============================================================

        String wrongPassword = "wrong123";


        boolean wrongPasswordMatches =
                passwordEncoder.matches(
                        wrongPassword,
                        encodedPassword
                );


        System.out.println(
                "Wrong password matches: "
                + wrongPasswordMatches
        );
    }
}