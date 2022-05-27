import java.util.Arrays;
import java.util.Random;

public class TestArrayOperations
{
    public static void main(String [] args)
    {
        System.out.println("Integer array operations test:" + "\n");
        integer_array_operations_test();
        System.out.println("-----------------------------------------");
        System.out.println("String array operations test:" + "\n");
        string_array_operations_test();
        System.out.println("-----------------------------------------");
    }
    private static void integer_array_operations_test()
    {
        int[] array = new int[10000];
        Random random_int = new Random();

        for (int i = 0 ;i < array.length; i++)
            array[i] = random_int.nextInt(10);

        System.out.println("AVERAGE of array is: " + IntegerArrayOperations.get_items_average(array));
        System.out.println(Arrays.toString(IntegerArrayOperations.get_sorted_array(array, "asc")));
        System.out.println(Arrays.toString(IntegerArrayOperations.get_sorted_array(array, "dec")));
        System.out.println(Arrays.toString(IntegerArrayOperations.get_sorted_array(array, "acs")));
        System.out.println("Frequency of elements in array " + " is: " + IntegerArrayOperations.get_items_frequency(array));
    }
    private static void string_array_operations_test()
    {
        // todo
        String[] array = new String[10000];
        Random random_name = new Random();

        for (int i = 0; i < array.length; i++)
            array[i] = String.valueOf(random_name.nextInt(10));

        System.out.println(Arrays.toString(StringArrayOperations.get_sorted_array(array, "asc")));
        System.out.println(Arrays.toString(StringArrayOperations.get_sorted_array(array, "dec")));
        System.out.println(Arrays.toString(StringArrayOperations.get_sorted_array(array, "acs")));
        System.out.println("Frequency of elements in array " + " is: " + StringArrayOperations.get_items_frequency(array));
    }
}
