package com.kata.warehouse_accounting.country.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_packing")
@SQLDelete(sql = "UPDATE product_packing SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class ProductPacking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String packingTitle;

    private boolean deleted = Boolean.FALSE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPacking that = (ProductPacking) o;
        return deleted == that.deleted && Objects.equals(id, that.id) && Objects.equals(packingTitle, that.packingTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, packingTitle, deleted);
    }
}
