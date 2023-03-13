package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class TopFrequent {

    public static void main(String[] args) {
        // int[] integerArray = new int[] { 1, 2, 3, 1, 2, 6, 7, 8, 43, 23, 35, 12, 4,
        // 6, 6, 64, 64, 2, 23, 12 };
        int[] integerArray = new int[] { 1, 2, 3, 1, 2, 1 };
        int[] results;
        int k = 2;
        StopWatch.start();
        results = topKFrequent(integerArray, k);
        StopWatch.finishReport();

        StopWatch.start();
        results = topKFrequentAlt(integerArray, k);
        StopWatch.finishReport();

        StopWatch.start();
        results = topKFrequentCustomObject(integerArray, k);
        StopWatch.finishReport();

        for (int i : results) {
            System.out.println(i);
        }
    }

    private static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> maps = new HashMap<>();

        Comparator<Map.Entry<Integer, Integer>> comparator = (o1, o2) -> {
            int compared = 0;
            if (o1.getValue() > o2.getValue()) {
                compared = 1;
            } else if (o1.getValue().equals(o2.getValue())) {
                compared = -1;
            }
            return compared;
        };

        for (int num : nums) {
            maps.put(num, maps.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(comparator);

        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
            maxHeap.offer(entry);
        }

        int start = 0;
        while (start < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            result[start++] = entry.getKey();
        }

        return result;
    }

    private static int[] topKFrequentAlt(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> valueToFreqMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            Integer value = Integer.valueOf(nums[i]);
            Integer freq = valueToFreqMap.get(value);
            if (freq == null) {
                freq = Integer.valueOf(0);
            }

            valueToFreqMap.put(value, Integer.valueOf(freq.intValue() + 1));
        }

        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

        for (Map.Entry<Integer, Integer> entry : valueToFreqMap.entrySet()) {
            minHeap.offer(new Integer[] { entry.getKey(), entry.getValue() });
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] ret = new int[k];
        while (!minHeap.isEmpty()) {
            int value = minHeap.poll()[0].intValue();
            ret[minHeap.size()] = value;
        }

        return ret;
    }

    private static int[] topKFrequentCustomObject(int[] nums, int k) {
        int[] result = new int[k];
        List<FrequencyPair> frequencyList = new ArrayList<>();
        Set<Integer> intSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for(Integer i: intSet){
            FrequencyPair frequencyPair = new FrequencyPair(i);
            for(int j: nums){
                if(j == i){
                    frequencyPair.increment();                    
                } 
            }
            frequencyList.add(frequencyPair);
        }
        frequencyList.sort((o1, o2) -> o2.frequency - o1.frequency);
        for(int i = 0; i < k; i++){
            result[i] = frequencyList.get(i).number;
        }
        return result;
    }

}

class FrequencyPair {
    Integer number;
    int frequency;

    public FrequencyPair() {
    }

    public FrequencyPair(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public void increment() {
        this.frequency++;
    }

}