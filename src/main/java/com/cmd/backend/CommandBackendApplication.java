package com.cmd.backend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cmd.backend.entity.Brand;
import com.cmd.backend.entity.Category;
import com.cmd.backend.entity.Command;
import com.cmd.backend.entity.Customer;
import com.cmd.backend.entity.Detail;
import com.cmd.backend.entity.Product;
import com.cmd.backend.repo.BrandRepository;
import com.cmd.backend.repo.CategoryRepository;
import com.cmd.backend.repo.CommandRepository;
import com.cmd.backend.repo.CustomerRepository;
import com.cmd.backend.repo.DetailRepository;
import com.cmd.backend.repo.ProductRepository;

@SpringBootApplication
public class CommandBackendApplication implements CommandLineRunner {

	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	BrandRepository brandRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CommandRepository orderRepository;
	
	@Autowired
	DetailRepository detailRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CommandBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Brand hp=new Brand("HP");
		Brand dell=new Brand("DELL");
		Brand bls=new Brand("BIOLASE");
		
		brandRepository.save(hp);
		brandRepository.save(dell);
		brandRepository.save(bls);
		
		Category info=new Category("Informatique");
		Category sport=new Category("Sport");
		Category maison=new Category("Maison");
		Category beaute=new Category("Beaute");
		Category ct5=new Category(0,"Coffee");
		
		categoryRepository.save(info);
		categoryRepository.save(sport);
		categoryRepository.save(maison);
		categoryRepository.save(beaute);
		categoryRepository.save(ct5);

		Customer c1=new Customer("Rbati","Abdo","rbati@gmail.com","pass","lot 9 juillet n17","0652515458");
		customerRepository.save(c1);
		Customer c2=new Customer("Kaldi","Rachid","ekaldi@gmail.com","pass00","Av toblik n17","0652115458");
		customerRepository.save(c2);
		
		int j=0;
		while (j<20) {
			customerRepository.save(new Customer("Rbati"+j,"Abdo"+j,"rbati"+j+"@gmail.com","pass"+j,"lot 9 juillet n17"+j,"06666666"+j));
			j++;
		}
		
		Product p1= new Product("photo.jpg","ordinateur",4512.25,50,new Date(),"ordinateur portable 11gen 8G Ram 500G SSD","",info,hp);
		Product p2=new Product("photo.jpg","Imprimante",712.25,50,new Date(),"Imp 3 options scanner & photocopie & WIFI","",info,dell);
		Product p3= new Product("photo.jpg","Gel",452.25,50,new Date(),"Gel douche Haute gamme","",beaute,bls);
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		
		int i=0;
		while (i<20) {
			productRepository.save( new Product("photo"+i+".jpg","ordinateur"+i,4512.25+i,50+i,new Date(),"ordinateur portable 11gen 8G Ram 500G SSD"+i,"",info,hp));
			i++;
		}
		
		
		List<Product> list=new ArrayList<>();
		list.add(p1);
		list.add(p2);
		
		List<Product> list2=new ArrayList<>();
		list2.add(p1);
		list2.add(p2);
		list2.add(p3);
		
		Command cmd= new Command(new Date(),false,"espece",c1);
		orderRepository.save(cmd);
		
		Detail d1=new Detail(5,p1,cmd);
		detailRepository.save(d1);
		Detail d2=new Detail(5,p2,cmd);
		detailRepository.save(d2);
		
		
		Command cmd2= new Command(new Date(),true,"Cheque",c2);
		orderRepository.save(cmd2);
	
		Detail d3=new Detail(5,p1,cmd2);
		detailRepository.save(d3);
		Detail d4=new Detail(6,p2,cmd2);
		detailRepository.save(d4);
		Detail d5=new Detail(10,p3,cmd2);
		detailRepository.save(d5);
		
		
		Command cmd3= new Command(new Date("10/02/2019"),false,"Cheque",c1);
		orderRepository.save(cmd3);
	
		detailRepository.save(new Detail(15,p1,cmd3));
		detailRepository.save(new Detail(51,p2,cmd3));
		detailRepository.save(new Detail(35,p3,cmd3));
		
		Command cmd19= new Command(new Date("11/05/2019"),false,"Cheque",c1);
		orderRepository.save(cmd19);
	
		detailRepository.save(new Detail(15,p1,cmd19));
		detailRepository.save(new Detail(51,p2,cmd19));
		detailRepository.save(new Detail(35,p3,cmd19));
		
		
		Command cmd4= new Command(new Date("03/02/2021"),false,"Cheque",c1);
		orderRepository.save(cmd4);
	
		detailRepository.save(new Detail(5,p1,cmd4));
		detailRepository.save(new Detail(11,p2,cmd4));
		detailRepository.save(new Detail(32,p3,cmd4));
		
		
		Command cmd5= new Command(new Date("10/02/2018"),false,"Cheque",c1);
		orderRepository.save(cmd5);
	
		detailRepository.save(new Detail(5,p1,cmd5));
		detailRepository.save(new Detail(11,p2,cmd5));
		detailRepository.save(new Detail(32,p3,cmd5));
		
		
		Command cmd6= new Command(new Date("05/02/2018"),true,"Cheque",c1);
		orderRepository.save(cmd6);
	
		detailRepository.save(new Detail(5,p1,cmd6));
		detailRepository.save(new Detail(11,p2,cmd6));
		detailRepository.save(new Detail(32,p3,cmd6));
		
		
		Command cmd7= new Command(new Date("10/02/2018"),true,"Cheque",c1);
		orderRepository.save(cmd7);
	
		detailRepository.save(new Detail(5,p1,cmd7));
		detailRepository.save(new Detail(11,p2,cmd7));
		detailRepository.save(new Detail(32,p3,cmd7));
		
		
	    System.out.println("------------- "+detailRepository.getProducts(cmd2).get(1).getDesignation() + " ------------- ");
		
	    //System.out.println("------------- "+productRepository.searchProduct("info").get(0).getDesignation() + " ------------- ");
		
		
	}

}
