package rn;

import model.Aluno;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AlunoRN extends AbstractRN<Aluno>{
    @PersistenceContext(unitName="ArmariosJPAPU")
    private EntityManager manager;
    
    public AlunoRN() {
        super(Aluno.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }
    
    public void salvar(Aluno a)
    {
        //validar parâmetros
        if(a.getId()==null)
            super.adicionar(a);
        else
            super.atualizar(a);
    }   
}