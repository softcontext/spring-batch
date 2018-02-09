package com.example.demo.writer;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

/*
 * we need add a header row into our CSV file, 
 * we have to create a component that writes the header to the created CSV file. 
 */
public class StringHeaderWriter implements FlatFileHeaderCallback {
	 
    private final String header;
 
    public StringHeaderWriter(String header) {
        this.header = header;
    }
 
    @Override
    public void writeHeader(Writer writer) throws IOException {
        writer.write(header);
    }
    
}
