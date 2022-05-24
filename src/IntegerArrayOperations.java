import java.util.Arrays;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Random;

public class IntegerArrayOperations
{

    public static void main(String[] args)
    {
        test();
    }

    private static void test()
    {
        int[] array = new int[10000];
        Random random_int = new Random();

        for (int i = 0 ;i < array.length; i++)
            array[i] = random_int.nextInt();

        System.out.println("AVERAGE of array is: " + get_items_average(array));
        System.out.println("Frequency of elements in array " + " is: " + get_items_frequency(array));
        System.out.println("Sorted Array From A-Z: " + Arrays.toString(get_sorted_array(array, "asc")));
        System.out.println("Sorted Array From Z-A: " + Arrays.toString(get_sorted_array(array, "dec")));
        System.out.println("Sorted Array From Z-A: " + Arrays.toString(get_sorted_array(array, "acs")));
    }


    private static int[] get_sorted_array(int[] input_array, String sorting_option)
    {
            if (Objects.equals(sorting_option, "ascending") || Objects.equals(sorting_option, "asc"))
            {
                Arrays.sort(input_array);
                return input_array;
            }
            else if (Objects.equals(sorting_option, "dec") || Objects.equals(sorting_option, "descending"))
            {
                return get_descending_order(input_array);
            }
            else
            {
                System.out.println("Apparently there is a typo in the sorting method you entered\nTry:\n'dec' or 'asc'");
                return null;
            }
    }

    private static int[] get_descending_order(int[] input_array)
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

    private static double get_items_average(int[] values)
    {
        double result = 0;

        for (int value : values)
        {
            result += value;
        }

        return result / values.length;
    }
}
