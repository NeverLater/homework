package com.thoughtworks.homework;

public class TextProcesser {

	/**
	 * @param text  输入文本字符串
	 * @param width 编辑器宽度
	 * @throws Exception 
	 */
	public void process(String text, int width) throws Exception {
		char[] textChar = text.toCharArray();
		int line = 1;
		int beforeindex,afterindex;//检测不能处理字符
		checkWidth(width);
		for (int i = 0; i < textChar.length;) {
			beforeindex=i;
			// for循环i++放在内部，取空格
			while (i < textChar.length && textChar[i] == ' ') {
				if (i != 0 && i % width == 0)
					line++;
				i++;

			}
			
			// 取字符
			String word = "";
			int beforeline = line;
			boolean firstword = false;
			while (i < textChar.length && isChar(textChar[i])) {
				if (text.indexOf(textChar[i]) == i)
					firstword = true;
				word += textChar[i];
				if (i != 0 && i % width == 0)
					line++;
				i++;

			}
			afterindex=i;
			
			checkSpecialCh(beforeindex,afterindex);
			
			int afterline = line;
			// 打印行号
			printSegement(beforeline, afterline, word, firstword);

		}
	}

	/**
	 * @param beforeline 分行后当前word第一个字符行号
	 * @param afterline  分行后当前word最后一个字符行号
	 * @param word       word字符串
	 * @param firstword  是否首个word
	 */
	public void printSegement(int beforeline, int afterline, String word, boolean firstword) {
		if (word.equals("")) return;
		if (firstword) System.out.print(word + "(" + afterline + ");");
		else if (afterline != beforeline)  System.out.print("(" + beforeline + ");" + word + "(" + beforeline + "," + afterline + ");");
		else {
			System.out.print("(" + beforeline + ");" + word + "(" + afterline + ");");
		}
	}
	
	public void checkWidth(int width) throws Exception {
		if(width<20||width>80) throw new Exception("ERROR: Width out of range!");
	}
	
	public void checkSpecialCh(int beforeindex,int afterindex) throws Exception {
		if(beforeindex==afterindex) throw new Exception("ERROR: Invalid character detected!");
	}
	
	/**
	 * @param ch
	 * @return 是否字符串
	 */
	public boolean isChar(char ch) {

		if ((Character.isLowerCase(ch) || Character.isUpperCase(ch)))
			return true;
		return false;
	}
}
