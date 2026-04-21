/**
 * @author jawc
 */
package br.com.jawc;

import br.com.jawc.dao.interfaces.IProductDao;
import br.com.jawc.dao.ProductDao;
import br.com.jawc.domain.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    private IProductDao dao;

    public ProductTest() {
        dao = new ProductDao();
    }

    @Test
    public void saveProductTest() {
        Product prod = new Product();
        prod.setName("Banana");
        prod.setCategory("Food");
        prod.setDescription("Healthy food, organic");
        prod = dao.save(prod);
        Assert.assertNotNull(prod.getId());
        Assert.assertNotNull(prod);
    }
}
