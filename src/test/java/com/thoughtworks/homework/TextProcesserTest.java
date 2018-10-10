package com.thoughtworks.homework;

import org.junit.Assert;
import org.junit.Test;

public class TextProcesserTest {
	static TextProcesser processer = new TextProcesser();

	@Test
	public void test1() {
		// 无特殊字符，30
		try {
			processer.process("The main theme of education in engineering school is learning to teach yourself", 30);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test2() {
		// 特殊字符，30
		Throwable ex=null;
		try {
			processer.process("The main theme of edu**cation in engineering school is learning to teach yourself", 30);
		} catch (Exception e) {
			ex=e;
			
		}
		Assert.assertEquals("ERROR: Invalid character detected!", ex.getMessage());
	}

	@Test
	public void test3()  {
		Throwable ex=null;
		try {
			processer.process("The main theme of education in engineering school is learning to teach yourself", 100);
		} catch (Exception e) {
			ex=e;
		}
		// 无特殊字符，100
		Assert.assertEquals("ERROR: Width out of range!", ex.getMessage());

	}

	@Test
	public void test4()  {
		// 无特殊字符，15
		Throwable ex=null;
		try {
			processer.process("The main theme of education in engineering school is learning to teach yourself", 15);
		} catch (Exception e) {
			ex=e;
		}
		Assert.assertEquals("ERROR: Width out of range!", ex.getMessage());

	}

	@Test
	public void test5()  {
		// 无特殊字符，80
		Throwable ex=null;
		try {
			processer.process("The main theme of education in engineering school is learning to teach yourself", 80);
		} catch (Exception e) {
			ex=e;
		}

	}
	
	

}
