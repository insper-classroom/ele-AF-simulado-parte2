/**
 * Curso: Elementos de Sistemas
 * Arquivo: CodeTest.java
 * Created by Luciano Soares <lpsoares@insper.edu.br>
 * Date: 16/04/2017
 */

package assembler;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.Rule;

import java.io.IOException;
import java.io.PrintWriter;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CodeTest  {

	private static StringBuilder builder = new StringBuilder();

	/**
	 * Create the test case
	 */
	public CodeTest() {
	}

	
	/**
	 * Teste para geração de código para Destino
	 */
	@Test
	public void testCode_Computation() {

		try {
			assertTrue("cmp_jg %A, %B"		,Code.comp(new String[] {"cmp_jg","%A","%B"}).matches("000001000111|001000010011"));
			assertTrue("cmp_jg %A, %C"		,Code.comp(new String[] {"cmp_jg","%A","%C"}).matches("000010000111|010000010011"));
			assertTrue("cmp_jg %A, %D"		,Code.comp(new String[] {"cmp_jg","%A","%D"}).matches("000011000111|011000010011"));
			assertTrue("cmp_jg %A, %E"		,Code.comp(new String[] {"cmp_jg","%A","%E"}).matches("000100000111|100000010011"));
			assertTrue("cmp_jg %A, %F"		,Code.comp(new String[] {"cmp_jg","%A","%F"}).matches("000101000111|101000010011"));
			assertTrue("cmp_jg %A, %G"		,Code.comp(new String[] {"cmp_jg","%A","%G"}).matches("000110000111|110000010011"));
			assertTrue("cmp_jg %A, (%A)"	,Code.comp(new String[] {"cmp_jg","%A","(%A)"}).matches("000111000111|111000010011"));
			assertTrue("cmp_jg %A, %A"		,Code.comp(new String[] {"cmp_jg","%A","%A"}).matches("000000000111|000000010011"));
			assertTrue("cmp_jg %A, %B, %C"	,Code.comp(new String[] {"cmp_jg","%A","%B","%C"}).matches("000001000111|001000010011"));
			assertTrue("cmp_jg %A, %C, %C"	,Code.comp(new String[] {"cmp_jg","%A","%C","%C"}).matches("000010000111|010000010011"));
			assertTrue("cmp_jg %A, %D, %D"	,Code.comp(new String[] {"cmp_jg","%A","%D","%D"}).matches("000011000111|011000010011"));
			assertTrue("cmp_jg %A, %E, %F"	,Code.comp(new String[] {"cmp_jg","%A","%E","%F"}).matches("000100000111|100000010011"));
			assertTrue("cmp_jg %A, %F, %A"	,Code.comp(new String[] {"cmp_jg","%A","%F","%A"}).matches("000101000111|101000010011"));
			assertTrue("cmp_jg %A, %G, %A"	,Code.comp(new String[] {"cmp_jg","%A","%G","%A"}).matches("000110000111|110000010011"));
			assertTrue("cmp_jg %A, (%A), %C",Code.comp(new String[] {"cmp_jg","%A","(%A)","%C"}).matches("000111000111|111000010011"));
			assertTrue("cmp_jg %A, %A, %G"	,Code.comp(new String[] {"cmp_jg","%A","%A","%G"}).matches("000000000111|000000010011"));

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Teste para geração de código para Destino
	 */
	@Test
	public void testCode_Destine() {

		try {
			org.junit.Assume.assumeNotNull( Code.dest(new String[] {"nop"}) );		// ignora test
		} catch(Exception e) {
			org.junit.Assume.assumeNoException(e);
		}
		try {

			assertEquals("0000", Code.dest(new String[] { "cmp_jg", "%A", "%D" }));
			assertEquals("0000", Code.dest(new String[] { "cmp_jg", "%A", "%B" }));
			assertEquals("0001", Code.dest(new String[] { "cmp_jg", "%A", "%D", "%A" }));
			assertEquals("0010", Code.dest(new String[] { "cmp_jg", "%A", "%D", "%B" }));
			assertEquals("0011", Code.dest(new String[] { "cmp_jg", "%A", "%D", "%C" }));
			assertEquals("0100", Code.dest(new String[] { "cmp_jg", "%A", "%D", "%D" }));
			assertEquals("0101", Code.dest(new String[] { "cmp_jg", "%A", "%D", "%E" }));
			assertEquals("0110", Code.dest(new String[] { "cmp_jg", "%A", "%D", "%F" }));
			assertEquals("0111", Code.dest(new String[] { "cmp_jg", "%A", "%D", "%G" }));
			assertEquals("1000", Code.dest(new String[] { "cmp_jg", "%A", "%D", "(%A)" }));
			assertEquals("1001", Code.dest(new String[] { "cmp_jg", "%A", "%D", "%A", "(%A)" }));
			assertEquals("1010", Code.dest(new String[] { "cmp_jg", "%A", "%D", "%B", "(%A)" }));
			assertEquals("1011", Code.dest(new String[] { "cmp_jg", "%A", "%D", "(%A)", "%C" }));
			assertEquals("1100", Code.dest(new String[] { "cmp_jg", "%A", "%D", "(%A)", "%D" }));
			assertEquals("1101", Code.dest(new String[] { "cmp_jg", "%A", "%D", "%E", "(%A)" }));
			assertEquals("1110", Code.dest(new String[] { "cmp_jg", "%A", "%D", "(%A)", "%F" }));
			assertEquals("1111", Code.dest(new String[] { "cmp_jg", "%A", "%D", "(%A)", "%G" }));

		} catch(Exception e) {
			e.printStackTrace();
		}

	}


}
