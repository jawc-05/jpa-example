/**
 * @author jawc
 */
package br.com.jawc;

import br.com.jawc.dao.interfaces.ITuitionDao;
import br.com.jawc.dao.TuitionDao;
import br.com.jawc.domain.Tuition;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;

public class TuitionTest {

    private ITuitionDao dao;

    public TuitionTest() {
        dao = new TuitionDao();
    }

    @Test
    public void saveTest(){
        Tuition tuition = new Tuition();
        tuition.setCode("A2");
        tuition.setPrice(new BigDecimal("500.00"));
        tuition.setDataTuition(Instant.now());
        tuition.setStatus("ATIVA");
        tuition = dao.save(tuition);

        Assert.assertNotNull(tuition);
        Assert.assertNotNull(tuition.getId());
    }
}
