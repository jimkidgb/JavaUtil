package test.webservice;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;

import net.sf.json.JSONObject;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class Webclient {

	public static void main(String[] args) {
		System.out.println("Start------------");
		Service service = new Service();
		String url = "http://10.124.88.50/sso/SSO_Service.asmx";
		String namespace = "http://tempuri.org/";

		String actionUri = "GetUser";
		String op = "GetUser";

		try {
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setUseSOAPAction(true);
			call.setSOAPActionURI(namespace + actionUri);
			call.setOperationName(new QName(namespace, op));
			call.addParameter(new QName(namespace, "os"), XMLType.XSD_STRING,
					ParameterMode.IN);
			call.addParameter(new QName(namespace, "passcode"),
					XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
			Object[] params = new Object[] {"1","123"};
			String result = (String) call.invoke(params);
			result = result.substring(1, result.length()-1);
			JSONObject jsonObj = JSONObject.fromObject(result);
			String workno = jsonObj.getString("0");
			String reason = jsonObj.getString("1");
			System.out.println(workno + "=" + reason);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("End------------");
	}

}
