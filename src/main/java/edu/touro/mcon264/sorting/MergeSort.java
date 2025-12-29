package edu.touro.mcon264.sorting;

import java.util.Comparator;

public class MergeSort implements Sorter {

    @Override
    @SuppressWarnings("unchecked")
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        if (a.length < 2) {
            return;
        }
        
        // Split array in half
        int mid = a.length / 2;
        T[] left = (T[]) new Object[mid];
        T[] right = (T[]) new Object[a.length - mid];
        
        // Copy elements
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < a.length; i++) {
            right[i - mid] = a[i];
        }
        
        // Recursively sort both halves
        sort(left, comp);
        sort(right, comp);
        
        // Merge them back together
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (comp.compare(left[i], right[j]) <= 0) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }
        
        // Copy any remaining elements
        while (i < left.length) {
            a[k++] = left[i++];
        }
        while (j < right.length) {
            a[k++] = right[j++];
        }
    }
}
