package com.example.zwq.utils;

import com.example.zwq.sys.entity.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * description: 集合
 *
 * @author zwq
 * @date 2022/4/26 11:13
 */
public class TestMain {

	public static void main(String[] args) {
		TestMain.doFilter();
		TestMain.doMap();
		TestMain.doDistinct();
		TestMain.doSorted();
		TestMain.doLimit();
		TestMain.doSkip();
		TestMain.doReduce();
		TestMain.doMin();
		TestMain.doMatch();
		TestMain.doGroup();
	}

	/**
	 * description: 过滤
	 * @author zwq
	 * @date 2022/4/26 14:28
	 */
	public static void doFilter() {
		System.out.println("----------- doFilter -------------");
		List<Integer> all = Arrays.asList(1,1,3,4,5);
		all = all.stream().filter(item -> item > 3).collect(Collectors.toList());
		all.forEach(l -> System.out.print(l+ " "));
		System.out.println();
	}

	/**
	 * description: 转换
	 * @author zwq
	 * @date 2022/4/26 14:28
	 */
	public static void doMap() {
		System.out.println("----------- doMap -----------");
		List<Integer> all = Arrays.asList(1,1,3,4,5);
		List<String> allString;
		allString = all.stream().map(item -> "数字" + item).collect(Collectors.toList());
		allString.forEach(l -> System.out.print(l+ " "));
		System.out.println();
	}

	/**
	 * description: 去重
	 * @author zwq
	 * @date 2022/4/26 14:28
	 */
	public static void doDistinct() {
		System.out.println("----------- doDistinct -----------");
		List<Integer> all = Arrays.asList(1,1,3,4,5);
		all = all.stream().distinct().collect(Collectors.toList());
		all.forEach(l -> System.out.print(l + " "));
		System.out.println();
	}

	/**
	 * description: 排序
	 * @author zwq
	 * @date 2022/4/26 14:28
	 */
	public static void doSorted() {
		System.out.println("----------- doSorted -----------");
		List<Integer> integerList = Arrays.asList(1,4,2,3,4);
		integerList = integerList.stream().sorted().collect(Collectors.toList());
		integerList.forEach(integer -> System.out.print(integer + " "));
		System.out.println();

		List<User> users = new ArrayList<>();
		users.add(new User(1L, "zwq", 23, "sdf@fasd.dcom"));
		users.add(new User(2L, "zwq2", 27, "1sdf@fasd.dcom"));
		users.add(new User(3L, "zwq3", 23, "s23df@fasd.dcom"));
		users.add(new User(4L, "zwq4", 25, "sdf@fa2sd.dcom"));
		users = users.stream().sorted((user1, user2) -> Integer.compare(user2.getAge(), user1.getAge()))
				.collect(Collectors.toList());
		users.forEach(user -> System.out.println(user));
	}

	/**
	 * description: 限制元素个数
	 * @author zwq
	 * @date 2022/4/26 14:28
	 */
	public static void doLimit() {
		System.out.println("----------- doLimit -----------");
		List<Integer> all = Arrays.asList(1,1,3,4,5);
		all = all.stream().limit(2).collect(Collectors.toList());
		all.forEach(l -> System.out.print(l + " "));
		System.out.println();
	}

	/**
	 * description: 删除前两个元素
	 * @author zwq
	 * @date 2022/4/26 14:28
	 */
	public static void doSkip() {
		System.out.println("----------- doSkip -----------");
		List<Integer> all = Arrays.asList(1,1,3,4,5);
		all = all.stream().skip(2).collect(Collectors.toList());
		all.forEach(l -> System.out.print(l + " "));
		System.out.println();
	}

	/**
	 * description: 聚合
	 * @author zwq
	 * @date 2022/4/26 14:28
	 */
	public static void doReduce() {
		System.out.println("----------- doReduce -----------");
		List<String> all = Arrays.asList("欢", "迎", "你");
		String s = all.stream().reduce("Java", (a, b) -> a + b);
		System.out.println(s);
	}

	/**
	 * description: 最小值
	 * @author zwq
	 * @date 2022/4/26 14:28
	 */
	public static void doMin() {
		System.out.println("----------- doMin -----------");
		List<User> users = new ArrayList<>();
		users.add(new User(1L, "zwq", 23, "sdf@fasd.dcom"));
		users.add(new User(2L, "zwq2", 27, "1sdf@fasd.dcom"));
		users.add(new User(3L, "zwq3", 21, "s23df@fasd.dcom"));
		User minUser = users.stream().min(Comparator.comparing(User::getAge)).get();
		System.out.println(minUser);
	}

	/**
	 * description: 匹配
	 * @author zwq
	 * @date 2022/4/26 14:28
	 */
	public static void doMatch() {
		System.out.println("----------- doMatch -----------");
		List<User> users = new ArrayList<>();
		users.add(new User(1L, "zwq", 23, "com"));
		users.add(new User(2L, "zwq2", 27, "cn"));
		users.add(new User(3L, "zwq3", 21, "none"));
		// anyMatch：Stream 中任意一个元素符合传入的 predicate，返回 true
		Boolean anyone = users.stream().anyMatch(user -> "com".equals(user.getEmail()));
		// allMatch：Stream 中全部元素符合传入的 predicate，返回 true
		Boolean everybody = users.stream().allMatch(user -> "com".equals(user.getEmail()));
		// noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true
		Boolean nobody = users.stream().noneMatch(user -> "test".equals(user.getEmail()));
		System.out.println(anyone + " " + everybody + " " + nobody);
	}

	/**
	 * description: 分组
	 * @author zwq
	 * @date 2022/4/26 14:28
	 */
	public static void doGroup() {
		System.out.println("----------- doGroup -----------");
		List<User> users = new ArrayList<>();
		users.add(new User(1L, "zwq", 23, "com"));
		users.add(new User(2L, "zwq", 27, "cn"));
		users.add(new User(3L, "zwq3", 21, "none"));
		Map<String,List<User>> genderMap =  users.stream()
				.collect(Collectors.groupingBy(User::getName));
		genderMap.forEach((k, v) -> System.out.println(k + ":" + v));
	}

}
