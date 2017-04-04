package ai.vitk.api;

import ai.vitk.sao.AttributeClassifier;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.tuple.Pair;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Phuong LE-HONG, phuonglh@gmail.com
 * <p>
 * Mar 18, 2017, 2:45:39 PM
 * <p>
 * Attributor service.
 *
 */
@Path("/att")
@Api(value = "att")
public class Attributor {
	AttributeClassifier classifier = new AttributeClassifier(false);
	
	@GET
	@Path("/execute")
	@ApiOperation(value = "English Personal Attribute Detection")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response execute(@ApiParam(value = "text", required = true) @QueryParam("text") String text) {
		List<Pair<String, Double>> attributes = classifier.decode(text);
		Response response = Response.status(200).entity(attributes).type(MediaType.APPLICATION_JSON).build();
		return response;
	}
}
