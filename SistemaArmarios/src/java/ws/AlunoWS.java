package ws;


import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import model.Aluno;
import rn.AlunoRN;

@Path("alunos")
public class AlunoWS {

    @EJB
    private AlunoRN alunoRN;

    @Context
    private UriInfo context;

    public AlunoWS() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Aluno> getAluno() {
        return alunoRN.listar();
    }
//
//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_XML)
//    public Aluno getAluno(@PathParam("id") long id) {
//        return alunoRN.buscar(id);
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_XML)
//    public void adicionarAluno(Aluno a, @Context final HttpServletResponse response) {
//        alunoRN.salvar(a);
//        //Alterar o codigo para 201 (Created)
//        response.setStatus(HttpServletResponse.SC_CREATED);
//        try {
//            response.flushBuffer();
//        } catch (IOException e) {
//            //Erro 500
//            throw new InternalServerErrorException();
//        }
//
//    }
//
//    @PUT
//    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_XML)
//    public void alterarAluno(@PathParam("id") long id, Aluno aluno) {
//        Aluno a =alunoRN.buscar(id);
//        a.setNome(aluno.getNome());
//        a.setEmail(aluno.getEmail());
//        a.setTelefone(aluno.getTelefone());
//        a.setMatricula(aluno.getMatricula());
//        alunoRN.atualizar(a);
//    }
//
//    @DELETE
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_XML)
//    public Aluno removerAluno(@PathParam("id") long id) {
//        Aluno a =alunoRN.buscar(id);
//        alunoRN.remover(a);
//        return a;
//    }
}
