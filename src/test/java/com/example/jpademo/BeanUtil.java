package com.example.jpademo;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class BeanUtil {
    public static void main(String[] args) {


        final List<Integer> list = List.of(1, 10, 11, 12, 13, 2, 3, 4, 6, 7, 8, 9, 5);

        final String str = list.stream()
                .filter(i -> i % 2 == 1)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining("|"));

        System.out.println(str);

        list.stream()
                .reduce(Integer::sum)
                .ifPresent(integer -> log.info("求和：{}", integer));

    }

    Integer value;

    public BeanUtil(Integer value) {
        this.value = value;
    }

    public int test() {
        try {
            log.info("test:{}", value);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(1);
        return value;
    }

}
