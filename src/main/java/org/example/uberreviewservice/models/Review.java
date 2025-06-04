package org.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookingreview")
public class Review {

    @Id // this annotation makes the id property a primary key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY)// IDENTITY MEANS AUTO INCREMENT
    private Long id;

    @Column(nullable = false)
    private String content;
    private Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) //this annotation tells sping about the froat of data object to be stored i.e Date/Time
    @CreatedDate //this annotation tells spring only handle it for object creation
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate //this annotation tells spring only handle it for object update
    private Date updatedAt;

    @Override
    public String toString() {
        return "Review: "+this.content+" "+this.rating+" "+this.createdAt;
    }
}

//new review(content, reviw)
