/**
 * 
 */
package com.luv2code.springdemo;

/**
 * @author Felipe Castro
 *
 */
public class SpanishFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "¡Hoy es tu día de suerte!";
	}

}
