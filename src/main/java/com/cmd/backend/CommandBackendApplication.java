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
import com.cmd.backend.entity.Product;
import com.cmd.backend.repo.BrandRepository;
import com.cmd.backend.repo.CategoryRepository;
import com.cmd.backend.repo.CommandRepository;
import com.cmd.backend.repo.CustomerRepository;
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
		
		categoryRepository.save(info);
		categoryRepository.save(sport);
		categoryRepository.save(maison);
		categoryRepository.save(beaute);

		Customer c1=new Customer("Rbati","Abdo","rbati@gmail.com","pass","lot 9 juillet n17","0652515458");
		Customer c2=new Customer("Kaldi","Rachid","ekaldi@gmail.com","pass00","Av toblik n17","0652115458");
		customerRepository.save(c1);
		customerRepository.save(c2);
		
		Product p1= new Product("photo.jpg","ordinateur",4512.25,50,new Date(),"ordinateur portable 11gen 8G Ram 500G SSD","",info,hp);
		Product p2=new Product("photo.jpg","Imprimante",712.25,50,new Date(),"Imp 3 options scanner & photocopie & WIFI","",info,dell);
		Product p3= new Product("photo.jpg","Gel",452.25,50,new Date(),"Gel douche Haute gamme","",beaute,bls);
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		
		
		List<Product> list=new ArrayList<>();
		list.add(p1);
		list.add(p2);
		
		List<Product> list2=new ArrayList<>();
		list2.add(p1);
		list2.add(p2);
		list2.add(p3);
		
		Command cmd= new Command(new Date(),false,"espece",c1,list);
		orderRepository.save(cmd);
		
		Command cmd2= new Command(new Date(),false,"Cheque",c2,list2);
		orderRepository.save(cmd2);
	
	}

}
