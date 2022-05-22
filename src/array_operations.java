import java.util.*;

public class array_operations
{
    public static void main(String[] args)
    {
        int[] array = {5, 6, 7, 8, 8, 20, 12, 15, 5, 6, 7, 8};
        System.out.println("AVERAGE of array " + Arrays.toString(array) + " is " + find_average(array));
        System.out.println("Frequency of elements in array " + " is: " + find_frequency(array));
        System.out.println("Sorted Array From A-Z: " + Arrays.toString(get_sorted_array(array)));
    }

    private static int[] get_sorted_array(int[] input_array)
        {
         Arrays.sort(input_array);
         return input_array;
        }
    private static Hashtable<Integer, Integer> find_frequency(int [] input_array)
{
    Hashtable<Integer, Integer> frequency_dict = new Hashtable<Integer, Integer> ();

    for (int j : input_array) {
        frequency_dict.put(j, Collections.frequency(List.of(input_array), j));
    }

    return frequency_dict;
}
    private static double find_average(int[] values)
    {
        double result = 0;
        for (int value : values) {
            result += value;
        }
        return result / values.length;
    }
}
