public class Random {

    // Laver et tilfældigt reg nr fra 1000 til 9999
    public static int randomReg_nr()    {
        java.util.Random random = new java.util.Random();

        return 1000 + random.nextInt(9000);
    }

    // Laver et tilfældigt konto nr fra 100000000 til 999999999
    public static int randomKonto_nr()    {
        java.util.Random random = new java.util.Random();

        return 100000000 + random.nextInt(900000000);
    }

}
