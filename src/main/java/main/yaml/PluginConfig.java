package main.yaml;

import org.jetbrains.annotations.NotNull;

public final class PluginConfig
        extends PluginYamlObject {

    public static final String JOIN_MESSAGE_PATH = "JoinEventMessage";
    public static final String LEAVE_MESSAGE_PATH = "LeaveEventMessage";
    public static final String RELOAD_MESSAGE_PATH = "ReloadMessage";
    public static final String NO_PERMISSION_PATH = "NoPermissionMessage";

    public PluginConfig() {
        super("Config.yml");
    }

    @NotNull
    public String getJoinMessage() {
        final String joinEventMessage = this.configuration.getString(PluginConfig.JOIN_MESSAGE_PATH);

        if (this.equalsStringNull(joinEventMessage))
            return joinEventMessage;

        return "ERROR MESSAGE";
    }

    @NotNull
    public String getLeaveMessage() {
        final String leaveEventMessage = this.configuration.getString(PluginConfig.LEAVE_MESSAGE_PATH);

        if (this.equalsStringNull(leaveEventMessage))
            return leaveEventMessage;

        return "ERROR MESSAGE";
    }

    @NotNull
    public String getReloadMessage() {
        final String reloadMessage = this.configuration.getString(PluginConfig.RELOAD_MESSAGE_PATH);

        if (reloadMessage != null)
            return reloadMessage;

        return "ERROR MESSAGE";
    }

    @NotNull
    public String getNoPermission() {
        final String NoPermissionMessage = this.configuration.getString(PluginConfig.NO_PERMISSION_PATH);

        if (NoPermissionMessage != null)
            return  NoPermissionMessage;

        return "ERROR MESSAGE";
    }

    private boolean equalsStringNull(final String msg) {
        return (msg != null);
    }

}
