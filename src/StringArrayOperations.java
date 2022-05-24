import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Objects;

public class StringArrayOperations
{
    public static void main(String[] args)
    {
        String[] array = {"This", "array", "is", "for", "test", "and", "fun", "purposes"};
        String[] names = {"Ahmed", "Mona", "Muhammad", "Muhammad", "Hadeer", "Ghada", "Muhammad", "Mona", "Ahmed"};
        System.out.println("Frequency of elements in array " + " is: " + get_items_frequency(names));
        System.out.println("Sorted Array From A-Z: " + Arrays.toString(get_sorted_array(array, "asc")));
        System.out.println("Sorted Array From Z-A: " + Arrays.toString(get_sorted_array(array, "dec")));
        System.out.println("Sorted Array From Z-A: " + Arrays.toString(get_sorted_array(array, "acs")));
    }

    private static Hashtable<String, Integer> get_items_frequency(String[] input_array)
    {
        get_sorted_array(input_array, "asc");
        int[] frequency_array = get_frequency_array(input_array);

        return get_frequency_dict(input_array, frequency_array);
    }

    private static Hashtable <String, Integer> get_frequency_dict(String[] input_array, int[] frequency_array)
    {
        Hashtable <String, Integer> frequency_dict = new Hashtable <String, Integer>();
        int visited = -1;
        for (int i = 0; i < input_array.length; i++)
        {
            if (frequency_array[i] != visited)
                frequency_dict.put(input_array[i], frequency_array[i]);
        }

        return frequency_dict;
    }

    private static int [] get_frequency_array(String[] input_array)
    {
        int [] frequency_array = new int[input_array.length];
        int visited = -1;

        for(int i = 0; i < input_array.length; i++)
        {
            int count = 1;

            for (int j = i + 1; j < input_array.length; j++)
            {
                if (Objects.equals(input_array[i], input_array[j]))
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

    private static String[] get_sorted_array(String[] input_array, String sorting_option)
    {
        if (Objects.equals(sorting_option, "ascending") || Objects.equals(sorting_option, "asc"))
        {
            Arrays.sort(input_array);
            return input_array;
        }
        else if (Objects.equals(sorting_option, "dec") || Objects.equals(sorting_option, "descending"))
        {
            return get_descending_order(input_array);
        } else
        {
            System.out.println("Apparently there is a typo in the sorting method you entered\nTry:\n'dec' or 'asc'");
            return null;
        }
    }


    private static String[] get_descending_order(String[] input_array)
    {
        Arrays.sort(input_array, Collections.reverseOrder());
        return input_array;
    }
}
