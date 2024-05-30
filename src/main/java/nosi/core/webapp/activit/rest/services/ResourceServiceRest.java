package nosi.core.webapp.activit.rest.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.google.gson.reflect.TypeToken;

import nosi.core.webapp.activit.rest.entities.ResourceService;
import nosi.core.webapp.activit.rest.entities.ResourcesService;
import nosi.core.webapp.activit.rest.request.RestRequest;
import nosi.core.webapp.helpers.FileHelper;
import nosi.core.webapp.webservices.helpers.ResponseConverter;
import nosi.core.webapp.webservices.helpers.ResponseError;

/**
 * Emanuel
 * 14 May 2019
 */
public class ResourceServiceRest extends GenericActivitiRest{

	public ResourceService getResource(String id_deployment, String id_resource) {
		ResourceService r = new ResourceService();
		String response = this.getRestRequest().get("repository/deployments/" + id_deployment + "/resources",
				id_resource, String.class);
		if (response != null) {
			/*String contentResp = "";
			try {
				contentResp = FileHelper.convertToString((InputStream) response.getEntity());
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (response.getStatus() == 200) {*/
				r = (ResourceService) ResponseConverter.convertJsonToDao(response, ResourceService.class);
			/*} else {
				this.setError((ResponseError) ResponseConverter.convertJsonToDao(contentResp, ResponseError.class));
			}
			response.close();*/
		}
		return r;
	}

	public String getResourceData(String id_deployment, String id_resource) {
		RestRequest request = this.getRestRequest();
		request.setAccept_format(MediaType.APPLICATION_XML);
		return request.get("repository/deployments/" + id_deployment + "/resourcedata/", id_resource, String.class);
		/*String contentResp = "";
		if (response != null) {
			if (response.getStatus() == 200) {
				try {
					contentResp = FileHelper.convertToString((InputStream) response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			response.close();

		return contentResp;}*/
	}

	public String getResourceData(String link) {
		String contentResp = "";
		try{
			RestRequest request = this.getRestRequest();

			request.setBase_url("");

			contentResp = request.get(link, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*

		if (response != null) {
			if (response.getStatus() == 200) {
				try {
					contentResp = FileHelper.convertToString((InputStream) response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			response.close();
		}*/
		return contentResp;
	}

	@SuppressWarnings("unchecked")
	public List<ResourceService> getResources(String id_deployment) {
		List<ResourceService> d = new ArrayList<>();
		try{
			String response = this.getRestRequest().get("repository/deployments/" + id_deployment + "/resources", String.class);
			if (response != null) {
				/*String contentResp = "";
				try {
					contentResp = FileHelper.convertToString((InputStream) response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (response.getStatus() == 200) {*/
					d = (List<ResourceService>) ResponseConverter.convertJsonToListDao(response,
							new TypeToken<List<ResourceService>>() {
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

	public ResourcesService getResource(String url) {
		ResourcesService resource = new ResourcesService();
		try{
			RestRequest req = this.getRestRequest();
			req.setBase_url("");
			var response = req.get(url, String.class);//TODO validate the conversion to ResourcesService.class directly and see the result of the received data

			if (response != null) {
				/*String contentResp = "";
				try {
					contentResp = FileHelper.convertToString((InputStream) response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (response.getStatus() == 200) {*/
					resource = (ResourcesService) ResponseConverter.convertJsonToDao(response, ResourcesService.class);
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
		return resource;
	}
	
	
	public String getResourceContent(String url) {
		String d = null;
		RestRequest req = this.getRestRequest();
		req.setBase_url("");
		req.setAccept_format(MediaType.APPLICATION_OCTET_STREAM);
		Response response = req.get(url);
		if (response != null) {
			if (response.getStatus() == 200) {
				try {
					d = FileHelper.convertInputStreamToBase64((InputStream) response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			response.close();
		}
		return d;
	}

}
