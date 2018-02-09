package com.example.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name="student")
public class StudentDTO {
	private String emailAddress;
    private String name;
    private String purchasedPackage;
}
