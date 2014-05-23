package tk.blizz.restful.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import tk.blizz.restful.model.User;

@Path("/user-management")
public class UserManagementModule {
	@GET
	@Path("/users/{id}")
	@Produces("application/json")
	public Response getUserById(@PathParam("id") Integer id) {
		User user = new User();
		user.setId(id);
		user.setFirstName("Lokesh");
		user.setLastName("Gupta");
		return Response.status(200).entity(user).build();
	}
}
