package app;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.TarefaDAO;
import entity.Tarefa;


@Path("/tarefas")
@Produces(MediaType.APPLICATION_JSON)
public class Routes {
	@Path("/")
	@GET
	public Response getAll(){
		TarefaDAO tarefaDAO = new TarefaDAO();
		List<Tarefa> listTarefa = tarefaDAO.getAll();
		GenericEntity<List<Tarefa>> list = new GenericEntity<List<Tarefa>>(listTarefa){};
		if(listTarefa.size() == 0)
			return Response.status(Response.Status.NOT_FOUND).build();
		return Response.ok(list).build();
	}
	
	@Path("/{id:[0-9]*}")
	@GET
	public Response get(@PathParam("id") int id){
		TarefaDAO tarefaDAO = new TarefaDAO();
		Tarefa tarefa = tarefaDAO.get(id);
		if(tarefa == null)
			return Response.status(Response.Status.NOT_FOUND).build(); 
		return Response.ok(tarefa).build();
	}
	
	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(Tarefa tarefa){
		TarefaDAO tarefaDAO = new TarefaDAO();
		tarefaDAO.insert(tarefa);
		return Response.ok(tarefa).build();
	}
	
	@Path("/")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Tarefa tarefa){
		TarefaDAO tarefaDAO = new TarefaDAO();
		tarefaDAO.update(tarefa);
		return Response.status(Response.Status.OK).build();
	}
	
	@Path("/{id:[0-9]*}")
	@DELETE
	public Response delete(@PathParam("id") int id){
		TarefaDAO tarefaDAO = new TarefaDAO();
		Tarefa tarefa = tarefaDAO.get(id);
		if(tarefa == null)
			return Response.status(Response.Status.NOT_FOUND).build();
		tarefaDAO.delete(id);
		return Response.status(Response.Status.OK).build();
	}

}
