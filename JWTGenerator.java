import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


/*
 * ================================================================
 * JWT GENERATOR - MANUAL IMPLEMENTATION
 * ================================================================
 *
 * This program demonstrates how a JWT is created internally
 * without using a JWT library such as JJWT.
 *
 *
 * JWT FORMAT:
 *
 *      HEADER.PAYLOAD.SIGNATURE
 *
 *
 * Example:
 *
 *      xxxxx.yyyyy.zzzzz
 *
 *
 * We are using:
 *
 *      Algorithm = HS256
 *
 * HS256 means:
 *
 *      HMAC + SHA-256
 *
 * ================================================================
 */

public class JWTGenerator {


    // ================================================================
    // SECRET KEY
    // ================================================================

    /*
     * The secret key is used to generate the JWT signature.
     *
     * IMPORTANT:
     *
     * This key must be kept SECRET.
     *
     * In a real Spring Boot application, DON'T hard-code it here.
     *
     * Instead use:
     *
     * - Environment variables
     * - application.properties with externalized secrets
     * - AWS Secrets Manager
     * - Vault
     * - Other secret-management systems
     *
     * For this learning example, we keep it here.
     */

    private static final String SECRET =
            "my-secret-key-my-secret-key-my-secret-key";


    // ================================================================
    // GENERATE JWT TOKEN
    // ================================================================

    public static String generateToken(
            String username) throws Exception {


        // ============================================================
        // STEP 1: CREATE JWT HEADER
        // ============================================================

        /*
         * The JWT Header tells the receiver:
         *
         * alg -> Algorithm used to create the signature
         *
         * typ -> Type of token
         *
         *
         * Here:
         *
         * alg = HS256
         * typ = JWT
         *
         *
         * Header:
         *
         * {
         *     "alg": "HS256",
         *     "typ": "JWT"
         * }
         */

        String header =
                """
                {"alg":"HS256","typ":"JWT"}
                """;


        // ============================================================
        // STEP 2: CREATE JWT PAYLOAD
        // ============================================================

        /*
         * Payload contains CLAIMS.
         *
         * Claims are information about the user/token.
         *
         * sub -> Subject / User identity
         * role -> User's role
         * iat -> Issued At
         * exp -> Expiration Time
         *
         *
         * IMPORTANT:
         *
         * Payload is NOT encrypted.
         *
         * It will only be Base64URL encoded.
         *
         * Therefore, sensitive information such as:
         *
         * - password
         * - credit card number
         * - secret keys
         *
         * should NOT be placed in the JWT payload.
         */

        long issuedAt =
                System.currentTimeMillis() / 1000;


        /*
         * Token will expire after 1 hour.
         *
         * 60 seconds
         * × 60 minutes
         *
         * = 3600 seconds
         */

        long expiration =
                issuedAt + 3600;


        String payload =
                """
                {"sub":"%s","role":"USER","iat":%d,"exp":%d}
                """.formatted(
                        username,
                        issuedAt,
                        expiration
                );


        // ============================================================
        // STEP 3: ENCODE HEADER USING BASE64URL
        // ============================================================

        /*
         * JWT uses Base64URL encoding.
         *
         *
         * Process:
         *
         * Header
         *   ↓
         * Convert String → bytes
         *   ↓
         * UTF-8
         *   ↓
         * Base64URL encoding
         *   ↓
         * Encoded Header
         *
         *
         * IMPORTANT:
         *
         * Base64URL is ENCODING.
         *
         * It is NOT encryption.
         */

        String encodedHeader =
                Base64.getUrlEncoder()
                        .withoutPadding()
                        .encodeToString(
                                header.getBytes(
                                        StandardCharsets.UTF_8
                                )
                        );


        // ============================================================
        // STEP 4: ENCODE PAYLOAD USING BASE64URL
        // ============================================================

        /*
         * Same process is performed for the payload.
         *
         *
         * Payload
         *   ↓
         * UTF-8 bytes
         *   ↓
         * Base64URL
         *   ↓
         * Encoded Payload
         */

        String encodedPayload =
                Base64.getUrlEncoder()
                        .withoutPadding()
                        .encodeToString(
                                payload.getBytes(
                                        StandardCharsets.UTF_8
                                )
                        );


        // ============================================================
        // STEP 5: CREATE HEADER.PAYLOAD
        // ============================================================

        /*
         * JWT has three sections separated by ".".
         *
         *
         * First section:
         *
         *      Header
         *
         * Second section:
         *
         *      Payload
         *
         *
         * Before creating the signature, we combine:
         *
         *      encodedHeader + "." + encodedPayload
         *
         *
         * Result:
         *
         *      HEADER.PAYLOAD
         */

        String data =
                encodedHeader
                        + "."
                        + encodedPayload;


        // ============================================================
        // STEP 6: CREATE HMAC-SHA256
        // ============================================================

        /*
         * Now we create a Java Mac object.
         *
         * Mac = Message Authentication Code
         *
         *
         * We request:
         *
         *      HmacSHA256
         *
         *
         * This means:
         *
         *      HMAC + SHA-256
         */

        Mac mac =
                Mac.getInstance("HmacSHA256");


        // ============================================================
        // STEP 7: CREATE SECRET KEY
        // ============================================================

        /*
         * Our SECRET is a String.
         *
         * Cryptographic algorithms work with bytes.
         *
         * Therefore:
         *
         * String
         *    ↓
         * UTF-8 bytes
         *    ↓
         * SecretKeySpec
         */

        SecretKeySpec key =
                new SecretKeySpec(
                        SECRET.getBytes(
                                StandardCharsets.UTF_8
                        ),
                        "HmacSHA256"
                );


        // ============================================================
        // STEP 8: INITIALIZE HMAC WITH SECRET KEY
        // ============================================================

        /*
         * We give the secret key to the Mac object.
         *
         * Now the Mac object knows which secret
         * should be used for signing.
         */

        mac.init(key);


        // ============================================================
        // STEP 9: GENERATE SIGNATURE
        // ============================================================

        /*
         * THIS IS THE MOST IMPORTANT STEP.
         *
         * We calculate:
         *
         *
         * HMAC-SHA256(
         *
         *      encodedHeader + "." + encodedPayload,
         *
         *      SECRET
         * )
         *
         *
         * The result is a byte array.
         *
         *
         * Conceptually:
         *
         *
         *       HEADER.PAYLOAD
         *              +
         *          SECRET KEY
         *              |
         *              ↓
         *         HMAC-SHA256
         *              |
         *              ↓
         *          SIGNATURE
         */

        byte[] signature =
                mac.doFinal(
                        data.getBytes(
                                StandardCharsets.UTF_8
                        )
                );


        // ============================================================
        // STEP 10: BASE64URL ENCODE SIGNATURE
        // ============================================================

        /*
         * The signature is currently a byte[].
         *
         * JWT represents the signature as Base64URL.
         *
         *
         * Therefore:
         *
         * byte[]
         *   ↓
         * Base64URL
         *   ↓
         * Encoded Signature
         */

        String encodedSignature =
                Base64.getUrlEncoder()
                        .withoutPadding()
                        .encodeToString(
                                signature
                        );


        // ============================================================
        // STEP 11: CREATE FINAL JWT
        // ============================================================

        /*
         * Now we have all three components:
         *
         *
         * 1. encodedHeader
         *
         * 2. encodedPayload
         *
         * 3. encodedSignature
         *
         *
         * JWT format:
         *
         *
         *      HEADER.PAYLOAD.SIGNATURE
         *
         *
         * Therefore:
         */

        String jwt =
                encodedHeader
                        + "."
                        + encodedPayload
                        + "."
                        + encodedSignature;


        // Return the final JWT

        return jwt;
    }


    // ================================================================
    // MAIN METHOD
    // ================================================================

    public static void main(String[] args)
            throws Exception {


        // ============================================================
        // CREATE JWT FOR USER
        // ============================================================

        /*
         * We are generating a JWT for:
         *
         * username = densil
         */

        String token =
                generateToken("densil");


        // ============================================================
        // PRINT FINAL JWT
        // ============================================================

        System.out.println(
                "\nFinal JWT:"
        );

        System.out.println(token);
    }
}