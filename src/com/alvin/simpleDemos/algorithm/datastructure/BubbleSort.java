package com.alvin.simpleDemos.algorithm.datastructure;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] inputList = {1, -2, 10, 20, -5, 12, 10};
        BubbleSort instance = new BubbleSort();
        instance.bubbleSort(inputList);
        System.out.println(Arrays.toString(inputList));
    }

    private void bubbleSort(int[] list) {
        for (int x = list.length - 1; x > 0; x--) {
            for (int i = 0; i < x; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
    }
}
