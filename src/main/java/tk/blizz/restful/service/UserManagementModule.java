package tk.blizz.restful.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tk.blizz.restful.model.User;

@Path("/user-management")
public class UserManagementModule {
	private final List<User> users = new ArrayList<User>();
	private final Map<Integer, User> iu = new HashMap<Integer, User>();

	// init...
	{
		User user = new User();
		user.setId(1);
		user.setFirstName("Lokesh");
		user.setLastName("Gupta");

		addUser(user);

		user = new User();
		user.setId(2);
		user.setFirstName("Hello");
		user.setLastName("World");

		addUser(user);

		user = new User();
		user.setId(3);
		user.setFirstName("Jack");
		user.setLastName("Wang");

		addUser(user);
	}

	@GET
	@Path("/users")
	@Produces("application/json")
	public Response getUsers() {
		return Response.status(200).entity(this.users).build();
	}

	@GET
	@Path("/user/{id}")
	@Produces("application/json")
	public Response getUser(@PathParam("id") Integer id) {
		User user = this.iu.get(id);
		if (user != null)
			return Response.status(200).entity(user).build();
		else
			return Response.status(Status.NOT_FOUND).build();
	}

	@PUT
	@Path("/user/{id}")
	@Produces("application/json")
	public Response addUser(@PathParam("id") Integer id) {
		throw new UnsupportedOperationException();
	}

	@DELETE
	@Path("/user/{id}")
	@Produces("application/json")
	public Response removeUser(@PathParam("id") Integer id) {
		throw new UnsupportedOperationException();
	}

	private void addUser(User user) {
		User old = this.iu.put(user.getId(), user);
		if (old != null)
			this.users.remove(old);

		this.users.add(user);
	}

	private void deleteUserById(Integer id) {
		User old = this.iu.remove(id);
		if (old != null)
			this.users.remove(old);
	}
}