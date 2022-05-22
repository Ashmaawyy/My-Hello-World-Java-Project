import java.util.*;

public class array_operations {
    public static void main(String[] args) {
        int[] array = {5, 6, 7, 8, 8, 20, 12, 15, 5, 6, 7, 8};
        System.out.println("AVERAGE of array " + Arrays.toString(array) + " is " + find_average(array));
        System.out.println("Frequency of elements in array " + " is: " + find_frequency(array));
}
private static Hashtable<Integer, Integer> find_frequency(int [] array)
{
    Hashtable<Integer, Integer> frequency_dict = new Hashtable <Integer, Integer> ();
    List<Integer> frequencies = new ArrayList<>();
    for (int j : array)
    {
        frequencies.add(Collections.frequency(List.of(array), j));
        System.out.println(frequencies);
    }
    for (int i = 0; i < array.length; i++)
    {
        frequency_dict.put(array[i], i);
    }

    return frequency_dict;
}
    private static double find_average(int[] values) {
        double result = 0;
        for (int value : values) {
            result += value;
        }
        return result / values.length;
    }
}
