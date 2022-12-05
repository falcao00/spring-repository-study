package br.com.study;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.study.exception.UnsuportedMathOperation;

@RestController
public class GreattingController {

	
	private static final String template = "Hello, %s!";
	private final AtomicLong count = new AtomicLong();
	
	//addition
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
				
		if( !isNumeric(numberOne) || !isNumeric(numberTwo) ) {
			throw new UnsuportedMathOperation("Please Set a numeric value");
		} 
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	//subtraction
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double sub(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
				
		if( !isNumeric(numberOne) || !isNumeric(numberTwo) ) {
			throw new UnsuportedMathOperation("Please Set a numeric value");
		} 
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	//multiplication
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double mult(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if( !isNumeric(numberOne) || !isNumeric(numberTwo) ) {
			throw new UnsuportedMathOperation("Please Set a numeric value");
		} 
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
		
	}
	
	//division
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double div(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if( !isNumeric(numberOne) || !isNumeric(numberTwo) ) {
			throw new UnsuportedMathOperation("Please Set a numeric value");
		} else if (!checkDivisionForZero(numberTwo)) {
			throw new UnsuportedMathOperation("Please Set a number diferent from 0");
		}
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	//average
	@RequestMapping(value = "/avre/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double avre(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if( !isNumeric(numberOne) || !isNumeric(numberTwo) ) {
			throw new UnsuportedMathOperation("Please Set a numeric value");
		}
		
		Double sum = sum(numberOne, numberTwo);
		
		return sum/2;
	}
	
	//Sqrt
	@RequestMapping(value = "/sqrt/{numberOne}/", 
			method=RequestMethod.GET)
	public Double Sqrt(
			@PathVariable(value = "numberOne") String numberOne
			) throws Exception {
		
		if( !isNumeric(numberOne)) {
			throw new UnsuportedMathOperation("Please Set a numeric value");
		}
		return Math.sqrt(convertToDouble(numberOne));
	}

	private boolean checkDivisionForZero(String numberTwo) {
		double strNumber = convertToDouble(numberTwo);
		if (strNumber != 0) return true;
		return false;
	}

	private double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
