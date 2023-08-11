// Реализовать алгоритм пирамидальной сортировки (сортировка кучей).
public class Main {
    public static void main(String[] args) {
        int[] arr = {20, -5, 7, 55, 3, 100, -13, 16};
        heapSort(arr);
        System.out.print("HeapSort -> ");
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;
        // один за другим извлекаем элементы из кучи
        for(int i = n/2 -1; i >= 0; i--)
            heapify(arr, i, n);

        for(int i = n - 1; i >= 0; i--){
            // Перемещаем текущий корень в конец
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, 0, i);
        }
    }
    private static void heapify(int[] arr, int i, int n){
        // левый = 2*i + 1
        int l = i * 2 + 1;
        // правый = 2*i + 2
        int r = i * 2 + 2;
        // Инициализируем наибольший элемент как корень
        int largest = i;
        // Если левый дочерний элемент больше корня
        if(l < n && arr[l] > arr[largest])
            largest = l;
        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if(r < n && arr[r] > arr[largest])
            largest = r;

        if(i != largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, largest, n);
        }

    }
}