package Entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Addresss {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int addId;
    private int doorNum;
    private String street;
    private String city;
    private String type;
}