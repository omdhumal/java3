package com.util;

import org.springframework.stereotype.Component;

@Component
public class ComponentTest {
	
	public void callInController() {
		System.out.println("object can call from External class bu @component keyword.");
	}

}
