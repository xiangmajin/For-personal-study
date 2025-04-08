package algorithm;

public class sort {
    public static void main(String[] args) {
        int[] a={56,7,9,10,6,5,98,89};
        selectionSort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = 0;j < arr.length - 1 - i;j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    //选择排序
    public static void selectionSort(int[] arr){
        for(int i = 0;i < arr.length - 1;i++) {
            for (int j = i+1; j < arr.length  ; j++) {
                if (arr[i] > arr[j ]) {
                    int temp = arr[i];
                    arr[i] = arr[j ];
                    arr[j ] = temp;
                }
            }
        }
    }
    //插入排序
    public static void insertionSort(int[] arr) {
        // 从第二个元素开始，因为第一个元素可视为已排序
        for (int i = 1; i < arr.length; i++) {
            // 记录当前要插入的元素
            int key = arr[i];
            int j = i - 1;

            // 将比 key 大的元素往后移动
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // 将 key 插入到合适的位置
            arr[j + 1] = key;
        }
    }
    //快速排序


    public static void quickSort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }

        private static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                // 分区操作，获取基准元素的最终位置
                int pivotIndex = partition(arr, low, high);

                // 递归排序基准元素左边的部分
                quickSort(arr, low, pivotIndex - 1);
                // 递归排序基准元素右边的部分
                quickSort(arr, pivotIndex + 1, high);
            }
        }

        private static int partition(int[] arr, int low, int high) {
            // 选择最后一个元素作为基准元素
            int pivot = arr[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    // 交换 arr[i] 和 arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // 将基准元素放到正确的位置
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            return i + 1;
        }
}
