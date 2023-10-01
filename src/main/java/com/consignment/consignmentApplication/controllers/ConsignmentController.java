package com.consignment.consignmentApplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consignment.consignmentApplication.dao.Consignment;
import com.consignment.consignmentApplication.dao.ConsignmentRepository;


@CrossOrigin(origins= "*",allowedHeaders= "*")
@RestController
public class ConsignmentController {
	
	@Autowired
	ConsignmentRepository repo;
	
	@GetMapping("/consignments")
	public List<Consignment> getAllConsignments()
	{
		return (List<Consignment>) repo.findAll();
		
	}
	
	@PostMapping("/consignment")
	public Consignment saveConsignment(@RequestBody Consignment consignement)
	{
		return repo.save(consignement);
	}
	
	@PutMapping("/consignment/{id}")
	public Consignment updateConsignment(@PathVariable Integer id,@RequestBody Consignment consignment)
	{
		Consignment existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Consignment Not Found"+id));
		
		existing.setConsignmentStatus(consignment.getConsignmentStatus()!= null ? consignment.getConsignmentStatus():existing.getConsignmentStatus());
		existing.setConsignmentCategory(consignment.getConsignmentCategory()!= null ? consignment.getConsignmentCategory():existing.getConsignmentCategory());
		existing.setDeleveryPartner(consignment.getDeleveryPartner()!= null ? consignment.getDeleveryPartner():existing.getDeleveryPartner());
		
		repo.save(existing);
		return existing;
	}
	
	@GetMapping("/consignment/{id}")
	public Consignment getConsignmentById(@PathVariable Integer id)
	{
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Consignment Not Found"+id));
	}
	
	@DeleteMapping("/consignment/{id}")
	public String deleteConsignment(@PathVariable Integer id)
	{
		repo.deleteById(id);
		
		return "Consignment is deleted";
		
	}
}
