package nosi.core.webapp.activit.rest.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.http.Part;
import jakarta.ws.rs.core.Response;
import com.google.gson.reflect.TypeToken;

import nosi.core.webapp.activit.rest.entities.DeploymentService;
import nosi.core.webapp.helpers.FileHelper;
import nosi.core.webapp.webservices.helpers.ResponseConverter;
import nosi.core.webapp.webservices.helpers.ResponseError;

/**
 * Emanuel 14 May 2019
 */
public class DeploymentServiceRest extends GenericActivitiRest {

	public DeploymentService getDeployment(String id) {
		DeploymentService d = new DeploymentService();
		String response = this.getRestRequest().get("repository/deployments/", id, String.class);
		if (response != null) {
			/*String contentResp = "";
			try {
				contentResp = FileHelper.convertToString((InputStream)response.getEntity());
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (response.getStatus() == 200) {*/
				d = (DeploymentService) ResponseConverter.convertJsonToDao(response, DeploymentService.class);
			/*} else {
				this.setError((ResponseError) ResponseConverter.convertJsonToDao(contentResp, ResponseError.class));
			}
			response.close();*/
		}
		return d;
	}

	@SuppressWarnings("unchecked")
	public DeploymentService getDeploymentByName(String name) {
		DeploymentService d = new DeploymentService();
		try {
			String response = this.getRestRequest().get("repository/deployments?name=" + name, String.class);
			if (response != null) {
				/*String contentResp = "";
				try {
					contentResp = FileHelper.convertToString((InputStream) response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (response.getStatus() == 200) {*/
					List<DeploymentService> list = (List<DeploymentService>) ResponseConverter
							.convertJsonToListDao(response, "data", new TypeToken<List<DeploymentService>>() {
							}.getType());
					if (list != null && !list.isEmpty())
						d = list.get(0);
				/*} else {
					this.setError((ResponseError) ResponseConverter.convertJsonToDao(contentResp, ResponseError.class));
				}
				response.close();*/
			}
		} catch (Exception e) {
			var error = new ResponseError();
			error.setMessage(e.getMessage());
			error.setException(e.toString());
			error.setStatusCode(500);

			this.setError(error);
		}
		return d;
	}

	@SuppressWarnings("unchecked")
	public List<DeploymentService> getDeployments(String idApp) {
		List<DeploymentService> d = new ArrayList<>();
		try {
			String response = this.getRestRequest().get("repository/deployments?&size=100000000&tenantId=" + idApp, String.class);
			if (response != null) {
				/*String contentResp = "";
				try {
					contentResp = FileHelper.convertToString((InputStream) response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (response.getStatus() == 200) {*/
					d = (List<DeploymentService>) ResponseConverter.convertJsonToListDao(response, "data",
							new TypeToken<List<DeploymentService>>() {
							}.getType());
				/*} else {
					this.setError((ResponseError) ResponseConverter.convertJsonToDao(contentResp, ResponseError.class));
				}
				response.close();*/
			}
		} catch (Exception e) {
			var error = new ResponseError();
			error.setMessage(e.getMessage());
			error.setException(e.toString());
			error.setStatusCode(500);

			this.setError(error);
		}
		return d;
	}

	public DeploymentService create(Part file, String idApp) throws IOException {
		DeploymentService d = new DeploymentService();
		String response = this.getRestRequest().post("repository/deployments?tenantId=" + idApp, file, ".bpmn20.xml", String.class);
		if (response != null) {
			/*String contentResp = "";
			try {
				contentResp = FileHelper.convertToString((InputStream) response.getEntity());
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (response.getStatus() == 201) {*/
				d = (DeploymentService) ResponseConverter.convertJsonToDao(response, DeploymentService.class);
			/*} else {
				this.setError((ResponseError) ResponseConverter.convertJsonToDao(contentResp, ResponseError.class));
			}
			response.close();*/
		}
		file.delete();
		return d;
	}

	public DeploymentService create(InputStream file, String idApp, String fileName, String contentType)
			throws IOException {
		DeploymentService d = new DeploymentService();
		String response = this.getRestRequest().post("repository/deployments?tenantId=" + idApp, file, fileName, contentType, String.class);
		if (response != null) {
			/*String contentResp = "";
			try {
				contentResp = FileHelper.convertToString((InputStream) response.getEntity());
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (response.getStatus() == 201) {*/
				d = (DeploymentService) ResponseConverter.convertJsonToDao(response, DeploymentService.class);
			/*} else {
				this.setError((ResponseError) ResponseConverter.convertJsonToDao(contentResp, ResponseError.class));
			}
			response.close();*/
		}
		return d;
	}

	public DeploymentService update(Part file, String idApp) throws IOException {
		DeploymentService d = new DeploymentService();
		String response = this.getRestRequest().post("repository/deployments?tenantId=" + idApp, file, ".bpmn20.xml", String.class);
		if (response != null) {
			/*String contentResp = "";
			try {
				contentResp = FileHelper.convertToString((InputStream) response.getEntity());
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (response.getStatus() == 200) {*/
				d = (DeploymentService) ResponseConverter.convertJsonToDao(response, DeploymentService.class);
			/*} else {
				this.setError((ResponseError) ResponseConverter.convertJsonToDao(contentResp, ResponseError.class));
			}
			response.close();*/
		}
		file.delete();
		return d;
	}

	public boolean delete(String id) {
		Response response = this.getRestRequest().delete("repository/deployments", id);
		boolean r = response != null && response.getStatus() == 204;
		if(response!=null) {
			response.close();
		}
		return r;
	}
}
