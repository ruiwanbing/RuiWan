public class Quicksort  {
    private int[] numbers;
    private int number;

    public void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        //choose pivot-value
        int pivot = numbers[number - 1];
        // i - all value on the left side of i < pivot
        // j - all value on the right side of j > pivot
        int i = low, j = high;
        //compare the low, right with pivot
        while (i < j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            swap(numbers, i, j);
            i++;
            j--;
        }
        //sort left unsorted elements
        if (i < high) {
            quicksort(i, high);
        }
        if (j > low) {
            quicksort(low, j);
        }

    }