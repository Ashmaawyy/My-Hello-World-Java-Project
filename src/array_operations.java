import java.util.*;

import static java.lang.Math.abs;

public class array_operations
{
    public static void main(String[] args)
    {
        int[] array = {5, 6, 7, 8, 8, 20, 12, 15, 5, 6, 7, 8, 20, 12, 15};
        System.out.println("AVERAGE of array is: " + find_average(array));
        System.out.println("Frequency of elements in array " + " is: " + get_items_frequency(array));
        System.out.println("Sorted Array From A-Z: " + Arrays.toString(get_sorted_array(array, "asc")));
        System.out.println("Sorted Array From Z-A: " + Arrays.toString(get_sorted_array(array, "dec")));
    }

    private static int[] get_sorted_array(int[] input_array, String option)
    {
            if (Objects.equals(option, "ascending") || Objects.equals(option, "asc"))
            {
                Arrays.sort(input_array);
            }
            else if (Objects.equals(option, "dec") || Objects.equals(option, "descending"))
            {
                int temp;
                for (int i = 0; i < input_array.length; i++)
                {
                    for (int j = i + 1; j < input_array.length; j++)
                    {
                        if (input_array[i] < input_array[j])
                        {
                            temp = input_array[i];
                            input_array[i] = input_array[j];
                            input_array[j] = temp;
                        }
                    }
                }
            }
            else
            {
                System.out.println("Apparently there is a typo in the sorting method you entered\nTry:\n'dec' or 'asc'");
            }
            return input_array;
    }
    private static Hashtable<Integer, Integer> get_items_frequency(int [] input_array)
    {
        get_sorted_array(input_array, "asc");
        int[] frequency_array = get_frequency_array(input_array);
        return get_frequency_dict(input_array, frequency_array);
    }
    private static Hashtable <Integer, Integer> get_frequency_dict(int[] input_array, int[] frequency_array)
    {
        Hashtable <Integer, Integer> frequency_dict = new Hashtable<Integer, Integer>();
        int visited = -1;
        for (int i = 0; i < input_array.length; i++)
        {
            if (frequency_array[i] != visited)
                frequency_dict.put(input_array[i], frequency_array[i]);
        }
        return frequency_dict;
    }
    private static int [] get_frequency_array(int[] input_array)
    {
        int [] frequency_array = new int[input_array.length];
        int visited = -1;
        for(int i = 0; i < input_array.length; i++)
        {
            int count = 1;
            for (int j = i + 1; j < input_array.length; j++)
            {
                if (input_array[i] == input_array[j])
                {
                    count++;
                    frequency_array[j] = visited;
                }
                if (frequency_array[i] != visited)
                    frequency_array[i] = count;

            }
        }
        return frequency_array;
    }
    private static double find_average(int[] values)
    {
        double result = 0;
        for (int value : values)
        {
            result += value;
        }
        return result / values.length;
    }
}
