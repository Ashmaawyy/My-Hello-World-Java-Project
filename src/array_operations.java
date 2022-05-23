import java.util.*;

import static java.lang.Math.abs;

public class array_operations
{
    public static void main(String[] args)
    {
        int[] array = {5, 6, 7, 8, 8, 20, 12, 15, 5, 6, 7, 8};
        System.out.println("AVERAGE of array is: " + find_average(array));
        find_frequency(array);
        //System.out.println("Frequency of elements in array " + " is: " + find_frequency(array));
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
                System.out.println("""
                        Apparently there is a typo in the sorting method you entered\s
                        Try:
                        'dec' or 'asc'\s""");
            }
            return input_array;
    }
    private static void find_frequency(int [] input_array)
{
    Hashtable<Integer, Integer> frequency_dict = new Hashtable<Integer, Integer> ();

    int [] frequencies_array = new int[input_array.length];
    int visited = -1;
    //Arrays.fill(frequencies_array, 1);
        for(int i = 0; i < input_array.length; i++)
        {
            int count = 1;
            for (int j = i + 1; j < input_array.length; j++) {
                if (input_array[i] == input_array[j]) {
                    count++;
                    frequencies_array[j] = visited;
                }
                if (frequencies_array[i] != visited) {
                    frequencies_array[i] = count;
                }

            }
        }
    Formatter fmt = new Formatter();
        fmt.format("%15s%15s\n", "Elements", "Frequency");
        for (int i = 0; i < frequencies_array.length; i++)
        {
            if (frequencies_array[i] != visited)
                fmt.format("%14s%14s\n", input_array[i], frequencies_array[i]);
        }
        System.out.println(fmt);
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
