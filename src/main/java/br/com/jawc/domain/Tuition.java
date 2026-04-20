/**
 * @author jawc
 */
package br.com.jawc.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;

@Table(name = "tb_tuition")
public class Tuition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tuition_seq")
    @SequenceGenerator(name="tuition_sq", sequenceName = "sq_tuition", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "data_tuition",  nullable = false)
    private Instant dataTuition;

    @Column(name= "code", length = 10, nullable = false, unique = true)
    private String code;

    @Column(name= "price")
    private BigDecimal price;

    @Column(name = "status")
    private String status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataTuition() {
        return dataTuition;
    }

    public void setDataTuition(Instant dataTuition) {
        this.dataTuition = dataTuition;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
