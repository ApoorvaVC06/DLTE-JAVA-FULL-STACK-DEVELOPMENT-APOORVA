package Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Studentss {
    @Id
    private int registerNumber;
    private String studentName;
    private int studentAge;
    private String studentEmail;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "AddressMapper",joinColumns = @JoinColumn(name = "RegNum"),inverseJoinColumns = @JoinColumn(name = "AddId"))
    @Nullable
    @JsonBackReference
    private Collection<Addresss> myBeneficiary=new ArrayList<>();
}
