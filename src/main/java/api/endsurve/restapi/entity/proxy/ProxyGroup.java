package api.endsurve.restapi.entity.proxy;

import api.endsurve.restapi.entity.Template;
import api.endsurve.restapi.json.JSONArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class ProxyGroup {
    private final String name;
    private final String[] wrappers;
    private final String proxyVersion;

    private final Template template;
    private final ProxyConfig config;

    private final int startPort;
    private final int startup;
    private final int memory;

    private final ProxyGroupMode mode;
    private final Map<String, Object> settings;

    public ProxyGroup(JSONObject object) {
        name = object.optString("name");

        JSONArray wrapperArray = object.optJSONArray("wrapper");
        wrappers = JSONArrayUtils.toStringArray(wrapperArray);

        proxyVersion = object.optString("proxyVersion");

        JSONObject templateObject = object.optJSONObject("template");
        template = new Template(templateObject);

        JSONObject configObject = object.optJSONObject("proxyConfig");
        config = new ProxyConfig(configObject);

        startPort = object.optInt("startPort");
        startup = object.optInt("startup");
        memory = object.optInt("memory");

        mode = object.optEnum(ProxyGroupMode.class, "proxyGroupMode");

        settings = object.optJSONObject("settings").toMap();
    }

    public String getName() {
        return name;
    }

    public String[] getWrappers() {
        return wrappers;
    }

    public String getProxyVersion() {
        return proxyVersion;
    }

    public Template getTemplate() {
        return template;
    }

    public ProxyConfig getConfig() {
        return config;
    }

    public int getStartPort() {
        return startPort;
    }

    public int getStartup() {
        return startup;
    }

    public int getMemory() {
        return memory;
    }

    public Map<String, Object> getSettings() {
        return settings;
    }

    public ProxyGroupMode getMode() {
        return mode;
    }

}
