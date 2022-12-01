package br.com.study;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreattingController {

	
	private static final String template = "Hello, %s!";
	private final AtomicLong count = new AtomicLong();
	
	@RequestMapping("/grettings")
	public Grettings gretting(@RequestParam(value = "name", defaultValue = "world") String name) {
		return new Grettings(count.incrementAndGet(), String.format(template, name));
	}
}
