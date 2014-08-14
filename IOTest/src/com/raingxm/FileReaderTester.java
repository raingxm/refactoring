package com.raingxm;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.management.RuntimeErrorException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileReaderTester {
	
	private FileReader _input;

	@Before
	public void setUp() {
		try {
			_input = new FileReader("data.txt");
		} catch (FileNotFoundException e) {
			throw new RuntimeException("error on closing test file");
		}
	}
	
	@After
	public void closeTestFile() {
		try {
			_input.close();
		} catch (IOException e) {
			throw new RuntimeException("error on closing test file");
		}
	}
	
	@Test
	public void testRead() throws IOException {
		char ch = '&';
		for(int i = 0; i < 4; i++) {
			ch = (char) _input.read();
		}
		assertEquals('d', ch);
	}
	
	@Test
	public void testReadAtEnd() throws IOException {
		int ch = -1234;
		for(int i = 0; i < 148; i++) {
			ch = _input.read();
		}
		assertEquals(-1, ch);
	}

}
