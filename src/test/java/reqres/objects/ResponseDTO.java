package reqres.objects;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class ResponseDTO implements Serializable {

	@SerializedName("name")
	private String name;

	@SerializedName("job")
	private String job;

	@SerializedName("id")
	private String id;

	@SerializedName("createdAt")
	private String createdAt;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setJob(String job){
		this.job = job;
	}

	public String getJob(){
		return job;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"name = '" + name + '\'' + 
			",job = '" + job + '\'' + 
			",id = '" + id + '\'' + 
			",createdAt = '" + createdAt + '\'' + 
			"}";
		}
}