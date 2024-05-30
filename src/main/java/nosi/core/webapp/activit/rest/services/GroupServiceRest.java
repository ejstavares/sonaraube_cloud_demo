package nosi.core.webapp.activit.rest.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.reflect.TypeToken;

import nosi.core.webapp.activit.rest.entities.GroupService;
import nosi.core.webapp.helpers.FileHelper;
import nosi.core.webapp.webservices.helpers.ResponseConverter;
import nosi.core.webapp.webservices.helpers.ResponseError;

/**
 * Emanuel 15 May 2019
 */
public class GroupServiceRest extends GenericActivitiRest{

	public GroupService getGroup(String id) {
		GroupService g = new GroupService();
		var response = this.getRestRequest().get("identity/groups", id, String.class);
		if (response != null) {
			/*String contentResp = "";
			try {
				contentResp = FileHelper.convertToString((InputStream) response.getEntity());
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (response.getStatus() == 200) {*/
				g = (GroupService) ResponseConverter.convertJsonToDao(response, GroupService.class);
			/*} else {
				this.setError((ResponseError) ResponseConverter.convertJsonToDao(contentResp, ResponseError.class));
			}
			response.close();*/
		}
		return g;
	}

	@SuppressWarnings("unchecked")
	public List<GroupService> getGroups() {
		List<GroupService> d = new ArrayList<>();
		try{
			var response = this.getRestRequest().get("identity/groups", String.class);
			if (response != null) {
				/*String contentResp = "";
				try {
					contentResp = FileHelper.convertToString((InputStream) response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (response.getStatus() == 200) {*/
					d = (List<GroupService>) ResponseConverter.convertJsonToListDao(response, "data",
							new TypeToken<List<GroupService>>() {
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

	public GroupService create(GroupService group) {
		GroupService g = new GroupService();
		var response = this.getRestRequest().post("identity/groups", ResponseConverter.convertDaoToJson(group), String.class);
		if (response != null) {
			/*String contentResp = "";
			try {
				contentResp = FileHelper.convertToString((InputStream) response.getEntity());
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (response.getStatus() == 201) {*/
				g = (GroupService) ResponseConverter.convertJsonToDao(response, GroupService.class);
			/*} else {
				this.setError((ResponseError) ResponseConverter.convertJsonToDao(contentResp, ResponseError.class));
			}
			response.close();*/
		}
		return g;
	}

	public GroupService update(GroupService group) {
		GroupService g = new GroupService();
		var response = this.getRestRequest().put("identity/groups", ResponseConverter.convertDaoToJson(group),
				group.getId(), String.class);
		if (response != null) {
			/*String contentResp = "";
			try {
				contentResp = FileHelper.convertToString((InputStream) response.getEntity());
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (response.getStatus() == 200) {*/
				g = (GroupService) ResponseConverter.convertJsonToDao(response, GroupService.class);
			/*} else {
				this.setError((ResponseError) ResponseConverter.convertJsonToDao(contentResp, ResponseError.class));
			}
			response.close();*/
		}
		return g;
	}

	public int addUser(String idGroup, String user) {
		JSONObject jobj = new JSONObject();
		try {
			jobj.put("userId", user);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		Response response = this.getRestRequest().post("identity/groups/" + idGroup + "/members", jobj.toString());
		int r= response != null ? response.getStatus() : -1;
		if(response!=null) {
			response.close();
		}
		return r;
	}

	public boolean delete(String id) {
		Response response = this.getRestRequest().delete("identity/groups", id);
		boolean r = response != null && response.getStatus() == 204;
		if(response!=null) {
			response.close();
		}
		return r;
	}
}
