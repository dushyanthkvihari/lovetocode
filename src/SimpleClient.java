import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.NameValuePair;
import java.util.List;
import java.util.ArrayList;

public class SimpleClient {
    public static void main(String vv[])throws  Exception
    {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://10.96.36.6/estudio/service/login");
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("iw_user", "iwenc:Nu5REzX=="));
        urlParameters.add(new BasicNameValuePair("iw_password", "iwenc:DlKV6x.p.4isOmv=="));
        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        CloseableHttpResponse response = client.execute(post);
        String setcookieValue=(((Header[])response.getHeaders("Set-Cookie"))[0]).getValue();
        String[] cookies = setcookieValue.split(";");
        String[] iwauthCookie = cookies[0].split("=");
        String IWAUTH = iwauthCookie[0];
        String IWAUT_VALUE = iwauthCookie[1];
        client.close();


        CloseableHttpClient ruleClient = HttpClients.createDefault();
       // HttpPost saverulePost = new HttpPost("http://10.96.36.6/wcm-service/service/projects/Targeting/site/rule/save");
        HttpPost saverulePost = new HttpPost("http://10.96.36.6/wcm-service/service/projects/Global/livesite/taxonomyexplorer/processBrowse?taxonomyId=Content%20Types&areaVPath=/default/main/EStudioGlobal/WORKAREA/default&iw_which_ui=estudio");
        List<NameValuePair> urlRuleParameters = new ArrayList<>();
//        urlRuleParameters.add(new BasicNameValuePair("id", "//rh76auth/default/main/Targeting/WORKAREA/default"));
//        urlRuleParameters.add(new BasicNameValuePair("json", "{\"rule\":{\"id\":\"\",\"name\":\"blah\",\"displayName\":\"\",\"description\":\"blah\",\"ifConditionType\":\"AND\",\"ifActions\":[\"false.actions\"],\"ifConditions\":[\"jyjf.conditions\"],\"elseActions\":[],\"type\":\"content\"},\"vpath\":\"//rh76auth/default/main/Targeting/WORKAREA/default/iwov-resources/rules/\",\"resourceRoot\":\"//rh76auth/default/main/Targeting/WORKAREA/default/iwov-resources/\",\"editMode\":\"create\"}"));
//        urlRuleParameters.add(new BasicNameValuePair("method", "save"));
        saverulePost.setEntity(new UrlEncodedFormEntity(urlRuleParameters));
        saverulePost.addHeader("Cookie",cookies[0]);
        saverulePost.addHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
        saverulePost.addHeader("Accept","application/json, text/plain, */*");
        CloseableHttpResponse resp=ruleClient.execute(saverulePost);
        resp.toString();
    }
}
