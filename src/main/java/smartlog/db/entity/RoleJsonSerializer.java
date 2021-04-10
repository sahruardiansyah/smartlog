package smartlog.db.entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Custom JSON serializer for Role entity class, extends from {@link JsonSerializer}
 * 
 * @author Tom
 */
public class RoleJsonSerializer extends JsonSerializer<Role> {
	@Override
    public void serialize(Role value, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {

    	jgen.writeStartObject();
    	jgen.writeNumberField("id", value.getId());
    	jgen.writeStringField("roleTitle", value.getRoleTitle());
    	jgen.writeStringField("roleDescription", value.getRoleDescription());

    	jgen.writeObjectField("privileges", value.getPrivileges());

    	jgen.writeEndObject();

    }
}
