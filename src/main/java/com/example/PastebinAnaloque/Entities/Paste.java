package com.example.PastebinAnaloque.Entities;


import com.example.PastebinAnaloque.Enums.Access;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Paste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String paste;
    private int expirationTime;
    private Access access;

    private String hashcode;

    @Override
    public String toString() {
        return "Paste{" +
                "Id=" + Id +
                ", paste='" + paste + '\'' +
                ", expirationTime=" + expirationTime +
                ", access=" + access +
                ", hashcode=" + hashcode +
                '}';
    }
}
