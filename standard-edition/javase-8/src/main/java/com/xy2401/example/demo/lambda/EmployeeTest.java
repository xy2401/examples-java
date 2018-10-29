package com.xy2401.example.demo.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BinaryOperator;

public class EmployeeTest {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("张三", 3000, 7, 60));
		employees.add(new Employee("李四", 4000, 6, 40));
		employees.add(new Employee("王五", 5000, 5, 30));
		employees.add(new Employee("赵六", 6000, 4, 50));
		employees.add(new Employee("周七", 7000, 3, 70));// 好惨啊 70 工龄 还没有退休

		System.out.println(employees);

		// 工资比较器
		Comparator<Employee> salaryComparator = (a, b) -> Double.compare(a.getSalary(), b.getSalary());

		// 技能等级比较器
		Comparator<Employee> levelComparator = (a, b) -> Double.compare(a.getLevel(), b.getLevel());

		// 工龄比较器
		Comparator<Employee> 工龄Comparator = (a, b) -> Double.compare(a.get工龄(), b.get工龄());

		// 按工资排序
		Collections.sort(employees, salaryComparator);
		System.out.println("工资"+employees);

		// 按技能等级排序
		Collections.sort(employees, levelComparator);
		System.out.println(employees);

		// 按工龄排序
		Collections.sort(employees, 工龄Comparator);
		System.out.println(employees);

		Random random = new Random(47);
		// 随机挑选两个员工
		Employee employeeRandom1 = employees.get(random.nextInt(employees.size()));
		Employee employeeRandom2 = employees.get(random.nextInt(employees.size()));

		System.out.println("bu幸运员工 a: " + employeeRandom1);
		System.out.println("bu幸运员工 b:" + employeeRandom2);

		// 取工资较高的员工 捐钱
		Employee employee = BinaryOperator.maxBy(salaryComparator).apply(employeeRandom1, employeeRandom2);

		System.out.println("捐钱的员工为:" + employee);

	}
	
 

}
