package br.com.salesha.sistemaPet.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	public String hello() {
		return "Olá mundo";
	}
}
