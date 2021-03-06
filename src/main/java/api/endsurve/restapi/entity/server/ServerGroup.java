package api.endsurve.restapi.entity.server;

import org.json.JSONObject;

import java.util.Map;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class ServerGroup {
    private final String name;
    private final ServerState mode;

    private final int joinPower;
    private final int memory;
    private final int percentForNewServerAutomatically;

    private final boolean maintenance;
    private final boolean notifyPlayerUpdatesForOffline;
    private final boolean notifyProxyUpdates;
    private final boolean notifyServerUpdates;
    private final boolean autoSavingForWorlds;

    private final Map<String, Object> settings;

    public ServerGroup(JSONObject object) {
        name = object.optString("name");
        mode = object.optEnum(ServerState.class, "mode");
        memory = object.optInt("memory");
        joinPower = object.optInt("joinPower");
        percentForNewServerAutomatically = object.optInt("percentForNewServerAutomatically");
        maintenance = object.optBoolean("maintenance");
        settings = object.optJSONObject("settings").toMap();

        JSONObject configObject = object.optJSONObject("advancedServerConfig");
        notifyPlayerUpdatesForOffline = configObject.optBoolean("notifyPlayerUpdatesFromNoCurrentPlayer");
        notifyProxyUpdates = configObject.optBoolean("notifyProxyUpdates");
        notifyServerUpdates = configObject.optBoolean("notifyServerUpdates");
        autoSavingForWorlds = !configObject.optBoolean("disableAutoSavingForWorlds");
    }

    public String getName() {
        return name;
    }

    public ServerState getMode() {
        return mode;
    }

    public int getJoinPower() {
        return joinPower;
    }

    public int getMemory() {
        return memory;
    }

    public int getPercentForNewServerAutomatically() {
        return percentForNewServerAutomatically;
    }

    public boolean isMaintenanceActive() {
        return maintenance;
    }

    public boolean isNotifyPlayerUpdatesForOffline() {
        return notifyPlayerUpdatesForOffline;
    }

    public boolean isNotifyProxyUpdates() {
        return notifyProxyUpdates;
    }

    public boolean isNotifyServerUpdates() {
        return notifyServerUpdates;
    }

    public boolean isAutoSavingForWorlds() {
        return autoSavingForWorlds;
    }

    public Map<String, Object> getSettings() {
        return settings;
    }
}
