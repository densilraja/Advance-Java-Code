
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapPractice {

    public static void main(String[] args) {

        // ============================================================
        // 1. CREATE CONCURRENT HASHMAP
        // ============================================================

        /*
         * ConcurrentHashMap is a thread-safe implementation of Map.
         *
         * Package:
         *
         * java.util.concurrent
         *
         * It is designed for MULTITHREADED applications where
         * multiple threads need to read and modify a Map.
         */
        ConcurrentHashMap<Integer, String> map
                = new ConcurrentHashMap<>();

        // Adding data
        map.put(101, "Densil");
        map.put(102, "Raja");
        map.put(103, "John");

        System.out.println(map);

        // ============================================================
        // 2. WHY NOT HASHMAP?
        // ============================================================

        /*
         * HashMap is NOT thread-safe.
         *
         * If multiple threads simultaneously modify a HashMap,
         * you can get inconsistent results or race conditions.
         *
         *
         * Example:
         *
         * Thread 1 ---> put()
         * Thread 2 ---> put()
         * Thread 3 ---> remove()
         *
         * All operating on the same HashMap.
         *
         * This is unsafe without external synchronization.
         *
         *
         * ConcurrentHashMap is specifically designed for this
         * type of concurrent access.
         */
        // ============================================================
        // 3. BASIC PUT()
        // ============================================================

        /*
         * put() adds or replaces a key-value pair.
         */
        map.put(104, "David");

        // ============================================================
        // 4. GET()
        // ============================================================

        /*
         * get() retrieves the value associated with a key.
         *
         * ConcurrentHashMap allows multiple threads to READ
         * simultaneously.
         */
        String name = map.get(101);

        System.out.println(
                "Employee: " + name
        );

        // ============================================================
        // 5. REMOVE()
        // ============================================================

        /*
         * Removes an entry based on the key.
         */
        map.remove(104);

        // ============================================================
        // 6. CONTAINSKEY()
        // ============================================================

        /*
         * Checks whether the specified key exists.
         */
        boolean exists
                = map.containsKey(101);

        System.out.println(
                "Key exists: " + exists
        );

        // ============================================================
        // 7. putIfAbsent()
        // ============================================================

        /*
         * VERY IMPORTANT METHOD.
         *
         * putIfAbsent() inserts the value ONLY IF
         * the key does not already exist.
         *
         *
         * Normal HashMap approach:
         *
         * if (!map.containsKey(key)) {
         *     map.put(key, value);
         * }
         *
         *
         * Problem:
         *
         * In a multithreaded environment,
         * another thread could modify the map between
         * containsKey() and put().
         *
         *
         * putIfAbsent() performs the operation atomically.
         */
        map.putIfAbsent(105, "Alex");

        // If 105 already exists,
        // this won't replace the existing value.
        map.putIfAbsent(105, "Robert");

        System.out.println(
                "105 = " + map.get(105)
        );

        // Output:
        //
        // 105 = Alex
        // ============================================================
        // 8. computeIfAbsent()
        // ============================================================

        /*
         * VERY IMPORTANT INTERVIEW METHOD.
         *
         * computeIfAbsent() calculates and inserts a value
         * ONLY if the key is absent.
         *
         *
         * Example use case:
         *
         * Cache
         * Database lookup
         * Creating lists for grouping
         */
        map.computeIfAbsent(
                106,
                key -> "Employee-" + key
        );

        System.out.println(
                "106 = " + map.get(106)
        );

        // ============================================================
        // 9. computeIfPresent()
        // ============================================================

        /*
         * computeIfPresent() executes the function
         * ONLY if the key already exists.
         */
        map.computeIfPresent(
                101,
                (key, value) -> value.toUpperCase()
        );

        System.out.println(
                "101 = " + map.get(101)
        );

        // ============================================================
        // 10. replace()
        // ============================================================

        /*
         * replace() replaces the value ONLY if the key exists.
         */
        map.replace(
                102,
                "Raja Updated"
        );

        System.out.println(
                "102 = " + map.get(102)
        );

        // ============================================================
        // 11. replace() WITH OLD VALUE CHECK
        // ============================================================

        /*
         * This version replaces the value only when
         * the current value matches the expected old value.
         *
         * This is useful for conditional updates.
         */
        map.replace(
                103,
                "John",
                "John Updated"
        );

        System.out.println(
                "103 = " + map.get(103)
        );

        // ============================================================
        // 12. ITERATION
        // ============================================================

        /*
         * ConcurrentHashMap allows iteration while other threads
         * are modifying the map.
         *
         * Its iterators are WEAKLY CONSISTENT.
         *
         * They do NOT throw ConcurrentModificationException
         * just because another thread modifies the map.
         */
        for (Map.Entry<Integer, String> entry
                : map.entrySet()) {

            System.out.println(
                    entry.getKey()
                    + " = "
                    + entry.getValue()
            );
        }

        // ============================================================
        // 13. MULTITHREADING EXAMPLE
        // ============================================================

        /*
         * Now let's create a ConcurrentHashMap shared by
         * multiple threads.
         */
        ConcurrentHashMap<Integer, Integer> counter
                = new ConcurrentHashMap<>();

        // Thread 1
        Thread thread1 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {

                counter.merge(
                        1,
                        1,
                        Integer::sum
                );
            }
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {

                counter.merge(
                        1,
                        1,
                        Integer::sum
                );
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();

        try {

            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {

            Thread.currentThread()
                    .interrupt();
        }


        /*
         * Both threads incremented the same key.
         *
         * Thread 1 -> 1000 increments
         * Thread 2 -> 1000 increments
         *
         * Expected:
         *
         * 2000
         */
        System.out.println(
                "Counter = "
                + counter.get(1)
        );
    }
}
