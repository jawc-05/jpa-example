/**
 * @author jawc
 */
package br.com.jawc.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name="product_sq", sequenceName = "sq_product", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "name",  nullable = false, length = 50)
    private String name;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "category", length = 25)
    private String category;
}
