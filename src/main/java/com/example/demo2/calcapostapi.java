package com.example.demo2;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class calcapostapi {
    @PersistenceContext(unitName = "MyPersistenceUnit")
    private EntityManager entityManager;
    @Resource
    UserTransaction ut;
    @Path("/calc")

    @POST
    public String createCalculation(CalculationEntity calculationentity) {

        CalculationEntity CE = new CalculationEntity();
        CE.setNumber1(calculationentity.getNumber1());
        CE.setNumber2(calculationentity.getNumber2());
        CE.setOperation(calculationentity.getOperation());
        if(CE.getOperation().equals("+"))
        {
            CE.setResult(CE.getNumber1() + CE.getNumber2());


        } else if (CE.getOperation().equals("-")) {
            CE.setResult(CE.getNumber1() - CE.getNumber2());

        } else if (CE.getOperation().equals("*")) {
            CE.setResult(CE.getNumber1() * CE.getNumber2());

        } else if (CE.getOperation().equals("/")) {
            CE.setResult(CE.getNumber1() / CE.getNumber2());

        }
        else
        {
            return "invaild operator";
        }

        try {
            ut.begin();
        } catch (NotSupportedException e) {
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }

        entityManager.persist(CE);
        try {
            ut.commit();
        } catch (RollbackException e) {
            throw new RuntimeException(e);
        } catch (HeuristicMixedException e) {
            throw new RuntimeException(e);
        } catch (HeuristicRollbackException e) {
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
        return "result: "+CE.getResult();
    }
    @Path("/calculations")
    @GET
    public List<CalculationEntity> getallcalculations()
    {
        List<CalculationEntity> calculationEntities = entityManager
                .createQuery("SELECT ce FROM CalculationEntity ce", CalculationEntity.class)
                .getResultList();
        return calculationEntities;

    }



}