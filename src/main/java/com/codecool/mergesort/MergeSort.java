package com.codecool.mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {

    /**
     * Sorts the given List in place
     * @param toSort the List to sort. Throws an error if its null
     */
    public void sort(List<Integer> toSort) {
        if (toSort == null) {
            throw new IllegalArgumentException();
        }
        
        this.mergeSort(toSort, 0, toSort.size() - 1);
    }

    private void mergeSort(List<Integer> toSort, int start, int end) {
        if (start < end) {
            int center = (start + end) / 2;
            mergeSort(toSort, start, center );
            mergeSort(toSort, center + 1, end);
            merge(toSort, start, center, end);
        }
    }

    private void merge(List<Integer> toSort, int start, int center, int end) {
        List<Integer> temp = new LinkedList<>();
        int left = start;
        int right = center + 1;

        while (left <= center && right <= end) {

            if (toSort.get(left) <= toSort.get(right)) {
                temp.add(toSort.get(left++));
            } else {
                temp.add(toSort.get(right++));
            }

        }

        while (left <= center) {
           temp.add(toSort.get(left++));
        }

        while (right <= end) {
            temp.add(toSort.get(right++));
        }

        for (int i = 0; i < temp.size(); i++) {
            toSort.set(start + i, temp.get(i));
        }
    }
}
