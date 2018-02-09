package com.example.demo.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.example.demo.model.Report;

public class CustomWriter implements ItemWriter<Report> {

	@Override
	public void write(List<? extends Report> items) throws Exception {
		System.out.println("CustomWriter # write() called. items.size = " + items.size());
		
		for (Report item : items) {
			System.out.println(item);
		}
	}

}
