package com.example.demo.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
//@ResponseBody
public class ClientController {
	
	List<Customer> customerlist = new ArrayList<Customer>();
	
	@RequestMapping(path="/",method=RequestMethod.GET)
	public String test() {
		
		return "Hello Spring boot!!!!...";
	}
	
	@RequestMapping(path="user")    // GET Method is default
	public String demo() {
		return "My name is Yeshwanth Kumar";
	}
	
	@RequestMapping(path="demo")    
	public int demo1() {
		return 1234;
	}
	
	@RequestMapping("admin")
	public String demo2() {
		return "<b style='color:red'>I am in Admin Page</b>";
	}
	
	@GetMapping("test")
	public double demo3() {
		return 123.45;
	}
	
	@GetMapping("display1/{id}")
	public int display1(@PathVariable("id") int eid)
	{
		return eid;
	}
	
	@GetMapping("display2/{a}/{b}")
	public double display2(@PathVariable("a") double x,@PathVariable("b") double y)
	{
		return x+y;
	}
	
	@GetMapping("display3/{a}/{b}")
	public String display3(@PathVariable("a") double x,@PathVariable("b") double y)
	{
		return "Output="+(x+y);
	}
	
	@GetMapping("display4/{name}")
	public String display4(@PathVariable("name") String name)
	{
		return "<font size='+2' color='green'>"+name+"</font>";
	}
	
	@GetMapping("display5")
	public int display5(@RequestParam("id") int eid)
	{
		return eid;
	}
	@GetMapping("display6")
	public String display6(@RequestParam("id") int eid, @RequestParam("name") String name)
	{
		String text1="My ID="+eid;
		String text2="My Name="+name;
		
		String output = text1 +"<br>"+text2;
		
		return output;
	}
	
	@GetMapping("display7")
	public String display7(@RequestParam("fname") String x, @RequestParam("lname") String y) 
	{
		return x.toUpperCase()+" "+y.toUpperCase();
	}
	
	@PostMapping("addcustomer")
	public String addcustomerdemo(@RequestBody Customer customer)
	{
		customerlist.add(customer);
		return "Customer added successfully";
		
	}
	
	@GetMapping("viewcustomers")
	public List<Customer> viewcustomerdemo()
	{
		return customerlist;
	}
	
	@RequestMapping(path="viewcustomerjson", produces=MediaType.APPLICATION_JSON_VALUE)    
	public List<Customer>  viewcustomerxml() {
		return customerlist;
	}
}

