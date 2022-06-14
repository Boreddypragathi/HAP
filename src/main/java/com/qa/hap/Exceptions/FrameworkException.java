package com.qa.hap.Exceptions;


	public class FrameworkException extends RuntimeException {

		
		public FrameworkException(String mesg) {
			super(mesg);
			printStackTrace();
		}
		
		
		
	}

