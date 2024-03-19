public class Main {
    public static void main(String[] args) {
        int[] array = {9, 7, 3, 5, 8, 1, 0, 2, 6};

        int maxIndex = findMaxIndex(array);
        System.out.println("The number of the maximum element of the array: " + maxIndex);

        int productBetweenZeros = productBetweenZeros(array);
        System.out.println("The product of array elements between the first and second zero elements: " + productBetweenZeros);

        transformArray(array);

        System.out.println("Array after conversion:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static int findMaxIndex(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int productBetweenZeros(int[] arr) {
        int product = 1;
        boolean foundFirstZero = false;

        for (int num : arr) {
            if (num == 0 && !foundFirstZero) {
                foundFirstZero = true;
            } else if (num == 0 && foundFirstZero) {
                break;
            } else if (foundFirstZero) {
                product *= num;
            }
        }
        return product;
    }

    public static void transformArray(int[] arr) {
        int length = arr.length;
        int[] transformedArray = new int[length];
        for (int i = 0; i < length / 2; i++) {
            transformedArray[i] = arr[2 * i + 1];
        }
        for (int i = 0; i < length / 2; i++) {
            transformedArray[i + length / 2] = arr[2 * i];
        }

        System.arraycopy(transformedArray, 0, arr, 0, length);
    }
}